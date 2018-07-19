package com.suriyal.shailendra.recyclerviewdemo.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.suriyal.shailendra.recyclerviewdemo.R;
import com.suriyal.shailendra.recyclerviewdemo.data.FakeDataSource;
import com.suriyal.shailendra.recyclerviewdemo.data.ListItem;
import com.suriyal.shailendra.recyclerviewdemo.logic.Controller;

import java.util.List;

/**
 * Created by shailendra.suriyal
 */

public class ListActivity extends AppCompatActivity implements  ViewInterface, View.OnClickListener{

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_DRAWABLES = "EXTRA_DRAWABLES";

    private List<ListItem> mListItems;

    private LayoutInflater mLayoutInflater;
    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;

    private Controller mController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecyclerView = (RecyclerView) findViewById(R.id.rec_list_activity);
        mLayoutInflater = getLayoutInflater();

        FloatingActionButton floatingActionButton = findViewById(R.id.fab_create_new_item);
        floatingActionButton.setOnClickListener(this);

        //This is Dependency Injection
        mController = new Controller(this, new FakeDataSource());

    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.fab_create_new_item) {

            mController.createNewListItem();
        }

    }


    @Override
    public void startDetailActivity(String dateAndTime, String message, int colorResource) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(EXTRA_DATE_AND_TIME,dateAndTime);
        i.putExtra(EXTRA_DRAWABLES,colorResource);
        i.putExtra(EXTRA_MESSAGE,message);
        startActivity(i);
    }

    @Override
    public void setupAdapterAndView(List<ListItem> listData) {
        this.mListItems = listData;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        mAdapter = new CustomAdapter();
        mRecyclerView.setAdapter(mAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(ListActivity.this,R.drawable.divider_white));
        mRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void addNewListItemToView(ListItem listItem) {
        mListItems.add(listItem);

        int endOfList = mListItems.size()-1;

        mAdapter.notifyItemInserted(endOfList);

        mRecyclerView.smoothScrollToPosition(endOfList);
    }

    private class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

        @NonNull
        @Override
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v = mLayoutInflater.inflate(R.layout.item_data, viewGroup, false);


            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
            ListItem currentItem = mListItems.get(i);

            customViewHolder.mColoredCircle.setBackgroundResource(currentItem.getColorResource());
            customViewHolder.mDateAndTime.setText(currentItem.getDateAndTime());
            customViewHolder.mMessage.setText(currentItem.getMessage());

        }

        @Override
        public int getItemCount() {
            //get the total no of data
            return mListItems.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            private  View mColoredCircle;
            private TextView mDateAndTime;
            private TextView mMessage;
            private ViewGroup mContainer;


            public CustomViewHolder(@NonNull View itemView) {
                super(itemView);

                this.mColoredCircle = itemView.findViewById(R.id.imv_list_item_circle);
                this.mDateAndTime = (TextView) itemView.findViewById(R.id.lbl_date_and_time);
                this.mMessage = (TextView) itemView.findViewById(R.id.lbl_message);
                this.mContainer = (ViewGroup) itemView.findViewById(R.id.root_list_item);
                this.mContainer.setOnClickListener(this);

            }

            @Override
            public void onClick(View view) {
                ListItem listItem = mListItems.get(this.getAdapterPosition());
                mController.onListItemClicked(listItem);
            }
        }
    }
}
