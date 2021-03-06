package com.liuy.controller.dto;

/**
 * 业务异常基类，所有业务异常都必须继承于此异常 定义异常时，需要先确定异常所属模块。 例如：无效用户可以定义为 [10010001]
 * 前四位数为系统模块编号，后4位为错误代码 ,唯一。
 *
 * @author yingjun
 */
public enum ResultEnum {

    SUCCESS(200, "OK"),
    FAILURE(100, "FAILURE"),
    PARA_ERR(99, "参数错误"),
    IP_NOT_IN_WHITE_LIST(98, "ip无访问权限"),
    BUSINESS_UNAVAILABLE(97, "该服务暂不可用，请稍后再试"),
    AMQP_MSG_NOT_SUPPORT_VERSION(96, "不支持的消息版本号"),
    AMQP_EXCHANGE_NOT_EXIST(95, "不存在的消息队列交换机"),
    AMQP_MSG_PARAM_ERR(94, "消息队列参数错误"),
    AMQP_MSG_SEND_FAIL(93, "消息队列消息发送失败"),
    MQ_MSG_TYPE_NOT_EXIST(92, "不支持的消息类型"),
    MQ_MSG_NOT_SUPPORT_MESSAGE(91, "该版本不支持此消息"),
    MQ_MSG_CONSUME_FAILED(90, "消息消费失败"),
    MQ_MSG_LISTENER_CONFLICT(89, "消息监听冲突"),
    FAIL_AND_TRY_AGAIN(88, "操作失败，请重试"),
    SERVICE_START_UP_FAIL(87, "服务启动失败"),
    OVER_LIMIT(86, "超过最大允许限制"),

    UPDATE_NEW_VERSION(2000, "版本过低，请升级到最新版本"),

    // im
    IM_GET_TOKEN_FAILED(101, "获取IM token失败"),
    IM_REGISTER_FAILED(102, "注册IM账号失败"),
    IM_ADD_CONTACTS_FAILED(103, "添加IM好友失败"),
    IM_DEL_CONTACTS_FAILED(104, "删除IM好友失败"),
    IM_FRIEND_UNEXIST(105, "用户ID不存在，请重新输入"),
    IM_SEND_MSG_FAILED(106, "消息发送失败"),
    IM_ALREADY_BE_FRIEND(107, "已添加对方为好友，请勿重复操作"),
    IM_FRIEND_APPLY_UNEXIST(108, "好友申请已过期"),
    IM_NOT_FRIENDS(109, "对方已不是您的关注"),
    IM_OVER_USER_OWN_GROUP_NUM(110, "已创建群数目达到上限"),
    IM_CREATE_CHATGROUP_FAILED(111, "创建群失败"),
    IM_CHATGROUP_UNEXIST(112, "群ID不存在，请重新输入"),
    IM_PERMISSION_DENY(113, "没有操作权限"),
    IM_OWNER_LEAVE_CHATGROUP_NOT_ALLOWED(114, "请先移交群会长权限"),
    IM_RM_CHATGROUP_MEMBER_FAILED(115, "删除群成员失败"),
    IM_OVER_CHATGROUP_MEMBERS_LIMIT(116, "群成员已达最大限制"),
    IM_INVITE_UNEXIST(117, "群邀请不存在"),
    IM_IMVITE_EXPIRE(118, "群邀请已过期"),
    IM_INVITE_ALREADY_PROCESSED(119, "群邀请已处理"),
    IM_ADD_CHATGROUP_MEMBER_FAILED(120, "添加群成员失败"),
    IM_NOT_CHATGROUP_MEMBER(121, "对方已不是群成员"),
    IM_TRANSFER_CHATGROUP_FAILED(122, "转移群失败，请刷新后重试"),
    IM_OVER_CHATGROUP_ADMINS_LIMIT(123, "群管理员已达上限"),
    IM_ALREADY_IN_CHATGROUP(124, "对方已是群成员"),
    IM_ALREADY_APPLY_JOIN_IN_CHATGROUP(125, "已成功发起申请，请耐心等待管理员审核"),
    IM_CHATGROUP_APPLY_UNEXIST(126, "群申请不存在"),
    IM_CHATGROUP_APPLY_ALREADY_PROCESSED(127, "群申请已处理"),
    IM_ADD_CHATGROUP_ADMIN_FAILED(128, "添加群管理员失败"),
    IM_RM_CHATGROUP_ADMIN_FAILED(129, "删除群管理员失败"),
    IM_CHATGROUP_PRIVATE(130, "群ID不存在，请重新输入"),
    IM_CREATE_CHATROOM_FAILED(131, "创建聊天室失败"),
    IM_CHATGROUP_BEING_PROCESSED(132, "您的群正在创建中"),
    IM_CHATGROUP_PRIVATE_SEARCHABLE(133, "该群不允许任何人加入"),
    IM_ACCOUNT_OR_PASSWORD_ERROR(134, "IM账号或者密码错误"),
    IM_GET_NEW_FRIEND_FAILED(135, "暂未获取到新的好友，请稍后再试"),
    IM_DENY_STRANGER_MSG(136, "TA不接受陌生人消息哦~"),
    IM_TALK_TO_STRANGER_GRADE_TOO_LOW(137, "TA开启了聊天保护设置"),
    IM_CHAT_GROUP_ALREADY_FORBID(138, "群已经在封禁状态"),
    IM_CHAT_GROUP_NO_FORBID(139, "群没有在封禁状态"),
    IM_CHAT_GROUP_MUTE_FAIL(140, "群禁言失败"),
    IM_CHAT_GROUP_UN_MUTE_FAIL(141, "群解除禁言失败"),
    IM_CHAT_GROUP_NOT_EXIST(142, "群聊不存在"),
    IM_FOCUS_CAN_NOT_SELF(143, "不能关注自己"),
    IM_UPDATE_MAX_USERS_FAILED(144, "修改群组最大人数失败"),
    IM_UPDATE_PASSWORD_FAILED(145, "修改密码失败"),
    IM_QUERY_CHAT_ROOM_MEMBER_FAILED(146, "查询聊天室成员失败"),
    IM_THIRD_RESOURCE_LIMITED(147, "im 第三方请求超限"),

