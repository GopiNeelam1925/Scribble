package com.suriyal.shailendra.recyclerviewdemo.list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.suriyal.shailendra.recyclerviewdemo.R;
import com.suriyal.shailendra.recyclerviewdemo.util.BaseActivity;

/**
 * Created by shailendra.suriyal
 */

public class ListActivity extends BaseActivity {

    private static final String LIST_FRAG = "LIST_FRAG";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        FragmentManager manager = getSupportFragmentManager();
        ListFragment fragment = (ListFragment) manager.findFragmentByTag(LIST_FRAG);
        if(fragment == null){
            fragment = ListFragment.newInstance();
        }

        addFragmentToActivity(manager,fragment, R.id.root_activity_list, LIST_FRAG );
    }



    //implements  ViewInterface, View.OnClickListener{

//    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
//    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
//    private static final String EXTRA_DRAWABLES = "EXTRA_DRAWABLES";
//
//    private List<Note> mListItems;
//
//    private LayoutInflater mLayoutInflater;
//    private RecyclerView mRecyclerView;
//    private Toolbar mToolbar;
//    private CustomAdapter mAdapter;
//
//    private Controller mController;
//
//
//    @TargetApi(Build.VERSION_CODES.N)
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_list);
//
//        mRecyclerView = findViewById(R.id.rec_list_activity);
//        mLayoutInflater = getLayoutInflater();
//        mToolbar = findViewById(R.id.tlb_list_activity);
//        mToolbar.setTitle(R.string.title_toolbar);
//        mToolbar.setLogo(R.drawable.ic_view_list_white_24dp);
//        mToolbar.setTitleMarginStart(72);
//
//
//        FloatingActionButton floatingActionButton = findViewById(R.id.fab_create_new_item);
//        floatingActionButton.setOnClickListener(this);
//
//        //This is Dependency Injection
//        mController = new Controller(this, new FakeDataSource());
//
//    }
//
//    @Override
//    public void onClick(View view) {
//        int viewId = view.getId();
//        if (viewId == R.id.fab_create_new_item) {
//
//            mController.createNewListItem();
//        }
//
//    }
//
//
//    @Override
//    public void startDetailActivity(String dateAndTime, String message, int colorResource, View viewRoot) {
//        Intent i = new Intent(this, DetailActivity.class);
//        i.putExtra(EXTRA_DATE_AND_TIME,dateAndTime);
//        i.putExtra(EXTRA_DRAWABLES,colorResource);
//        i.putExtra(EXTRA_MESSAGE,message);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setEnterTransition(new Fade(Fade.IN));
//            getWindow().setEnterTransition(new Fade(Fade.OUT));
//
//            ActivityOptions options = ActivityOptions
//                    .makeSceneTransitionAnimation(this,
//                            new Pair<View, String>(viewRoot.findViewById(R.id.imv_list_item_circle),
//                                    getString(R.string.transition_drawable)),
//                            new Pair<View, String>(viewRoot.findViewById(R.id.lbl_message),
//                                    getString(R.string.transition_message)),
//                            new Pair<View, String>(viewRoot.findViewById(R.id.lbl_date_and_time),
//                                    getString(R.string.transition_date_time)));
//            startActivity(i,options.toBundle());
//
//        }
//
//        startActivity(i);
//    }
//
//    @Override
//    public void setupAdapterAndView(List<Note> listData) {
//        this.mListItems = listData;
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//
//        mRecyclerView.setLayoutManager(linearLayoutManager);
//
//        mAdapter = new CustomAdapter();
//        mRecyclerView.setAdapter(mAdapter);
//        DividerItemDecoration dividerItemDecoration =
//                new DividerItemDecoration(mRecyclerView.getContext(),
//                linearLayoutManager.getOrientation());
//
//        dividerItemDecoration.setDrawable(
//                ContextCompat.getDrawable(ListActivity.this,
//                R.drawable.divider_white));
//        mRecyclerView.addItemDecoration(dividerItemDecoration);
//
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createHelperCallback());
//        itemTouchHelper.attachToRecyclerView(mRecyclerView);
//
//    }
//
//    @Override
//    public void addNewListItemToView(Note listItem) {
//        mListItems.add(listItem);
//
//        int endOfList = mListItems.size()-1;
//
//        mAdapter.notifyItemInserted(endOfList);
//
//        mRecyclerView.smoothScrollToPosition(endOfList);
//    }
//
//    @Override
//    public void deleteListItemAt(int position) {
//        mListItems.remove(position);
//
//        mAdapter.notifyItemRemoved(position);
//
//    }
//
//    @Override
//    public void showUndoSnackBar() {
//
//        Snackbar.make(
//                findViewById(R.id.root_list_activity),
//                getString(R.string.action_delete_item),
//                Snackbar.LENGTH_LONG)
//                .setAction(R.string.action_undo, new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mController.onUndoConfirmed();
//                    }
//                })
//                .addCallback(new BaseTransientBottomBar.BaseCallback<Snackbar>() {
//                    @Override
//                    public void onDismissed(Snackbar transientBottomBar, int event) {
//                        super.onDismissed(transientBottomBar, event);
//                        mController.onSnackbarTimeOut();
//                    }
//                }).show();
//    }
//
//    @Override
//    public void insertListItemAt(int position, Note listItem) {
//        mListItems.add(position,listItem);
//        mAdapter.notifyItemInserted(position);
//
//    }
//
//    private class CustomAdapter extends  RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {
//
//        @NonNull
//        @Override
//        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//
//            View v = mLayoutInflater.inflate(R.layout.item_data, viewGroup, false);
//
//
//            return new CustomViewHolder(v);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
//            Note currentItem = mListItems.get(i);
//
//            customViewHolder.mColoredCircle.setImageResource(currentItem.getColorResource());
//            customViewHolder.mDateAndTime.setText(currentItem.getNoteId());
//            customViewHolder.mMessage.setText(currentItem.getMessage());
//
//            customViewHolder.mProgressBar.setVisibility(View.INVISIBLE);
//        }
//
//        @Override
//        public int getItemCount() {
//            //get the total no of data
//            return mListItems.size();
//        }
//
//        public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//
//            private CircleImageView mColoredCircle;
//            private TextView mDateAndTime;
//            private TextView mMessage;
//            private ViewGroup mContainer;
//            private ProgressBar mProgressBar;
//
//
//            public CustomViewHolder(@NonNull View itemView) {
//                super(itemView);
//
//                this.mColoredCircle = itemView.findViewById(R.id.imv_list_item_circle);
//                this.mDateAndTime = itemView.findViewById(R.id.lbl_date_and_time);
//                this.mMessage = itemView.findViewById(R.id.lbl_message);
//                this.mContainer = itemView.findViewById(R.id.root_list_item);
//                this.mProgressBar = itemView.findViewById(R.id.pro_item_data);
//                this.mContainer.setOnClickListener(this);
//
//
//            }
//
//            @Override
//            public void onClick(View view) {
//                Note listItem = mListItems.get(this.getAdapterPosition());
//                mController.onListItemClicked(listItem,
//                        view);
//            }
//        }
//    }
//    private  ItemTouchHelper.Callback createHelperCallback() {
//        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(
//                0,
//                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//
//            //not used, as the first parameter above is 0
//            @Override
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
//                                  RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//
//            @Override
//            public void onSwiped(final RecyclerView.ViewHolder viewHolder, int swipeDir) {
//                int position = viewHolder.getAdapterPosition();
//                mController.onListItemSwiped(
//                        position,
//                        mListItems.get(position)
//                );
//            }
//        };
//
//        return simpleItemTouchCallback;
//
//    }
}
