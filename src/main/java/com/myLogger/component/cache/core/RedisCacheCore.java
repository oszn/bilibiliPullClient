package com.myLogger.component.cache.core;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
//import com.example.demo.liuyi.component.ProtoStuffSerializerUtil;
import com.myLogger.component.ProtoStuffSerializerUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisCacheCore {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Integer LOCK_TIMEOUT_SEC = 2;

    private RedisTemplate<String, String> redisTemplate;

    protected void setRedisTemplate(RedisTemplate<String, String> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    public void ping(){
        redisTemplate.opsForValue();
    }
    //redis fake lock, using for muti-process server
    public boolean lock(String key){
        return setnxWithExpire(key, "", LOCK_TIMEOUT_SEC);
    }

    public boolean lock(String key,Integer timeoutS){
        return setnxWithExpire(key, "", timeoutS);
    }

    //redis unlock
    public void unlock(String key){
        this.deleteCache(key);
    }

    public void zAdd(String key, Set<ZSetOperations.TypedTuple<String>> tuples){
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        zset.add(key, tuples);
    }

    public void zAdd(String key, String value, double score) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        zset.add(key, value, score);
    }

    public Set<String> zRangeByScore(String key, double min, double max) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, min, max);
    }

    public Double zIncrBy(String key, String value, double score) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.incrementScore(key, value, score);
    }

    public Double zScore(String key, String value) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.score(key,value);
    }

    public Long zCard(String key) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.zCard(key);
    }

    public void zRemRange(String key, long l1, long l2) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        zset.removeRange(key, l1, l2);
    }

    public Set<ZSetOperations.TypedTuple<String>> reverseRangeWithScores(String key, Long min, Long max) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.reverseRangeWithScores(key, min, max);
    }

    public Set<String> zRange(String key, Long min, Long max) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.range(key, min, max);
    }

    public Set<String> zReverseRange(String key, Long min, Long max) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.reverseRange(key, min, max);
    }

    public Set<ZSetOperations.TypedTuple<String>> zRangeWithScores(String key, Long min, Long max) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.rangeWithScores(key, min, max);
    }

    public Set<String> reverseRangeByScore(String key, double min, double max, long offset, long count) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.reverseRangeByScore(key, min, max, offset,count);
    }

    public Set<ZSetOperations.TypedTuple<String>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        return zset.reverseRangeByScoreWithScores(key, min, max, offset,count);
    }

    public void zRem(String key) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        //test：Zrem需要制定分数段查询范围
        Long i = zset.removeRangeByScore(key, 0, 99999999999999999L);
    }

    public void zRemByScore(String key,long startScore, long endScore) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        Long i = zset.removeRangeByScore(key, startScore, endScore);
    }

    public void zRem(String key, String member) {
        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        //test：Zrem需要制定分数段查询范围
        Long i = zset.remove(key, member);
    }

    public <T> boolean putCache(String key, T obj) {
        final byte[] bKey = key.getBytes();
        final byte[] bValue = ProtoStuffSerializerUtil.serialize(obj);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bKey, bValue);
            }
        });
        return result;
    }

    /**
     * @param key
     * @param obj
     * @param expireTime 单位: s
     * @param <T>
     */
    public <T> void putCacheWithExpireTime(String key, T obj, final long expireTime) {
        final byte[] bKey = key.getBytes();
        final byte[] bValue = ProtoStuffSerializerUtil.serialize(obj);
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bKey, expireTime, bValue);
                return true;
            }
        });
    }

    public <T> boolean putListCache(String key, List<T> objList) {
        final byte[] bKey = key.getBytes();
        final byte[] bValue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.setNX(bKey, bValue);
            }
        });
        return result;
    }

    public <T> boolean putListCacheWithExpireTime(String key, List<T> objList, final long expireTime) {
        final byte[] bKey = key.getBytes();
        final byte[] bValue = ProtoStuffSerializerUtil.serializeList(objList);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                connection.setEx(bKey, expireTime, bValue);
                return true;
            }
        });
        return result;
    }

    public <T> T getCache(final String key, Class<T> targetClass) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key.getBytes());
            }
        });
        if (result == null) {
            return null;
        }
        return ProtoStuffSerializerUtil.deserialize(result, targetClass);
    }

    public <T> List<T> getListCache(final String key, Class<T> targetClass) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.get(key.getBytes());
            }
        });
        if (result == null) {
            return null;
        }
        return ProtoStuffSerializerUtil.deserializeList(result, targetClass);
    }

    /**
     * 精确删除key
     *
     * @param key
     */
    public void deleteCache(String key) {
        final byte[] bKey = key.getBytes();
        Long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(bKey);
            }
        });

    }

    /**
     * 模糊删除key
     *
     * @param pattern
     */
    public void deleteCacheWithPattern(String pattern) {
        Set<String> keys = redisTemplate.keys(pattern);
        redisTemplate.delete(keys);
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 需要增加几
     * @return
     */
    public long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递增
     *
     * @param key   键
     * @param delta 需要增加几
     * @return
     */
    public double incr(String key, double delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key   键
     * @param delta 要减少几
     * @return
     */
    public long decr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /**
     * 获取字符串值
     *
     * @param key
     * @return
     */
    public String getString(String key, String defaultValue) {
        String value = redisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(value)) {
            value = defaultValue;
        }
        return value;
    }

    public String getSet(String key, String value) {
        String valueOld = redisTemplate.opsForValue().getAndSet(key, value);
        ;
        if (StringUtils.isEmpty(valueOld)) {
            valueOld = "0";
        }
        return valueOld;
    }

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public <T> List<T> getList(String key, Class<T> targetClass) {
        String value = get(key);
        return JSONObject.parseArray(value, targetClass);
    }

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setList(String key, List<?> objList) {
        String value = JSON.toJSONString(objList);
        set(key, value);
    }

    public boolean setnx(String key, String value) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                return redisConnection.setNX(key.getBytes(), value.getBytes());
            }
        });
    }

    public boolean setnxWithExpire(String key, String value, Integer expire) {
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                boolean result = false;
                if (redisConnection.setNX(key.getBytes(), value.getBytes())) {
                    result = redisConnection.expire(key.getBytes(), expire);
                }
                return result;
            }
        });
    }

    public void setExString(String key, String value, long l) {
        redisTemplate.opsForValue().set(key, value, l, TimeUnit.SECONDS);
    }

    /**
     * 设置缓存失效时间
     */
    public boolean expire(String key, Long time) {
        try {
            if (time != null && time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 往队列里添加数据
     *
     * @param key
     * @param value
     */
    public void lpush(String key, String value) {
        redisTemplate.opsForList().leftPush(key, value);
    }

    public String rpop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    public void lrem(String key, String val) {
        redisTemplate.opsForList().remove(key, 1, val);
    }

    public List<String> lrange(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    public long lsize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    public void sadd(String key, String... var2) {
        redisTemplate.opsForSet().add(key, var2);
    }


    public void srem(String key, String... var2) {
        redisTemplate.opsForSet().remove(key, var2);
    }
    public Set<String> smembers(String key) {

        return redisTemplate.<String>opsForSet().members(key);
    }

    public Boolean sIsMember(String key, String var){
        return redisTemplate.<String>opsForSet().isMember(key, var);
    }

    public <T> void hset(String key, String field, T value) {
        final byte[] bKey = key.getBytes();
        final byte[] bFiled = field.getBytes();
        final byte[] bValue = ProtoStuffSerializerUtil.serialize(value);
        redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hSet(bKey, bFiled, bValue);
            }
        });
    }

    public void hdel(String key, String field) {
        final byte[] bKey = key.getBytes();
        final byte[] bFiled = field.getBytes();
        redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hDel(bKey, bFiled);
            }
        });
    }

    public <T> T hget(String key, String field, Class<T> targetClass) {
        byte[] result = redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.hGet(key.getBytes(), field.getBytes());
            }
        });
        if (result == null) {
            return null;
        }
        return ProtoStuffSerializerUtil.deserialize(result, targetClass);
    }

    public Double zscore(String redisKey, String member) {

        return redisTemplate.<String, String>opsForZSet().score(redisKey, member);
    }

    public Set<String> getKeysByPattern(String pattern) {
        return redisTemplate.keys(pattern);
    }


    public Long getZsetReverseRank(String key, String member) {
        return redisTemplate.opsForZSet().reverseRank(key, member);
    }

    public Double getZsetScoreByMember(String key, String member) {
        return redisTemplate.opsForZSet().score(key, member);
    }

    public void rename(String oldKey, String newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    public Set<String> zRevrangeByScore(String key, Long minScore, Long maxScore) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, minScore, maxScore);
    }

    /**
     * 根据给定的布隆过滤器添加值
     */


    /**
     * 根据给定的布隆过滤器判断值是否存在
     */

}
