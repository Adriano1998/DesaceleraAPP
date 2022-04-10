package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton imgbtn_Ajudame,imgbtn_Livros,imgbtn_Playlists, imgbtn_Exercicios,
            imgbtn_EncontreProfissional,imgbtn_Cadastrese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaInicial);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaInicial);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaInicial);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_Ajudame = findViewById(R.id.imgbtnAjudameTelaInicial);
        imgbtn_Ajudame.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaInicial);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaInicial);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));



    }

    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);
    }
}