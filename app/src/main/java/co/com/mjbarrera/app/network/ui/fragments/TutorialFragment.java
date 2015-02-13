package co.com.mjbarrera.app.network.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.com.mjbarrera.app.network.R;

/**
 * Created by personal on 26/10/14.
 */
public class TutorialFragment extends Fragment {

    @InjectView(R.id.imageTutorial)
    ImageView mImageTutorial;
    @InjectView(R.id.textViewTutorial)
    TextView mTextViewTutorial;

    private static final String KEY_CONTENT = "TutorialFragment:Content";
    private static final String KEY_SCREEN_CONTENT = "TutorialFragment:Screen";
    private String mContent = "";
    private int mScreenImageResource = R.drawable.gesture;

    public static Fragment newInstance(String content,
                                       int screenResource) {
        TutorialFragment fragment = new TutorialFragment();
        fragment.mContent = content;
        fragment.mScreenImageResource = screenResource;

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorial, container,
                false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        mImageTutorial.setImageResource(mScreenImageResource);
        mTextViewTutorial.setText(mContent);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null)
                && (savedInstanceState.containsKey(KEY_CONTENT)
                && savedInstanceState.containsKey(KEY_SCREEN_CONTENT))) {

            mContent = savedInstanceState.getString(KEY_CONTENT);
            mScreenImageResource = savedInstanceState
                    .getInt(KEY_SCREEN_CONTENT);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mContent);
        outState.putInt(KEY_SCREEN_CONTENT, mScreenImageResource);
    }

}