    // accout
    ACCOUNT_LOGIN_AUTH_FAILED(401, "登陆认证失败，请重新登录"),
    ACCOUNT_VERIFY_CODE_INVALID(200, "验证码错误，请重新输入"),
    ACCOUNT_GET_VERIFY_CODE_FAILED(201, "获取验证码过于频繁，请稍后再试"),
    ACCOUNT_GET_VERIFY_CODE_TO_UPGRADE(202, "当前版本较低, 请升级到最新版本"),
    ACCOUNT_ONLY_SUPPORT_REBIND_PHONE(203, "仅支持换绑手机号"),
    ACCOUNT_PARA_ERR(204, "参数错误"),
    ACCOUNT_CANCEL_BIND_FAILD(205, "仅有一种绑定关系时，不允许解绑"),
    ACCOUNT_GET_PHONE_FAILED(206, "手机号验证失败"),
    ACCOUNT_PASSWORD_UNMATCH(230, "帐号或密码错误，请重新输入"),
    ACCOUNT_UNEXIST(233, "用户不存在"),
    ACCOUNT_ALREADY_EXIST(234, "该账号已注册"),
    ACCOUNT_ACCESS_WECHAT_FAILD(237, "绑定微信失败，请重试"),
    ACCOUNT_FORTUNE_NOT_ENOUGH(240, "金豆余额不足"),
    ACCOUNT_FORTUNE_DIAMOND_NOT_ENOUGH(240, "钻石余额不足"),
    ACCOUNT_FORTUNE_IN_CHANGE(241, "系统繁忙，请稍后再试"),
    ACCOUNT_TOKEN_UNMATCH_ERROR_STATUS(242, "token 不匹配"),
    ACCOUNT_PASSWORD_FORMAT_INVALID(243, "账号密码格式错误，请重新输入"),
    ACCOUNT_PHONE_FORMAT_INVALID(244, "手机号码格式错误，请重新输入"),
    ACCOUNT_PHONE_ALREADY_BIND(247, "该手机号码已被绑定，如有疑问请联系客服"),
    ACCOUNT_ALREADY_BIND_OTHER_PHONE(248, "该账号已绑定手机号"),
    ACCOUNT_WECHAT_ALREADY_BIND(249, "该微信号已被绑定"),
    ACCOUNT_QQ_ALREADY_BIND(250, "该QQ号已被绑定"),
    ACCOUNT_ONLY_WECHAT_BIND(251, "账号只绑定了微信"),
    ACCOUNT_ONLY_QQ_BIND(252, "账号只绑定了QQ"),
    ACCOUNT_PHONE_UN_BLIND(253, "该手机号尚未绑定账户，请先登陆嗨呀平台进行手机号绑定！"),
    ACCOUNT_UID_IS_NULL(254, "用户为空，请检查参数"),
    ACCOUNT_USER_CONTENT_ERR(255, "%s数量超过最大限制"),
    ACCOUNT_USER_DELETE_ERR(256, "该关注不可删除哦~"),
    ACCOUNT_PROP_TYPE_ERR(257, "道具类型输入错误!"),
    ACCOUNT_COINS_CHANGE_REASON_ERR(258, "道具变化原因输入错误"),
    ACCOUNT_USER_NAME_DUMPLICATED(259, "该昵称已被占用"),
    ACCOUNT_INPUT_NULL(260, "输入不能为空"),
    ACCOUNT_USER_NAME_EXCEED(263, "一个月内只能修改一次昵称"),
    ACCOUNT_INFO_EDIT_COUNT_REACHED_LIMIT(268, "%s是重要信息只可以更改一次哦~请谨慎更改"),
    ACCOUNT_REGISTER_OVER_LIMIT(300, "已达到限制，无法创建账号"),
    ACCOUNT_USER_NAME_INVALID(301, "您输入的昵称含有系统不支持字符，请重试。"),
    ACCOUNT_QQ_TOKEN_ERROR(305, "QQ登陆授权获取失败"),




    ACCOUNT_USER_NAME_OVER_MAX_MODIFY(309, "用户昵称每周最多允许更改%s次。"),
    ACCOUNT_CAN_NOT_UNREGISTER(310, "该账号不可注销"),
    ACCOUNT_ALREADY_UNREGISTERED(311, "账号已注销"),
    ACCOUNT_RESET_EMPTY(312,"账号重置属性为空"),
    ACCOUNT_RESET_NOT_SUPPORT(313,"账号重置该属性暂不支持"),
    ACCOUNT_APPLE_ALREADY_BIND(314, "该苹果账号已被绑定"),
    ACCOUNT_QQ_ERR_BIND(315, "该QQ号绑定异常, 请升级到最新版本后重试"),

    ACCOUNT_REGISTER_GOTO_VOICE_ROOM_ERROR(316, "新用户注册同一个子渠道同时间段只允许配置一个"),

    //real info
    REAL_INFO_NOT_CONFIG(264, "该账号还未实名认证"),
    REAL_INFO_VERIFY_REACHED_LIMIT(265, "认证次数已达到上限"),
    REAL_INFO_ALREADY_EXIST(266, "认证未通过，该证件信息已被使用"),
    REAL_INFO_ALI_VERIFY_FAILURE(267, "证件信息输入有误，请重新填写"),
    REAL_INFO_IS_VERIFYING(268, "实名认证审核中"),
    REAL_INFO_VERIFY_NUM_LIMIT(221, "实名认证账号数已达上限"),
    REAL_INFO_VERIFY_FAILURE(222, "认证失败"),
    REAL_INFO_NO_FACE_VERIFY(223, "为保证您的资金安全，请完成人脸认证哦~"),
    REAL_INFO_NO_UPDATE_FACE_VERIFY(224, "为保证您的资金安全，请升级后再来提现哦~"),
    REAL_INFO_MIN_AGE_LIMIT(225, "未成年人不支持认证哦~"),


    // shop
    SHOP_ORDER_NOT_EXIST(261, "订单不存在"),
    SHOP_GOODS_NOT_EXIST(262, "商品不存在"),
    SHOP_EXCHANGE_ENOUGTH(268, "钻石不足，请购买钻石"),
    SHOP_PAY_TYPE_ERROR(269, "支付方式错误"),


    WALLET_WITHDRAW_NOT_EXIST(270, "提现申请不存在"),
    PAY_THIRD_FAIL(271, "第三方支付失败"),
    PAY_TYPE_UNSUPPORT(272, "不支持的支付方式"),
    PAY_ORDER_TYPE_UNSUPPORT(273, "不支持的订单类型"),
    WALLET_WITHDRAW_MONEY_UNREAH_LIMIT(274, "单次最低需提现50元"),
    WALLET_WITHDRAW_NUM_OVER_LIMIT(275, "本周提现次数已用完，下周再来提现哦"),
    WALLET_WITHDRAW_UNFINISH(276, "当前还有未完成的提现"),
    WALLET_WITHDRAW_APP_INVALID(277, "当前还有未完成的提现"),
    WALLET_WITHDRAW_TYPE_ERROR(859, "提现类型输入有误"),
    WALLET_WITHDRAW_UPDATETIME_INVALID(279, "时间有误"),
    WALLET_WITHDRAW_MONEY_INVALID(280, "金额有误"),
    WALLET_PROFIT_TYPE_INVALID(281, "类型有误"),
    WALLET_WITHDRAW_FAIL(282, "提现失败"),
    WALLET_SATE_ERROR(402, "提现状态非法，无法进行转账操作"),
    PAY_OPERATION_UNSUPPORT(283, "不支持的支付操作"),
    PAY_ACCOUNT_UN_EXIST(400, "尚未绑定相应的提现账号"),
    PAY_WAP_URL_INVALID(401, "非法的支付跳转地址"),


    PAY_CERTIFICATE_EXIST(853, "支付凭证异常"),
    WALLET_PUNCH_WITHDRAW_MONEY_UNREAH_LIMIT(853, "打卡单次最低需提现1元"),
    WALLET_WITHDRAW_TIME_ERROR(857, "提现时间不在规定时间范围内"),
    PAY_DIMOND_INSUFFICIENT(858, "钻石数量不足"),

    PAY_RISK_AUTO_CONTROL(859, "系统检测到您的账号存在安全问题，无法充值"),
    PAY_BLACK_USER_IS_ALREADY_EXIST(860, "用户已在支付黑名单"),
    PAY_BLACK_USER_IS_NOT_EXIST(861, "支付黑名单不存在对应用户"),

    //sign
    SIGN_ERROR_STATUS(300, "签到失败"),
    SIGNED_TODAY_ERROR_STATUS(301, "今日已成功签到"),
    SIGN_DAY_NOT_MATCH_STATUS(302, "奖励领取失败，累计签到天数不足"),
    SIGN_REWARD_RECEIVED_ERROR_STATUS(303, "对应签到奖励已领取"),
    SIGN_REWARD_RECEIVED(200, "领奖成功"),

