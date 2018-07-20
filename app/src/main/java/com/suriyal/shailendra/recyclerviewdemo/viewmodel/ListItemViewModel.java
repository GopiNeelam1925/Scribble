package com.suriyal.shailendra.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItemRepository;

/**
 * Created by shailendra.suriyal
 */
public class ListItemViewModel extends ViewModel {

    private ListItemRepository repository;

    ListItemViewModel(ListItemRepository repository) {
        this.repository = repository;
    }

    public LiveData<ListItem> getListItemById(String itemId){
        return repository.getListItemBy(itemId);
    }

}
