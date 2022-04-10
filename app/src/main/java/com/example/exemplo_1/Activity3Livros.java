package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Activity3Livros extends AppCompatActivity {

    ImageButton imgbtn_Ajudame,imgbtn_Livros,imgbtn_VoltarpTelaInicial,imgbtn_Playlists,imgbtn_Exercicios,
            imgbtn_EncontreProfissional,imgbtn_Cadastrese,imgbtn_EbookElsieHerber,
            imgbtn_EbookTatianaAuler, imgbtn_EbookDiegoFalco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3_livros);

        imgbtn_EbookElsieHerber = findViewById(R.id.imgbtnEbookElsieHerberTelaLivros);
        imgbtn_EbookElsieHerber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://ebook.elsieherber.com.br/?utm_source=google-ads3&utm_campaign=ebook-elsie&utm_medium=google-ads3-pesquisa&utm_content=ebook-elsie-pesquisa-ads3&gclid=CjwKCAjw_tWRBhAwEiwALxFPoSQ3f72sn2Xc0MhHqjNiO-aUOgEvmeN8rAEqw6Mg8NuTymgm8okc2RoCDgkQAvD_BwE")));
            }});

        imgbtn_EbookTatianaAuler = findViewById(R.id.imgbtnEbookTatianaAulerTelaLivros);
        imgbtn_EbookTatianaAuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.institutoauler.com.br/ebook-ansiedade-gratuito")));
            }});

        imgbtn_EbookDiegoFalco = (ImageButton) findViewById(R.id.imgbtnEbookDiegoFalcoTelaLivros);
        imgbtn_EbookDiegoFalco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://terapiacognitivaonline.com/ebook-ansiedade/")));
            }});


        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaLivros);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaLivros);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaLivros);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaLivros);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaLivros);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaLivros);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_Ajudame = findViewById(R.id.imgbtnAjudameTelaLivros);
        imgbtn_Ajudame.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));


           }

    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);}



}