package co.com.mjbarrera.app.network.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.application.PepfullApplication;
import co.com.mjbarrera.app.network.domain.telegraph.Telegraph;

public class TelegraphFragment extends Fragment {

    private Activity mActivity;
    private TextView txtMisonTitle;
    private TextView txtMisionContent;
    private String myjsonstring;
    private List<Telegraph> list;

    public TelegraphFragment() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_telegraph, container,
                false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtMisonTitle = (TextView) view.findViewById(R.id.txtTitle);
        txtMisionContent = (TextView) view.findViewById(R.id.txtContent);


        initViews();
    }

    public void initViews() {

        list = PepfullApplication.getListTelegraph();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase("Telegrafo")) {
                txtMisonTitle.setText(list.get(i).getId());
                txtMisionContent.setText(list.get(i).getContent());
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

    public static String jsonToStringFromAssetFolder(String fileName, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(fileName);

        byte[] data = new byte[file.available()];
        file.read(data);
        file.close();
        return new String(data);
    }

}
