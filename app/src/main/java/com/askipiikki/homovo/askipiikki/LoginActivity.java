package com.askipiikki.homovo.askipiikki;

import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
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


/**
 * Created by HOMOVO on 2.2.2016.
 *
 * I guess here should read something more than just default mambo jumbo.
 *
 */

public class LoginActivity extends AppCompatActivity {

    private static EditText username;
    private static EditText password;
    private static Button login_button;
    private TextView nfcTxt;

    NfcAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        nfcTxt = (TextView)findViewById(R.id.textView_nfc);
        LoginButton();

        adapter = NfcAdapter.getDefaultAdapter(this);

        /*
        if(adapter == null)
        {
            // NFC is not available to your device
        }
        */
    }

    @Override
    public void onNewIntent(Intent intent) {
        setIntent(intent);
        resolveIntent(intent);
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
                                password.getText().toString().equals("pass")) {
                            Toast.makeText(LoginActivity.this, "Username and password is correct",
                                    Toast.LENGTH_SHORT).show();
                            Intent menu = new Intent(LoginActivity.this, MenuActivity.class);
                            startActivity(menu);

                        } else {
                            Toast.makeText(LoginActivity.this, "Username and password is NOT correct",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }


    private void resolveIntent(Intent intent) {
        String action = intent.getAction();
        if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)
                || NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action))
        {
            Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
            NdefMessage[] msgs = null;
            if (rawMsgs != null) {
                msgs = new NdefMessage[rawMsgs.length];
                for (int i = 0; i < rawMsgs.length; i++) {
                    msgs[i] = (NdefMessage) rawMsgs[i];
                }
            }
            buildTagViews(msgs);
        }
    }

    void buildTagViews(NdefMessage[] msgs)
    {
        if (msgs == null || msgs.length == 0) {
            return;
        }

        String tagId = new String(msgs[0].getRecords()[0].getType());
        String body = new String(msgs[0].getRecords()[0].getPayload());

        nfcTxt.setText("NFC ID: " + tagId);
    }


}
