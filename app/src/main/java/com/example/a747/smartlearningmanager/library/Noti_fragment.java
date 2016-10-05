package com.example.a747.smartlearningmanager.library;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a747.smartlearningmanager.*;
import com.example.a747.smartlearningmanager.R;

/**
 * Created by WasanHi on 9/1/2016.
 */
public class Noti_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.noti, container, false);
    }
}
