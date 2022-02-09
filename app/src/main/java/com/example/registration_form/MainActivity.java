package com.example.registration_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
     EditText fname,lname,email,pass,phno;
     Button regbtn;
     String RegularExpr ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname=findViewById(R.id.inputfname);
        lname=findViewById(R.id.inputlname);
        email=findViewById(R.id.inputemail);
        pass=findViewById(R.id.editTextTextPassword);
        phno=findViewById(R.id.inputPhno);
        regbtn=findViewById(R.id.Lbtn);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=fname.getText().toString();
                String password=pass.getText().toString();
                String Lastname=lname.getText().toString();
                String emailaddress=email.getText().toString();
                String Phonenumber=phno.getText().toString();

                if (isEmpty(fname)) {

                    fname.setError("First name is required!");
                }

                if (isEmpty(lname)) {
                    lname.setError("Last name is required!");
                }
                if(isEmpty(email)){
                    email.setError("Email is required");
                }
                if(isEmpty(phno)){
                    phno.setError("phone number is required");
                }

                if(validatePassword(password))
                {
                    Bundle bundle=new Bundle();
                    bundle.putString("uname",username);
                    bundle.putString("pwd",password);
                    bundle.putString("lnam",Lastname);
                    bundle.putString("mailid",emailaddress);
                    bundle.putString("phone",Phonenumber);
                    Intent intent = new Intent(MainActivity.this,Login_Page.class);
                    intent.putExtras(bundle);
                    startActivity(intent);


                }
                else
                {
                    Toast.makeText(MainActivity.this, "Invalid Password Format", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    public boolean validatePassword(String password)
    {
        Pattern pattern= Pattern.compile(RegularExpr);
        Matcher matcher= pattern.matcher(password);

        return matcher.matches();
    }
    boolean isEmpty(EditText text) {
        CharSequence str = text.getText().toString();
        return TextUtils.isEmpty(str);
    }
}