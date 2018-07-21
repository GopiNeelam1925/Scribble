package com.suriyal.shailendra.recyclerviewdemo.networking;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by shailendra.suriyal
 */
public interface APIInterface {


    @GET("/notes")
    Call<List<ListItem>> doGetListResources();

    @POST("/notes")
    Call<ListItem> createListItem(@Body ListItem listItem);

    // delete Gist
    @DELETE("notes/{id}")
    Call<Void> deleteListItem(@Path("id") String id);
}