    // voice room
    VOICEROOM_UNEXIST(310, "该房间不存在"),
    VOICEROOM_OFF_SEAT(311, "用户已不在麦序"),
    VOICEROOM_ON_SEAT(312, "用户已在麦序"),
    VOICEROOM_SEAT_UNEXIST(313, "麦序位置不存在"),
    VOICEROOM_OUT_ROOM(314, "用户已不在房间"),
    VOICEROOM_SEAT_TAKEN(315, "暂无空麦位哦~"),
    VOICEROOM_PEMISSION_DENY(316, "您不是管理员，没有操作权限"),
    VOICEROOM_NOT_ALLOWED_ENTER(317, "您已被添加至此房间黑名单"),
    VOICEROOM_PASSWORD_WRONG(318, "房间密码错误，请重新输入"),
    VOICEROOM_ALREADY_IN_ROOM(319, "您已在房间内"),
    VOICEROOM_PASSWD_LEN_EXCEED(320, "密码字符数已超过限制"),
    VOICEROOM_HOST_SEAT_UNTAKEN(321, "主持位为空时，不可入座"),
    VOICEROOM_ADD_BLACK_FAILED(322, "操作失败，请先解除其管理员权限"),
    VOICEROOM_BE_KICKED_OUT_ROOM(323, "目标用户退出语音房或者被管理员请出"),
    VOICEROOM_SEAT_QUEUE_ENABLE_NOT_ALLOWED_ON_SEAT(325, "请参与排麦"),
    VOICEROOM_SEAT_QUEUE_OVER_SIZE(327, "当前排麦人数已经达到最大排麦人数"),
    VOICEROOM_SEAT_FULL(328, "暂无空麦位哦~"),
    VOICEROOM_SEAT_NOT_ALLOWD_CHANGE(329, "排麦模式下不可自由变更座位"),
    VOICEROOM_ON_SEAT_NOT_ALLOWD_QUEUE_UP(331, "您已经在麦位上了"),
    VOICEROOM_SEAT_LOCKED(332, "当前麦位已锁"),
    VOICEROOM_PK_NUM_ERROR(333, "参数PK人数不合法"),
    VOICEROOM_PK_TIME_ERROR(334, "参数PK时长不合法"),
    VOICEROOM_PK_IN_PKING(335, "当前用户上局PK尚未结束，无法参加新的对局"),
    VOICEROOM_PK_USER_NOT_IN_PKING(336, "当前用户不在PK状态"),
    VOICEROOM_PK_USER_CHARM_UPDATE_ERROR(337, "当前用户不在PK状态"),
    VOICEROOM_PK_VOICEROOM_PKING(338, "当前语音房处于PK状态"),
    VOICEROOM_ALREADY_FOCUS(340, "您已经关注该语音房"),
    VOICEROOM_TOP_ALREADY_CONFIGURED(341, "您已经配置过该语音房"),
    VOICEROOM_TIMING_KICK(342, "您已被定时禁止进入该语音房"),
    VOICEROOM_ANNOUNCE_LEN_EXCEED(343, "公告字符数已超过限制"),
    VOICEROOM_IS_FIRST_CREATE(344, "首次创建语音房请编辑基本信息"),
    VOICEROOM_SHORT_ID_IS_EXIST(345, "该靓号已被绑定"),
    VOICEROOM_NOT_OWNER(346, "您不是房主，没有操作权限"),
    VOICEROOM_EXCEED_MAX_ADMIN_NUM(347, "超过最大管理员数量10"),
    VOICEROOM_CONTENT_IS_CONTAINS_SENSITIVE_WORD(348, "您的%s因含有违规内容，提交失败。"),
    VOICEROOM_SEAT_ALL_TAKEN(349, "所有麦位已满"),
    VOICEROOM_REBATE_NOT_ENOUGH(350, "返点余额不足"),
    VOICEROOM_REBATE_WITHDRAW_NOT_EXIST(351, "返点提现记录不存在"),
    VOICEROOM_REBATE_ALREADY_VERIFY(352, "返点提现记录已经审核过了"),
    VOICEROOM_REBATE_CAN_NOT_EXCHANGE(353, "已经设置不能兑换，请联系客服"),
    VOICEROOM_REBATE_CAN_NOT_EXCHANGE_LAST_WEEK(354, "超出兑换上周返点时限，请联系客服"),
    VOICEROOM_REBATE_AMOUNT_ERR(355, "兑换金额输入需大于0"),
    VOICEROOM_TO_UPGRADE(356, "当前版本较低, 请升级后再来哦"),
    VOICEROOM_HAS_NO_TYPE_POWER(357, "暂无开设权限"),
    VOICEROOM_EXCEED_MAX_GUEST_NUM(358, "超过最大嘉宾数量"),
    VOICEROOM_NO_GUEST_PERMISSION(359, "无权限设置嘉宾"),
    VOICEROOM_GUEST_HAS_BINDED(360, "设置失败，用户已是其他房间嘉宾"),
    VOICEROOM_UPDATE_PERMITS_ERROR(361, "更新语音房权限失败"),
    VOICEROOM_EXCEED_MAX_ADMIN_NUM_APPOINT_ORDER(362, "超过最大管理员数量20"),
    VOICEROOM_SEAT_NOT_GOD(363, "只有大神才可以坐此麦位哦~"),
    VOICEROOM_IOS_NO_ENTER(364, "暂不支持进入派单房哦~"),
    VOICEROOM_WELCOME_WORDS_COUNT_OVER_LIMIT(365, "欢迎语最多只可设置10条哦~"),
    VOICEROOM_WELCOME_WORDS_LENGTH_OVER_LIMIT(366, "欢迎语长度超过最大限制"),
    VOICEROOM_CONFIG_EXIST(367, "当前位置已经配置"),
    VOICEROOM_TOP_CONFIG_ERROR(368, "语音房配置时间冲突"),
    VOICEROOM_CFG_EXIST(369, "配置冲突"),
    VOICEROOM_SPLIT_FLOW_CFG_UNEXIST(370, "分流配置不存在"),
    VOICEROOM_VOICE_AUDIT_UNEXIST(371, "房间音频检测不存在"),

    //voice room anchor
    ANCHOR_ALREADY_EXITS(326, "对应主播信息已被注册"),
    ANCHOR_INFO_NOT_COMPLETED(324, "信息不完善"),
    ANCHOR_NO_PERMISSION(339, "电台房需要认证哦"),

    // gift
    GIFT_UNEXIST(330, "礼物不存在"),
    //中间号段被使用
    GIFT_SEND_ERROR_ACCOUNT_BE_FORBIDDEN(350, "礼物发送失败，该用户已被封号"),
    GIFT_SEND_ERROR_ACCOUNT_CANCELED(351, "礼物发送失败，该用户账号已注销"),
    GIFT_OFFLINE(352, "礼物已下架"),
    GIFT_DISCOUNT_CARD_NOT_EXIST(353, "不存在的礼物折扣卡"),

    //task
    TASK_CANNOT_TAKE_REWARD(600, "奖励领取失败，请完成任务后再次提交"),
    TASK_HAVE_EXIST(601, "当前任务已存在"),

    //promote
    PROMOTE_MASTER_INVALID_ERROR_STATUS(280, ""),
    PROMOTE_ALREADY_BIND_MASTER_ERROR_STATUS(281, ""),
    PROMOTE_DEVICE_FORBIDEN_ERROR_STATUS(282, ""),
    PROMOTE_DEVICE_BIND_OVER_FIVE(283, ""),
    PROMOTE_USER_FORBIDDEN(284, ""),
    PRONOTE_ALREADY_BE_MASTER(285, ""),
    PROMOTE_USER_NOT_EXIT(286, "用户不存在"),
    PROMOTE_USER_INFO_WRONG(287, "用户信息有误或用户ID为空"),
    PROMOTE_VERISON_IGNORED(288, "version ignored"),
    PROMOTE_APPID_WRONG(289, "平台ID错误"),

    //me
    ME_REALINFO_UPDATE_FAILURE(730, "更新实名信息失败"),

    //hall
    HALL_NOT_XIST(700, "大厅不存在"),
    HALL_REGISTER_FAILED(701, "游戏账号注册失败"),
    PERMISSION_FAILED(702, "账号验证失败"),
    CHECK_OUT_FAILED(703, "金豆带出失败"),
    CHECK_IN_FAILED(704, "信息获取失败，请重新进入游戏"),
    GAME_NOT_EXIST(705, "游戏不存在"),
    TOKEN_NOT_EXIST(706, "游戏信息获取失败，请重新进入游戏"),
    TYPE_COIN_WRONG(707, "type与金豆类型不符"),

