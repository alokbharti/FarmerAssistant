package com.example.bhart.farmerassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyerDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer_detail);
        setTitle("Fill Up Your Detail");

        final String farmerPhone= getIntent().getStringExtra("phone");
        //Toast.makeText(BuyerDetail.this,farmerPhone,Toast.LENGTH_LONG).show();

        final EditText name = (EditText)findViewById(R.id.BuyerName);
        final EditText address=(EditText)findViewById(R.id.BuyerAddress);
        final EditText phoneNumber=(EditText)findViewById(R.id.Buyerphone);
        final EditText pincode = (EditText)findViewById(R.id.BuyerPincode);
        Button submit = (Button)findViewById(R.id.BuyerSubmit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String BuyerName = name.getText().toString();
                String BuyerAddress=address.getText().toString();
                String BuyerPincode = pincode.getText().toString();
                String BuyerPhone = phoneNumber.getText().toString();
                if (BuyerName.isEmpty() || BuyerAddress.isEmpty() || BuyerPhone.isEmpty() || BuyerPincode.isEmpty()) {
                    Toast.makeText(BuyerDetail.this,"Pleas fill your details",Toast.LENGTH_SHORT).show();
                }else{
                    String message = " Hey!,  " + BuyerName + " is interested in your product. \nHere is his address " + BuyerAddress + " \npincode:- " + BuyerPincode +
                            "\nHis contact number is " + BuyerPhone + "\n Try to contact him as early as possible.";

                    SmsManager.getDefault().sendTextMessage(farmerPhone, null, message, null, null);

                    Log.d("FarmerPhone", farmerPhone);
                    Toast.makeText(BuyerDetail.this, "Your details has been send, please wait for his/her reply. \n Thank you!", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });

    }
}
