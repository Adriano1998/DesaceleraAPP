package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplo_1.database.BancoSQLite;
import com.example.exemplo_1.modelos.FichaAnamnese;
import com.example.exemplo_1.modelos.Profissional;
import com.example.exemplo_1.modelos.Usuario;

public class Activity9EncontreProfissional extends AppCompatActivity {

    ImageButton imgbtn_Ajudame, imgbtn_Livros, imgbtn_VoltarpTelaInicial, imgbtn_Playlists, imgbtn_Exercicios, 
            imgbtn_EncontreProfissional, imgbtn_Cadastrese, imgbtn_Logoff;

    TextView txtvw_NomeC2L1, txtvw_NomeC2L2, txtvw_NumeroRegistroC3L1, txtvw_NumeroRegistroC3L2, txtvw_EmailC4L1, txtvw_EmailC4L2,
    txtvw_NomeC2L3, txtvw_NumeroRegistroC3L3, txtvw_EmailC4L3;
    Button btn_EnviarFichaAnamneseC1L1, btn_EnviarFichaAnamneseC1L2, btn_EnviarFichaAnamneseC1L3;



 /*   public int getDecideEmail() {
        return decideEmail;
    } */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity9_encontre_profissional);

        btn_EnviarFichaAnamneseC1L1 = findViewById(R.id.btnEnviarFichaAnamneseC1L1TelaEncontreProfissional);
        btn_EnviarFichaAnamneseC1L2 = findViewById(R.id.btnEnviarFichaAnamneseC1L2TelaEncontreProfissional);
        btn_EnviarFichaAnamneseC1L3 = findViewById(R.id.btnEnviarFichaAnamneseC1L3TelaEncontreProfissional);

        txtvw_NomeC2L1 = findViewById(R.id.txtvwNomeC2L1TelaEncontreProfissional);
        txtvw_NomeC2L2 = findViewById(R.id.txtvwNomeC2L2TelaEncontreProfissional);
        txtvw_NomeC2L3 = findViewById(R.id.txtvwNomeC2L3TelaEncontreProfissional);

        txtvw_NumeroRegistroC3L1 = findViewById(R.id.txtvwNumeroRegistroC3L1TelaEncontreProfissional);
        txtvw_NumeroRegistroC3L2 = findViewById(R.id.txtvwNumeroRegistroC3L2TelaEncontreProfissional);
        txtvw_NumeroRegistroC3L3 = findViewById(R.id.txtvwNumeroRegistroC3L3TelaEncontreProfissional);

        txtvw_EmailC4L1 = findViewById(R.id.txtvwEmailC4L1TelaEncontreProfissional);
        txtvw_EmailC4L2 = findViewById(R.id.txtvwEmailC4L2TelaEncontreProfissional);
        txtvw_EmailC4L3 = findViewById(R.id.txtvwEmailC4L3TelaEncontreProfissional);




        imgbtn_Logoff = findViewById(R.id.imgbtnLogoffTelaEncontreProfissional);
        imgbtn_Logoff.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaEncontreProfissional);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaEncontreProfissional);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaEncontreProfissional);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaEncontreProfissional);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaEncontreProfissional);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaEncontreProfissional);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_Ajudame = findViewById(R.id.imgbtnAjudameTelaEncontreProfissional);
        imgbtn_Ajudame.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));

        try{
            BancoSQLite db = new BancoSQLite(this);
            Cursor cursor = db.fetch();
            cursor.moveToFirst();
            txtvw_NomeC2L1.setText(cursor.getString(3).toString());
            txtvw_NumeroRegistroC3L1.setText(cursor.getString(5).toString());
            txtvw_EmailC4L1.setText(cursor.getString(1).toString());
            cursor.moveToPosition(1);
            txtvw_NomeC2L2.setText(cursor.getString(3).toString());
            txtvw_NumeroRegistroC3L2.setText(cursor.getString(5).toString());
            txtvw_EmailC4L2.setText(cursor.getString(1).toString());
            cursor.moveToPosition(2);
            txtvw_NomeC2L3.setText(cursor.getString(3).toString());
            txtvw_NumeroRegistroC3L3.setText(cursor.getString(5).toString());
            txtvw_EmailC4L3.setText(cursor.getString(1).toString());

        } catch(Exception e){
            Toast.makeText(this, "Nem todos os profissionais estão cadastrados", Toast.LENGTH_SHORT).show();
        }

        BancoSQLite db = new BancoSQLite(this);







        btn_EnviarFichaAnamneseC1L1.setOnClickListener(view -> {

                FichaAnamnese ficha = db.selecionarFichaporId("1");
                Profissional profissa = db.selecionarProfissionalporID("1");
                Usuario usuario = db.selecionarUsuarioporID("1");
                Activity activity = Activity9EncontreProfissional.this;
                ShareCompat.IntentBuilder.from(activity)
                        .setType("message/rfc822")
                        .addEmailTo(profissa.getLoginEmail_profissionais())
                        .setText("\n" + "\n" + "1 - O que você está sentindo??" + "\n" + "\n" +ficha.getOquevoceestasentindo()  + "\n" + "\n" + "2 - Como começou??" + "\n" + "\n" + ficha.getComocomecou()
                                + "\n" + "\n" + "3 - Foi Repentino ou Gradual??" + "\n" + "\n"      + ficha.getFoirepentinoougradual() +  "\n" + "\n" + "4 - Quais Sintomas você está sentindo??" + "\n" + "\n" + ficha.getQuaissintomasvoceestasentindo()
                        + "\n" + "\n" + "Nome do Paciente :" + "\n" + usuario.getNome() + "\n" + "\n" + "Email do Paciente : " + "\n" + usuario.getLoginEmail())
                        .startChooser();



        } );



        btn_EnviarFichaAnamneseC1L2.setOnClickListener(view -> {
                FichaAnamnese ficha2 = db.selecionarFichaporId("2");
                Profissional profissa = db.selecionarProfissionalporID("2");
                Usuario usuario = db.selecionarUsuarioporID("2");
                Activity activity = Activity9EncontreProfissional.this;
                ShareCompat.IntentBuilder.from(activity)
                        .setType("message/rfc822")
                        .addEmailTo(profissa.getLoginEmail_profissionais())
                        .setText("\n" + "\n" + "1 - O que você está sentindo??" + "\n" + "\n" +ficha2.getOquevoceestasentindo()  + "\n" + "\n" + "2 - Como começou??" + "\n" + "\n" + ficha2.getComocomecou()
                                + "\n" + "\n" + "3 - Foi Repentino ou Gradual??" + "\n" + "\n"      + ficha2.getFoirepentinoougradual() +  "\n" + "\n" + "4 - Quais Sintomas você está sentindo??" + "\n" + "\n" + ficha2.getQuaissintomasvoceestasentindo()
                                + "\n" + "\n" + "Nome do Paciente :" + "\n" + usuario.getNome() + "\n" + "\n" + "Email do Paciente : " + "\n" + usuario.getLoginEmail())
                        .startChooser();


        });



        btn_EnviarFichaAnamneseC1L3.setOnClickListener(view -> {

                FichaAnamnese ficha3 = db.selecionarFichaporId("3");
                Profissional profissa = db.selecionarProfissionalporID("3");
                Usuario usuario = db.selecionarUsuarioporID("3");
                Activity activity = Activity9EncontreProfissional.this;
                ShareCompat.IntentBuilder.from(activity)
                        .setType("message/rfc822")
                        .addEmailTo(profissa.getLoginEmail_profissionais())
                        .setText("\n" + "\n" + "1 - O que você está sentindo??" + "\n" + "\n" +ficha3.getOquevoceestasentindo()  + "\n" + "\n" + "2 - Como começou??" + "\n" + "\n" + ficha3.getComocomecou()
                                + "\n" + "\n" + "3 - Foi Repentino ou Gradual??" + "\n" + "\n"      + ficha3.getFoirepentinoougradual() +  "\n" + "\n" + "4 - Quais Sintomas você está sentindo??" + "\n" + "\n" + ficha3.getQuaissintomasvoceestasentindo()
                                + "\n" + "\n" + "Nome do Paciente :" + "\n" + usuario.getNome() + "\n" + "\n" + "Email do Paciente : " + "\n" + usuario.getLoginEmail())
                        .startChooser();

        });










    }





    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);}



}