    COIN_OVER_MAX(708, "金豆数量超过最大值"),
    MD5_FAIL(709, "MD5校验失败"),

    //game
    GAME_NOT_EXISIT(710, "游戏不存在"),
    GAME_ACCOUNT_BIND_ALREADY(711, "游戏账号已绑定"),
    GAME_ZONE_NOT_EXIST(712, "游戏分区不存在"),
    GAME_ACCOUNT_NOT_BIND(713, "游戏账号未绑定"),

    // match
    MATCH_NOT_EXIST(720, "比赛不存在"),
    MATCH_NOT_SUPPORT_ACTION(721, "当前状态不支持该操作"),
    MATCH_USER_NOT_START_GAME(722, "用户未参加比赛"),
    MATCH_OVER_MAX_MEMBER(723, "已达最大报名人数"),

    //share
    SHARE_PARAM_ERROR(730, "参数share_type有误"),
    SHARE_FORBIDDEN_ERROR(731, "这条动态正在审核中,请耐心等待哦～"),
    SHARE_DELETE_ERROR(732, "动态已被删除"),

    //trend
    TOPIC_NOT_EXIST(750, "话题不存在"),
    TREND_HAS_KEYWORD(751, "含有敏感词汇，发表失败"),
    TREND_IS_LIKED(752, "不能重复点赞"),
    TREND_NOT_LIKED(753, "不可取消点赞"),
    BLACK_USER_NOT_EXIT(754, "屏蔽的用户不存在"),
    USER_HAS_IN_BLACK(755, "已屏蔽对应用户"),
    USER_IS_BANNED(756, "您因违规已被禁言，如有疑问请联系客服"),
    BROADCAST_COUNT_ZERO(757, "喊话次数不足，充值可奖励喊话次数"),
    BROADCAST_CANNOT(758, "正在发表喊话，请稍后重试"),
    SYSTEM_CONFIG_NOT_EXIST(759, "系统号不存在"),
    TREND_NOT_EXIST(760, "当前动态已被删除"),
    TREND_CONTENT_NULL(761, "请先填写动态内容"),
    USER_TREND_WRONG(762, "只有发布者才能删除"),
    BROADCAST_FAILED(763, "喊话失败，请稍后再试"),
    TREND_ADD_FAILED(764, "添加失败，热门话题已存在"),
    TREND_UPDATE_FAILED(765, "编辑话题失败"),
    TREND_TOPIC_DELETE_FAIL(766, "删除话题失败"),
    TREND_TOPIC_NOT_EXIST(767, "当前话题不存在"),
    TREND_COMMEND_SIZE_OVER(768, "评论字数超过限制"),
    TREND_IN_UPGRADE(769, "请升级新版本后再来发动态哦~"),
    TREND_TOP_INSERT_ERROR(770,"动态置顶插入时间冲突"),

    CONTENT_ROBOT_NULL(719, "当前话题无机器人"),
    //rank
    RANK_NO_RANKLIST(760, "没有此类型的排行榜"),

    //Cp
    CP_JOIN_FAILED(780, "组Cp失败"),
    CP_JOIN_ALREADY_IN_QUEUE(781, "已处于匹配队列"),

    //Console config
    CONSOLE_ALREAGY_CONFIGURED(791, "已经配置过该产品"),
    CONSOLE_CONGIG_FAILED(790, "产品配置失败"),

    //exam test
    EXAM_USER_ALREADY_TESTED(820, "您已经测试过了"),
    EXAM_QUESTION_NULL(821, "抱歉，服务器找不到这个题了~"),
    EXAM_CANNOT_RE_ANSWER(822, "不可重新答上一题"),
    EXAM_NO_ANSWER(823, "没有这个答案"),
    EXAM_ADD_RECORD_PARAM_INVALID(824, "添加答题记录缺少参数或者参数错误"),


    //lip
    LIP_CONFIG_IS_NULL(826, "口红配置信息为空"),
    LIP_ID_ERROR_STATUS(828, "口红ID异常"),

    //reset card
    RESETCARD_RESET_CART_OVER_MAX(825, "复活卡已达数量上限"),
    RESETCARD_FORTUNE_NOT_ENOUGH(829, "剩余复活卡不足，分享可获得复活卡"),
    RESETCARD_FORTUNE_IN_CHANGE(830, "复活卡变更中"),
    RESETCARD_SHARE_NO_RESET_CARD(827, "分享参数错误，不得复活卡"),
    RESETCARD_OVER_MAX_SHARE_ADD_RESETCARD(835, "本日分享可得复活卡已达上限！"),
    RESETCARD_TYPE_WRONG(824, "type与复活卡类型不符"),

    //userPrizeItem
    USERPRIZEITEM_ID_IS_NULL(831, "校验失败，获奖ID为空"),
    USERPRIZEITEM_CHECK_STATE_IS_NULL(832, "审核状态输入异常"),
    USERPRIZEITEM_CHECK_REMARK_IS_NULL(833, "提交失败，请填写驳回原因！"),

    // check phone
    CHECK_PHONE_FORMAT_INVALID(834, "输入内容有误，请检查后提交！"),

    //punch
    PUNCH_BALANCE_NOT_ENOUGH(851, "打卡钱包余额不足"),
    PUNCH_BALANCE_IN_CHANGE(852, "打卡钱包余额更中"),
    PUNCH_NOT_SIGN(853, "没有报名无法打卡"),
    PUNCH_TIME_WRONG(854, "打卡时间不满足"),
    PUNCH_HAS_PUNCH(855, "已经打卡过"),
    PUNCH_HAS_SIGN(856, "已报名，请勿重复报名"),

    //push
    PUSH_UN_KNOW(900, "不存在的通知事件"),


    //apple pay
    APPLE_PAY_RECEIPT_UNKNOW(20000, "支付凭证非嗨呀支付凭证"),
    APPLE_PAY_RECEIPT_ERROR02(21002, "支付凭证异常"),
    APPLE_PAY_RECEIPT_ERROR03(21003, "receipt无法通过验证"),
    APPLE_PAY_RECEIPT_ERROR05(21005, "receipt当前服务不可用"),
    APPLE_PAY_RECEIPT_ERROR07(21007, "receipt是Sandbox receipt，但却发送至生产系统的验证服务"),
    APPLE_PAY_RECEIPT_ERROR08(21008, "receipt是生产receipt，但却发送至Sandbox环境的验证服务"),
    APPLE_PAY_CONFIG_ERROR(21009, "添加参数存在空值"),
    APPLE_PAY_CONFIG_EXIST(21010, "该配置信息已存在"),
    APPLE_PAY_RECEIPT_UNUSUAL(22001, "苹果凭证验证异常"),
    APPLE_PAY_RECEIPT_EXIST(22002, "该订单已验证"),
    APPLE_PAY_GOODS_EXIST(22003, "苹果商店该商品信息配置不存在"),


    //activity_config
    ACTIVITY_EXHIBITION_CONFIG_UN_EXIST(901, "活动展示配置信息不存在"),
    ACTIVITY_BASIC_CONFIG_UN_EXIST(902, "活动基础配置信息不存在"),

    //block
    BLOCK_APPLICATION_EXIST(903, "该应用配置系统中已存在"),
    BLOCK_APP_PLAN_BE_USED(904, "该屏蔽方案已经被应用使用，不允许删除"),
    BLOCK_BUTTON_BE_USED(905, "该按钮已经配置在屏蔽方案中，不允许删除"),
    BLOCK_PAY_BE_USED(906, "该支付方式已经配置在屏蔽方案中，不允许删除"),
    //bill
    BILL_PARAMETER_ERROR(907, "账单字段参数传入错误"),
    //sql order
    SQL_ORDER_ERROR(908, "账单字段参数传入错误"),

