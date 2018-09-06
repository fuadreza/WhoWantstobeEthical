package io.github.fuadreza.whowantstobeethical.utilitarianisme;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Dibuat dengan kerjakerasbagaiquda oleh Shifu pada tanggal 21/08/2018.
 */
public class UtilitarianismeFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public UtilitarianismeFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Util1Fragment();
        } else {
            return new Util2Fragment();
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
