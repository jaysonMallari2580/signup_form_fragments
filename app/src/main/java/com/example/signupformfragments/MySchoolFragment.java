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

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MySchoolFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MySchoolFragment extends Fragment {

    private MaterialButton buttonBack, buttonContinue;
    private TextInputLayout schoolInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_my_school,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonBack = view.findViewById(R.id.back_button_my_school);
        buttonContinue = view.findViewById(R.id.continue_button_my_school);
        schoolInput = view.findViewById(R.id.school_text_input);

        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragment();
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
    }

    public void swapFragment(){
        Bundle bundle = new Bundle();
        bundle.putString(Constant.EMAIL,requireArguments().get(Constant.EMAIL).toString());
        bundle.putString(Constant.NAME,requireArguments().get(Constant.NAME).toString());
        bundle.putString(Constant.BIRTHDAY,requireArguments().get(Constant.BIRTHDAY).toString());
        bundle.putString(Constant.GENDER,requireArguments().get(Constant.GENDER).toString());
        bundle.putString(Constant.SCHOOL,schoolInput.getEditText().getText().toString());
        ProfileFragment profileFragment = ProfileFragment.newInstance();
        profileFragment.setArguments(bundle);

        int fragmentTransaction = getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,profileFragment)
                .addToBackStack(null).commit();
    }

    public static MySchoolFragment newInstance(){
        return new MySchoolFragment();
    }
}