    //applet
    APPLET_CONFIG_IS_NULL(909, "小程序配置信息为空"),

    // order
    ORDER_UNEXIST(1000, "订单不存在"),
    ORDER_PAY_SERVICE_UNEXIST(1001, "无法找到订单对应的支付实例"),
    ORDER_FSM_ACTION_UNSUPPORT(1002, "不支持的订单操作"),
    ORDER_FSM_INVALID_PARA(1003, "陪玩订单参数错误"),
    ORDER_CREATE_FAIL(1004, "下单失败"),
    ORDER_F2fPAY_PARA_CHECK_FAIL(1005, "回调参数校验失败"),
    ORDER_NO_FORMAT_INVALID(1006, "非法订单号"),
    ORDER_CAN_NOT_REVOKE(1007, "该订单当前不能取消"),
    ORDER_INVALID_STATE(1008, "无效的订单状态"),
    ORDER_ALREADY_EXIST(1009, "订单已存在"),
    ORDER_NOTIFY_FAIL(1010, "订单结果通知失败"),
    ORDER_OVER_LIMIT_CAPACITY(1011, "订单超限，请联系运维人员"),
    ORDER_PARA_ERR(1012, "非法订单参数,请核对后重新下单"),
    ORDER_INVALID_VERSION(1013, "非法版本号"),
    ORDER_INVALID_POLLING(1014, "不支持的轮询操作"),
    ORDER_HAS_UNFINISHED_ORDER(1016, "尚有未完成订单"),
    ORDER_WALLET_ERROR(1017, "订单零钱包余额更新失败"),
    ORDER_WALLET_NOT_ENOUGH(1018, "余额不足"),
    ORDER_OVER_NUM_LIMIT(1019, "超出单数限制"),
    ORDER_PRICE_ERROR(1020, "输入价格与商品价格不一致"),

    ACCOMPANY_ORDER_ACTION_INVALID(1050, "非法的陪玩订单触发动作"),

    APP_UNEXIST(1015, "小游戏不存在"),


    //Forbidden

    USER_FORBIDDEN_EXIST(1100, "用户该项禁用信息已存在"),
    USER_FORBIDDEN_LOG_IN(1101, "对不起，您的账号已经被冻结，请联系客服！"),
    USER_FORBIDDEN_TREND(1102, "对不起，您的账号已经被管理员关闭发帖功能！"),
    USER_FORBIDDEN_CREATE_VOICE_ROOM(1103, "对不起，您的账号已经被管理员关闭创建语音房功能！"),
    USER_FORBIDDEN_EXIST_NULL(1104, "存在为空的输入参数，请检查！"),
    USER_FORBIDDEN_EXIST_LIMIT_TIME_TIME_IS_NULL(1105, "非永久禁止项时间不能为空"),
    USER_FORBIDDEN_PHONE_CREATE_VOICE_ROOM(1106, "绑定手机号后才能开房间哦"),
    USER_FORBIDDEN_PHONE_TREND(1106, "绑定手机号后才能发动态哦"),
    USER_FORBIDDEN_PHONE_COMMENT(1106, "绑定手机号后才能发评论哦"),
    USER_FORBIDDEN_PHONE_CP(1106, "绑定手机号后才能速配哦"),
    USER_FORBIDDEN_PHONE_ADD_FRIEND(1106, "绑定手机号后才能加好友哦"),
    USER_FORBIDDEN_PHONE_DRIFT_BOTTLE(1106, "绑定手机号后才能玩漂流瓶哦"),
    USER_FORBIDDEN_PHONE(1107, "该手机号已被封停，请更换手机号后再试"),

    USER_FORBIDDEN_VOICEROOM_PLAY_LIMIT_TIME(1108, "您的房间涉嫌违规播放，关停%s小时"),
    USER_FORBIDDEN_VOICEROOM_PLAY_UN_LIMIT_TIME(1109, "您的房间涉嫌违规播放，已被永久关停"),


    USER_FORBIDDEN_DEVICE_IP(1110, "账号存在风险，登陆失败"),
    USER_FORBIDDEN_PAY_ERROR(1111, "账号已被封停，充值失败"),
    USER_DEVICE_ID_LOGIN_ERROR(1112, "该设备由于安全原因无法注册登录。"),

    // mini game
    MINI_GAME_APP_GET_USER_INFO_ERROR(1200, "获取用户信息失败，请重试！"),
    MINI_GAME_APP_GET_ENCRY_ERROR(1201, "获取加密数据失败！"),
    MINI_GAME_APP_CHECK_FAILED(1202, "校验信息未通过"),
    MINI_GAME_APP_SESSION_KEY_RETURN_ERROR(1203, "SessionKey返回异常，请重试"),

    // robot task
    ROBOT_TASK_INVALID_TASK_TYPE(1300, "非法的任务类型"),
    ROBOT_TASK_INVALID_CONFIG_ID(1301, "非法配置项"),
    ROBOT_TASK_INVALID_TRIGGER_TYPE(1302, "非法任务触发类型"),
    ROBOT_TASK_INVALID_CONFIG(1303, "任务配置错误"),
    ROBOT_TASK_PARSE_TASK_ERR(1304, "任务解析失败"),
    ROBOT_TASK_INVALID_SUB_CONFIG_ID(1305, "未找到任务对应的子配置项"),
    ROBOT_TASK_UNSUPPORT_OPERATION(1306, "不支持的任务操作"),
    ROBOT_TASK_PRESENT_INNER_ACCOUNT_NULL(1307, "送礼内部账号未配置"),


    // music

    MUSIC_IMPORT_ERROR(1400, "音乐上传失败"),
    MUSIC_ADD_LIST_IS_NULL(1401, "音乐上传列表为空"),

    //RobotTaskPresentInnerAccount
    ROBOT_TASK_PRESENT_INNER_ACCOUNT_EXIST(1500, "该账户信息已存在"),

    //QM游戏平台
    QM_REGISTER_FAIL(1600, "QM平台游戏账户注册失败"),
    QM_QUERY_BALANCE_FAIL(1601, "QM平台游查询账户余额失败"),
    QM_HOST_CONNECT_FAIL(1602, "QM平台游查连接失败"),
    QM_CHANGE_COINS_ERROR(1603, "QM平台转账失败"),
    QM_CHANGE_IN_COINS_ERROR(1604, "QM平台金豆带入失败"),
    QM_CHANGE_OUT_COINS_ERROR(1605, "QM平台金豆带出失败"),
    QM_ORDER_QUERY_ERROR(1606, "QM平台订单状态查询失败"),

    //social
    SOCIAL_RELATION_CONFIG_NOT_EXIST(1700, "社交关系配置信息不存在"),
    SOCIAL_RELATION_ENUM_NOT_EXIST(1701, "不存在的社交关系"),
    SOCIAL_RELATION_ENUM_IS_EXIST(1702, "已存在的社交关系"),
    SOCIAL_RELATION_ERROR_PARAMETER(1703, "存在不合法的输入参数"),
    SOCIAL_RELATION_ERROR_PARAMETER_NUM_DAY_CONT_NOT_NULL(1704, "存在单日上限时 max_num_day字段不能为空"),
    SOCIAL_RELATION_ERROR_APPLY_RELATION(1705, "参数输入错误，请重试！"),
    SOCIAL_RELATION_NOT_FRIEND_CANT_NOT_APPLY(1706, "非好友关系无法申请社交关系"),
    SOCIAL_RELATION_INTIMACY_NOT_ENOUGH(1707, "亲密度值不足，无法申请社交关系"),
    SOCIAL_RELATION_R_ELATION_IS_MAX(1708, "已达到该关系申请上限"),
    SOCIAL_RELATION_IS_NOW(1709, "已是当前社交关系，无需申请"),
    SOCIAL_RELATION_INVITED_WAIT(1710, "已经发起申请，等待对方回应"),
    SOCIAL_RELATION_INVITED_FAIL(1711, "申请状态已失效"),
    SOCIAL_RELATION_INVITED_NOT_EXIST(1712, "用户申请不存在"),
    SOCIAL_RELATION_ADD_CP_EXIST(1713, "当前用戶已经与其他用户建立了cp关系，无法申请"),

