package co.com.mjbarrera.app.network.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.LinePageIndicator;
import com.viewpagerindicator.PageIndicator;

import butterknife.ButterKnife;
import butterknife.OnClick;
import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.ui.adapters.TutorialFragmentAdapter;
import co.com.mjbarrera.app.network.utils.IntentHelper;

public class LoginFragment extends Fragment {

    OnClickHomeListener mCallback;

    private TutorialFragmentAdapter mAdapter;
    private ViewPager mPager;
    private PageIndicator mIndicator;

    @OnClick(R.id.button_login)
    void goToHome() {
        mCallback.onClick();
        IntentHelper.goToHomeActivity(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container,
                false);
        ButterKnife.inject(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() == null)
            return;
        else {
            mAdapter = new TutorialFragmentAdapter(getChildFragmentManager(),
                    getActivity().getApplicationContext());
            mPager = (ViewPager) getView().findViewById(R.id.viewPager);
            mPager.setAdapter(mAdapter);
            mIndicator = (LinePageIndicator) getView().findViewById(R.id.indicator);
            mIndicator.setViewPager(mPager);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnClickHomeListener) activity;
        } catch (ClassCastException e) {
            Log.e(LoginFragment.class.getName(), e.getMessage());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }

    public interface OnClickHomeListener {
        public void onClick();
    }
}
