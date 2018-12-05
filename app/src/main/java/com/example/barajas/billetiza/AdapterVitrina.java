package com.example.barajas.billetiza;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

public class AdapterVitrina extends RecyclerView.Adapter<AdapterVitrina.ViewHolderVitrina> {

    ArrayList<String> ListVitrina;

    public AdapterVitrina(ArrayList<String> listVitrina) {
        ListVitrina = listVitrina;
    }


    @Override
    public ViewHolderVitrina onCreateViewHolder( ViewGroup viewGroup, int i) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlist,null,false);
        return new ViewHolderVitrina(view);


    }

    @Override
    public void onBindViewHolder( ViewHolderVitrina holder, int i) {
        holder.asignarVitrina(ListVitrina.get(i));

    }

    @Override
    public int getItemCount() {

        return ListVitrina.size();
    }

    public class ViewHolderVitrina extends RecyclerView.ViewHolder {
        TextView dato;

        public ViewHolderVitrina( View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.RecyclerVitrina);
        }

        public void asignarVitrina(String datos) {
            dato.setText(datos);
        }
    }
    }

