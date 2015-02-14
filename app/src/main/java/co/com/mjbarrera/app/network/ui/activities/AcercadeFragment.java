package co.com.mjbarrera.app.network.ui.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.ui.fragments.LoginFragment;

public class AcercadeFragment extends android.support.v4.app.Fragment {

    private Activity mActivity;
    private ImageButton btnFB;
    private ImageButton btnTW;
    private TextView mLink;
    private static String URL = "http://www.timetoast.com/timelines/linea-de-tiempo-de-las-redes-informaticas";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_acercade, container, false);

        mLink = (TextView) rootView.findViewById(R.id.clickableTextView);
        mLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent link = new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                startActivity(link);
            }
        });
        btnTW = (ImageButton) rootView.findViewById(R.id.btnTW);
        btnTW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent twIntent = getOpenTwitterIntent(mActivity.getBaseContext());
                startActivity(twIntent);
            }
        });

        btnFB = (ImageButton) rootView.findViewById(R.id.btnFB);
        btnFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fbIntent = getOpenFacebookIntent(mActivity.getBaseContext());
                startActivity(fbIntent);
            }
        });
        return rootView;
    }

    public static Intent getOpenTwitterIntent(Context context) {

        //http://www.idfromuser.com/
        try {
            // get the Twitter app if possible
            context.getPackageManager().getPackageInfo("com.twitter.android", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("twitter://user?user_id=273223589"));


        }catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("twitter://user?user_id=273223589"));
        }
    }

    public static Intent getOpenFacebookIntent(Context context) {
        //https://graph.facebook.com/ULosLibertadores
        try {

            context.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://profile/113035982110296"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/ULosLibertadores"));
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
