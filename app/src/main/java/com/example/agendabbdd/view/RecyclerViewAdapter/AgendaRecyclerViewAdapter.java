package com.example.agendabbdd.view.RecyclerViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agendabbdd.R;
import com.example.agendabbdd.model.entity.Agenda;
import com.example.agendabbdd.viewModel.AgendaViewModel;

import java.util.List;

public class AgendaRecyclerViewAdapter extends  RecyclerView.Adapter<AgendaRecyclerViewAdapter.ViewHolder>{

    List<Agenda> listaContactos;
    Context contexto;
    private AgendaViewModel viewModel;

    public AgendaRecyclerViewAdapter(List<Agenda> list, Context context) {

        this.listaContactos = list;
        contexto = context;
        viewModel = new ViewModelProvider((ViewModelStoreOwner) context).get(AgendaViewModel.class);

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvContacto.setText(listaContactos.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvContacto;
        ConstraintLayout parent_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvContacto = itemView.findViewById(R.id.textView);
            parent_layout = itemView.findViewById(R.id.LinearLayout);
        }
    }
}
