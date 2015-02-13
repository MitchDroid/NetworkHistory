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
import co.com.mjbarrera.app.network.domain.PerfilEgreso.PEgreso;
import co.com.mjbarrera.app.network.domain.PerfilEgreso.PEgresoFunciones;
import co.com.mjbarrera.app.network.utils.JSONHandler;


public class PEgresoFragment extends Fragment {

    private Activity mActivity;
    private TextView txtContentUno;
    private TextView txtContentDos;
    private TextView txtItemUno;
    private TextView txtItemDos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment_perfil_egreso, container, false);

        txtContentUno = (TextView) rootView.findViewById(R.id.txtPerfilEgresonContentUno);
        txtContentDos = (TextView) rootView.findViewById(R.id.txtPerfilEgresonContentDos);
        txtItemUno = (TextView) rootView.findViewById(R.id.txtPerfilEgresoItemUno);
        txtItemDos = (TextView) rootView.findViewById(R.id.txtPerfilEgresoItemDos);

        initViews();

        return rootView;
    }

    public void initViews(){
        PEgreso response = PepfullApplication.getPerfilEgresoResponse();
        txtContentUno.setText(response.getContent_uno());
        txtContentDos.setText(response.getContent_dos());

        List<PEgresoFunciones> list = response.getListFunciones();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId().equalsIgnoreCase("1")){
                txtItemUno.setText("- " + list.get(i).getContent());
            }else if(list.get((i)).getId().equalsIgnoreCase("2")){
                txtItemDos.setText("- " + list.get(i).getContent());
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