    //WECHAT_ALARM
    WE_CHAT_SEND_ERROR(1800, "微信警报消息发送失败!"),


    //GameResultDetailVO
    GAME_RESULT_DETAIL_PARAM_IS_NULL(1900, "存在为空的参数，请检查入参！"),

    //sensitive
    Sensitive_connect_error(1950, "敏感词获取连接失败"),
    Sensitive_return_error(1951, "敏感词获取返回失败"),

    //voice drift
    DRIFT_BOTTLE_PARAM_ERROR(1400, "漂流瓶参数错误"),
    DRIFT_BOTTLE_NULL(1401, "不存在的漂流瓶"),

    ACTIVITY_UNSUPPORT_OPERATION(1500, "不支持的活动操作"),

    VIP_SCORE_CFG_ERR(1600, "vip积分配置有误"),
    VIP_UPGRADE_CFG_ERR(1601, "vip升级配置有误"),


    //systemMessage
    SYSTEM_MESSAGE_PARAM_IS_NULL(1700, "存在为空的参数"),
    SYSTEM_MESSAGE_PARAM_SEN_TYPE_ERROR(1701, "发送类型输入错误"),
    SYSTEM_MESSAGE_PARAM_SEN_UID_IS_NULL(1702, "为置顶用户发送时Uids不能为空"),
    SYSTEM_MESSAGE_PARAM_SEN_DEVICE_IS_NULL(1703, "为置顶用户发送时device_type不能为空"),
    SYSTEM_MESSAGE_PARAM_SEN_ChannelVersion_IS_ALL_NULL(1704, "通过渠道发送时渠道版本不能都为空"),
    SYSTEM_MESSAGE_CONFIG_ID_UN_EXIST(1705, "不存在的配置id"),
    SYSTEM_MESSAGE_SEND_CAN_NOT_DELETE(1706, "已发送的消息信息不能更改"),
    SYSTEM_MESSAGE_UID_ERROR(1707, "发送用户id格式错误，请以，为分隔符"),
    SYSTEM_MESSAGE_CATEGORY_NOT_EXIST(1708, "不存在的消息类别"),
    SYSTEM_MESSAGE_CONTENT_ERROR(1709, "富文本格式不正确"),

    //black
    BLACK_IS_EXIST(1800, "该类禁用信息不存在"),

    //prop
    PROP_CONFIG_UNEXIST(1850, "道具配置信息不存在"),
    PROP_CONFIG_ERR(1851, "道具配置信息有误"),
    PROP_NOT_SUPPORT_ACTION(1852, "该道具不支持该操作"),
    PROP_OVER_MAX_USE_KIND_AT_ONE_TIME(1853, "超出最大同时使用种类"),
    PROP_OVER_MAX_USE_NUMBER_AT_ONE_TIME(1854, "超出最大同时使用量"),
    PROP_OVER_CUR_NUMBER(1855, "超出剩余使用量"),
    PROP_USER_NUMBER_ERR(1856, "用户道具数量出现错误"),
    PROP_USER_CONFIG_ERR(1857, "用户道具信息出现错误"),
    PROP_USER_GRANT_MESSAGE_TYPE_ERROR(1856, "道具消息发送类型错误"),


    //group
    GROUP_CONFIG_IS_EXIST(1900, "分组信息不存在"),
    GROUP_USER_IS_EXIST(1901, "组用户信息已存在"),

    //wallet
    WALLET_BALANCE_NOT_ENOUGH(1950, "账户余额不足"),
    WALLET_BALANCE_UPDATE_ERROR(1951, "账户余额更新失败，请重试"),
    WALLET_WITHDRAW_NOT_SUPPORT(1952, "不支持该提现方式"),
    WALLET_WITHDRAW_PARAM_ERROR(1953, "存在为空的提现参数"),
    WALLET_WITHDRAW_MIN_AMOUNT_ERROR(1954, "可提现金额大于%.2f元才能申请提现哦"),
    WALLET_WITHDRAW_MAX_AMOUNT_ERROR(1955, "最大提现金额不能高于%.2f元"),
    WALLET_WITHDRAW_AMOUNT_ERROR(1956, "提现金额校验不通过"),
    WALLET_WITHDRAW_WEEKDAY_ERROR(1957, "%s才能提现哦"),
    WALLET_WITHDRAW_AUDIT_ERROR(1958, "该申请单号已处理"),
    WALLET_TYPE_ERROR(1959, "钱包类型错误"),
    WALLET_WITHDRAW_RULE_MIN_AMOUNT_ERROR(1960, "最低提现金额必须大于%.2f元才能提现哦"),
    WALLET_ADD_LIMITED(1961, "超过添加限制金额"),
    //settle

    SETTLE_TYPE_NOT_EXIST(2000, "结算方式不存在"),
    SETTLE_ERROR_INCOME(2001, "非法收益插入"),

    // pound egg
    POUND_EGG_REWARD_CONFIG_ERR(2100, "砸蛋奖励配置错误"),
    POUND_EGG_REWARD_GET_ERR(2101, "砸蛋奖励变更失败"),
    POUND_EGG_EXPORT_MAX_ERROR(2102, "导出记录超出最大行数限制"),
    POUND_EGG_UNSUPPORT(2103, "请升级到最新版本后扭蛋"),
    POUND_EGG_PUBLIC_POOL_ERR(2104, "扭蛋功能升级中, 敬请期待"),
    POUND_EGG_ERR(2105, "服务端根据条件传值"),//服务端根据条件传值
    POUND_EGG_CONFIG_ERR(2106, "砸蛋配置错误"),

    // lucky coin
    LUCKYCOIN_REWARD_UNEXIST(2200, "没有待领取奖励"),
    LUCKYCOIN_REWARD_UNSETTLED(2201, "奖励尚未结算"),
    LUCKYCOIN_REWARD_ALREADY_TAKEN(2202, "奖励已领取"),
    LUCKYCOIN_REWARD_EXPIRED(2203, "奖励已过期"),


    //antispam
    ANTISPAM_REQUEST_FAIL(2300, "请求失败"),

    //activity
    ACTIVITY_NOT_FOUND_HANDLER(2400, "该活动找不到对应的handler"),
    ACTIVITY_NOT_FOUND_CONFIG(2401, "该活动找不到对应的活动配置"),
    ACTIVITY_NOT_FOUND(2403, "活动不存在或已下架"),
    ACTIVITY_CFG_INVALID(2404, "活动配置不存在"),
    ACTIVITY_GOODS_NOT_FOUND(2405, "活动商品已售空"),
    ACTIVITY_HAD_VOTED(2406,"请勿重复投票"),
    ACTIVITY_NOT_VOTE(2407,"很抱歉，您没有抽奖资格，支持歌手可获得抽奖次数哦"),
    ACTIVITY_HAD_LOTTERY(2408,"您已经参加过抽奖活动了哦～"),
    ACTIVITY_NOT_START(2409,"活动尚未开始"),
    ACTIVITY_HAD_FINISHED(2410,"活动已经结束啦"),
    ACTIVITY_START_ERROR(2411,"活动启动异常"),
    ACTIVITY_ALREADY_TAKEN_IN(2412, "您已参与该活动或活动已下架"),
    ACTIVITY_USER_OVER_LIMIT(2413, "活动参与人数已达到上限"),
    ACTIVITY_CP_CONFIG_ERROR(2414,"CP送礼活动配置错误"),
    ACTIVITY_CONTENT_NAME_DUPLICATE(2415,"活动名称重复"),



