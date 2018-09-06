package io.github.fuadreza.whowantstobeethical.right;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 24/08/2018.
 */
class RightFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public RightFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Right1Fragment();
        } else if (position == 1) {
            return new Right2Fragment();
        } else if (position == 2) {
            return new Right3Fragment();
        } else {
            return new Right4Fragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "1";
            case 1:
                return "2";
            case 2:
                return "3";
            case 3:
                return "4";
            default:
                return null;
        }
    }
}
