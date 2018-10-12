package com.example.ajay.crownstack.framework;

import android.app.Application;

public class App extends Application {

    private static ApiContext apiContext;

    @Override
    public void onCreate() {
        super.onCreate();
        apiContext = new ApiContext(getBaseContext());
    }

    public static ApiContext getApiContext(){
        return apiContext;
    }
}
