package diet.indian.best.indiandiet.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

import diet.indian.best.indiandiet.CircleImageView;
import diet.indian.best.indiandiet.PrefManager;
import diet.indian.best.indiandiet.R;
import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link profile.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link profile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profile extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";

	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;
	CircleImageView cusimage;
	ImageView edit;
	SegmentedGroup gender, marital, wt;
	private OnFragmentInteractionListener mListener;
	PrefManager manager;

	public profile() {
		// Required empty public constructor
	}

	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment profile.
	 */
	// TODO: Rename and change types and number of parameters
	public static profile newInstance(String param1, String param2) {
		profile fragment = new profile();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.user_prof_edit,container,false);
		manager = new PrefManager(getContext());
		cusimage = (CircleImageView) view.findViewById(R.id.cusimage);
		edit=(ImageView) view.findViewById(R.id.editimage);
		edit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.i("inside","profile");

				Intent i = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

				getActivity().startActivityForResult(i, 1);
			}
		});

		gender = (SegmentedGroup) view.findViewById(R.id.Gender);

		gender.setOnCheckedChangeListener(new SegmentedGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
				if(R.id.Male == checkedId){
					manager.setGender("Male");
					Toast.makeText(getActivity(),"male",Toast.LENGTH_SHORT).show();
				}else if(R.id.Female == checkedId){
					manager.setGender("Female");
					Toast.makeText(getActivity(),"female",Toast.LENGTH_SHORT).show();
				}
			}
		});
		wt = (SegmentedGroup) view.findViewById(R.id.weightstat);
		wt.setOnCheckedChangeListener(new SegmentedGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
				if(R.id.Gweight == checkedId){
					Toast.makeText(getContext(),"Woww You Wanna Gain Some Weight",Toast.LENGTH_SHORT).show();
				}else if(R.id.Lweight == checkedId){
					Toast.makeText(getContext(),"Woww You Wanna Reduce Some Weight",Toast.LENGTH_SHORT).show();
				}
				else if(R.id.Hweight == checkedId){
					Toast.makeText(getContext(),"Hurray!! Staying Healthy is best choice!",Toast.LENGTH_SHORT).show();
				}
			}
		});
		marital = (SegmentedGroup) view.findViewById(R.id.marital_stat);
		marital.setOnCheckedChangeListener(new SegmentedGroup.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
				if(R.id.Married == checkedId){

					Toast.makeText(getContext(),"Selected Married",Toast.LENGTH_SHORT).show();
				}else if(R.id.Unmarried == checkedId){
					Toast.makeText(getContext(),"Selected Unmarried",Toast.LENGTH_SHORT).show();
				}
			}
		});
		return view;
	}

	// TODO: Rename method, update argument and hook method into UI event
	public void onButtonPressed(Uri uri) {
		if (mListener != null) {
			mListener.onFragmentInteraction(uri);
		}
	}

	/*@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		if (context instanceof OnFragmentInteractionListener) {
			mListener = (OnFragmentInteractionListener) context;
		} else {
			throw new RuntimeException(context.toString()
					+ " must implement OnFragmentInteractionListener");
		}
	}
*/
	@Override
	public void onDetach() {
		super.onDetach();
		mListener = null;
	}

	/**
	 * This interface must be implemented by activities that contain this
	 * fragment to allow an interaction in this fragment to be communicated
	 * to the activity and potentially other fragments contained in that
	 * activity.
	 * <p>
	 * See the Android Training lesson <a href=
	 * "http://developer.android.com/training/basics/fragments/communicating.html"
	 * >Communicating with Other Fragments</a> for more information.
	 */
	public interface OnFragmentInteractionListener {
		// TODO: Update argument type and name
		void onFragmentInteraction(Uri uri);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == 1 && null != data) {



			try {
				final Uri imageUri = data.getData();
				final InputStream imageStream;
				imageStream = getActivity().getContentResolver().openInputStream(imageUri);
				final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
				cusimage.setImageBitmap(selectedImage);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}



		}


	}
}
