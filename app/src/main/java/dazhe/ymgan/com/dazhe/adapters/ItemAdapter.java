package dazhe.ymgan.com.dazhe.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import dazhe.ymgan.com.dazhe.R;
import dazhe.ymgan.com.dazhe.entities.ItemInfo;

/**
 * Created by ymgan on 2015/11/19.
 */
public class ItemAdapter extends BaseAdapter {

    private static final String TAG = "DZ_ItemAdapter";

    private Activity mActivity = null;
    private ArrayList<ItemInfo> mItemList = null;
    private static LayoutInflater inflater = null;

    private ImageLoader mImgLoader = null;

    public ItemAdapter(Activity activity, ArrayList<ItemInfo> itemList,ImageLoader imgLoader){
        this.mActivity = activity;
        this.mItemList = itemList;
        this.mImgLoader = imgLoader;
        inflater = (LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mItemList == null ? 0 : mItemList.size();
    }

    @Override
    public Object getItem(int position) {
        if(mItemList == null)
            return null;
        return mItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = inflater.inflate(R.layout.list_item, null);
        }

        ItemInfo item = mItemList.get(position);

        TextView txtTitle = (TextView)view.findViewById(R.id.title);
        txtTitle.setText(item.getTitle());

        NetworkImageView imgView = (NetworkImageView)view.findViewById(R.id.picUrl);
        showImageByNetWorkImageView(imgView, item.getPic_url());

        return view;
    }

    private void showImageByNetWorkImageView(NetworkImageView imgView, String imgUrl){

        imgUrl += "_100x100.jpg";
        Log.d(TAG, imgUrl);
        //RequestQueue mQueue = Volley.newRequestQueue(mActivity);
        //ImageLoader imgLoader = new ImageLoader(mQueue, new BitmapCache());
        imgView.setImageUrl(imgUrl, mImgLoader);
    }

}
