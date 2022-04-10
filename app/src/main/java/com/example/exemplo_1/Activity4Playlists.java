package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

public class Activity4Playlists extends AppCompatActivity {

    ImageButton imgbtn_Ajudame,imgbtn_Livros,imgbtn_VoltarpTelaInicial,
            imgbtn_Playlists,imgbtn_Exercicios,imgbtn_EncontreProfissional,imgbtn_Cadastrese;

    TextView txtvw_LinkSomInstrumental, txtvw_LinkSonsNatureza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity4_playlists);

        txtvw_LinkSomInstrumental = findViewById(R.id.txtvwLinkSomInstrumentalTelaPlaylists);
        txtvw_LinkSonsNatureza = findViewById(R.id.txtvwLinkSomNaturezaTelaPlaylists);

        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaPlaylists);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaPlaylists);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaPlaylists);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaPlaylists);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaPlaylists);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaPlaylists);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_Ajudame = findViewById(R.id.imgbtnAjudameTelaPlaylists);
        imgbtn_Ajudame.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));

    }
    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);}



}