package ru.xinvestoriginal.siliconwalleytest.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import ru.xinvestoriginal.siliconwalleytest.models.ResponseItem;


/**
 * Created by x-inv on 04.11.2017.
 */

public interface PointApi {
    @GET("/v1/search-items")
    @Headers({"Content-Type: application/xml", "Accept: application/xml"})
    Call<ResponseItem> getData();
}
