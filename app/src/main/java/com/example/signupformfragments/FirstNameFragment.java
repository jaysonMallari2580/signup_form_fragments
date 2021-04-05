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
 * Use the {@link FirstNameFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstNameFragment extends Fragment {

    private MaterialButton button, backButton;
    TextInputLayout nameInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_first_name,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = view.findViewById(R.id.continue_button_my_name);
        backButton = view.findViewById(R.id.back_button_my_first_name);
        nameInput = view.findViewById(R.id.firstName);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragment();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });
    }

    private void swapFragment(){
        Bundle bundle = new Bundle();
        bundle.putString(Constant.NAME,nameInput.getEditText().getText().toString());
        bundle.putString(Constant.EMAIL, requireArguments().get(Constant.EMAIL).toString());
        BirthdayFragment birthdayFragment = BirthdayFragment.newInstance();
        birthdayFragment.setArguments(bundle);


        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,birthdayFragment).addToBackStack(null).commit();
    }

    public static  FirstNameFragment newInstance(){
        return new FirstNameFragment();
    }
}