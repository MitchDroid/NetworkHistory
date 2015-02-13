package co.com.mjbarrera.app.network.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.application.PepfullApplication;
import co.com.mjbarrera.app.network.domain.radio.Radio;


/**
 * Created by Personal on 26/10/2014.
 */
public class RadioFragment extends Fragment {

    private Activity mActivity;
    private TextView txtContent;
    private ListView listView;
    private ListView subListView;

    protected List<Radio> list;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_radio, container, false);

        txtContent = (TextView) rootView.findViewById(R.id.txtContent);


        initViews();
        return rootView;
    }

    public void initViews() {

        list = PepfullApplication.getListRadio();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase("Radio")) {
                txtContent.setText(list.get(i).getContent());
            }
        }

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mActivity = activity;
        } catch (ClassCastException e) {
            Log.e(LoginFragment.class.getName(), e.getMessage());
        }
    }
}
