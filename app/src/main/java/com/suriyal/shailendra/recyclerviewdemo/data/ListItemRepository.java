package com.suriyal.shailendra.recyclerviewdemo.data;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by shailendra.suriyal
 */
public class ListItemRepository {


    private final ListItemDAO mListItemDAO;

    @Inject
    public ListItemRepository(ListItemDAO listItemDAO){
        this.mListItemDAO = listItemDAO;
    }

    public LiveData<List<ListItem>> getListOfData() {
        return mListItemDAO.getListItems();
    }

    public LiveData<ListItem> getListItemBy(String itemId){
        return mListItemDAO.getListItemById(itemId);
    }

    public void insertListItem(ListItem listItem) {
         mListItemDAO.insertListItem(listItem);
    }

    public void deleteListItem(ListItem listItem){
        mListItemDAO.deleteListItem(listItem);
    }

}
