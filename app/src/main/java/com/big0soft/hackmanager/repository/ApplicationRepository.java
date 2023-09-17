package com.big0soft.hackmanager.repository;

import com.big0soft.hackmanager.model.ApplicationVersion;
import com.big0soft.hackmanager.rest.ClientConfig;
import com.big0soft.hackmanager.service.ApiService;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class ApplicationRepository {
    private ApiService service;


    public Single<String> editVersion ( String version
            , String packageName){
        return service.editVersion(version,packageName);

    }

    public ApplicationRepository() {
        service = ClientConfig.getInstance().service();
    }
   public Single<List<ApplicationVersion>> getApplicationsVersion(){
        return service.getApplicationsVersion();
   }
}
