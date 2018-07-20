package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItemRepository;

/**
 * Created by shailendra.suriyal
 */
public class NewListItemViewModel extends ViewModel {

    private ListItemRepository repository;

    NewListItemViewModel(ListItemRepository repository) {
        this.repository = repository;
    }

    /**
     * Attach our LiveData to the Database
     */
    public void addNewItemToDatabase(ListItem listItem){
        new AddItemTask().execute(listItem);
    }

    private class AddItemTask extends AsyncTask<ListItem, Void, Void> {

        @Override
        protected Void doInBackground(ListItem... item) {
            repository.insertListItem(item[0]);
            return null;
        }
    }
}

