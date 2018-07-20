package com.suriyal.shailendra.recyclerviewdemo.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by shailendra.suriyal
 */
@Database(entities = {ListItem.class},version = 1)
public abstract class ListItemDatabase extends RoomDatabase{

    public abstract ListItemDAO mListItemDAO();
}
