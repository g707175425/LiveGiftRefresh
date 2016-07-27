package cn.com.unfind.livingrefreshgift;

/**
 * @author zhongxf
 * @Description 礼物的实体类
 * @Date 2016/6/6.
 */
public interface GiftVo {

    String getUserId();

    String getName();

    int getNum();

    int getGiftId();

    String generateId();//可以使用 uid+giftid拼起来组成一个唯一标识
}
