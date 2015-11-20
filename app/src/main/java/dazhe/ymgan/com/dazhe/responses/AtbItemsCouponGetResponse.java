package dazhe.ymgan.com.dazhe.responses;

import java.util.ArrayList;

import dazhe.ymgan.com.dazhe.entities.ItemInfo;

/**
 * Created by ymgan on 2015/11/20.
 */
public class AtbItemsCouponGetResponse {
    public ItemsResult items;

    public long total_results;

    public static class ItemsResult{
        public ArrayList<ItemInfo> aitaobao_item;
    }
}
