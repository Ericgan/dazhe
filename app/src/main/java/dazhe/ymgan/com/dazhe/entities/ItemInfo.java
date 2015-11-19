package dazhe.ymgan.com.dazhe.entities;

/**
 * Created by ymgan on 2015/11/19.
 */
public class ItemInfo {

    private String nick;
    private String openIid;
    private String picUrl;
    private String title;
    private String couponPrice;
    private String couponRate;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getOpenIid() {
        return openIid;
    }

    public void setOpenIid(String openIid) {
        this.openIid = openIid;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(String couponPrice) {
        this.couponPrice = couponPrice;
    }

    public String getCouponRate() {
        return couponRate;
    }

    public void setCouponRate(String couponRate) {
        this.couponRate = couponRate;
    }
}
