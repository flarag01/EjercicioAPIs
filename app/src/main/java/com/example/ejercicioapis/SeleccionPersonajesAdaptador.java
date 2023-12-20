package com.example.ejercicioapis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SeleccionPersonajesAdaptador extends RecyclerView.Adapter<SeleccionPersonajesAdaptador.ViewHolder>{

    List<Personaje> itemList = new ArrayList<>();
    RecyclerView rvPersonajes;

    public SeleccionPersonajesAdaptador(List<Personaje> itemList, RecyclerView rvPersonajes) {
        this.itemList = itemList;
        this.rvPersonajes = rvPersonajes;
    }

    @NonNull
    @Override
    public SeleccionPersonajesAdaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seleccion_personajes_item ,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SeleccionPersonajesAdaptador.ViewHolder holder, int position) {
        Personaje personaje = itemList.get(position);
        holder.txtNombre.setText(personaje.getNombre());
        holder.txtGenero.setText("Genero: "+personaje.getGenero());
        holder.txtNacimiento.setText("Nacimiento: "+personaje.getNacimiento());
        holder.txtAltura.setText("Altura: "+personaje.getAltura());
        holder.txtPeso.setText("Peso: "+personaje.getPeso());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtGenero;
        TextView txtNacimiento;
        TextView txtAltura;
        TextView txtPeso;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtGenero = itemView.findViewById(R.id.txtGenero);
            txtNacimiento = itemView.findViewById(R.id.txtNacimiento);
            txtAltura = itemView.findViewById(R.id.txtAltura);
            txtPeso = itemView.findViewById(R.id.txtPeso);
        }
    }
}
