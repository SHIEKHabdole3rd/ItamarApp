package com.example.heartofstone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.ref.Reference;
import java.util.ArrayList;

public class Login_Activity extends AppCompatActivity {
    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef= database.getReference();
    ArrayList<User_Class> Users=new ArrayList<>();
    Button BTNLogin, BTNRegister;
    EditText TVUsername, TVPassword;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        TVUsername = (EditText) findViewById(R.id.TVUserName);
        TVPassword = (EditText) findViewById(R.id.TVPassword);

        Query q=myRef.child("allUsers").orderByKey();
        q.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot Datasnapshot) {
                for (DataSnapshot dst: Datasnapshot.getChildren()){
                    User_Class User= dst.getValue(User_Class.class);
                    Users.add(User);
                }
            }

            @Override
            public void onCancelled( DatabaseError error) {

            }
        });

        BTNLogin = (Button) findViewById(R.id.BTNLogin);
        BTNLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i=0 ;i<Users.size()-1 ;i++){
                   if (Users.get(i).Username.equals(TVUsername.getText().toString()) && Users.get(i).Password.equals(TVPassword.getText().toString())){
                       if (Users.get(i).admin== true)
                       {
                           Intent intentT = new Intent(Login_Activity.this, Test_activity.class);
                           startActivity(intentT);
                       }
                       else {
                           count++;
                           Intent intentM = new Intent(Login_Activity.this, Lobbies_activity.class);
                           startActivity(intentM);
                       }
                   }
                }
                if (count == Users.size()){
                    Toast.makeText(getApplicationContext(),"Username or Password are incorrect",Toast.LENGTH_SHORT).show();
                }
            }
        });

        BTNRegister = (Button) findViewById(R.id.BTNRegister);
        BTNRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentS = new Intent(Login_Activity.this, SignUp_Activity.class);
                startActivity(intentS);
            }

        });
    }
}