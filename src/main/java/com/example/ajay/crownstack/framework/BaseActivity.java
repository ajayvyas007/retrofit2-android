package com.example.ajay.crownstack.framework;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import retrofit2.Call;

public class BaseActivity extends AppCompatActivity {

    private ArrayList<Call> requests = new ArrayList<>();

    private void clearRequests() {
        for (Call request : requests)
            request.cancel();
        requests.clear();
    }

    protected String coalesceError(String error) {
        return error != null ? error : "Internet Connection too slow!";
    }

    public ApiInterface getApiService() {
        return App.getApiContext().getService();
    }

    private <T, V> T processResponse(retrofit2.Response<T> response, ResponseCallback<V> callback) {
        if (response.isSuccessful() && response.body() != null) {
            return response.body();
        } else {
            callback.onError("Error", coalesceError(null), new Error[0]);
            return null;
        }
    }

    private <T> void processError(ResponseCallback<T> callback, Throwable t) {
        if (isNetworkAvailable())
            callback.onError("Error", coalesceError(null), new Error[0]);
        else
            callback.onError("Error", "Internet Connection not available!", new Error[0]);
    }

    public void showError(String title, String message, final RetryCallback callback) {

    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null){
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return false;
    }



    public <T> void enqueueRequest(final Call<T> request, final ResponseCallback<T> callback) {
        requests.add(request);
        request.enqueue(new retrofit2.Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                if (!request.isCanceled()) {
                    T responseBody = processResponse(response, callback);
                    if (responseBody != null)
                        callback.onResponse(responseBody);
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if (!request.isCanceled()) {
                    processError(callback, t);
                }
            }

        });
    }

    @Override
    protected void onDestroy() {
        clearRequests();
        super.onDestroy();
    }
}
