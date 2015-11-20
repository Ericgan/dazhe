package dazhe.ymgan.com.dazhe.entities;

/**
 * Created by ymgan on 2015/11/19.
 */
public class ItemInfo {

    private String nick;
    private String open_iid;
    private String pic_url;
    private String title;
    private String coupon_price;
    private String coupon_rate;

    public String getCoupon_rate() {
        return coupon_rate;
    }

    public void setCoupon_rate(String coupon_rate) {
        this.coupon_rate = coupon_rate;
    }

    public String getCoupon_price() {
        return coupon_price;
    }

    public void setCoupon_price(String coupon_price) {
        this.coupon_price = coupon_price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    public String getOpen_iid() {
        return open_iid;
    }

    public void setOpen_iid(String open_iid) {
        this.open_iid = open_iid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
