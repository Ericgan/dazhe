package dazhe.ymgan.com.dazhe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import dazhe.ymgan.com.dazhe.adapters.ItemAdapter;
import dazhe.ymgan.com.dazhe.dal.ItemVolley;
import dazhe.ymgan.com.dazhe.entities.ItemInfo;
import dazhe.ymgan.com.dazhe.utils.BitmapCache;


public class ItemListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<ItemInfo> mItemList;
    private ItemVolley itemVolley = null;
    private ItemAdapter mAdapter = null;

    private static final int PAGE_SIZE = 20;
    private int currentPageNo = 0;

    private ImageLoader mImgLoader = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        mItemList = new ArrayList<ItemInfo>();


        RequestQueue mQueue = Volley.newRequestQueue(this);
        mImgLoader = new ImageLoader(mQueue, new BitmapCache());


        listView = (ListView) findViewById(R.id.list);


        Response.Listener<ArrayList<ItemInfo>> mListener = new Response.Listener<ArrayList<ItemInfo>>() {
            @Override
            public void onResponse(ArrayList<ItemInfo> itemInfos) {

                for(ItemInfo item : itemInfos){
                    mItemList.add(item);
                }

                // get listview current position - used to maintain scroll position
                int currentPosition = listView.getFirstVisiblePosition();

                // Appending new data to menuItems ArrayList
                mAdapter = new ItemAdapter(ItemListActivity.this, mItemList,mImgLoader);
                listView.setAdapter(mAdapter);
                // Setting new scroll position
                listView.setSelectionFromTop(currentPosition + 1, 0);
            }
        };

        itemVolley = new ItemVolley(this);
        itemVolley.setItemListener(mListener);
        LoadItemInfos();

        // LoadMore button
        Button btnLoadMore = new Button(this);
        btnLoadMore.setText("Load More");
        /**
         * Listening to Load More button click event
         * */
        btnLoadMore.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // Starting a new async task
                LoadItemInfos();
            }
        });

        // Adding Load More button to lisview at bottom
        listView.addFooterView(btnLoadMore);
    }


    private void LoadItemInfos(){
        currentPageNo += 1;
        itemVolley.LoadItems(currentPageNo, PAGE_SIZE);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
