package ca.dmi.uqtr.coiffex3.screen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import ca.dmi.uqtr.coiffex3.ModeleAdapter;
import ca.dmi.uqtr.coiffex3.R;
import ca.dmi.uqtr.coiffex3.modele.Modele;

public class AcceuilClient extends AppCompatActivity {


    private RecyclerView myRecyclerView;
    private ModeleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_client);
        setContentView(R.layout.activity_accueil_client);
        myRecyclerView = findViewById(R.id.my_list);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager( this,
                        LinearLayoutManager.VERTICAL,
                        false);
        GridLayoutManager glm = new GridLayoutManager(this, 1);
        myRecyclerView.setLayoutManager(glm);
        adapter = new ModeleAdapter(this);
        myRecyclerView.setAdapter(adapter);

        initModele();

    }

    private void initModele(){
        adapter.addItem(new Modele("Knowless",50, "1"));
        adapter.addItem(new Modele("Passion twist",40, "2"));
        adapter.addItem(new Modele("Locs",100, "3"));
        adapter.addItem(new Modele("Braids",70, "4"));
        adapter.addItem(new Modele("Dreads",90, "5"));
        adapter.addItem(new Modele("Nattes collées",200, "6"));
        adapter.addItem(new Modele("Vanilles",150, "7"));
        adapter.addItem(new Modele("Chignon",80, "8"));
        adapter.addItem(new Modele("Perruques",70, "9"));
        adapter.addItem(new Modele("Goddess Braids",60, "10"));




    }
}