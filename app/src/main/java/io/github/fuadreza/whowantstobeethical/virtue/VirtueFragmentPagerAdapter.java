package io.github.fuadreza.whowantstobeethical.virtue;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 24/08/2018.
 */
class VirtueFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public VirtueFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Virtue1Fragment();
        } else {
            return new Virtue2Fragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "1";
            case 1:
                return "2";
            default:
                return null;
        }
    }
}
