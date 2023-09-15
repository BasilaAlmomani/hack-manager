package com.big0soft.hackmanager.service;

import com.big0soft.hackmanager.model.ApplicationVersion;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {
    @GET("version_controller")
    Single<List<ApplicationVersion>> getApplicationsVersion();
}
