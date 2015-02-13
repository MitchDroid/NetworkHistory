package co.com.mjbarrera.app.network.ui.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.viewpagerindicator.IconPagerAdapter;

import co.com.mjbarrera.app.network.R;
import co.com.mjbarrera.app.network.ui.fragments.TutorialFragment;

/**
 * Created by personal on 26/10/14.
 */
public class TutorialFragmentAdapter extends FragmentPagerAdapter implements
        IconPagerAdapter {

    String[] content;
    private Resources res;
    private TypedArray imageResources;
    private int mCount = 0;

    public TutorialFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        res = context.getResources();
        imageResources = res.obtainTypedArray(R.array.tutorial_images);
        mCount = imageResources.length();
        content = res.getStringArray(R.array.contents_array);
    }

    @Override
    public int getIconResId(int index) {
        return 0;
    }

    @Override
    public Fragment getItem(int position) {
        return TutorialFragment.newInstance(
                content[position % content.length],
                imageResources.getResourceId((position % imageResources.length()), R.drawable.gesture)
        );
    }

    @Override
    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        if (count > 0 && count <= 3) {
            mCount = count;
            notifyDataSetChanged();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return content[position % content.length];
    }
}
