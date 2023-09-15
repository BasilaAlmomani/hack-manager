package com.big0soft.hackmanager.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.big0soft.hackmanager.model.ApplicationVersion;
import com.big0soft.hackmanager.repository.ApplicationRepository;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ApplicationVersionViewModel extends ViewModel {
    private final ApplicationRepository applicationRepository;
private final CompositeDisposable compositeDisposable = new CompositeDisposable();
private MutableLiveData<List<ApplicationVersion>> applicationVersionLiveData = new MutableLiveData<>();
    public ApplicationVersionViewModel() {
        this.applicationRepository = new ApplicationRepository();
    }
    public void getApplicationsVersion(){
        applicationRepository.getApplicationsVersion()
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<List<ApplicationVersion>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<ApplicationVersion> applicationVersions) {
                        applicationVersionLiveData.postValue(applicationVersions);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public MutableLiveData<List<ApplicationVersion>> getApplicationVersionLiveData() {
        return applicationVersionLiveData;
    }
}
