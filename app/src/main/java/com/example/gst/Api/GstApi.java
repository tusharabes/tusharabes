package com.example.gst.Api;

import com.example.gst.Data.GstData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GstApi {
    @GET("gst")
    Call<List<GstData>> getData();
}
