package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.exemplo_1.database.BancoSQLite;
import com.example.exemplo_1.modelos.Profissional;
import com.example.exemplo_1.modelos.Usuario;

public class Activity8Profissional extends AppCompatActivity {

    ImageButton imgbtn_Ajudame, imgbtn_Livros, imgbtn_VoltarpTelaInicial, imgbtn_Playlists,
            imgbtn_Exercicios, imgbtn_EncontreProfissional, imgbtn_Cadastrese, imgbtn_CrieSeuCadastro;

    EditText edttxt_CampoNome, edttxt_CampoSobrenome, edttxt_CampoEmail, edttxt_CampoNumeroRegistro,
            edttxt_CampoDataNascimento, edttxt_CampoSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity8_profissional);

        edttxt_CampoNome = findViewById(R.id.edttxtCampoNomeTelaCadastroProfissional);
        edttxt_CampoSobrenome = findViewById(R.id.edttxtCampoSobrenomeTelaCadastroProfissional);
        edttxt_CampoEmail = findViewById(R.id.edttxtCampoEmailTelaCadastroProfissional);
        edttxt_CampoNumeroRegistro = findViewById(R.id.edttxtCampoNumeroRegistroTelaCadastroProfissional);
        edttxt_CampoDataNascimento = findViewById(R.id.edttxtCampoDataNascimentoTelaCadastroProfissional);
        edttxt_CampoSenha = findViewById(R.id.edttxtCampoSenhaTelaCadastroProfissional);

        imgbtn_CrieSeuCadastro = findViewById(R.id.imgbtnCrieSeuCadastroTelaCadastroProfissional);
        imgbtn_CrieSeuCadastro.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaCadastroProfissional);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaCadastroProfissional);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaCadastroProfissional);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaCadastroProfissional);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaCadastroProfissional);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaCadastroProfissional);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_Ajudame = findViewById(R.id.imgbtnAjudameTelaCadastroProfissional);
        imgbtn_Ajudame.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));


 /*       imgbtn_CrieSeuCadastro.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              DBHelper dbHelper = new DBHelper(Activity8Profissional.this);
              dbHelper.addProfissional(edttxt_CampoNome.getText().toString().trim(),
                      edttxt_CampoSobrenome.getText().toString().trim(),
                      edttxt_CampoEmail.getText().toString().trim(),
                      Integer.valueOf(edttxt_CampoNumeroRegistro.getText().toString().trim()),
                      Integer.valueOf(edttxt_CampoDataNascimento.getText().toString().trim()),
                      edttxt_CampoSenha.getText().toString().trim());
          }
      }
    ); */
        imgbtn_CrieSeuCadastro.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);

            if(edttxt_CampoNome.getText().toString().isEmpty() || edttxt_CampoSobrenome.getText().toString().isEmpty()
            || edttxt_CampoDataNascimento.getText().toString().isEmpty() || edttxt_CampoNumeroRegistro.getText().toString().isEmpty()
            || edttxt_CampoSenha.getText().toString().isEmpty() || edttxt_CampoEmail.getText().toString().isEmpty()
            ){
                Toast.makeText(this, "Digite todos os campos", Toast.LENGTH_SHORT).show();
            }

            else {

            if(db.inserirProfissional(new Profissional(
                    edttxt_CampoNome.getText().toString(),
                    edttxt_CampoSobrenome.getText().toString(),
                    edttxt_CampoEmail.getText().toString(),
                    edttxt_CampoNumeroRegistro.getText().toString(),
                    edttxt_CampoDataNascimento.getText().toString(),
                    edttxt_CampoSenha.getText().toString()
            ))){
                Toast.makeText(this, "Profissional cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Não foi possivel realizar o cadastro", Toast.LENGTH_SHORT).show();
            }
                }


});
    }

    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);
    }


}