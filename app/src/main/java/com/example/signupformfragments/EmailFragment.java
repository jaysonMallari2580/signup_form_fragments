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
 * Use the {@link EmailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EmailFragment extends Fragment {

    private MaterialButton button;
    private TextInputLayout emailInput;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_create_account, container, false);
        //return the view
        return inflater.inflate(R.layout.fragment_email,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = (MaterialButton) view.findViewById(R.id.continue_button_my_email);
        emailInput = (TextInputLayout)view.findViewById(R.id.email);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapFragment();
            }


        });

    }

    private void swapFragment(){
        Bundle bundle = new Bundle();
        bundle.putString(Constant.EMAIL,emailInput.getEditText().getText().toString());
        FirstNameFragment nameFragment = FirstNameFragment.newInstance();
        nameFragment.setArguments(bundle);


        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, nameFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }


    public static EmailFragment newInstance(){
        return new EmailFragment();
    }
}