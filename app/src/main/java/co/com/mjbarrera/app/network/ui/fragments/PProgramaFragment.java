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
import co.com.mjbarrera.app.network.domain.PerfilProfesional.PProfesionalPerfil;
import co.com.mjbarrera.app.network.domain.PerfilPrograma.PPrograma;
import co.com.mjbarrera.app.network.domain.PerfilPrograma.PProgramaConocimientos;
import co.com.mjbarrera.app.network.domain.PerfilPrograma.PProgramaHabilidades;
import co.com.mjbarrera.app.network.domain.PerfilPrograma.PProgramaPerfil;
import co.com.mjbarrera.app.network.ui.adapters.CustomListAdapter;
import co.com.mjbarrera.app.network.utils.JSONHandler;

/**
 * Created by Personal on 26/10/2014.
 */
public class PProgramaFragment extends Fragment {

    private Activity mActivity;
    private TextView txtSubTitle;
    private TextView txtItemone;
    private TextView txtItemtwo;
    private TextView txtItemthree;

    private TextView txtConocimientosItemsOne;
    private TextView txtConocimientosItemsTwo;
    private TextView txtConocimientosItemsThree;

    private TextView txtHabilidadesItemsOne;
    private TextView txtHabilidadesItemsTwo;
    private TextView txtHabilidadesItemsThree;

    private ListView listView;
    private String[] values;
    private List<PProgramaPerfil> listItems;
    private List<PProgramaConocimientos> itemsConocimientos;
    private List<PProgramaHabilidades> itemsHabilidades;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_perfil_programa, container, false);

        txtSubTitle = (TextView) rootView.findViewById(R.id.txtpprogramasubtitle);
        listView = (ListView) rootView.findViewById(R.id.listview);
        txtItemone = (TextView) rootView.findViewById(R.id.txtaptitudesitemone);
        txtItemtwo = (TextView) rootView.findViewById(R.id.txtaptitudesitemtwo);
        txtItemthree = (TextView) rootView.findViewById(R.id.txtaptitudesitemthree);

        txtConocimientosItemsOne = (TextView) rootView.findViewById(R.id.txtconocimientositemone);
        txtConocimientosItemsTwo = (TextView) rootView.findViewById(R.id.txtconocimientositemtwo);
        txtConocimientosItemsThree = (TextView) rootView.findViewById(R.id.txtconocimientositemthree);

        txtHabilidadesItemsOne = (TextView) rootView.findViewById(R.id.txthabilidadesitemone);
        txtHabilidadesItemsTwo = (TextView) rootView.findViewById(R.id.txthabilidadesitemtwo);
        txtHabilidadesItemsThree = (TextView) rootView.findViewById(R.id.txthabilidadesitemthree);


        initViews();
        return rootView;
    }

    public void initViews(){

        PPrograma pprograma = PepfullApplication.getpPrograma();
        listItems = pprograma.getListPefil();
        values = new String[listItems.size()];

        txtSubTitle.setText(pprograma.getContent());

        for (int i = 1; i < listItems.size(); i++) {
            if(!listItems.get(i).getId().equalsIgnoreCase("1")){
                values[i] = listItems.get(i).getContent();

                if(listItems.get(i).getId().equalsIgnoreCase("2")){
                    txtItemone.setText(" - " + listItems.get(i).getContent());
                }else if(listItems.get(i).getId().equalsIgnoreCase("3")){
                    txtItemtwo.setText(" - " + listItems.get(i).getContent());
                }else if(listItems.get(i).getId().equalsIgnoreCase("4")){
                    txtItemthree.setText(" - " + listItems.get(i).getContent());
                }
            }

        }

        itemsConocimientos = pprograma.getListConocimientos();

        for (int i = 0; i < itemsConocimientos.size(); i++) {
            if(itemsConocimientos.get(i).getId().equalsIgnoreCase("2")){
                txtConocimientosItemsOne.setText(" - " + itemsConocimientos.get(i).getContent());
            }else  if(itemsConocimientos.get(i).getId().equalsIgnoreCase("3")) {
                txtConocimientosItemsTwo.setText(" - " + itemsConocimientos.get(i).getContent());
            }else  if(itemsConocimientos.get(i).getId().equalsIgnoreCase("4")) {
                txtConocimientosItemsThree.setText(" - " + itemsConocimientos.get(i).getContent());
            }
        }

        itemsHabilidades = pprograma.getListHabilidades();

        for (int i = 0; i < itemsHabilidades.size(); i++) {
            if(itemsHabilidades.get(i).getId().equalsIgnoreCase("2")){
                txtHabilidadesItemsOne.setText(itemsHabilidades.get(i).getContent());
            }else   if(itemsHabilidades.get(i).getId().equalsIgnoreCase("3")){
                txtHabilidadesItemsTwo.setText(itemsHabilidades.get(i).getContent());
            }else   if(itemsHabilidades.get(i).getId().equalsIgnoreCase("4")){
                txtHabilidadesItemsThree.setText(itemsHabilidades.get(i).getContent());
            }
        }

//        CustomListAdapter adapater = new CustomListAdapter(mActivity.getBaseContext(), values);
//        listView.setAdapter(adapater);

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