    //package
    PACKAGE_STUFF_RUN_OUT(2500, "已用完，无法使用"),
    PACKAGE_STUFF_NO_USING(2500, "无使用中物品，无法取下"),
    PACKAGE_GIFT_NUMBER_ERROR(2502, "背包礼物明细扣除异常"),

    //AppThirdBind

    APP_BIND_THIRD_UN_KNOWN(2550, "APP第三方绑定信息不存在"),

    //shop pay
    SHOP_THE_DAY_REAL_PAY_EXCEED_MAX(2600, "您当日充值充值已达最大限制，请明日再试！"),
    SHOP_THE_DAY__PRE_REAL_PAY_EXCEED_MAX(2601, "您的本次充值档位超过单日充值限制，请降低档位后重试"),
    SHOP_USER_ACCOUNT_CANCELED(2602, "账号已注销，充值失败"),
    SHOP_GOOD_SOLD_OUT(2603, "该商品类型已下架"),

    // redpacket
    REDPACKET_UNEXIST(2700, "红包不存在"),
    REDPACKET_EXPIRED(2701, "红包已过期"),
    REDPACKET_UNSUPPORT_RECEIVE_TYPE(2702, "不支持的红包发放方式"),
    REDPACKET_NEED_PASSWORD(2703, "请先设置支付密码"),
    REDPACKET_RECEIVE_NUMBER_ERROR(2704, "红包数量非法"),
    REDPACKET_RECEIVER_UNEXIST(2705, "无效的红包接收人"),
    REDPACKET_DIAMONDS_OVER_LIMIT(2706, "红包钻石超过最大限制"),
    REDPACKET_NOT_FRIEND(2707, "只有好友才能发送红包哦"),
    REDPACKET_BLACK(2708, "您已拉黑对方，红包无法发送"),
    REDPACKET_BLACKED(2709, "您已被拉黑，红包无法发送"),
    REDPACKET_FAILL_USER_BE_FORBIDDEN(2710, "红包发送失败，对方账户存在异常"),
    REDPACKET_FAILL_USER_BE_CANCELED(2711, "红包发送失败，对方账户存在异常"),
    REDPACKET_NO_SEND_POWER(2712, "没有红包发送权限"),

    //channel
    CHANNEL_UN_CONFIG(2800, "该渠道尚未配置，请联系管理员现在控制台进行渠道配置"),


    GIFT_NUM_ERROR(2850, "送礼数量不合法"),

    // union
    UNION_EXIST_UNHANDLED_APPLY(3000, "签约失败, 存在未处理的签约信息"),
    UNION_EXIST_SIGNED(3001, "签约失败, 已经处于签约中"),
    UNION_NOT_EXIST_SIGNED(3002, "解约失败, 并没有被签约"),
    UNION_NOT_EXIST_UNION_ID(3003, "工会ID不存在"),

    //AppThirdBindService
    APP_BIND_PARAM_ERROR(2900, "阿里push绑定参数缺失"),
    APP_BIND_USING_CAN_NOT_MODIFY(2901, "已使用中的配置禁止编辑"),
    APP_BIND_THIRD_TYPE_CAN_NOT_MODIFY(2902, "third_type与 bind_type 不可更改 "),

    // config
    CONFIG_PARAM_EMPTY(3000, "参数配置为空"),
    CONFIG_PARAM_UNEXIST(3001, "参数配置不存在"),
    CONFIG_PARAM_VALUE_TYPE_INVALID(3002, "参数配置值类型不匹配"),


    // Oss
    THIRD_OSS_GET_TOKEN_ERROR(3003, "oss获取上传token失败"),

    // Guard
    GUARD_GROUP_NAME_EDITED_ALREADY(3004, "本周已更改过守护团名称了，下周再来改吧~"),

    // 临时屏蔽相互喜欢聊天接口
    TEMPORARY_UPDATING(3005, "功能升级中，敬请期待"),


    // 临时屏蔽相互喜欢聊天接口
    FISTCharge_EXIST(3050, "首充已经完成"),
    GOOD_TYPE_NOT_MATCH_CURRENCY_TYPE(3051, "商品类型与应付货币类型不匹配"),

    //贵族
    NOBLE_OPENED(3100, "已经开通贵族"),
    NOBLE_NOBLE_LEVEL_TOO_LOW(3101, "贵族等级过低，没有特权，请开通更高等级"),
    NOBLE_NO_CONFIG(3102, "配置不存在"),
    NOBLE_NO_OPENED_OR_EXPIRED(3103, "贵族还没开启或已过期"),
    NOBLE_EXPIRED(3104, "贵族过期了"),
    NOBLE_CAN_NOT_OPEN_LOW(3105, "不能开通低等级贵族"),
    NOBLE_CAN_NOT_HIDE(3106, "进房隐身为公爵贵族的专属特权哦~"),
    NOBLE_ENUM_NO_CONFIG(3107, "贵族枚举中暂未配置该等级贵族"),
    // magic box
    MAGIC_BOX_GEM_NOT_ENOUGH(3200, "宝石余额不足"),
    MAGIC_BOX_REWARD_GET_ERR(3201, "魔盒奖励变更失败"),
    MAGIC_BOX_REWARD_CONFIG_ERR(3202, "魔盒奖励配置错误"),
    MAGIC_BOX_NOT_ENOUGH(3203, "魔盒数量不足"),
    GEM_NOT_ENOUGH(3204, "宝石数量不足"),
    MAGIC_BOX_VERSION_NOT_SUPPORT(3205, "请升级到最新版本后开启魔盒"),
    MAGIC_BOX_ERROR(3206, "服务端限制逻辑"),//服务端限制逻辑，文案由限制逻辑输出
    MAGIC_BOX_Max_OPEN(3207, ""),//服务端限制逻辑，文案由限制逻辑输出

    //visit
    VISIT_TYPE_ERROR(3250, "visit_type类型不存在"),


    //skill
    Skill_NOT_EXIST(3300, "技能不存在"),
    USER_SKILL_NOT_EXIST(3301, "用户技能不存在"),
    Skill_FORBBID(3302, "技能被禁用"),
    Skill_VERIFY_FORBBID(3303, "您已禁止认证大神"),
    SKILL_NEED_REAL_AUTH(3304, "申请技能需要实名认证"),
    SKILL_ADMIN_NO_RECORD(3305, "没有待审核记录"),
    SKILL_VERIFYING(3306, "技能在审核中"),
    SKILL_FORBIDDEN(3307, "已在封禁状态"),
    SKILL_NO_PARAM(3308, "缺少参数"),
    SKILL_ALREADY_HAVE(3309, "已经拥有该技能"),
    SKILL_NOT_GOD(3310, "用户不是大神"),
    SKILL_GOD_FORBID_ORDER(3311, "大神被限制下单"),
    SKILL_FORBID_ORDER(3312, "技能已失效"),
    SKILL_NOT_OPEN(3313, "技能没有开启接单"),
    SKILL_AVATAR_VERIFYING(3314, "头像正在审核中"),
    SKILL_NO_MODIFICATION(3315, "没有更改项"),
    SKILL_NO_CONFIG(3316, "找不到配置"),
    SKILL_STATISTICS_CAS_ERROR(3317, "技能数据统计错误"),
    SKILL_LAB_ERROR(3318, "技能标签"),

    // coupon
    COUPON_CFG_ERR(3400, "优惠券配置错误"),

    //blind datin

