package com.example.registration_form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Page extends AppCompatActivity {
    EditText fname,pass;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_page);
        fname=findViewById(R.id.inputfname);
        pass=findViewById(R.id.editTextTextPassword);
        btn=findViewById(R.id.Lbtn);

        Bundle bundle=getIntent().getExtras();
       String username= bundle.getString("uname");
       String password= bundle.getString("pwd");
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String user=fname.getText().toString();
               String pdd=pass.getText().toString();
               if(user.equals(username) &&  pdd.equals(password))
               {
                   Intent intent = new Intent(Login_Page.this,Successful_Page.class);
                   startActivity(intent);
               }
               else
               {
                   Toast.makeText(Login_Page.this, "failed", Toast.LENGTH_LONG).show();
               }
           }
       });
    }
}