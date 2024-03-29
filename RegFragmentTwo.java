package com.example.hp.oouattendance;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.oouattendance.CentralData.LecturerInfo;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegFragmentTwo.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegFragmentTwo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegFragmentTwo extends Fragment {

    private EditText lecturerId, courses, pass, cPass;
    private Button regBackBtn, regSubmitBtn;
    private ProgressBar pBar;
    private Spinner campusLocation, qual;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private String qualification;
    private String campus;

    public RegFragmentTwo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegFragmentTwo.
     */
    // TODO: Rename and change types and number of parameters
    public static RegFragmentTwo newInstance(String param1, String param2) {
        RegFragmentTwo fragment = new RegFragmentTwo();
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
        final View rootView = LayoutInflater.from(getContext())
                .inflate(R.layout.reg_fragment_two, container, false);
        // inflater.inflate(R.layout.reg_fragment_two, container, false);
        lecturerId = rootView.findViewById(R.id.lecturer_id);
        courses = rootView.findViewById(R.id.course_list);
        pass = rootView.findViewById(R.id.lecturer_password);
        cPass = rootView.findViewById(R.id.lecturer_confirm_password);
        campusLocation = rootView.findViewById(R.id.campus_spinner);
        qual = rootView.findViewById(R.id.qual_spinner);
        regBackBtn = rootView.findViewById(R.id.reg_back_btn);
        regSubmitBtn = rootView.findViewById(R.id.reg_submit);
        pBar = rootView.findViewById(R.id.regProgressBar);

        final String coursesOffered = courses.getText().toString();
        final String password = pass.getText().toString().trim();
        final String confirmPassword = cPass.getText().toString().trim();
        qual.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(qual.getSelectedItem().toString().trim()){
                    case "B.Sc":
                        qualification = "B.Sc";
                        break;
                    case "M.Sc":
                        qualification = "M.Sc";
                        break;
                    case "Ph.D":
                        qualification = "Ph.D";
                        break;
                    default:
                        qualification = null;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        campusLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (campusLocation.getSelectedItem().toString().trim()){
                    case "Ago-Iwoye":
                        campus = "Ago-Iwoye";
                        break;
                    case "Ayetoro":
                        campus = "Ayetoro";
                        break;
                    case "Ibogun":
                        campus = "Ibogun";
                        break;
                    case "Ikenne":
                        campus = "Ikenne";
                        break;
                    case "Shagamu":
                        campus = "Shagamu";
                        break;
                    default:
                        campus = null;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        regBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
//                startActivity(intent);

            }
        });


        regSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pBar.setVisibility(ProgressBar.VISIBLE);
//              all the details from the first and second fragment will be added to the centralised data
                LecturerInfo lecturerInfo = new LecturerInfo();
                RegFragmentOne regFragmentOne = new RegFragmentOne();
                lecturerInfo.Name.add(regFragmentOne.name);
                lecturerInfo.Address.add(regFragmentOne.lAddress);
                lecturerInfo.Nationality.add(regFragmentOne.nation);
                lecturerInfo.PhoneNumber.add(regFragmentOne.phone);
                lecturerInfo.StateOfOrigin.add(regFragmentOne.stateOfOrigin);
                lecturerInfo.Religion.add(regFragmentOne.religion);
                lecturerInfo.Gender.add(regFragmentOne.gender);
                lecturerInfo.Courses.add(coursesOffered);
                lecturerInfo.Qualification.add(qualification);

//                don't forget to handle the authentication of the email before adding the email to the LecturerInfo
                lecturerInfo.Email.add(regFragmentOne.lEmail);

                if (password == confirmPassword) {
                    lecturerInfo.Password.add(password);
                }else{
                    Toast.makeText(getContext(), "Password Mismatch", Toast.LENGTH_SHORT).show();
                }

            }
        });

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
