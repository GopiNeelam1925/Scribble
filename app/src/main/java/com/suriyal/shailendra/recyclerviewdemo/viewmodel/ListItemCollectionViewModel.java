package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItemRepository;

import java.util.List;

/**
 * Created by shailendra.suriyal
 */
public class ListItemCollectionViewModel extends ViewModel {

    private ListItemRepository mListItemRepository;


    public ListItemCollectionViewModel(ListItemRepository listItemRepository) {
        mListItemRepository = listItemRepository;
    }

    public LiveData<List<ListItem>> getListItems(){
        return mListItemRepository.getListOfData();
    }

    public void deleteListItem(ListItem listItem){
        DeleteItemTask deleteItemTask = new DeleteItemTask();
        deleteItemTask.execute(listItem);
    }

    private class DeleteItemTask extends AsyncTask<ListItem, Void, Void> {

        @Override
        protected Void doInBackground(ListItem... listItem) {
            mListItemRepository.deleteListItem(listItem[0]);
            return null;
        }
    }
}
