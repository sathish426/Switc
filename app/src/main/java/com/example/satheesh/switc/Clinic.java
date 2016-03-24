package com.example.satheesh.switc;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.satheesh.switc.MainActivity;
import com.example.satheesh.switc.R;
import com.example.satheesh.switc.UserSessionManager;

public class Clinic extends AppCompatActivity {

    TextView btnsave,btnnext,btnprev;

    boolean nextsave,isNextsave;
    EditText txtUsername, txtPassword,txtsave;

    // User Session Manager Class
    DoctorSessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clinic);

        // User Session Manager
        session = new DoctorSessionManager(getApplicationContext());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // get Email, Password input text
        txtUsername = (EditText) findViewById(R.id.editText);
        txtPassword = (EditText) findViewById(R.id.editText2);
        txtsave = (EditText) findViewById(R.id.editText3);

        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();


        // User Login button

        btnsave = (TextView) findViewById(R.id.btnsave);
        btnnext=(TextView)findViewById(R.id.button);
        btnprev=(TextView)findViewById(R.id.previous);
        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SeniorDoctor.class);

                startActivity(i);


            }
        });
       /* final Button.OnClickListener listener2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.equals("admin") && password.equals("admin")&&save.equals("admin")){

                    // Creating user login session
                    // Statically storing name="Android Example"
                    // and email="androidexample84@gmail.com"
                    //     session.createUserLoginSession("Android Example", "androidexample84@gmail.com");

                    // Starting MainActivity
                    Toast.makeText(getApplicationContext(), "Data saved", Toast.LENGTH_LONG).show();

                }
                // Take picture
            }
        };
        Button.OnClickListener listener1 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open camera
                v.setOnClickListener(listener2);
            }
        };

        btnnext.setOnClickListener(listener1);
*/
// Later at some point, e.g. when camera is closed:
        //   btnnext.setOnClickListener(listener1);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                String save = txtsave.getText().toString();
              /*  if(isNextsave==true){
                    AlertDialog alertDialog = new AlertDialog.Builder(JuniorDotor.this).create();
                    alertDialog.setMessage("Please save data before go to next");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // session.createUserLoginSession("Android Example", "androidexample84@gmail.com");
                            Intent i = new Intent(getApplicationContext(), JuniorDotor.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                            // Add new Flag to start new Activity
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);

                            finish();
                            // Starting MainActivity

                        }

                    });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "cancel",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Intent i = new Intent(getApplicationContext(), JuniorDotor.class);
                                    startActivity(i);
                                }
                            });
                    alertDialog.show();

                }*/
                if (nextsave==true) {
                    Intent i = new Intent(getApplicationContext(), Clinic.class);
                    startActivity(i);

                /*String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                String save = txtsave.getText().toString();


                if (username.equals(username) && password.equals(password)&&save.equals(save))
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setMessage("Please save data before go to next");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // session.createUserLoginSession("Android Example", "androidexample84@gmail.com");

                            // Starting MainActivity

                        }

                    });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "cancel",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Intent i = new Intent(getApplicationContext(), SeniorDoctor.class);
                                    startActivity(i);
                                }
                            });
                    alertDialog.show();


                    // Creating user login session
                    // Statically storing name="Android Example"
                    // and email="androidexample84@gmail.com"
                    *//* session.createUserLoginSession("Android Example", "androidexample84@gmail.com");

                     // Starting MainActivity
                     Intent i = new Intent(getApplicationContext(), MainActivity.class);
                     i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                     // Add new Flag to start new Activity
                     i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                     startActivity(i);

                     finish();*//*
                } else   {
                    Intent i = new Intent(getApplicationContext(), SeniorDoctor.class);
                    startActivity(i);

                }*/
                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(Clinic.this).create();
                    alertDialog.setMessage("Please enter some data to continue");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // session.createUserLoginSession("Android Example", "androidexample84@gmail.com");
                            Intent i = new Intent(getApplicationContext(), Clinic.class);
                            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                            // Add new Flag to start new Activity
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(i);

                            finish();
                            // Starting MainActivity

                        }

                    });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "cancel",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    Intent i = new Intent(getApplicationContext(), JuniorDotor.class);
                                    startActivity(i);
                                }
                            });
                    alertDialog.show();

                }


            }

        });

        // Login button click event
        btnsave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                // Get username, password from EditText
                String username1 = txtUsername.getText().toString();
                String password1 = txtPassword.getText().toString();
                String save1 = txtsave.getText().toString();

                // Validate if username, password is filled
                if(username1.trim().length() > 0 && password1.trim().length() > 0 &&save1.trim().length()>0){

                    // For testing puspose username, password is checked with static data
                    // username = admin
                    // password = admin

                    if(username1.equals("test") && password1.equals("test")&&save1.equals("test")){


                        // Creaifting user login session
                        // Statically storing name="Android Example"
                        // and email="androidexample84@gmail.com"
                        //     session.createUserLoginSession("Android Example", "androidexample84@gmail.com");

                        // Starting MainActivity
                        Toast.makeText(getApplicationContext(), "Data saved", Toast.LENGTH_LONG).show();
                        nextsave=true;




                    }
                }else{
                    Intent i = new Intent(getApplicationContext(), Clinic.class);
                    startActivity(i);
                    // user didn't entered username or password
                    Toast.makeText(getApplicationContext(), "Username/Password is incorrect", Toast.LENGTH_LONG).show();


                }

            }
        });
    }
}