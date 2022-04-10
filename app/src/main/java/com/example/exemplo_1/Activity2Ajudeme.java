package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class Activity2Ajudeme extends AppCompatActivity {

    ImageButton imgbtn_Ajudame, imgbtn_Livros, imgbtn_VoltarpTelaInicial, imgbtn_Playlists,
            imgbtn_Exercicios, imgbtn_EncontreProfissional, imgbtn_Cadastrese;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

     /*   imgbtn_Ajudame = findViewById(R.id.ajudeme2);
        imgbtn_Ajudame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ajuda = new Intent(getApplicationContext(), Activity2Ajudeme.class);
                startActivity(ajuda);
            }
        }); */

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaAjudame);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaAjudame);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaAjudame);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaAjudame);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_Ajudame = findViewById(R.id.imgbtnAjudameTelaAjudame);
        imgbtn_Ajudame.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaAjudame);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaAjudame);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));


    }

    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);
    }
}