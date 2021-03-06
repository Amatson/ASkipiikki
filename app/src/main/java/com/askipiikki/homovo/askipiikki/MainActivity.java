package com.askipiikki.homovo.askipiikki;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
// import android.view.Menu;
// import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
}





/*

public class LoginActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button login_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton();
    }

    public void LoginButton(){
        username = (EditText)findViewById(R.id.editText_user);
        password = (EditText)findViewById(R.id.editText_password);
        login_button = (Button)findViewById(R.id.button_login);

        login_button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (username.getText().toString().equals("user") &&
                        password.getText().toString().equals("pass")){
                            Toast.makeText(LoginActivity.this,"Username and password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(v.getContext(), MenuActivity.class);
                            startActivity(intent);

                        }
                        else {
                            Toast.makeText(LoginActivity.this,"Username and password is NOT correct",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}





public class MenuActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_scan;
    private TextView formatTxt, contentTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_scan = (Button)findViewById(R.id.button_scan);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        button_scan.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.getId()==R.id.button_scan){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            formatTxt.setText("FORMAT: " + scanFormat);
            contentTxt.setText("CONTENT: " + scanContent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}


*/