package com.example.ajay.crownstack.framework;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class EndpointInterceptor implements Interceptor {

    private Context context;

    EndpointInterceptor (Context context){
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();

        /*if(isNetworkAvailable()){
            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
        }else {
            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
        }*/

        String endpointIndexHeader = request.header("BaseUrl");
        if(!TextUtils.isEmpty(endpointIndexHeader)){
            String newUrl = request.url().uri().resolve(endpointIndexHeader+request.url().uri().getPath()).toString();
            builder .url(newUrl)
                    .removeHeader("BaseUrl");
        }

        return chain.proceed(builder.build());
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

