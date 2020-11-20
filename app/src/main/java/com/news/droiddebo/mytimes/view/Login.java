package com.news.droiddebo.mytimes.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.news.droiddebo.mytimes.database.DbAccessObj;
import com.news.droiddebo.mytimes.R;

public class Login extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName() ;
    public static final String MYPREFS = "myprefs";
    public static final String NAMEKEY = "namekey";
    public static final String PWDKEY = "pwdkey";
    CheckBox remember;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    //private SharedPreferences loginPreferences;
    //private SharedPreferences.Editor loginPrefsEditor;
    DbAccessObj dbAccessObj;
    EditText nameEditText,pwdEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(TAG,"onCreate");
        nameEditText =  findViewById(R.id.email);
        pwdEditText = findViewById(R.id.password);
        remember = findViewById(R.id.checkbox);
        dbAccessObj = new DbAccessObj(this);
        dbAccessObj.openDb();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    /* if(remember.isChecked())
       {
           restoreData();
      }*/
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onpause");
        if(remember.isChecked()) {
            int i = 1;
        }
        else{
            restoreData();
        }
    }
    /**
     * this method will save data from edittexts into a sharedprefs
     */
    private void saveData() {
        Log.i(TAG,"saveData");
        //get the data from the edittext
        String name = nameEditText.getText().toString();
        String pwd = pwdEditText.getText().toString();
        //create a file names myprefs
        SharedPreferences preferences = getSharedPreferences(MYPREFS,MODE_PRIVATE);
        //open the file
        SharedPreferences.Editor editor = preferences.edit();
        //write to the file
        editor.putString(NAMEKEY,name);
        editor.putString(PWDKEY,pwd);
        //save the file
        editor.apply();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onresume");
        /*if(remember.isChecked()) {
            restoreData();
        }*/
       /* else{
           // nameEditText.clear();
        }*/
    }
    private void restoreData(){
        Log.i(TAG,"restoreData");
        //open the file
        SharedPreferences preferences = getSharedPreferences(MYPREFS,MODE_PRIVATE);
        //read the file
        String name = preferences.getString(NAMEKEY,"");
        String pwd = preferences.getString(PWDKEY,"");
        //set the data in edittexts
        nameEditText.setText(name);
        pwdEditText.setText(pwd);
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onstop");
    }
    public void clickHandler(View view) {
        Log.e(TAG,"clickHandler");
        switch (view.getId()){
            case R.id.buttonlogin:
                getCredentials();
                break;
        }
    }
    private void startHome() {
        Intent hIntent = new Intent(Login.this, MainActivity.class);
        // hIntent.putExtra("mykey","abdul");
        startActivity(hIntent);
    }
    private void getCredentials() {
        String userentry = nameEditText.getText().toString();
        String username = dbAccessObj.uservalid(userentry);
        String pwd = dbAccessObj.query(userentry);
        String userpwd = pwdEditText.getText().toString();
        if(userentry.equals(username)){
            if(pwd.equals(userpwd)){
                Toast.makeText(getApplicationContext(), "Hello "+username, Toast.LENGTH_SHORT).show();
                startHome();
            }
            else{
                Toast.makeText(this, "Invalid Password", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            Toast.makeText(this, "Invalid Username Kindly register", Toast.LENGTH_SHORT).show();
        }
    }


    public void handleDb(View view) {
        switch (view.getId()){
            case R.id.buttonput:
                String title = nameEditText.getText().toString();
                String subtitle = pwdEditText.getText().toString();
                dbAccessObj.createRow(title,subtitle);
                break;
        }
    }
}
