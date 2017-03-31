package com.example.lakshmi.firebase;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProduct extends AppCompatActivity {
EditText name;
    Button b;
    private ProgressDialog progressDialog;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        name=(EditText)findViewById(R.id.pro);
        b=(Button)findViewById(R.id.ok);
        progressDialog = new ProgressDialog(this);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReferenceFromUrl("https://fir-e4378.firebaseio.com/AddProduct");
    }


    public void upload(View v)
    {

        DatabaseReference id = databaseReference .push();
        id.child("name").setValue(name.getText().toString());

        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
    }
}
