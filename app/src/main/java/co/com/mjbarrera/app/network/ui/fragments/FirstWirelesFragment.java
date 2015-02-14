package co.com.mjbarrera.app.network.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.application.PepfullApplication;
import co.com.mjbarrera.app.network.domain.PerfilEgreso.FirstWireless;


public class FirstWirelesFragment extends Fragment {

    private Activity mActivity;
    private TextView txtContent;
    private List<FirstWireless> listItems;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_first_wireless, container, false);

        txtContent = (TextView) rootView.findViewById(R.id.txtContent);

        initViews();

        return rootView;
    }

    public void initViews() {
        listItems = PepfullApplication.getListFirstWireless();

        for (int i = 0; i < listItems.size(); i++) {
            if (listItems.get(i).getId().equalsIgnoreCase("FWireless")) {
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


    @Override
    public void onDetach() {
        super.onDetach();
    }


}
