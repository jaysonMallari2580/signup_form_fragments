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
 * Use the {@link BirthdayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BirthdayFragment extends Fragment {

    private MaterialButton button, backButton;
    private TextInputLayout birthdayInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_birthday,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button= view.findViewById(R.id.continue_button_my_birthday);
        backButton = view.findViewById(R.id.back_button_my_birthday);
        birthdayInput = view.findViewById(R.id.birthday);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragment();
            }
        });
    }

    public void swapFragment(){
        Bundle bundle = new Bundle();
        bundle.putString(Constant.BIRTHDAY,birthdayInput.getEditText().getText().toString());
        bundle.putString(Constant.NAME,requireArguments().get(Constant.NAME).toString());
        bundle.putString(Constant.EMAIL,requireArguments().get(Constant.EMAIL).toString());
        IamFragment iamFragment = IamFragment.newInstance();
        iamFragment.setArguments(bundle);

        int fragmentTransaction = getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,iamFragment)
                .addToBackStack(null)
                .commit();
    }

    public static BirthdayFragment newInstance(){
        return new BirthdayFragment();
    }
}