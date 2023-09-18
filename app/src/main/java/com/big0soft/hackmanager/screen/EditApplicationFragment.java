package com.big0soft.hackmanager.screen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.big0soft.hackmanager.R;
import com.big0soft.hackmanager.databinding.FragmentEditApplicationBinding;
import com.big0soft.hackmanager.model.ApplicationVersion;
import com.big0soft.hackmanager.viewmodel.ApplicationVersionViewModel;

public class EditApplicationFragment extends Fragment {

    private ApplicationVersionViewModel applicationVersionViewModel;


    FragmentEditApplicationBinding binding;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        applicationVersionViewModel= new ViewModelProvider(this)
                .get(ApplicationVersionViewModel.class);


    }







    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_application,container,false);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditApplicationFragmentArgs args = EditApplicationFragmentArgs.fromBundle(requireArguments());
        ApplicationVersion applicationVersion = args.getArgsApplication();
        binding.fragmentEditButtonChangeVersion.setOnClickListener(v->{
            String version = binding.fragmentEditEditTextVersion.getText().toString().trim();
            applicationVersionViewModel.editVersion(version,applicationVersion.getPackageName());
        });

    }




    }