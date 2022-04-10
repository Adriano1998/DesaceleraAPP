package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class Activity11Redirecionamento extends AppCompatActivity {

    ImageButton imgbtn_VoltarpTelaInicial;
    Button btn_CadastrarUsuario, btn_CadastrarProfissional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity11_redirecionamento);


        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaCadastrese);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        btn_CadastrarProfissional = findViewById(R.id.btnCadastrarProfissionalTelaCadastrese);
        btn_CadastrarProfissional.setOnClickListener(evt -> proximaTela(Activity8Profissional.class));

        btn_CadastrarUsuario = findViewById(R.id.btnCadastrarUsuarioTelaCadastrese);
        btn_CadastrarUsuario.setOnClickListener(evt -> proximaTela(Actvity7FormUsuario.class));

    }

    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);}


}