package com.example.gst.View;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.gst.Api.GstApi;
import com.example.gst.Data.GstData;
import com.example.gst.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button search;
    Button but1,but2;
    EditText gstNumber;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        initViews();

        search.setOnClickListener(view -> {
            if(TextUtils.isEmpty(gstNumber.getText().toString()))
            {
                gstNumber.setError("Empty Number");
                return;
            }
            else if(gstNumber.getText().toString().contains(" "))
            {
                gstNumber.setError("Space found");
                return;
            }
            callApi();
        });
    }

//  Calling Of an Api after Search Button Pressed

    private void callApi() {
        dialog=new ProgressDialog(MainActivity.this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMessage("Loading...");
        dialog.show();

        String number=this.gstNumber.getText().toString();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.164:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GstApi api=retrofit.create(GstApi.class);

        Call<List<GstData>> res=api.getData();

        res.enqueue(new Callback<List<GstData>>() {
            @Override
            public void onResponse(Call<List<GstData>> call, Response<List<GstData>> response) {
                if(response.isSuccessful())
                {
                    List<GstData> data=response.body();
                    for(GstData users : data)
                    {
                        if(users.getGstNumber().equals(number))
                        {
                            Intent intent=new Intent(MainActivity.this, GstDetail.class);
                            intent.putExtra("Data",  users);
                            startActivity(intent);
                            break;
                        }
                    }
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Call<List<GstData>> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, "Error Loading Data", Toast.LENGTH_SHORT).show();
            }
        });
    }

//  Initializing the views

    private void initViews() {
        search=findViewById(R.id.id_search);
        but1=findViewById(R.id.id_but1);
        but2=findViewById(R.id.id_but2);
        gstNumber=findViewById(R.id.id_gstNumber);



    }
}