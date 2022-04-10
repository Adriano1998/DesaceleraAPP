package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.exemplo_1.database.BancoSQLite;
import com.example.exemplo_1.modelos.Profissional;
import com.example.exemplo_1.modelos.Usuario;

public class Activity6Login extends AppCompatActivity {

    ImageButton imgbtn_Ajudame, imgbtn_Livros, imgbtn_VoltarpTelaInicial,
            imgbtn_Playlists, imgbtn_Exercicios, imgbtn_EncontreProfissional,
            imgbtn_Cadastrese, imgbtn_EntrarLogin;
    TextView txtvw_LinkEsquecisenha;
    EditText edttxt_PreencherEmail, edttxt_PreencherSenha;
    CheckBox chckbx_VoceePaciente;
    int usuarioounao;
//    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity6_login);

        edttxt_PreencherEmail = findViewById(R.id.edttxtPreencherEmailTelaLogin);
        edttxt_PreencherSenha = findViewById(R.id.edttxtPreencherSenhaTelaLogin);


        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaLogin);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaLogin);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaLogin);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaLogin);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaLogin);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaLogin);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_Ajudame = findViewById(R.id.imgbtnAjudameTelaLogin);
        imgbtn_Ajudame.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));

        imgbtn_EntrarLogin = findViewById(R.id.imgbtnEntrarLoginTelaLogin);

        txtvw_LinkEsquecisenha = findViewById(R.id.txtvwLinkEsqueciSenhaTelaLogin);
        txtvw_LinkEsquecisenha.setOnClickListener(evt -> proximaTela(Activity12EsqueciSenha.class));

        chckbx_VoceePaciente = findViewById(R.id.chckbxVoceePacienteTelaLogin);

        chckbx_VoceePaciente.setOnClickListener(view->{
            if(chckbx_VoceePaciente.isChecked()){
               usuarioounao = 1;
            }
            else {
                usuarioounao = 0;
            }
        });





        imgbtn_EntrarLogin.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);
            if(edttxt_PreencherEmail.getText().toString().isEmpty() || edttxt_PreencherSenha.getText().toString().isEmpty()){
                Toast.makeText(this, "Digite todos os campos", Toast.LENGTH_SHORT).show();
            }

            else {
                if (usuarioounao == 1) {
                    try {
                        //   Profissional profissional = db.selecionarProfissional(edttxt_PreencherEmail.getText().toString());
                        Usuario usuario = db.selecionarUsuario(edttxt_PreencherEmail.getText().toString());

                        if (usuario.getSenha().equals(edttxt_PreencherSenha.getText().toString())) {
                            Intent intent = new Intent(this, Activity10Anamnese.class);
                            startActivity(intent);
                            Toast.makeText(this, "Usuario logado", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(this, "Usuario não encontrado", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(this, "Usuario nãoo cadastrado", Toast.LENGTH_SHORT).show();
                    }
                } else {


                    try {
                        Profissional profissional = db.selecionarProfissional(edttxt_PreencherEmail.getText().toString());

                        if (profissional.getSenha_profissionais().equals(edttxt_PreencherSenha.getText().toString())) {
                            Toast.makeText(this, "Bem vindo, Profissional!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(this, "Profissional não encontrado", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(this, "Profissional nãoo cadastrado", Toast.LENGTH_SHORT).show();
                    }
                }
                }
            });






    }
    // imgbtn_EntrarLogin.setOnClickListener(evt -> proximaTela(Activity10Anamnese.class));


    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);
    }
}




















