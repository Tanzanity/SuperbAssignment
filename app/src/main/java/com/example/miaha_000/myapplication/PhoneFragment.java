package com.example.miaha_000.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by miaha_000 on 2016-06-11.
 */

public class PhoneFragment extends Fragment{

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       myView = inflater.inflate(R.layout.phone_layout, container, false);
        return myView;
    }
}
