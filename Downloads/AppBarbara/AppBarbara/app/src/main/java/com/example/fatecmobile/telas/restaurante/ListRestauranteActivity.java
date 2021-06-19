package com.example.fatecmobile.telas.restaurante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerRestaurante;
import com.example.fatecmobile.modelos.RestauranteBean;

import java.util.List;

public class ListRestauranteActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeAlunos;
    List<RestauranteBean> restaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurante);
        final ControllerRestaurante ge = new ControllerRestaurante(getBaseContext());
        ListaDeAlunos = (ListView) findViewById(R.id.listares);
        restaurantes = ge.listarRestaurantes();
        ArrayAdapter<RestauranteBean> adapter = new ArrayAdapter<RestauranteBean>(this,android.R.layout.simple_list_item_1,restaurantes);
        ListaDeAlunos.setAdapter(adapter);
        ListaDeAlunos.setOnItemClickListener(this); // Clique no item
        ListaDeAlunos.setOnItemLongClickListener(this); // Pressão sobre o item
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        RestauranteBean res = (RestauranteBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListRestauranteActivity.this, UptRestauranteActivity.class);
        it.putExtra("Restaurante",res);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + res.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        RestauranteBean res = (RestauranteBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListRestauranteActivity.this, UptRestauranteActivity.class);
        it.putExtra("Restaurante",res);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + res.getId(),Toast.LENGTH_LONG).show();
    }
}
