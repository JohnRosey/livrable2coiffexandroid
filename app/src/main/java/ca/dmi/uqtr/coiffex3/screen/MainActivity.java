package ca.dmi.uqtr.coiffex3.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

import ca.dmi.uqtr.coiffex3.R;
import ca.dmi.uqtr.coiffex3.db.DBHelper;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper dbHelper = new DBHelper(this);

        //add data to database
        dbHelper.addUser("admin","admin","admin","admin","admin","admin");
        dbHelper.addUser("user","user","user","user","user","user");

        Button boutonStart = (Button) findViewById(R.id.button_initial);
        boutonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConnexionActivity();
            }
        });
    }

    private void ConnexionActivity() {
        Intent Connexion = new Intent(this,Connexion.class);
        startActivity(Connexion);
    }
}
