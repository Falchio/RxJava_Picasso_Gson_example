package ru.falchio.myretrofitexample;


import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class RetrofitPresenter {
    private final String TAG = this.getClass().getSimpleName();
    private RetrofitApi retrofitApi;
    private String avaPath;

    public RetrofitPresenter() {
        this.retrofitApi = new RetrofitApi();
    }

    public void getString() {
        Observable<User> single = retrofitApi.requestServer();
        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            Log.d(TAG, "getString: " + user.avaPath);
            avaPath = user.avaPath;
        }, throwable -> {
            Log.e(TAG, "getString: Error");
        });
    }

    public String getAvaPath() {
        return avaPath;
    }
}


