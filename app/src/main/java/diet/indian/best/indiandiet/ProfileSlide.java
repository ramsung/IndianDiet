package diet.indian.best.indiandiet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

import agency.tango.materialintroscreen.SlideFragment;
import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * Created by RK on 7/31/2017.
 */

public class ProfileSlide extends SlideFragment {
    private CheckBox checkBox;
    CircleImageView cusimage;
    ImageView edit;
    SegmentedGroup gender, marital, wt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.user_prof_edit, container, false);
        cusimage = (CircleImageView) view.findViewById(R.id.cusimage);
        edit=(ImageView) view.findViewById(R.id.editimage);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, 1);
            }
        });

        gender = (SegmentedGroup) view.findViewById(R.id.Gender);
        gender.setOnCheckedChangeListener(new SegmentedGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(R.id.Male == checkedId){
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Gender", "Male");
                    editor.commit();
                    Toast.makeText(getContext(),"male",Toast.LENGTH_SHORT).show();
                }else if(R.id.Female == checkedId){
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Gender", "Female");
                    editor.commit();
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
                    Toast.makeText(getContext(),"Selected Unmarried",Toast.LENGTH_SHORT).show();               }
            }
        });
        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.pink_900;
    }

    @Override
    public int buttonsColor() {
        return R.color.black;
    }

    /*@Override
    public boolean canMoveFurther() {
        return checkBox.isChecked();
    }*/
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
    @Override
    public String cantMoveFurtherErrorMessage() {
        return getString(R.string.error_message);
    }
}
