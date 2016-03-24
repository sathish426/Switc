package com.example.satheesh.switc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.satheesh.switc.MainActivity;
import com.example.satheesh.switc.R;
import com.example.satheesh.switc.UserSessionManager;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin,btnnext,btnlogout;

    EditText txtUsername, txtPassword;

    // User Session Manager Class
    UserSessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startactivity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // User Session Manager
        session = new UserSessionManager(getApplicationContext());


        // get Email, Password input text
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);

        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();


        // User Login button
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnnext=(Button)findViewById(R.id.button);
        btnnext=(Button)findViewById(R.id.button);


        // Login button click event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Get username, password from EditText
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                String username1 = txtUsername.getText().toString();
                String password1 = txtPassword.getText().toString();
                String username2 = txtUsername.getText().toString();
                String password2 = txtPassword.getText().toString();
                // Validate if username, password is filled
                if(username.trim().length() > 0 && password.trim().length() > 0){

                    // For testing puspose username, password is checked with static data
                    // username = admin
                    // password = admin

                    if(username.equals("admin") && password.equals("admin")){

                        // Creating user login session
                        // Statically storing name="Android Example"
                        // and email="androidexample84@gmail.com"
                        session.createUserLoginSession("Android Example", "androidexample84@gmail.com");

                        // Starting MainActivity
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);

                        finish();

                    }

                    if(username1.equals("test") && password1.equals("test")){

                        // Creating user login session
                        // Statically storing name="Android Example"
                        // and email="androidexample84@gmail.com"
                        session.createUserLoginSession1("Android Example", "androidexample84@gmail.com");

                        // Starting MainActivity
                        Intent i = new Intent(getApplicationContext(), Hospital.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);

                        finish();

                    }
                    if(username2.equals("user") && password2.equals("user")){

                        // Creating user login session
                        // Statically storing name="Android Example"
                        // and email="androidexample84@gmail.com"
                        session.createUserLoginSession1("Android Example", "androidexample84@gmail.com");

                        // Starting MainActivity
                        Intent i = new Intent(getApplicationContext(), PatientActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                        // Add new Flag to start new Activity
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);

                        finish();

                    }
                    else{

                        // username / password doesn't match
                        Toast.makeText(getApplicationContext(), "Username/Password is incorrect", Toast.LENGTH_LONG).show();

                    }
                }else{

                    // user didn't entered username or password
                    Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_LONG).show();

                }

            }
        });
    }
}