package diet.indian.best.indiandiet;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import diet.indian.best.indiandiet.model.OrderStatus;
import diet.indian.best.indiandiet.model.Orientation;
import diet.indian.best.indiandiet.model.TimeLineModel;
import me.majiajie.pagerbottomtabstrip.*;
import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.listener.*;

import static diet.indian.best.indiandiet.R.id.tab;
import static diet.indian.best.indiandiet.R.id.viewPager;

public class home extends AppCompatActivity {

    int[] testColors = {0xFF455A64, 0xFF00796B, 0xFF795548, 0xFF5B4947, Color.parseColor("#424141")};
//    int[] testColors = {0xFF009688, 0xFF009688, 0xFF009688, 0xFF009688, 0xFF009688};
Toolbar toolbar;
    NavigationController mNavigationController;
    public final static String EXTRA_ORIENTATION = "EXTRA_ORIENTATION";
    public final static String EXTRA_WITH_LINE_PADDING = "EXTRA_WITH_LINE_PADDING";
    public RelativeLayout layout;
    PageBottomTabLayout pageBottomTabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       layout = (RelativeLayout) findViewById(R.id.activity_material_design);
       toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Indian Diet");
        toolbar.setTitleTextColor(Color.parseColor("#ffffff"));
        getIntent().putExtra(EXTRA_ORIENTATION, Orientation.VERTICAL);
        getIntent().putExtra(EXTRA_WITH_LINE_PADDING, false);
        pageBottomTabLayout = (PageBottomTabLayout) findViewById(R.id.tab);



        mNavigationController = pageBottomTabLayout.material()
                .addItem(R.drawable.man,"Personal",testColors[0])
                .addItem(R.drawable.socialacc,"Social",testColors[1])
                .addItem(R.drawable.nearme,"Near Me",testColors[2])
                .addItem(R.drawable.myacc,"Profile",testColors[3])
                .addItem(R.drawable.activity,"Activity",testColors[4])
                .setMode(MaterialMode.CHANGE_BACKGROUND_COLOR | MaterialMode.HIDE_TEXT)
                .setDefaultColor(0x89FFFFFF)
                .build();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),mNavigationController.getItemCount()));
        toolbar.setBackgroundColor(testColors[0]);

        mNavigationController.setupWithViewPager(viewPager);

        mNavigationController.addTabItemSelectedListener(new me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                Log.i("asd","selected: " + index + " old: " + old);
                 toolbar.setBackgroundColor(testColors[index]);
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
    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
public int getLayout(){
    return layout.getHeight();
}

}