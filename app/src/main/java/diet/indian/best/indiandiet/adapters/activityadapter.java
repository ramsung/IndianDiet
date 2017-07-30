package diet.indian.best.indiandiet.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Px;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import diet.indian.best.indiandiet.R;
import diet.indian.best.indiandiet.home;

/**
 * Created by mohan on 7/30/17.
 */

public class activityadapter extends RecyclerView.Adapter<activityadapter.MyViewHolder> {
	private int count;
	private android.content.Context Context;

	public activityadapter(Context Context, int count) {
		this.Context = Context;
		this.count = count;
	}

	@Override
	public activityadapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View itemView = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.griditem, parent, false);
		RecyclerView.ViewHolder holder = new MyViewHolder(itemView);

		return (MyViewHolder) holder;
	}

	@Override
	public void onBindViewHolder(final activityadapter.MyViewHolder holder, int position) {

		final int pos = position;
		try {
//
			Resources r =Context.getResources();
			int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, r.getDisplayMetrics()); // i have bottom tabbar so yf you dont have any thing like this just leave 150 to 0.I think in your case height of image view an your top(Pifer)
			//this change height of rcv

			DisplayMetrics displaymetrics = new DisplayMetrics();
			((home)Context).getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
			int height = ((home)Context).getLayout();
			int width = displaymetrics.widthPixels;
			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			params.setMargins(1,1,1,1);
			params.height = (height - px) / 2;

			//params.width = (width -px )/3;
			//height recycleviewer (there are 5 rows so divide by 5 but i think in your case there are 4 rows so divide by 4)
			holder.layout.setLayoutParams(params);

//           viewHolder.background.setBackground(ContextCompat.getDrawable(context, totalList.get(position).getBackground()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	/*	Album album = albumList.get(position);

//        final Typeface font = Typeface.createFromAsset(Context.getAssets(), "Timber.ttf");
		//  holder.title.setTypeface(font);
		holder.title.setText(album.getName());
		holder.count.setText(album.getNumOfSongs() + " songs");
		Glide.with(Context).load(album.getThumbnail()).into(holder.thumbnail);
		try {
			Palette.from(album.getImage()).maximumColorCount(16).generate(new Palette.PaletteAsyncListener() {
				@Override
				public void onGenerated(Palette palette) {
					// Get the "vibrant" color swatch based on the bitmap

					if (palette.getVibrantSwatch() != null) {
						holder.backgroundColor.setBackgroundColor(palette.getVibrantSwatch().getRgb());
						holder.title.setTextColor(palette.getVibrantSwatch().getTitleTextColor());
						holder.count.setTextColor(palette.getVibrantSwatch().getBodyTextColor());

					}else if (palette.getLightVibrantSwatch() != null) {
						holder.backgroundColor.setBackgroundColor(palette.getLightVibrantSwatch().getRgb());
						holder.title.setTextColor(palette.getLightVibrantSwatch().getTitleTextColor());
						holder.count.setTextColor(palette.getLightVibrantSwatch().getBodyTextColor());
						//holder.count.setTextColor(palette.getMutedSwatch().getBodyTextColor());

					}else if (palette.getDarkVibrantSwatch() != null) {
						holder.backgroundColor.setBackgroundColor(palette.getDarkVibrantSwatch().getRgb());
						holder.title.setTextColor(palette.getDarkVibrantSwatch().getTitleTextColor());
						holder.count.setTextColor(palette.getDarkVibrantSwatch().getBodyTextColor());

					}else if (palette.getLightMutedSwatch() != null) {
						holder.backgroundColor.setBackgroundColor(palette.getLightMutedSwatch().getRgb());
						holder.title.setTextColor(palette.getLightMutedSwatch().getTitleTextColor());
						holder.count.setTextColor(palette.getLightMutedSwatch().getBodyTextColor());
						//holder.count.setTextColor(palette.getMutedSwatch().getBodyTextColor());
					}  else if (palette.getDarkMutedSwatch() != null) {
						holder.backgroundColor.setBackgroundColor(palette.getDarkMutedSwatch().getRgb());
						holder.title.setTextColor(palette.getDarkMutedSwatch().getTitleTextColor());
						holder.count.setTextColor(palette.getDarkMutedSwatch().getBodyTextColor());

					}  else if (palette.getDominantSwatch() != null) {
						holder.backgroundColor.setBackgroundColor(palette.getDominantSwatch().getRgb());
						holder.title.setTextColor(palette.getDominantSwatch().getTitleTextColor());
						holder.count.setTextColor(palette.getDominantSwatch().getBodyTextColor());

					} else if (palette.getMutedSwatch() != null) {
						holder.backgroundColor.setBackgroundColor(palette.getMutedSwatch().getRgb());
						holder.title.setTextColor(palette.getMutedSwatch().getTitleTextColor());
						holder.count.setTextColor(palette.getMutedSwatch().getBodyTextColor());

					}


				}
			});
		} catch (Exception e) {
			Log.i("exception:", album.getName());
		}*/
	}

	@Override
	public int getItemCount() {
		return count;
	}

	public class MyViewHolder extends RecyclerView.ViewHolder {
		public TextView text;
		public LinearLayout layout;
		public ImageView icon;

		public MyViewHolder(View view) {
			super(view);
			text = (TextView) view.findViewById(R.id.activitytext);
			layout = (LinearLayout) view.findViewById(R.id.mainlayout);
			icon = (ImageView) view.findViewById(R.id.activityicon);

		}
	}

}
