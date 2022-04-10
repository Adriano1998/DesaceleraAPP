package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.widget.EditText;
import android.widget.ImageButton;

public class Activity12EsqueciSenha extends AppCompatActivity {

    ImageButton imgbtn_EnviarSenha,imgbtn_VoltarpTelaInicial;
    EditText edttxt_CampoNome, edttxt_CampoEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity12_esqueci_senha);

        edttxt_CampoNome = findViewById(R.id.edttxtCampoNomeTelaEsqueciminhasenha);
        edttxt_CampoEmail = findViewById(R.id.edttxtCampoEmailTelaEsqueciminhasenha);

        imgbtn_EnviarSenha = findViewById(R.id.imgbtnEnviarSenhaTelaEsqueciminhasenha);
        imgbtn_EnviarSenha.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaEsqueciminhasenha);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));
    }

    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);}




}