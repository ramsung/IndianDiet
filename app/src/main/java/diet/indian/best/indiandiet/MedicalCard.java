package diet.indian.best.indiandiet;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import agency.tango.materialintroscreen.SlideFragment;


/**
 * Created by RK on 7/31/2017.
 */

public class MedicalCard extends SlideFragment implements
    AdapterView.OnItemSelectedListener {

   // String[] disease = {"None", "Allergies", "Alzheimer's", "Arthritis", "Asthma", "Blood Pressure", "Cancer", "Cholesterol", "Chronic Pain",
          //  "Depression", "Diabetes", "Digestion", "Eyesight", "Heart", "HIV/AIDS", "Infectious Disease", "Menopause", "Sexual Health", "Skin", "Thyroid",};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String gender= preferences.getString("Gender", null);
        if (gender.equalsIgnoreCase("Male")) {
            setContentView(R.layout.medical_card_male);
        }
            else if(gender.equalsIgnoreCase("Female")){
                setContentView(R.layout.medical_card_female);
            }

        //Spinner spin = (Spinner) findViewById(R.id.spinner2);
        //spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the disease list
       // ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, disease);
       // aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
       // spin.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View arg1, int position,long id) {
     //   Toast.makeText(getApplicationContext(),disease[position] , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
