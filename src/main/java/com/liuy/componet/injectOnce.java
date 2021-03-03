package com.liuy.componet;//package com.liuy.componet;
//
//import com.alibaba.fastjson.JSONObject;
//import com.liuy.dao.mapper.BiliMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//
//import java.util.HashMap;
//import java.util.Map;
//
////@Component
//public class injectOnce {
////    @Autowired
//    BiliMapper biliMapper;
//
//    public Map<String,Object> cmap;
//    public injectOnce(){
//        cmap=new HashMap<>();
//    }
//    public void loopJson(Object object,String prefix){
//        if(object instanceof JSONObject) {
//            JSONObject jsObject = (JSONObject) object;
//            for (Map.Entry<String, Object> entry : jsObject.entrySet()) {
//                Object o = entry.getValue();
//
//                String _prefix=prefix+"_"+entry.getKey();
//                if (o instanceof String|| o ==null) {
//                    System.out.println("key:" + _prefix + "，value:" + entry.getValue());
//                    biliMapper.insertCow(_prefix,"varchar(40)");
//                }else if(o instanceof Integer){
//                    biliMapper.insertCow(_prefix,"int");
//                }
//                else {
//                    loopJson(o,_prefix);
//                }
//            }
//        }
//    }
//    @Bean
//    public void init(){
//        JSONObject j=JSONObject.parseObject(w);
//        loopJson(j,"");
//    }
//    public static final String w="{\n" +
//            "    \"code\": 0,\n" +
//            "    \"message\": \"0\",\n" +
//            "    \"ttl\": 1,\n" +
//            "    \"data\": {\n" +
//            "        \"card\": {\n" +
//            "            \"mid\": \"2\",\n" +
//            "            \"name\": \"碧诗\",\n" +
//            "            \"approve\": false,\n" +
//            "            \"sex\": \"男\",\n" +
//            "            \"rank\": \"20000\",\n" +
//            "            \"face\": \"http://i0.hdslb.com/bfs/face/ef0457addb24141e15dfac6fbf45293ccf1e32ab.jpg\",\n" +
//            "            \"DisplayRank\": \"0\",\n" +
//            "            \"regtime\": 0,\n" +
//            "            \"spacesta\": 0,\n" +
//            "            \"birthday\": \"\",\n" +
//            "            \"place\": \"\",\n" +
//            "            \"description\": \"\",\n" +
//            "            \"article\": 0,\n" +
//            "            \"attentions\": [],\n" +
//            "            \"fans\": 944017,\n" +
//            "            \"friend\": 226,\n" +
//            "            \"attention\": 226,\n" +
//            "            \"sign\": \"kami.im 直男过气网红 # av362830 “We Are Star Dust”\",\n" +
//            "            \"level_info\": {\n" +
//            "                \"current_level\": 6,\n" +
//            "                \"current_min\": 0,\n" +
//            "                \"current_exp\": 0,\n" +
//            "                \"next_exp\": 0\n" +
//            "            },\n" +
//            "            \"pendant\": {\n" +
//            "                \"pid\": 3860,\n" +
//            "                \"name\": \"2021拜年纪\",\n" +
//            "                \"image\": \"http://i2.hdslb.com/bfs/garb/item/7f8aa8ef1eed8c2dce0796801ddc82552a4164f9.png\",\n" +
//            "                \"expire\": 0,\n" +
//            "                \"image_enhance\": \"http://i2.hdslb.com/bfs/garb/item/7f8aa8ef1eed8c2dce0796801ddc82552a4164f9.png\",\n" +
//            "                \"image_enhance_frame\": \"\"\n" +
//            "            },\n" +
//            "            \"nameplate\": {\n" +
//            "                \"nid\": 10,\n" +
//            "                \"name\": \"见习偶像\",\n" +
//            "                \"image\": \"http://i1.hdslb.com/bfs/face/e93dd9edfa7b9e18bf46fd8d71862327a2350923.png\",\n" +
//            "                \"image_small\": \"http://i1.hdslb.com/bfs/face/275b468b043ec246737ab8580a2075bee0b1263b.png\",\n" +
//            "                \"level\": \"普通勋章\",\n" +
//            "                \"condition\": \"所有自制视频总播放数>=10万\"\n" +
//            "            },\n" +
//            "            \"Official\": {\n" +
//            "                \"role\": 2,\n" +
//            "                \"title\": \"bilibili创始人（站长）\",\n" +
//            "                \"desc\": \"\",\n" +
//            "                \"type\": 0\n" +
//            "            },\n" +
//            "            \"official_verify\": {\n" +
//            "                \"type\": 0,\n" +
//            "                \"desc\": \"bilibili创始人（站长）\"\n" +
//            "            },\n" +
//            "            \"vip\": {\n" +
//            "                \"vipType\": 2,\n" +
//            "                \"dueRemark\": \"\",\n" +
//            "                \"accessStatus\": 0,\n" +
//            "                \"vipStatus\": 1,\n" +
//            "                \"vipStatusWarn\": \"\",\n" +
//            "                \"theme_type\": 0\n" +
//            "            }\n" +
//            "        },\n" +
//            "        \"following\": false,\n" +
//            "        \"archive_count\": 36,\n" +
//            "        \"article_count\": 0,\n" +
//            "        \"follower\": 944017\n" +
//            "    }\n" +
//            "}";
//}
