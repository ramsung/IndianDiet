package diet.indian.best.indiandiet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import agency.tango.materialintroscreen.SlideFragment;

/**
 * Created by RK on 7/31/2017.
 */

public class MedicalSlide extends SlideFragment implements  AdapterView.OnItemSelectedListener{
    private CheckBox checkBox;

    String[] disease = {"None", "Allergies", "Alzheimer's", "Arthritis", "Asthma", "Blood Pressure", "Cancer", "Cholesterol", "Chronic Pain",
            "Depression", "Diabetes", "Digestion", "Eyesight", "Heart", "HIV/AIDS", "Infectious Disease", "Menopause", "Sexual Health", "Skin", "Thyroid",};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.medical_card, container, false);
        Spinner spin = (Spinner) view.findViewById(R.id.spinner2);
        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the disease list
        ArrayAdapter aa = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, disease);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);
        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.green_400;
    }

    @Override
    public int buttonsColor() {
        return R.color.red_400;
    }

    /*@Override
    public boolean canMoveFurther() {
        return checkBox.isChecked();
    }*/

    @Override
    public String cantMoveFurtherErrorMessage() {
        return getString(R.string.error_message);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getContext(),disease[position] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
