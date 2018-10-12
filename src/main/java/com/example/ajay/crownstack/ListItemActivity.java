package com.example.ajay.crownstack;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ajay.crownstack.adapter.ItemAdapter;
import com.example.ajay.crownstack.framework.BaseActivity;
import com.example.ajay.crownstack.framework.ResponseCallback;
import com.example.ajay.crownstack.framework.RetryCallback;
import com.example.ajay.crownstack.model.Data;
import com.example.ajay.crownstack.model.Responce;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListItemActivity extends BaseActivity {


    private RecyclerView recyclerView;
    private List<Data> datas;
    private ItemAdapter adapter;
    private CircleImageView artist_avatar;
    private ImageView backdrop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initCollapsingToolbar();
        datas = new ArrayList<>();
        adapter = new ItemAdapter(this, datas);
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                final Data data = datas.get(position);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(ListItemActivity.this,ItemDetails.class);
                        intent.putExtra("item",data);
                        startActivity(intent);
                    }
                }, 200);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        recyclerView.setAdapter(adapter);
        backdrop = (ImageView)findViewById(R.id.backdrop);
        artist_avatar = (CircleImageView)findViewById(R.id.artist_avatar);
        getDataFromServer();


    }


    /**
     * Initializing collapsing toolbar
     * Will show and hide the toolbar title on scroll
     */
    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        appBarLayout.setExpanded(true);

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.artist_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

    private void getDataFromServer(){
        enqueueRequest(getApiService().getSongsList(), new ResponseCallback<Responce>() {
            @Override
            public void onResponse(Responce response) {
                if(response!=null && response.getResults().size()>0){
                    Glide.with(ListItemActivity.this).load(response.getResults().get(0).getArtworkUrl100()).into((artist_avatar));
                    Glide.with(ListItemActivity.this).load(response.getResults().get(0).getArtworkUrl100()).into((backdrop));
                }
                datas.addAll(response.getResults());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(String title, String message, Error[] formErrors) {
                showError(title, message, new RetryCallback() {
                    @Override
                    public void onRetry() {
                    }

                    @Override
                    public void onError() {
                    }
                });
            }
        });
    }
}
