package com.suriyal.shailendra.recyclerviewdemo.view;

import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;

import java.util.List;

/**
 * Created by shailendra.suriyal
 */
public interface ViewInterface {

    void startDetailActivity(String dateAndTime, String message, int colorResource);

    void setupAdapterAndView(List<ListItem> listData);

    void addNewListItemToView(ListItem listItem);
}
