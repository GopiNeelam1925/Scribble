package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.util.Log;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItemRepository;
import com.suriyal.shailendra.recyclerviewdemo.networking.APIClient;
import com.suriyal.shailendra.recyclerviewdemo.networking.APIInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by shailendra.suriyal
 */
public class NewListItemViewModel extends ViewModel {

    private ListItemRepository repository;

    NewListItemViewModel(ListItemRepository repository) {
        this.repository = repository;
        mAPIInterface = APIClient.getClient().create(APIInterface.class);
    }

    private APIInterface mAPIInterface;
    /**
     * Attach our LiveData to the Database
     */
    public void addNewItemToDatabase(ListItem listItem){

        new AddItemTaskToDatabase().execute(listItem);
        new AddItemTaskToServerDatabase().execute(listItem);
    }

    private class AddItemTaskToServerDatabase extends AsyncTask<ListItem, Void, Void> {

        @Override
        protected Void doInBackground(ListItem... item) {
            Call<ListItem> call1 = mAPIInterface.createListItem(item[0]);
            call1.enqueue(new Callback<ListItem>() {
                @Override
                public void onResponse(Call<ListItem> call, Response<ListItem> response) {
                    Log.d(this.getClass().getCanonicalName(), "Item Successfully added Shailu");
                }

                @Override
                public void onFailure(Call<ListItem> call, Throwable t) {
                    Log.d(this.getClass().getCanonicalName(), "Item Successfully added Shailu");

                    call.cancel();
                }
            });
            return null;
        }
    }


    private class AddItemTaskToDatabase extends AsyncTask<ListItem, Void, Void> {

        @Override
        protected Void doInBackground(ListItem... item) {
            repository.insertListItem(item[0]);
            return null;
        }
    }
}

