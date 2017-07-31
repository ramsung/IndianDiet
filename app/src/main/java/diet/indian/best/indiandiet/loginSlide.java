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

public class loginSlide extends SlideFragment {
    private CheckBox checkBox;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_main, container, false);
       // checkBox = (CheckBox) view.findViewById(R.id.radiogroup);
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
    public String cantMoveFurtherErrorMessage() {
        return getString(R.string.error_message);
    }
}
