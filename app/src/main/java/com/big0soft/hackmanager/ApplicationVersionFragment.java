package com.big0soft.hackmanager;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.big0soft.hackmanager.databinding.FragmentApplicationVersionBinding;
import com.big0soft.hackmanager.model.ApplicationVersion;
import com.big0soft.hackmanager.repository.ApplicationRepository;
import com.big0soft.hackmanager.viewmodel.ApplicationVersionViewModel;

import java.util.ArrayList;
import java.util.List;


public class ApplicationVersionFragment extends Fragment {
    private FragmentApplicationVersionBinding binding;
    private RecyclerView recyclerView;
    private VersionAdapter adapter;

    private ApplicationVersionViewModel applicationVersionViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new VersionAdapter(new ArrayList<>());

        applicationVersionViewModel= new ViewModelProvider(this)
                .get(ApplicationVersionViewModel.class);


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_application_version,container,false);
applicationVersionViewModel.getApplicationsVersion();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recycler.setHasFixedSize(false);

                binding.recycler.setLayoutManager(new LinearLayoutManager(requireContext()));


        binding.recycler.setAdapter(adapter);
        binding.setLifecycleOwner(this);
        applicationVersionViewModel.getApplicationVersionLiveData().observe(getViewLifecycleOwner(), new Observer<List<ApplicationVersion>>() {
            @Override
            public void onChanged(List<ApplicationVersion> applicationVersions) {

                adapter.addItems(applicationVersions);
            }
        });


    }

    private List<ApplicationVersion> getFackItems() {
        return List.of(
                new ApplicationVersion(1,"pm name","verion"),
                new ApplicationVersion(1,"pm name","verion"),
                 new ApplicationVersion(1,"pm name","verion"),
                 new ApplicationVersion(1,"pm name","verion"),
                  new ApplicationVersion(1,"pm name","verion")
        );
    }
}