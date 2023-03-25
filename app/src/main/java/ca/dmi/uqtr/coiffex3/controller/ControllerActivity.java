package ca.dmi.uqtr.coiffex3.controller;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import ca.dmi.uqtr.coiffex3.screen.MainActivity;

public class ControllerActivity extends AppCompatActivity {

        public void openConnexion() {
                Intent Connexion = new Intent(this, ca.dmi.uqtr.coiffex3.screen.Connexion.class);
                startActivity(Connexion);
        }
        public void openInscription() {
                Intent Inscription = new Intent(this, ca.dmi.uqtr.coiffex3.screen.Inscription.class);
                startActivity(Inscription);
        }
        public void openAccueil() {
                Intent Accueil = new Intent(this, MainActivity.class);
                startActivity(Accueil);
        }
}

