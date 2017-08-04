package diet.indian.best.indiandiet;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import info.hoang8f.android.segmented.SegmentedGroup;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class profileedit extends AppCompatActivity {
    CircleImageView cusimage;
    ImageView edit;
    SegmentedGroup gender, marital, wt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_prof_edit);
        cusimage = (CircleImageView) findViewById(R.id.cusimage);
        edit=(ImageView) findViewById(R.id.editimage);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, 1);
            }
        });

        gender = (SegmentedGroup) findViewById(R.id.Gender);
        gender.setOnCheckedChangeListener(new SegmentedGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(R.id.Male == checkedId){
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Gender", "Male");
                    editor.commit();
                }else if(R.id.Female == checkedId){
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Gender", "Female");
                    editor.commit();
                }
            }
        });
        wt = (SegmentedGroup) findViewById(R.id.weightstat);
        wt.setOnCheckedChangeListener(new SegmentedGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(R.id.Gweight == checkedId){
                    Toast.makeText(getApplicationContext(),"Woww You Wanna Gain Some Weight",Toast.LENGTH_SHORT).show();
                }else if(R.id.Lweight == checkedId){
                    Toast.makeText(getApplicationContext(),"Woww You Wanna Reduce Some Weight",Toast.LENGTH_SHORT).show();
                }
                else if(R.id.Hweight == checkedId){
                    Toast.makeText(getApplicationContext(),"Hurray!! Staying Healthy is best choice!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        marital = (SegmentedGroup) findViewById(R.id.marital_stat);
        marital.setOnCheckedChangeListener(new SegmentedGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if(R.id.Married == checkedId){
                    Toast.makeText(getApplicationContext(),"Selected Married",Toast.LENGTH_SHORT).show();
                }else if(R.id.Unmarried == checkedId){
                    Toast.makeText(getApplicationContext(),"Selected Unmarried",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && null != data) {



            try {
                final Uri imageUri = data.getData();
                final InputStream imageStream;
                imageStream = getContentResolver().openInputStream(imageUri);
                final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                cusimage.setImageBitmap(selectedImage);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }



        }


    }


}
