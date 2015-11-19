package dazhe.ymgan.com.dazhe.dal;

import android.content.Context;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import dazhe.ymgan.com.dazhe.base.Config;
import dazhe.ymgan.com.dazhe.entities.ItemInfo;

/**
 * Created by ymgan on 2015/11/19.
 */
public class ItemVolley {

    private Context mContext = null;

    private Response.Listener<String> mListener = null;

    private Response.Listener<ArrayList<ItemInfo>> itemListener = null;

    public ItemVolley(Context context){
        this.mContext = context;
        this.mListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                ArrayList<ItemInfo> itemList = null;
                Gson gson = new Gson();
                itemList = gson.fromJson(s, new TypeToken<ArrayList<ItemInfo>>(){}.getType());
                itemListener.onResponse(itemList);
            }
        };
    }

    public void LoadItems(int pageNo, int pageSize){
        String url = Config.HOST + "?pageNo=" + pageNo + "&pageSize=" + pageSize;
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this.mContext);
        StringRequest request = new StringRequest(Request.Method.GET, url, mListener, errorListener){
            @Override
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try{
                    String jsonString = new String(response.data, "UTF-8");
                    return Response.success(jsonString,
                            HttpHeaderParser.parseCacheHeaders(response));
                }
                catch (UnsupportedEncodingException e){
                    return Response.error(new ParseError(e));
                }
                catch (Exception je) {
                    return Response.error(new ParseError(je));
                }
            }
        };

        requestQueue.add(request);
    }


    public void setItemListener(Response.Listener<ArrayList<ItemInfo>> mListener) {
        this.itemListener = mListener;
    }

}
