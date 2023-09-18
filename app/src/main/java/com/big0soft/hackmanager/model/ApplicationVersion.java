package com.big0soft.hackmanager.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ApplicationVersion implements Serializable {
    private int id;
    private String version;
 //   @SerializedName("package_name")
    private String packageName;


    public ApplicationVersion(int id, String version, String packageName) {
        this.id = id;
        this.version = version;
        this.packageName = packageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

}
