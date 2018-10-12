package com.example.ajay.crownstack.framework;

/**
 * Created by Ajay Vyas(Android Developer)
 * on 25/06/18 at SSI(Gurgaon).
 */

public interface ResponseCallback<T> {
    void onResponse(T response);

    void onError(String title, String message, Error[] formErrors);
}
