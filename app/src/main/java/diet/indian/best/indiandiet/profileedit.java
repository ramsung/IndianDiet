package diet.indian.best.indiandiet;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static diet.indian.best.indiandiet.R.id.female;
import static diet.indian.best.indiandiet.R.id.male;
import static diet.indian.best.indiandiet.R.styleable.View;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class profileedit extends AppCompatActivity implements View.OnTouchListener {
    CircleImageView cusimage;
    ImageView edit;
    Button male,female;

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
        male = (Button) findViewById(R.id.male);
        female = (Button) findViewById(R.id.female);
        male.setOnTouchListener(this);
        female.setOnTouchListener(this);


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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int id = v.getId();
        if(id == R.id.male){
            male.setPressed(true);

            female.setPressed(false);
        }else if(id == R.id.female){
            male.setPressed(false);
            female.setPressed(true);
        }
        return true;
    }
}
