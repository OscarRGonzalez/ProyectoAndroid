package com.example.pictopocketiv.localpersistence;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.pictopocketiv.R;
import com.example.pictopocketiv.firebase.FirebaseAuthService;
import com.example.pictopocketiv.states.MainActivityStateMV;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChoosePopulationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChoosePopulationFragment extends Fragment {

    /** Attrs **/
    private static final String TAG = ChoosePopulationFragment.class.getSimpleName();
    private MainActivityStateMV mActivityMV;
    private Button mButtonDefaultPopulation;
    private Button mButtonBasicPopulation;
    private ChoosePopulationListener mListener;

    public interface ChoosePopulationListener {
        void onBasicPopulation();
        void onDefaultPopulation();
    }

    public void setListener(ChoosePopulationListener listener) {
        mListener = listener;
    }


    /** C **/
    public ChoosePopulationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AccessFormFragment.
     */
    public static ChoosePopulationFragment newInstance() {
        ChoosePopulationFragment fragment = new ChoosePopulationFragment();
        return fragment;
    }

    /** Lifecycle **/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.choose_population, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setAccessModel(view);
        setUI(view);
    }


    /** UI **/
    private void setUI(View view) {
        mButtonDefaultPopulation = (Button) view.findViewById(R.id.btn_population_default);
        //mPopulationDefault.setOnClickListener(onPopulationDefault);

        mButtonBasicPopulation = (Button) view.findViewById(R.id.btn_population_basic);
        //mPopulationBasic.setOnClickListener(onPopulationBasic);
        mButtonBasicPopulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onBasicPopulation();
                }
            }
        });

        mButtonDefaultPopulation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onDefaultPopulation();
                }
            }
        });
    }


    /** Main Activity Status Model */
    private void setAccessModel(View view) {
        mActivityMV = new ViewModelProvider(getActivity())
                .get(MainActivityStateMV.class);
    }


    /** Listeners **/
    private View.OnClickListener onPopulationDefault = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //mActivityMV.setPopulation("default");
            //mActivityMV.setIsLoggedIn(true);
            // print the current population

        }
    };

    private View.OnClickListener onPopulationBasic = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //mActivityMV.setPopulation("basic");
            //mActivityMV.setIsLoggedIn(true);
        }
    };

}