    BLIND_DATING_WRONG_ROOM_TYPE(3500, "不是相亲放,不能开始相亲"),
    BLIND_DATING_NO_SUPPORT_OPERATION(3501, "相亲该阶段,不支持该操作"),
    BLIND_DATING_CAN_NOT_SELECT_SELF(3502, "不能选择自己"),
    BLIND_DATING_CAN_NOT_START(3502, "至少需要两位嘉宾才能开始"),
    BLIND_DATING_CAN_NOT_DELAY(3503, "本环节不可延时哦"),
    BLIND_DATING_CAN_NOT_SEAT(3504, "游戏已开始，不能上麦哦"),
    BLIND_DATING_CAN_NOT_CHANGE_SEAT(3505, "游戏已开始，不能换坐哦"),
    BLIND_DATING_CAN_NOT_OFF_SEAT(3506, "心动选择环节无法下麦哦"),
    BLIND_DATING_ALREADY_STOP(3507, "游戏已经结束"),
    BLIND_DATING_HAS_NO_POWER(3508, "您没有操作权限"),
    BLIND_DATING_PARAM_ERR(3509, "参数错误"),
    BLIND_DATING_CONFIG_ERR(3510, "配置错误"),
    BLIND_DATING_CAN_NOT_SKIP_SELECT(3511, "至少需要2人完成心动选择"),

    //location_block
    LOCAtION_BLOCK_EXIST(3550, "屏蔽信息已存在"),

    A8GAME_CONFIG_ERR(3600, "游戏限制配置错误"),
    A8GAME_CONFIG_EXIST(3601, "该用户游戏配置信息已存在"),

    //

    EXCHANGE_PARAM_ERROR(3700, "自定义充值金额不能为空"),
    EXCHANGE_NUMBER_ERROR(3701, "兑换金额异常"),

    //pay plan
    PAY_PLAN_USING(3750, "支付方案应用中，不能删除"),
    PAY_PLAN_ID_ERROR(3751, "支付方案id异常"),
    PAY_PLAN_NAME_EXIST(3752, "该配置方案名称已存在"),


    //user_name_check
    USER_NAME_TOO_LANG(3800, "用户昵称不能超过%s个字符"),
    USER_LOGIN_DEVICE_CHECK(3801, "设备登录账号已达上限，请勿频繁切换账号。"),
    USER_LOGIN_UID_CHECK(3801, "该账号已在多台设备登录，为了您的账号安全，此次登录失败"),
    USER_LOGIN_IP_CHECK(3801, "登录账号已达上限，请勿频繁切换账号。"),


    //rebate
    REBATE_PERMISSION_ERROR(3900, "您当前没有返点权限，请联系客户开通"),
    REBATE_WALLET_NOT_BALANCE(3901, "返点兑换余额不足"),
    REBATE_WALLET_ACCOUNT_BALANCE(3902, "请先添加提现账户信息"),
    REBATE_UPDATE_ERROR(3903, "系统繁忙，请重试"),
    REBATE_UPDATE_BANK(3904, ""),//用于rebate 模块可变异常提示




    GOODS_TYPE_ERROR(4000, "商品类型异常"),

    //promote
    PROMOTE_EXIST(4100, "该idfa已存在"),
    PROMOTE_PLATE_FORM_EXIST(4101, "推广渠道类型不存在"),
    PROMOTE_BILI_EXIST(4102, "Bili TrackID已存在"),

    //4200
    WITHDRAW_CARATE_ERROR(4201, "加密失败"),
    WITHDRAW_SIGN_ERROR(4202, "签约失败"),
    WITHDRAW_ALiPay_ERROR(4203, "支付宝提现失败"),



    //4300
    CURRENCY_TYPE_ERROR(4300,"该类型货币道具类型不存在"),

  //4400
    SHOP_ORDER_STATE_ERROR(4400,"只有支付待审核待状态才可以审核"),
    SHOP_ORDER_STATE_UPDATE_ERROR(4401,"订单状态更新失败"),
    SHOP_LIMIT_PAY(4402,"暂无自定义充值权限，请联系管理员开通"),
    SHOP_MINE_MONEY(4403,"最低起冲"),
    SHOP_ORDER_WAIT_APPROVE(4404,"存在审核中充值订单，请等待审核"),
    SHOP_PAY_TOO_BIG(4405,"单笔最高充值金额限定为%s元哦"),
    SHOP_PAY_HAIN_COINS_RULE(4406,"自定义文案"),
    SHOP_PAY_IP_LIMIT(4407,"该地区暂不支持充值哦，请联系客服了解详情"),

    //4500
    ADVENT_EXIST(4500,"广告配置信息不存在"),
    //4600
    SUPREME_EGG_CONFIG_ERR(4600, "幸运转盘配置错误"),
    SUPREME_EGG_PUBLIC_POOL_ERR(4601, "幸运转盘升级中, 敬请期待"),
    SUPREME_EGG_REWARD_CONFIG_ERR(4602, "幸运转盘奖励配置错误"),
    SUPREME_EGG_LIMIT_ERR(4603, "服务端根据条件传值"),//幸运转盘某个用户被限制
    SUPREME_EGG_REWARD_GET_ERR(4604, "转盘奖励变更失败"),

    //4700
    GUILD_OWN_EXIST(4700,"该用户已有公会"),
    GUILD_NAME_EXIST(4701,"已存在相同公会名称"),
    GUILD_NOT_EXIST(4702,"公会不存在"),
    GUILD_UID_FACE_CERTIFY_NOT_PASS(4703,"请先完成实名认证哦~"),
    GUILD_JOIN_ONLY_ONE(4704,"您实名信息下的其他账号已加入公会哦，请退会后再来申请~"),
    GUILD_JOIN_APPLY(4705,"您提交的公会申请正在审核中哦~"),
    GUILD_APPLY_NOT_EXIST(4706, "该用户没有公会加入或者退出申请"),
    GUILD_MAX_MEMBER(4707, "公会成员已达上限"),
    GUILD_MEMBER_NOT_JOIN(4708, "该用户未加入公会"),
    GUILD_EXIT_APPLY_ERROR(4709, "该用户存在多条退会记录"),
    GUILD_OWNER_NOT_FORCE_EXIT(4710, "公会长不能强制退会"),
    GUILD_JOIN_APPLY_ERROR(4711, "该用户存在多条申请记录"),
    GUILD_OWNER_NOT_EXIT_APPLY(4712, "公会长不能提出退会申请"),
    GUILD_EXIT_REJOIN_APPLY(4713, "暂不可加入公会哟～"),
    GUILD_FORCE_EXIT_REJOIN_APPLY(4714, "暂不可加入公会哟～"),
    GUILD_EXIT_APPLY(4715,"申请退会请求正在审核中哦~"),
    GUILD_OWNER_JOIN_LIMIT(4716,"公会长实名账号加入限制"),

    //4800 grade
    GRADE_TYPE_ERROR(4800, "等级类型不存在"),

    // 4900 task
    TASK_GROUP_UNEXIST(4900, "任务不存在"),

    // 5000 user recommend
    USER_RECOMMEND_OVER_LIMIT(5000, "你换的太频繁，1小时后再来"),
    USER_RECOMMEND_NOT_SUPPORT(5001, "暂不支持该推荐方式"),

    // 5100 chat earn
    CHAT_EARN_STATISTICS_NOT_EXIST(5100, "不存在的统计方式"),


    //5100
    LOVE_RANK_PUBLIC_SENSITIVE_MSG(51001, "发布内容包含敏感词"),

    VIEW_DATA_HANDLER_NOT_EXIST(5300,"视图数据流处理器不存在"),
    VIEW_DATA_SCENE_HANDLER_NOT_EXIST(5301,"视图数据流场景处理器不存在"),

    // 5400 -5499 gaming
    GAMING_TYPE_NOT_EXIST(5400, "不存在的玩法类型"),
    GAMING_CFG_ERR(5401, "玩法配置有误"),
    GAMING_PUBLIC_POOL_ERR(5402, "玩法升级中, 敬请期待"),


    // 5500 -5599  privilege
    PRIVILEGE_UN_EXIST(5501,"用户暂时无此特权"),

    // 5600 -5699  privilege
    LOGIN_SMS_CODE_ERROR(5601,"验证码已失效；可重新请求新的验证码"),
    ;




    ;

    ;


    private int state;

    private String msg;

    ResultEnum(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }

    public static ResultEnum stateOf(int index) {
        for (ResultEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setState(int state) {
        this.state = state;
    }
}
