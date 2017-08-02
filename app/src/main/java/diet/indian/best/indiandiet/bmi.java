package diet.indian.best.indiandiet;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;




/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class bmi extends AppCompatActivity {

    GaugeView gaugeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_activity);
        gaugeView = (GaugeView) findViewById(R.id.gaugeview);


        //gaugeView.setTargetValue(25f);
    }



    public void calculate(View v) {
        if(v.getId() == R.id.calculatebmi) {
            EditText heightText = (EditText) findViewById(R.id.heightbmi);
            TextView resultText = (TextView) findViewById(R.id.resultbmi);

            EditText weightText = (EditText) findViewById(R.id.weightbmi);

            float weight = Float.parseFloat(weightText.getText().toString());
            float height = Float.parseFloat(heightText.getText().toString());

            float bmiValue = calculateBMI(weight, height);

            String bmiInterpretation = interpretBMI(bmiValue);
            gaugeView.setTargetValue(bmiValue);
            resultText.setText(bmiValue + " - " + bmiInterpretation);


            //resultText.setText(bmiInterpretation);

        }
    }

    private float calculateBMI(float weight, float height) {
        return (float) ((weight / height / height)*10000);
    }

    private String interpretBMI(float bmiValue) {
        if(bmiValue < 16) {
            return "Severely underweight";
        } else if(bmiValue < 18.5) {
            return "Underweight";
        } else if(bmiValue < 25) {
            return "Normal";
        } else if(bmiValue < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}