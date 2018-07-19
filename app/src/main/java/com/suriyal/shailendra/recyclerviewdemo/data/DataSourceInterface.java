package com.suriyal.shailendra.recyclerviewdemo.data;

import java.util.List;

/**
 * Created by shailendra.suriyal
 */
public interface DataSourceInterface {

    List<ListItem> getListOfData();

    ListItem createNewListItem();
}
