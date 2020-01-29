package com.example.entrenamientointent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    TextView tv1_2act;
    String dato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        tv1_2act = findViewById(R.id.tv1_2act);

        dato = getIntent().getStringExtra("dato");
        tv1_2act.setText("" + dato);

    }

    public void returnToPreviusActivity(View view){
        Intent intent = new Intent();
        intent.putExtra("dato2", dato);
        setResult(RESULT_OK, intent);
        finish();//finishes the current activity, then OnActivityResult from the previous activity is executed by its own.
    }


}
