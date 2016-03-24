package com.example.satheesh.switc;

import java.util.HashMap;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class UserSessionManager {
	
	// Shared Preferences reference
	SharedPreferences pref;
	
	// Editor reference for Shared preferences
	Editor editor;
	
	// Context
	Context _context;
	
	// Shared pref mode
	int PRIVATE_MODE = 0;
	
	// Sharedpref file name
	private static final String PREFER_NAME = "my pref";
	private static final String PREFER_NAME1 = "dctor";
	private static final String PREFER_NAME2 = "hospital";
	// All Shared Preferences Keys
	private static final String IS_USER_LOGIN = "IsUserLoggedIn";
	private static final String IS_USER_LOGIN1 = "IsUserLoggedIn";
	private static final String IS_USER_LOGIN2 = "IsUserLoggedIn";

	
	// User name (make variable public to access from outside)
	public static final String KEY_NAME = "name";
	public static final String KEY_NAME1= "name";
	public static final String KEY_NAME2= "name";
	
	// Email address (make variable public to access from outside)
	public static final String KEY_EMAIL = "email";
	public static final String KEY_EMAIL1 = "email";
	public static final String KEY_EMAIL2 = "email";
	
	// Constructor
	public UserSessionManager(Context context){
		this._context = context;
		pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
		editor = pref.edit();
	}

	//Create login session
	public void createUserLoginSession(String name, String email){
		// Storing login value as TRUE
		editor.putBoolean(IS_USER_LOGIN, true);
		
		// Storing name in pref
		editor.putString(KEY_NAME, name);
		
		// Storing email in pref
		editor.putString(KEY_EMAIL, email);
		
		// commit changes
		editor.commit();
	}
	public void createUserLoginSession1(String name, String email){
		// Storing login value as TRUE
		editor.putBoolean(IS_USER_LOGIN1, true);

		// Storing name in pref
		editor.putString(KEY_NAME1, name);

		// Storing email in pref
		editor.putString(KEY_EMAIL1, email);

		// commit changes
		editor.commit();
	}
	public void createUserLoginSession2(String name, String email){
		// Storing login value as TRUE
		editor.putBoolean(IS_USER_LOGIN, true);

		// Storing name in pref
		editor.putString(KEY_NAME2, name);

		// Storing email in pref
		editor.putString(KEY_EMAIL2, email);

		// commit changes
		editor.commit();
	}
	/**
	 * Check login method will check user login status
	 * If false it will redirect user to login page
	 * Else do anything
	 * */
	public boolean checkLogin(){
		// Check login status
		if(!this.isUserLoggedIn()){
			
			// user is not logged in redirect him to Login Activity
			Intent i = new Intent(_context, com.example.satheesh.switc.LoginActivity.class);
			
			// Closing all the Activities from stack
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

			// Add new Flag to start new Activity
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			
			// Staring Login Activity
			_context.startActivity(i);
			
			return true;
		}
		return false;
	}
	public boolean checkLogin2(){
		// Check login status
		if(!this.isUserLoggedIn2()){

			// user is not logged in redirect him to Login Activity
			Intent i = new Intent(_context, com.example.satheesh.switc.LoginActivity.class);

			// Closing all the Activities from stack
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

			// Add new Flag to start new Activity
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

			// Staring Login Activity
			_context.startActivity(i);

			return true;
		}
		return false;
	}

	public boolean checkLogin1(){
		// Check login status
		if(!this.isUserLoggedIn1()){

			// user is not logged in redirect him to Login Activity
			Intent i = new Intent(_context, com.example.satheesh.switc.LoginActivity.class);

			// Closing all the Activities from stack
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

			// Add new Flag to start new Activity
			i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

			// Staring Login Activity
			_context.startActivity(i);

			return true;
		}
		return false;
	}


	/**
	 * Get stored session data
	 * */
	public HashMap<String, String> getUserDetails(){
		
		//Use hashmap to store user credentials
		HashMap<String, String> user = new HashMap<String, String>();
		
		// user name
		user.put(KEY_NAME, pref.getString(KEY_NAME, null));
		
		// user email id
		user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
		
		// return user
		return user;
	}
	public HashMap<String, String> getUserDetails1(){

		//Use hashmap to store user credentials
		HashMap<String, String> user = new HashMap<String, String>();

		// user name
		user.put(KEY_NAME1, pref.getString(KEY_NAME1, null));

		// user email id
		user.put(KEY_EMAIL1, pref.getString(KEY_EMAIL1, null));

		// return user
		return user;
	}
	public HashMap<String, String> getUserDetails2(){

		//Use hashmap to store user credentials
		HashMap<String, String> user = new HashMap<String, String>();

		// user name
		user.put(KEY_NAME2, pref.getString(KEY_NAME2, null));

		// user email id
		user.put(KEY_EMAIL2, pref.getString(KEY_EMAIL2, null));

		// return user
		return user;
	}
	/**
	 * Clear session details
	 * */
	public void logoutUser(){
		
		// Clearing all user data from Shared Preferences
		editor.clear();
		editor.commit();
		
		// After logout redirect user to Login Activity
		Intent i = new Intent(_context, LoginActivity.class);
		
		// Closing all the Activities
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		
		// Add new Flag to start new Activity
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		
		// Staring Login Activity
		_context.startActivity(i);
	}

	public void logoutUser1(){

		// Clearing all user data from Shared Preferences
		editor.clear();
		editor.commit();

		// After logout redirect user to Login Activity
		Intent i = new Intent(_context, LoginActivity.class);

		// Closing all the Activities
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		// Add new Flag to start new Activity
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		// Staring Login Activity
		_context.startActivity(i);
	}
	public void logoutUser2(){

		// Clearing all user data from Shared Preferences
		editor.clear();
		editor.commit();

		// After logout redirect user to Login Activity
		Intent i = new Intent(_context, LoginActivity.class);

		// Closing all the Activities
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

		// Add new Flag to start new Activity
		i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

		// Staring Login Activity
		_context.startActivity(i);
	}
	// Check for login
	public boolean isUserLoggedIn(){
		return pref.getBoolean(IS_USER_LOGIN, false);
	}
	public boolean isUserLoggedIn1(){
		return pref.getBoolean(IS_USER_LOGIN1, false);
	}
	public boolean isUserLoggedIn2(){
		return pref.getBoolean(IS_USER_LOGIN2, false);
	}
}


