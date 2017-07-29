package diet.indian.best.indiandiet;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AFragment extends Fragment
{
    private static final String ARG_C = "content";

    public static AFragment newInstance(String content) {
        Bundle args = new Bundle();
        args.putString(ARG_C,content);
        AFragment fragment = new AFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        String content = getArguments().getString(ARG_C);
        View personal = inflater.inflate(R.layout.personal, container, false);
        View social = inflater.inflate(R.layout.social, container, false);
        View nearme = inflater.inflate(R.layout.nearme, container, false);
        if(Integer.parseInt(content) == 0){
            return personal;
        }else if (Integer.parseInt(content) == 1){
            return social;
        }else if (Integer.parseInt(content) == 2){
            return nearme;
        }
        TextView textView = new TextView(getContext());
        textView.setTextSize(30);
        textView.setGravity(Gravity.CENTER);
        textView.setText("Test\n\n" +content);
        textView.setBackgroundColor(0xFFececec);
        return textView;
    }
}
