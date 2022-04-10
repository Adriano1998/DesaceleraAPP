package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity5Exercicios extends AppCompatActivity {

    ImageButton imgbtn_Ajudeme,imgbtn_Livros,imgbtn_VoltarpTelaInicial,imgbtn_Playlists,
            imgbtn_Exercicios,imgbtn_EncontreProfissional,imgbtn_Cadastrese;
    TextView txtvw_LinkMaisExercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity5_exercicios);

        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaExercicios);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaExercicios);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaExercicios);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaExercicios);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaExercicios);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaExercicios);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_Ajudeme = findViewById(R.id.imgbtnAjudameTelaExercicios);
        imgbtn_Ajudeme.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));


        txtvw_LinkMaisExercicios = (TextView) findViewById(R.id.txtvwLinkMaisExerciciosTelaExercicios);
        txtvw_LinkMaisExercicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=A4tkULKy7RY")));
            }});

    }

    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);}


}