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
import com.big0soft.hackmanager.VersionAdapter;
import com.big0soft.hackmanager.databinding.FragmentEditApplicationBinding;
import com.big0soft.hackmanager.model.ApplicationVersion;
import com.big0soft.hackmanager.viewmodel.ApplicationVersionViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditApplicationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditApplicationFragment extends Fragment {

    private ApplicationVersionViewModel applicationVersionViewModel;


    FragmentEditApplicationBinding fragmentEditApplicationBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentEditApplicationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_application,container,false);

        return fragmentEditApplicationBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditApplicationFragmentArgs args = EditApplicationFragmentArgs.fromBundle(requireArguments());
        ApplicationVersion applicationVersion = args.getArgsApplication();
        applicationVersionViewModel.editVersion(applicationVersion.getVersion(),applicationVersion.getPackageName());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        applicationVersionViewModel= new ViewModelProvider(this)
                .get(ApplicationVersionViewModel.class);


    }

}