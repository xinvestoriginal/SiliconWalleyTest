package ru.xinvestoriginal.siliconwalleytest.presenters;

import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import ru.xinvestoriginal.siliconwalleytest.api.PointApi;
import ru.xinvestoriginal.siliconwalleytest.models.PointItem;
import ru.xinvestoriginal.siliconwalleytest.models.ResponseItem;
import ru.xinvestoriginal.siliconwalleytest.views.IMain;

/**
 * Created by x-inv on 04.11.2017.
 */

public class MainPresenter {
    private static final String POINT_URL = "https://api.jeench.com";

    private static MainPresenter instance = null;
    public static MainPresenter getInstance(){
        if (instance == null) instance = new MainPresenter();
        return instance;
    }

    private List<PointItem> items;
    private IMain view;

    private MainPresenter(){
        items = null;
        view  = null;
    }

    public void take(IMain v){
        view = v;
        if (items == null){
            loadItems();
        }else{
            view.onItemsLoad(items);
        }
    }

    public void drop(){
        view = null;
        instance = null;
    }

    private void loadItems(){
        view.setProgressBarVisible(true);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(POINT_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        PointApi pointApi = retrofit.create(PointApi.class);
        pointApi.getData().enqueue(new Callback<ResponseItem>() {
            @Override
            public void onResponse(Call<ResponseItem> call, Response<ResponseItem> response) {

                if(response.isSuccessful()) {
                    items = response.body().message.points;

                    if (view != null) {
                        view.setProgressBarVisible(false);
                        view.onItemsLoad(items);
                    }
                }
                else {
                    if (view != null) {
                        view.setProgressBarVisible(false);
                        view.onItemsError();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseItem> call, Throwable t) {
                Log.e("@@@","onFailure " + t.getMessage());
                if (view != null) view.onItemsError();
                t.printStackTrace();
            }
        });
    }
}
