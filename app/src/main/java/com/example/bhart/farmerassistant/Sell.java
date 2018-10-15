package com.example.bhart.farmerassistant;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sell extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mFirebaseAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mFirebaseDatabaseReference;

    public static final int RC_SIGN_IN =1;
    private EditText name;
    private EditText state;
    private EditText district;
    private EditText pincode;
    private EditText commodity;
    private EditText price;
    private EditText weight;
    private Button submit;
    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);
        setTitle("Sell Your Seeds");

        name=(EditText) findViewById(R.id.name);
        state=(EditText)findViewById(R.id.farmer_state);
        district = (EditText)findViewById(R.id.farmer_district);
        pincode=(EditText)findViewById(R.id.farmer_pincode);
        commodity = (EditText)findViewById(R.id.farmer_commodity);
        price = (EditText)findViewById(R.id.farmer_amount);
        weight = (EditText)findViewById(R.id.farmer_weight);
        submit=(Button)findViewById(R.id.submit);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseDatabaseReference = mFirebaseDatabase.getReference().child("farmers");

        mFirebaseAuth = FirebaseAuth.getInstance();

        mFirebaseAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();

                if (user!=null){
                    Toast.makeText(Sell.this,"Welcome !",Toast.LENGTH_SHORT).show();
                }
                else{
                    startActivityForResult(
                            AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setIsSmartLockEnabled(false)
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.PhoneBuilder().build())
                            ).build(),RC_SIGN_IN);
                }
            }
        };
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fName=name.getText().toString();
                final String fState=state.getText().toString();
                final String fDistrict=district.getText().toString();
                final String fPincode=pincode.getText().toString();
                final String fCommodity=commodity.getText().toString();
                final String fPrice=price.getText().toString();
                final String fWeight=weight.getText().toString();

                Product_detail product_detail = new Product_detail(fName,fState,fDistrict,fPincode,
                                                                        fCommodity,fPrice,fWeight,false,user.getPhoneNumber());
                mFirebaseDatabaseReference.push().setValue(product_detail);

                name.setText("");
                state.setText("");
                district.setText("");
                pincode.setText("");
                commodity.setText("");
                price.setText("");
                weight.setText("");

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.sell_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id=item.getItemId();

        if (id==R.id.Sign_Out){
            AuthUI.getInstance().signOut(this);
            finish();
            return true;
        }
        else if (id==R.id.sold_products){

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN){
            if (resultCode == RESULT_OK){
                Toast.makeText(Sell.this, "Signed In", Toast.LENGTH_SHORT).show();
            } else if (resultCode == RESULT_CANCELED) {
                //Toast.makeText(Sell.this, "Signed In Failed", Toast.LENGTH_SHORT).show();
                finish();
            }

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mFirebaseAuthListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mFirebaseAuthListener);
    }
}
