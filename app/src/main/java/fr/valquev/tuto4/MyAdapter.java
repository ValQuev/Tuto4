package fr.valquev.tuto4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Personne> personnes;
    private OnItemClick callback;

    public MyAdapter(List<Personne> personnes, Context context) {
        this.personnes = personnes;
        this.callback = (OnItemClick) context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {
        Personne personne = personnes.get(position);

        myViewHolder.nom.setText(personne.getNomPrenom());
        myViewHolder.age.setText(personne.getAge() + " ans");

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onClick(position);
            }
        });

        myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                callback.onLongClick(position);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return personnes.size();
    }

    protected class MyViewHolder extends RecyclerView.ViewHolder {

        protected TextView nom;
        protected TextView age;

        public MyViewHolder(View itemView) {
            super(itemView);

            nom = (TextView) itemView.findViewById(R.id.nom);
            age = (TextView) itemView.findViewById(R.id.age);
        }

    }
}
