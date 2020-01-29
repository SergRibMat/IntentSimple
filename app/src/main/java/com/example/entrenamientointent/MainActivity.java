package com.example.entrenamientointent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText et_1;
    private String valor;
    TextView tv1;
    Intent intent;
    private String elDato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_1 = (EditText) findViewById(R.id.et_1);
        tv1 = (TextView) findViewById(R.id.tv1);
    }

    public void nextActivity(View view){
        intent = new Intent(this, SegundoActivity.class); //helps to create certain actions en the activity; in this case, is simply to create a new one.
        valor = et_1.getText().toString();
        checkValue();//simple input control
        intent.putExtra("dato", valor);//A recomendation, if you want do send a number, send it as a String and then cast it. this way wont give unexpected errors
        //startActivity(intent);//its a method that starts the activity with the info u gave to the intent object
        startActivityForResult(intent, 1);//starts an activity and you want something from the other activity, and when you finish the
        //second activity, it returns the wanted result, then you use onActivityResult to retrieve that information
        //this of the request code as an ID. You can insert the integer you prefer and that requestcode will identify a certain intent.
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){//you can use as many requestCode == as actual request codes you have.
            if (resultCode == RESULT_OK){
                elDato = data.getStringExtra("dato2");
                showDato2();
            }
        }
    }

    public void implicidIntent(View view){//this is called implicid intent because you want to open a thirt party app.
        Uri uri = Uri.parse("https://google.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);//this is a proper way to start a navegator to open a website.
    }

    private void showDato2(){
        tv1.setText(elDato);
    }

    private void checkValue(){
        if (valor == null || valor.isEmpty()){
            valor = "7";
        }
    }



}
