package com.example.heartofstone;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Set;

public class SignUp_Activity extends AppCompatActivity {
    Button BTNRegisterR;
    EditText Username, Email, Password, Age, Phonenum;

    //counter for new User placement and a sum counter for age
    int count = 0;
    User_Class UserEXP= new User_Class();
    ArrayList<User_Class> Users = new ArrayList<User_Class>();

    FirebaseDatabase database= FirebaseDatabase.getInstance();
    DatabaseReference myRef= database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        Username = (EditText) findViewById(R.id.TVUserNameR);
        Email = (EditText) findViewById(R.id.TVEmailR);
        Password = (EditText) findViewById(R.id.TVPasswordR);
        Age = (EditText) findViewById(R.id.TVAgeR);
        Phonenum = (EditText) findViewById(R.id.TVPhoneNumR);
        BTNRegisterR = (Button) findViewById(R.id.BTNRegisterFinish);
        BTNRegisterR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check if Users Size not over 100, Age is 16 or Above, Phonenum in correct length(10 digits),Password longer then 6 Chars
                if (Users.size() <= 100 && Integer.valueOf(Age.getText().toString()) >= 16 && Phonenum.getText().toString().length() == 10 && Password.getText().toString().length() >= 6) {
                    Users.add( new User_Class(Username.getText().toString(), (Password.getText().toString()), Email.getText().toString(), Integer.valueOf(Phonenum.getText().toString()), Integer.valueOf(Age.getText().toString())));
                    InsertUserToFirebase();
                    //count++;
                    //Toast.makeText(getApplicationContext(), "This is your " + count + " User", Toast.LENGTH_SHORT).show();
                    Intent intentP = new Intent(SignUp_Activity.this, Lobbies_activity.class);
                    startActivity(intentP);
                }
                //If one of the checks doesn't work gives a Toast of what is wrong
                if (Phonenum.getText().toString().length() != 10)// Phonenum in correct length(10 digits)
                    Toast.makeText(getApplicationContext(), "Your phonenumber is incorrect", Toast.LENGTH_SHORT).show();
                if (Password.getText().toString().length() < 6)//Password longer then 6 Chars
                    Toast.makeText(getApplicationContext(), "Your Password length needs to be longer than 6 chars", Toast.LENGTH_SHORT).show();
                if (Integer.valueOf(Age.getText().toString()) < 16)//Age is 16 or Above
                    Toast.makeText(getApplicationContext(), "Your Age is not above 16", Toast.LENGTH_SHORT).show();
                if (Users.size()>100)//Users Size not over 100
                    Toast.makeText(getApplicationContext(), "Too many Users", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void InsertUserToFirebase(){
            UserEXP=Users.get(count);
            myRef.child("allUsers").push().setValue(UserEXP);
        }
    }