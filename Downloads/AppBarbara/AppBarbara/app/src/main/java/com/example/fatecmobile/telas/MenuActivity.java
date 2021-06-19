package com.example.fatecmobile.telas;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
//import android.support.*;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.fatecmobile.R;
import com.example.fatecmobile.modelos.UsuarioBean;
import com.example.fatecmobile.telas.restaurante.AddRestauranteActivity;
import com.example.fatecmobile.telas.restaurante.ListRestauranteActivity;
import com.example.fatecmobile.telas.restaurante.ListRestauranteParamActivity;
import com.example.fatecmobile.telas.usuario.AddUsuActivity;
import com.example.fatecmobile.telas.usuario.ListUsuActivity;
import com.example.fatecmobile.telas.usuario.ListUsuParamActivity;

public class MenuActivity extends AppCompatActivity {

    Button addUsu, addTer, listUsu, listTer, listUsuPar, listTerPar;
    TextView textUsuLogado;
    UsuarioBean usuLogado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Intent it = getIntent();
        usuLogado = (UsuarioBean) it.getSerializableExtra("UsuarioLogado");
        listUsu = (Button) findViewById(R.id.btlistusu);
        textUsuLogado = (TextView) findViewById(R.id.lbUsuLogado);
        textUsuLogado.setText(usuLogado.getLogin());
        listUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuActivity.class);
                startActivity(it);
            }
        });

        listUsuPar = (Button) findViewById(R.id.btlistusuParam);
        listUsuPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListUsuParamActivity.class);
                startActivity(it);
            }
        });

        addUsu = (Button) findViewById(R.id.btnovousu);
        addUsu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddUsuActivity.class);
                startActivity(it);
            }
        });

        //terceiros
        listTer = (Button) findViewById(R.id.btlistres);
        listTer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListRestauranteActivity.class);
                startActivity(it);
            }
        });

        listTerPar = (Button) findViewById(R.id.btlistParamRestaurantes);
        listTerPar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, ListRestauranteParamActivity.class);
                startActivity(it);
            }
        });

        addTer = (Button) findViewById(R.id.btnovores);
        addTer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(MenuActivity.this, AddRestauranteActivity.class);
                startActivity(it);
            }
        });
    }

}
