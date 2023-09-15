package com.big0soft.hackmanager.repository;

import com.big0soft.hackmanager.model.ApplicationVersion;
import com.big0soft.hackmanager.rest.ClientConfig;
import com.big0soft.hackmanager.service.ApiService;

import java.util.List;

import io.reactivex.Single;

public class ApplicationRepository {
    private ApiService service;

    public ApplicationRepository() {
        service = ClientConfig.getInstance().service();
    }
   public Single<List<ApplicationVersion>> getApplicationsVersion(){
        return service.getApplicationsVersion();
   }
}
