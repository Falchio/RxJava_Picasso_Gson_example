package ru.falchio.myretrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @Expose
    @SerializedName("avatar_url")
    public String avaPath;

    public String getAvaPath() {
        return avaPath;
    }
}
