package com.example.hp.oouattendance;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hp.oouattendance.CentralData.LecturerInfo;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegFragmentOne.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegFragmentOne#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegFragmentOne extends Fragment {

    EditText fName, lName, email, phNum, nationality, address, origin;
    Spinner lReligion, lGender;
    Button regNextBtn;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public String name, lEmail, nation, lAddress, stateOfOrigin, religion, gender;
    public int phone;

    public RegFragmentOne() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegFragmentOne.
     */
    // TODO: Rename and change types and number of parameters
    public static RegFragmentOne newInstance(String param1, String param2) {
        RegFragmentOne fragment = new RegFragmentOne();
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
                             final Bundle savedInstanceState) {
        final View rootView = LayoutInflater.from(getContext())
                 .inflate(R.layout.reg_fragment_one, container, false);

        fName = rootView.findViewById(R.id.lecturer_first_name);
        lName = rootView.findViewById(R.id.lecturer_last_name);
        phNum = rootView.findViewById(R.id.lecturer_phone_number);
        email = rootView.findViewById(R.id.lecturer_email);
        nationality = rootView.findViewById(R.id.lecturer_nationality);
        address = rootView.findViewById(R.id.lecturer_residential_address);
        origin = rootView.findViewById(R.id.lecturer_state_of_origin);
        lGender = rootView.findViewById(R.id.lecturer_gender_spinner);
        lReligion = rootView.findViewById(R.id.lecturer_religion_spinner);
        regNextBtn = rootView.findViewById(R.id.reg_next);

        name = lName.getText().toString().trim() + "\t" + fName.getText().toString().trim();
//        phone = Integer.parseInt(phNum.getText().toString().trim());
        lEmail = email.getText().toString().trim();
        nation = nationality.getText().toString().trim();
        lAddress = address.getText().toString().trim();
        stateOfOrigin = origin.getText().toString().trim();

        lGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(lGender.getSelectedItem().toString().trim()){
                    case "Male":
                        gender = "Male";
                        break;
                    case "Female":
                        gender = "Female";
                        break;
                    case "Other":
                        gender = "Other";
                        break;
                    default:
                        gender = null;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        lReligion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(lReligion.getSelectedItem().toString().trim()){
                    case "Christian":
                        religion = "Christian";
                        break;
                    case "Muslim":
                        religion = "Muslim";
                        break;
                    case "Traditionalist":
                        religion = "Traditionalist";
                        break;
                    default:
                        religion = null;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        regNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        //adding the gotten details to the Centralised data class "LecturerInfo.java"


        // Inflate the layout for this fragment
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
