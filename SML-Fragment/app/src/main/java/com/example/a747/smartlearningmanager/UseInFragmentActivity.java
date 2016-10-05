package com.example.a747.smartlearningmanager;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.a747.smartlearningmanager.library.ImageFragment;
import com.example.a747.smartlearningmanager.library.SimpleFragment;
import com.example.a747.smartlearningmanager.library.StatusBarUtil;
import com.example.a747.smartlearningmanager.library.StatusBarView;
import com.example.a747.smartlearningmanager.library.Todo_fragment;
import com.example.a747.smartlearningmanager.library.home_fragment;


import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Jaeger on 16/8/11.
 *
 * Email: chjie.jaeger@gamil.com
 * GitHub: https://github.com/laobie
 */
public class UseInFragmentActivity extends BaseActivity {
    private ViewPager mVpHome;
    private BottomNavigationBar mBottomNavigationBar;
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();

    private boolean isFullScreen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_use_in_fragment);
        mVpHome = (ViewPager) findViewById(R.id.vp_home);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.homew, "Home"))
            .addItem(new BottomNavigationItem(R.drawable.pencilw, "Todo list"))
            .addItem(new BottomNavigationItem(R.drawable.videow, "Elearning"))
            .addItem(new BottomNavigationItem(R.drawable.notiw, "Notification"))
            .addItem(new BottomNavigationItem(R.drawable.morew, "More & Setting"))
            .initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                mVpHome.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });

        mFragmentList.add(new home_fragment());
        mFragmentList.add(new Todo_fragment());
        mFragmentList.add(new SimpleFragment());
        mFragmentList.add(new SimpleFragment());
        mFragmentList.add(new SimpleFragment());

        mVpHome.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
               mBottomNavigationBar.selectTab(position);
                switch (position) {
                    case 0:
                        isFullScreen = false;
                        StatusBarUtil.setTranslucentForImageViewInFragment(UseInFragmentActivity.this, null);
                        break;
                    default:
                        if (isFullScreen) {
                            resetFragmentView(mFragmentList.get(position));
                        }
                        /*Random random = new Random();
                        int color = 0xff000000 | random.nextInt(0xffffff);
                        StatusBarUtil.setColor(UseInFragmentActivity.this, color, 38);
                        if (mFragmentList.get(position) instanceof SimpleFragment) {
                            ((SimpleFragment) mFragmentList.get(position)).setTvTitleBackgroundColor(color);
                        }*/
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mVpHome.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });
    }



    @Override
    protected void setStatusBar() {
        isFullScreen = true;
        StatusBarUtil.setTranslucentForImageViewInFragment(UseInFragmentActivity.this, null);
    }

    public void resetFragmentView(Fragment fragment) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View contentView = findViewById(android.R.id.content);
            if (contentView != null) {
                ViewGroup rootView;
                rootView = (ViewGroup) ((ViewGroup) contentView).getChildAt(0);
                if (rootView.getPaddingTop() != 0) {
                    rootView.setPadding(0, 0, 0, 0);
                }
            }
            if (fragment.getView() != null) fragment.getView().setPadding(0, getStatusBarHeight(this), 0, 0);
        }
    }

    private static int getStatusBarHeight(Context context) {
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }
}
