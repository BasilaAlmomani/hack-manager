package com.big0soft.hackmanager.rest;

import com.big0soft.hackmanager.service.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientConfig {
    private static ClientConfig instance;
private Retrofit retrofit;
    private ClientConfig(){
        retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.1.39/hack1/hack/api/v1/")
                .build();
    }
    public static ClientConfig getInstance() {
        if (instance == null) {
            synchronized (ClientConfig.class){
                instance = new ClientConfig();
            }
        }
        return instance;
    }
    public ApiService service(){
        return retrofit.create(ApiService.class);
    }
}
