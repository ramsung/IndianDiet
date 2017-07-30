package diet.indian.best.indiandiet;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import diet.indian.best.indiandiet.adapters.activityadapter;
import diet.indian.best.indiandiet.model.OrderStatus;
import diet.indian.best.indiandiet.model.Orientation;
import diet.indian.best.indiandiet.model.TimeLineModel;

public class AFragment extends Fragment
{
    private static final String ARG_C = "content";
    private RecyclerView mRecyclerView;
    private TimeLineAdapter mTimeLineAdapter;
    private List<TimeLineModel> mDataList = new ArrayList<>();
    private Orientation mOrientation;
    private boolean mWithLinePadding;
    RecyclerView rv;
    public static AFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C,content);
        AFragment fragment = new AFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        String content = getArguments().getString(ARG_C);
        View personal = inflater.inflate(R.layout.personal, container, false);
        View social = inflater.inflate(R.layout.social, container, false);
        View nearme = inflater.inflate(R.layout.nearme, container, false);
        View profile = inflater.inflate(R.layout.profile, container, false);
        View store = inflater.inflate(R.layout.store, container, false);

        if(Integer.parseInt(content) == 0){
            mOrientation = Orientation.VERTICAL;
            mWithLinePadding = true;
            mRecyclerView = (RecyclerView) personal.findViewById(R.id.recyclerView);
            mRecyclerView.setLayoutManager(getLinearLayoutManager());
            mRecyclerView.setHasFixedSize(true);
            setDataListItems();
            mTimeLineAdapter = new TimeLineAdapter(mDataList, mOrientation, mWithLinePadding);
            mRecyclerView.setAdapter(mTimeLineAdapter);

            return personal;
        }else if (Integer.parseInt(content) == 1){
            return social;
        }else if (Integer.parseInt(content) == 2){
            return nearme;
        }else if (Integer.parseInt(content) == 3){
            return profile;
        }else if (Integer.parseInt(content) == 4){
            rv = (RecyclerView) store.findViewById(R.id.rv);
            activityadapter adapter = new activityadapter(getContext(),9);
            rv.setAdapter(adapter);
            GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
            rv.setLayoutManager(layoutManager);
            adapter.notifyDataSetChanged();

            return store;
        }
        TextView textView = new TextView(getContext());
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        textView.setText("Test\n\n" +content);
        textView.setBackgroundColor(0xFFececec);
        return textView;
    }

    private LinearLayoutManager getLinearLayoutManager() {
        if (mOrientation == Orientation.HORIZONTAL) {
            return new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        } else {
            return new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        }
    }

    private void setDataListItems(){
        mDataList.add(new TimeLineModel("Item successfully delivered", "", OrderStatus.INACTIVE));
        mDataList.add(new TimeLineModel("Courier is out to delivery your order", "2017-02-12 08:00", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineModel("Item has reached courier facility at New Delhi", "2017-02-11 21:00", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("Item has been given to the courier", "2017-02-11 18:00", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("Item is packed and will dispatch soon", "2017-02-11 09:30", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("Order is being readied for dispatch", "2017-02-11 08:00", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("Order processing initiated", "2017-02-10 15:00", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("Order confirmed by seller", "2017-02-10 14:30", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineModel("Order placed successfully", "2017-02-10 14:00", OrderStatus.COMPLETED));
    }

}
