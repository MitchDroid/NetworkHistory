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
import co.com.mjbarrera.app.network.domain.PerfilOcupacional.POcupacional;
import co.com.mjbarrera.app.network.domain.PerfilOcupacional.POcupacionalPerfil;
import co.com.mjbarrera.app.network.domain.PerfilProfesional.PProfesionalPerfil;
import co.com.mjbarrera.app.network.ui.adapters.CustomListAdapter;
import co.com.mjbarrera.app.network.utils.JSONHandler;

/**
 * Created by Miller Barrera on 27/10/2014.
 */
public class POcupacionalFragment extends Fragment {

    private Activity mActivity;
    private TextView txtSubTitle;
    private ListView listView;
    private String[] values;
    private List<POcupacionalPerfil> listItems;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_perfil_ocupacional, container, false);

        txtSubTitle = (TextView) rootView.findViewById(R.id.txtpocupacionalsubtitle);
        listView = (ListView) rootView.findViewById(R.id.listview);

        initViews();

        return rootView;
    }

    public void initViews(){

        POcupacional ocupacional = PepfullApplication.getpOcupacional();
        listItems = ocupacional.getListPerfil();
        values = new String[listItems.size()];

        txtSubTitle.setText(ocupacional.getContent());

        for (int i = 0; i < listItems.size(); i++) {
            values[i] = listItems.get(i).getContent();
        }

        CustomListAdapter adapter = new CustomListAdapter(mActivity.getBaseContext(), values);
        listView.setAdapter(adapter);

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
