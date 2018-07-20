package com.suriyal.shailendra.recyclerviewdemo.data;

import android.arch.persistence.room.Database;

/**
 * Created by shailendra.suriyal
 */
@Database(entities = {ListItem.class},version = 1)
public abstract class ListItemDatabase {

    public abstract ListItemDAO mListItemDAO();
}
