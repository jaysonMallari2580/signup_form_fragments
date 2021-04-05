package com.example.signupformfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.textview.MaterialTextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    private MaterialTextView emailV,nameV,bdayV,genderV,schoolV;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        emailV = view.findViewById(R.id.info_email);
        nameV = view.findViewById(R.id.profile_name);
        bdayV = view.findViewById(R.id.info_birthday);
        genderV = view.findViewById(R.id.info_gender);
        schoolV = view.findViewById(R.id.info_school);


        emailV.setText(requireArguments().get(Constant.EMAIL).toString());
        nameV.setText(requireArguments().get(Constant.NAME).toString());
        bdayV.setText(requireArguments().get(Constant.BIRTHDAY).toString());
        genderV.setText(requireArguments().get(Constant.GENDER).toString());
        schoolV.setText(requireArguments().get(Constant.SCHOOL).toString());

    }

    public static ProfileFragment newInstance(){
        return  new ProfileFragment();
    }
}