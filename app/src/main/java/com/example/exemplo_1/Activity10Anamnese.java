package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.exemplo_1.database.BancoSQLite;
import com.example.exemplo_1.modelos.FichaAnamnese;
import com.example.exemplo_1.modelos.Profissional;

public class Activity10Anamnese extends AppCompatActivity {

    ImageButton imgbtn_Ajudame,imgbtn_Livros,imgbtn_VoltarpTelaInicial,imgbtn_Playlists,
            imgbtn_Exercicios,imgbtn_EncontreProfissional, imgbtn_Cadastrese,imgbtn_EnviarFichaAnamnese,
            imgbtn_Logoff;

    EditText edttxt_CampoOquevoceestasentindo, edttxt_CampoComocomecou, edttxt_CampoFoirepentinoougradual,
    edttxt_CampoQuaissintomasvoceestasentindo;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity10_anamnese);



        imgbtn_Logoff = findViewById(R.id.imgbtnLogoffTelaAnamnese);
        imgbtn_Logoff.setOnClickListener(evt -> proximaTela(MainActivity.class));

        edttxt_CampoOquevoceestasentindo = findViewById(R.id.edttxtcampoOquevoceestasentindoTelaFichaAnamnese);
        edttxt_CampoComocomecou = findViewById(R.id.edttxtCampoComocomecouTelaFichaAnamnese);
        edttxt_CampoFoirepentinoougradual = findViewById(R.id.edttxtCampoFoirepetinoougradualTelaFichaAnamnese);
        edttxt_CampoQuaissintomasvoceestasentindo = findViewById(R.id.edttxtCampoQuaissintomasVoceestasentindoTelaFichaAnamnese);

        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaFichaAnamnese);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaFichaAnamnese);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaFichaAnamnese);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaFichaAnamnese);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaFichaAnamnese);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaFichaAnamnese);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_Ajudame = findViewById(R.id.imgbtnAjudameTelaFichaAnamnese);
        imgbtn_Ajudame.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));

        imgbtn_EnviarFichaAnamnese = findViewById(R.id.imgbtnEnviarFichaAnamneseTelaFichaAnamnese);
        imgbtn_EnviarFichaAnamnese.setOnClickListener(evt -> proximaTela(Activity9EncontreProfissional.class));


        imgbtn_EnviarFichaAnamnese.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);
            if (edttxt_CampoFoirepentinoougradual.getText().toString().isEmpty() || edttxt_CampoComocomecou.getText().toString().isEmpty()
                    || edttxt_CampoOquevoceestasentindo.getText().toString().isEmpty() || edttxt_CampoQuaissintomasvoceestasentindo.getText().toString().isEmpty()
            ) {
                Toast.makeText(this, "Digite todos os campos", Toast.LENGTH_SHORT).show();
            } else {
                if (db.inserirFicha(new FichaAnamnese(
                        edttxt_CampoOquevoceestasentindo.getText().toString(),
                        edttxt_CampoComocomecou.getText().toString(),
                        edttxt_CampoFoirepentinoougradual.getText().toString(),
                        edttxt_CampoQuaissintomasvoceestasentindo.getText().toString()
                ))) {
                    Toast.makeText(this, "Ficha cadastrada com sucesso", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, Activity9EncontreProfissional.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Não foi possivel realizar o cadastro", Toast.LENGTH_SHORT).show();
                }
            }



        });






   /*         Intent emailIntent = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:" + email));
            emailIntent.setType("text/plain");
          //  emailIntent.setData("mailto:" + email)
            emailIntent.putExtra(Intent.EXTRA_TEXT,  "\n" + "\n" + "1 - O que você está sentindo??" + "\n" + "\n" +
                    edttxt_CampoOquevoceestasentindo.getText().toString()
                    + "\n" + "\n" + "2 - Como começou??" + "\n" + "\n" + edttxt_CampoComocomecou.getText().toString() + "\n" + "\n" +
                    "3 - Foi repentino ou gradual??" + "\n" +"\n" + edttxt_CampoFoirepentinoougradual.getText().toString() + "\n" + "\n" +
                    "4 - Quais sintomas você está sentindo??" + "\n" + "\n" +
                    edttxt_CampoQuaissintomasvoceestasentindo.getText().toString() + "\n");

            try {
                startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                finish();
            } catch(android.content.ActivityNotFoundException ex){
                Toast.makeText(this, "Não há cliente de email instalado", Toast.LENGTH_SHORT).show();
            }

*/
  /*      BancoSQLite db = new BancoSQLite(this);
        Cursor cursor = db.fetch();
        cursor.moveToFirst();
        if(cursor!= null){
            cursor.moveToNext();
        }
        if(botaoouNao == 1){
            cursor.moveToPosition(0);
        }
        else if(botaoouNao == 2){
            cursor.moveToPosition(1);
        }
        else if(botaoouNao == 3){
            cursor.moveToPosition(2);
        }
        cursor.getString(1).toString()



         */

   /*     imgbtn_EnviarFichaAnamnese.setOnClickListener(view -> {


            */

    }
    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);}
}