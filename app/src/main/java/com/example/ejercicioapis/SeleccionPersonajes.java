package com.example.ejercicioapis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SeleccionPersonajes extends AppCompatActivity {

    List<Personaje> itemList = new ArrayList<>();
    RecyclerView rvPersonajes;
    SeleccionPersonajesAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_personajes);

        rvPersonajes = findViewById(R.id.rvPersonajes);
        rvPersonajes.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new SeleccionPersonajesAdaptador(itemList, rvPersonajes);
        rvPersonajes.setAdapter(adaptador);

        RequestQueue cola = Volley.newRequestQueue(this);

        JsonObjectRequest peticion = new JsonObjectRequest(
                Request.Method.GET,
                "https://swapi.dev/api/people/?format=json",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            // Obtener el array de personajes
                            JSONArray results = response.getJSONArray("results");

                            // Iterar a través de los personajes y agregarlos a itemList
                            for (int i = 0; i < results.length(); i++) {
                                JSONObject personajeJson = results.getJSONObject(i);
                                Personaje personaje = new Personaje(
                                        personajeJson.getString("name"),
                                        personajeJson.getString("gender"),
                                        personajeJson.getString("birth_year"),
                                        personajeJson.getString("height"),
                                        personajeJson.getString("mass")
                                );
                                itemList.add(personaje);
                            }

                            // Notificar al adaptador que los datos han cambiado
                            adaptador.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("VolleyError", "Error en la solicitud", error);
                Toast.makeText(SeleccionPersonajes.this, "Error en la solicitud", Toast.LENGTH_SHORT).show();
            }
        });

        // Agregar la solicitud a la cola
        cola.add(peticion);
    }
}
