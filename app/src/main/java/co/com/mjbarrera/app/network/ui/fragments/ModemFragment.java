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
import co.com.mjbarrera.app.network.domain.Modem.Modem;

/**
 * Created by Personal on 26/10/2014.
 */
public class ModemFragment extends Fragment {

    private Activity mActivity;
    private TextView txtContent;
    private ListView listView;
    private String[] values;
    private List<Modem> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_modem, container, false);
        txtContent = (TextView) rootView.findViewById(R.id.txtContent);

        initView();
        return rootView;


    }

    public void initView(){

        listItems = PepfullApplication.getListModem();

        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getId().equalsIgnoreCase("Modem")) {
                txtContent.setText(listItems.get(i).getContent());
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
