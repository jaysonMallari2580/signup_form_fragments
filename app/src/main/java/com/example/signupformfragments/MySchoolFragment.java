package com.example.signupformfragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MySchoolFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MySchoolFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MySchoolFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MySchoolFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MySchoolFragment newInstance(String param1, String param2) {
        MySchoolFragment fragment = new MySchoolFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my_school,container,false);
        MaterialButton buttonBack = view.findViewById(R.id.back_button_my_school);
        MaterialButton buttonContinue = view.findViewById(R.id.continue_button_my_school);

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
        // Inflate the layout for this fragment
        return view;
    }

    public void swapFragment(){
        ProfileFragment profileFragment = ProfileFragment.newInstance();
        int fragmentTransaction = getFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,profileFragment)
                .addToBackStack(null).commit();
    }

    public static MySchoolFragment newInstance(){
        return new MySchoolFragment();
    }
}