package com.example.signupformfragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link IamFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class IamFragment extends Fragment {

    private MaterialButton continueButton, backButton, womanButton, manButton;
    private String gender ="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iam,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        continueButton = view.findViewById(R.id.continue_button_my_iam);
        backButton = view.findViewById(R.id.back_button_my_iam);
        womanButton = view.findViewById(R.id.woman_button);
        manButton = view.findViewById(R.id.man_button);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragment();
            }
        });

        womanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender="Woman";
            }
        });

        manButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gender="Man";
            }
        });

    }

    public void swapFragment(){
        Bundle bundle = new Bundle();
        bundle.putString(Constant.GENDER, gender);
        bundle.putString(Constant.EMAIL,requireArguments().get(Constant.EMAIL).toString());
        bundle.putString(Constant.NAME,requireArguments().get(Constant.NAME).toString());
        bundle.putString(Constant.BIRTHDAY,requireArguments().get(Constant.BIRTHDAY).toString());
        MySchoolFragment mySchoolFragment = MySchoolFragment.newInstance();
        mySchoolFragment.setArguments(bundle);

        int fragmentTransaction = getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,mySchoolFragment)
                .addToBackStack(null)
                .commit();
    }

    public static IamFragment newInstance(){
        return new IamFragment();
    }
}