package com.big0soft.hackmanager.service;

import com.big0soft.hackmanager.model.ApplicationVersion;

import java.util.List;

import io.reactivex.Single;
import kotlin.ParameterName;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("version_controller")
    Single<List<ApplicationVersion>> getApplicationsVersion();

    @GET("version_controller/update_application_version.php")
    Single<String> editVersion(@Query("version")String version
            ,@Query("pm_name")String packageName);
}
