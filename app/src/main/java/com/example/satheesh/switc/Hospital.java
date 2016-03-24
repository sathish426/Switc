package com.example.satheesh.switc;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.satheesh.switc.MainActivity;
import com.example.satheesh.switc.R;
import com.example.satheesh.switc.UserSessionManager;

public class Hospital extends AppCompatActivity {

    TextView  btnsa,btnnext,btnlogout;
    boolean nextsave,isNextsave;
    EditText txtUsername, txtPassword,txtsave;

    // User Session Manager Class
    DoctorSessionManager session;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // User Session Manager
        session = new DoctorSessionManager(getApplicationContext());

        // get Email, Password input text
        txtUsername = (EditText) findViewById(R.id.editText);
        txtPassword = (EditText) findViewById(R.id.editText2);
        txtsave = (EditText) findViewById(R.id.editText3);
        // getSupportActionBar().setTitle("Login");
        Toast.makeText(getApplicationContext(),
                "User Login Status: " + session.isUserLoggedIn(),
                Toast.LENGTH_LONG).show();


        // User Login button
        btnsa = (TextView) findViewById(R.id.btnsave);
        btnnext=(TextView)findViewById(R.id.button);
        btnlogout=(TextView)findViewById(R.id.logout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();
                String save = txtsave.getText().toString();
                if(isNextsave==true){
                    AlertDialog alertDialog = new AlertDialog.Builder(Hospital.this).create();
                    alertDialog.setMessage("Please save data before go to next");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // session.createUserLoginSession("Android Example", "androidexample84@gmail.com");
                            Intent i = new Intent(getApplicationContext(), Hospital.class);
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
                                    Intent i = new Intent(getApplicationContext(), Corporate.class);
                                    startActivity(i);
                                }
                            });
                    alertDialog.show();

                }
                if (nextsave==true) {
                    Intent i = new Intent(getApplicationContext(), Corporate.class);
                    startActivity(i);

                }else{
                    AlertDialog alertDialog = new AlertDialog.Builder(Hospital.this).create();
                    alertDialog.setMessage("Please enter detalis to continue");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // session.createUserLoginSession("Android Example", "androidexample84@gmail.com");
                            Intent i = new Intent(getApplicationContext(), Hospital.class);
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
                                    Intent i = new Intent(getApplicationContext(),Corporate.class);
                                    startActivity(i);
                                }
                            });
                    alertDialog.show();

                }


            }

        });

        // Login button click event
        btnsa.setOnClickListener(new View.OnClickListener() {

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

                    if(username1.equals(username1) && password1.equals(password1)&&save1.equals(save1)){


                        // Creaifting user login session
                        // Statically storing name="Android Example"
                        // and email="androidexample84@gmail.com"
                        //     session.createUserLoginSession("Android Example", "androidexample84@gmail.com");

                        // Starting MainActivity
                        Toast.makeText(getApplicationContext(), "Data saved", Toast.LENGTH_LONG).show();
                        nextsave=true;

                        isNextsave=true;


                    }
                }else{
                    Intent i = new Intent(getApplicationContext(),Corporate .class);
                    startActivity(i);
                    // user didn't entered username or password
                    Toast.makeText(getApplicationContext(), "Username/Password is incorrect", Toast.LENGTH_LONG).show();


                }

            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_settings:
                // search action
                return true;
            case R.id.action_hospital:
                // location found
                Intent intent=new Intent(getApplicationContext(),Hospital.class);
                startActivity(intent);
                return true;
            case R.id.action_patient:
                Intent i=new Intent(getApplicationContext(),PatientActivity.class);
                startActivity(i);
                // refresh
                return true;
            case R.id.logout:
                // help action
                Intent in=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(in);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}