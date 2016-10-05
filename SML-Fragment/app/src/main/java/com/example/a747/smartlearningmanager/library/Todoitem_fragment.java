package com.example.a747.smartlearningmanager.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by WasanHi on 8/30/2016.
 */
public class Todoitem_fragment extends Fragment {
    private TextView mTvTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(com.example.a747.smartlearningmanager.R.layout.todo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = (TextView) view.findViewById(R.id.tv_title);
    }

    public void setTvTitleBackgroundColor(int color) {
        mTvTitle.setBackgroundColor(color);
    }
}


