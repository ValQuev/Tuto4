package fr.valquev.tuto4;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity implements OnItemClick {

    private List<Personne> personnes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);

        personnes = new ArrayList<>();

        personnes.add(new Personne("Durand Michel", 76));
        personnes.add(new Personne("Dupont Jeannine", 54));
        personnes.add(new Personne("Dutunnel Georges", 47));
        personnes.add(new Personne("Dufour Bastien", 34));
        personnes.add(new Personne("Dumicroonde Charlotte", 23));
        personnes.add(new Personne("Ducon François", 37));
        personnes.add(new Personne("Dupuis Jean", 64));

        recyclerView.setAdapter(new MyAdapter(personnes, this));
    }

    @Override
    public void onClick(int position) {
        Personne personne = personnes.get(position);
        Toast.makeText(getApplicationContext(), "Clic normal : " + personne.getNomPrenom() + " a " + personne.getAge() + " ans", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLongClick(int position) {
        Personne personne = personnes.get(position);
        Toast.makeText(getApplicationContext(), "Clic long : " + personne.getNomPrenom() + " a " + personne.getAge() + " ans", Toast.LENGTH_LONG).show();
    }
}
