package diet.indian.best.indiandiet;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import me.majiajie.pagerbottomtabstrip.*;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.*;

import static diet.indian.best.indiandiet.R.id.tab;

public class home extends AppCompatActivity {
    int[] testColors = {0xFF455A64, 0xFF00796B, 0xFF795548, 0xFF5B4947, 0xFFF57C00};
//    int[] testColors = {0xFF009688, 0xFF009688, 0xFF009688, 0xFF009688, 0xFF009688};

    NavigationController mNavigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

      /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        PageBottomTabLayout pageBottomTabLayout = (PageBottomTabLayout) findViewById(R.id.tab);


        mNavigationController = pageBottomTabLayout.material()
                .addItem(R.drawable.myacc,"Personal",testColors[0])
                .addItem(R.drawable.socialacc,"Social",testColors[1])
                .addItem(R.drawable.nearme,"Nearby",testColors[2])
                .setMode(MaterialMode.CHANGE_BACKGROUND_COLOR | MaterialMode.HIDE_TEXT)
                .setDefaultColor(0x89FFFFFF)
                .build();
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),mNavigationController.getItemCount()));

        //自动适配ViewPager页面切换
        mNavigationController.setupWithViewPager(viewPager);

        //也可以设置Item选中事件的监听
        mNavigationController.addTabItemSelectedListener(new me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Log.i("asd","selected: " + index + " old: " + old);
            }

            @Override
            public void onRepeat(int index) {
                Log.i("asd","onRepeat selected: " + index);
            }
        });
    }


    private class ListScrollListener extends RecyclerView.OnScrollListener{

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            if(dy > 8){
                mNavigationController.hideBottomLayout();
            } else if(dy < -8){
                mNavigationController.showBottomLayout();
            }
        }
    }



    private class TestViewPagerAdapter extends FragmentPagerAdapter {

        public TestViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            TestFragment fragment = new TestFragment();
            fragment.setListListener(new ListScrollListener());
            return fragment;
        }

        @Override
        public int getCount() {
            return mNavigationController.getItemCount();
        }
    }

    public static class TestFragment extends Fragment{

        RecyclerView.OnScrollListener listListener;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.recyclerview,container,false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
            recyclerView.setAdapter(new TestAdapter());
            recyclerView.addItemDecoration(new DividerItemDecoration(view.getContext(),DividerItemDecoration.VERTICAL));
            recyclerView.addOnScrollListener(listListener);

        }

        public void setListListener(RecyclerView.OnScrollListener listListener) {
            this.listListener = listListener;
        }
    }

    private static class TestAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            int padding = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 16, parent.getResources().getDisplayMetrics());
            TextView textView = new TextView(parent.getContext());
            textView.setPadding(padding,padding,padding,padding);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);

            return new RecyclerView.ViewHolder(textView) {};
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            if(holder.itemView instanceof TextView){
                ((TextView) holder.itemView).setText(String.valueOf(position));
            }
        }

        @Override
        public int getItemCount() {
            return 100;
        }
    }
}