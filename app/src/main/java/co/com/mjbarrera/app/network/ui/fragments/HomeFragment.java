package co.com.mjbarrera.app.network.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.special.ResideMenu.ResideMenu;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.ui.activities.MenuActivity;

public class HomeFragment extends Fragment {

    private View rootView;
    private Activity mActivity;
    private ResideMenu resideMenu;

    public HomeFragment() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        setUpViews();
        return rootView;
    }

    private void setUpViews() {
        MenuActivity parentActivity = (MenuActivity) mActivity;
        resideMenu = parentActivity.getResideMenu();

        rootView.findViewById(R.id.btn_open_menu).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
                    }
                });

        // add gesture operation's ignored views
        FrameLayout ignored_view = (FrameLayout) rootView
                .findViewById(R.id.ignored_view);
        resideMenu.addIgnoredView(ignored_view);
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