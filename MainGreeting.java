package com.example.holmesmarin.ppa;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Intent.ACTION_SEND;


/**
 * Created by Holmes Marin on 4/3/2017.
 */

public class MainGreeting extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        Button sendBtn = (Button) findViewById(R.id.button8);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText textMessage=(EditText)findViewById(R.id.editText);
                String vtextMessage=textMessage.getText().toString();
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{"holmes.marin@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "Felicitacion desde PPA");
                i.putExtra(Intent.EXTRA_TEXT, vtextMessage);
                startActivity(Intent.createChooser(i, "Seleccionar aplicación."));
            }
        });


        final Button boton_salida = (Button)findViewById(R.id.button7);
        boton_salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
    }

}
