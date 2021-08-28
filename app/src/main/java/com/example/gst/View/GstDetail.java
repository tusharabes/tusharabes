package com.example.gst.View;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gst.Data.GstData;
import com.example.gst.R;

public class GstDetail extends AppCompatActivity {

    TextView status,gstin,address,business,registration_date,business_type
            ,payer_type,centre_jur,state_jur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst_detail);
        intitViews();
        loadData();
    }

//  Loading the data into the Views

    private void loadData() {
        GstData data= (GstData) getIntent().getSerializableExtra("Data");
        status.setText(data.getStatus().toUpperCase());
        address.setText(data.getAddress());
        gstin.setText(data.getGstNumber());
        business.setText(data.getName());
        registration_date.setText(data.getRegistrationDate());
        business_type.setText(data.getBusinessType());
        payer_type.setText(data.getTaxType());
        centre_jur.setText(data.getCentreJurisdiction());
        state_jur.setText(data.getStateJurisdiction());
    }
//  Initializing the views

    private void intitViews() {
        status=findViewById(R.id.id_status);
        address=findViewById(R.id.id_address);
        gstin=findViewById(R.id.id_gstin);
        business=findViewById(R.id.id_company_name);
        registration_date=findViewById(R.id.id_date);
        business_type=findViewById(R.id.id_business_type);
        payer_type=findViewById(R.id.id_payer_type);
        centre_jur=findViewById(R.id.id_centre_jur);
        state_jur=findViewById(R.id.id_state_jur);
    }
}