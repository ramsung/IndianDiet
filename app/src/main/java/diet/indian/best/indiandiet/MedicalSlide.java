package diet.indian.best.indiandiet;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import agency.tango.materialintroscreen.SlideFragment;

/**
 * Created by RK on 7/31/2017.
 */

public class MedicalSlide extends SlideFragment {
    private CheckBox checkBox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.medical_card, container, false);

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
}
