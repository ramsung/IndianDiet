package diet.indian.best.indiandiet;

/**
 * Created by RK on 8/5/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import diet.indian.best.indiandiet.fragments.*;
import diet.indian.best.indiandiet.fragments.profile;

public class WelcomeActivity extends AppCompatActivity {

	private ViewPager viewPager;

	SectionsPagerAdapter adapter;
	private LinearLayout dotsLayout;
	private TextView[] dots;

	private Button btnBack, btnNext;
	private PrefManager prefManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Checking for first time launch - before calling setContentView()
		prefManager = new PrefManager(this);
		if (!prefManager.isFirstTimeLaunch()) {
			launchHomeScreen();
			finish();
		}

		// Making notification bar transparent
		if (Build.VERSION.SDK_INT >= 21) {
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
		}

		setContentView(R.layout.activity_welcome);
		adapter = new SectionsPagerAdapter(getSupportFragmentManager());
		adapter.addFragment(new slide1(), "slide1");
		adapter.addFragment(new profile(), "profile");
		adapter.addFragment(new question(), "question");
		adapter.addFragment(new medical(), "medical");
		adapter.addFragment(new slide5(), "slide5");
		viewPager = (ViewPager) findViewById(R.id.view_pager);
		dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
		btnBack = (Button) findViewById(R.id.btn_back);
		btnNext = (Button) findViewById(R.id.btn_next);


		// layouts of all welcome sliders
		// add few more layouts if you want


		// adding bottom dots
		addBottomDots(0);

		// making notification bar transparent
		changeStatusBarColor();


		viewPager.setAdapter(adapter);
		viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
		btnBack.setVisibility(View.INVISIBLE);
		btnBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				int id = viewPager.getCurrentItem();
				viewPager.setCurrentItem(id-1);


			}
		});

		btnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// checking for last page
				// if last page home screen will be launched
				int current = getItem(+1);
				if (current < 5) {
					// move to next screen
					viewPager.setCurrentItem(current);
				} else {
					launchHomeScreen();
				}
			}
		});
	}

	private void addBottomDots(int currentPage) {
		dots = new TextView[5];
		Log.i("length", String.valueOf(dots.length));
		int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
		int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

		dotsLayout.removeAllViews();
		for (int i = 0; i < dots.length; i++) {
			dots[i] = new TextView(this);
			dots[i].setText(Html.fromHtml("&#8226;"));
			dots[i].setTextSize(35);
			dots[i].setTextColor(colorsInactive[currentPage]);
			dotsLayout.addView(dots[i]);
		}

		if (dots.length > 0)
			dots[currentPage].setTextColor(colorsActive[currentPage]);
	}

	private int getItem(int i) {
		return viewPager.getCurrentItem() + i;
	}

	private void launchHomeScreen() {
		prefManager.setFirstTimeLaunch(true);
		startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
		finish();
	}

	//  viewpager change listener
	ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

		@Override
		public void onPageSelected(int position) {
			addBottomDots(position);

			// changing the next button text 'NEXT' / 'GOT IT'
			if (position == 5 - 1) {
				// last page. make button text to GOT IT
				btnNext.setText(getString(R.string.start));
				btnBack.setVisibility(View.GONE);
			}else if(position == 0){
				btnBack.setVisibility(View.INVISIBLE);
			}

			else {
				// still pages are left
				btnNext.setText(getString(R.string.next));
				btnBack.setVisibility(View.VISIBLE);
			}
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {

		}
	};

	/**
	 * Making notification bar transparent
	 */
	private void changeStatusBarColor() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			window.setStatusBarColor(Color.TRANSPARENT);
		}
	}

	/**
	 * View pager adapter
	 */

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

}
