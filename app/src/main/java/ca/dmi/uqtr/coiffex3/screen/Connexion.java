package ca.dmi.uqtr.coiffex3.screen;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import ca.dmi.uqtr.coiffex3.R;
import ca.dmi.uqtr.coiffex3.controller.ControllerActivity;
import ca.dmi.uqtr.coiffex3.db.DBHelper;

public class Connexion extends AppCompatActivity {

    EditText mail, pass;
    Button login;
    TextView enregistrer;

    Cursor cursor;
    CheckBox show;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();

        enregistrer = (TextView) findViewById(R.id.text_register);

        mail = (EditText) findViewById(R.id.edit_mail);
        pass = (EditText) findViewById(R.id.edit_mot_de_pas);
        show = (CheckBox) findViewById(R.id.showPass);

        login = (Button)findViewById(R.id.buttonLogin);
        showPass();

        enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Connexion.this, Inscription.class);
                startActivity(intent);
                finish();
            }
        });



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cursor = db.rawQuery("SELECT * FROM " + DBHelper.USER_TABLE + " WHERE "
                                + DBHelper.COLUMN_MAIL + " =? AND " + DBHelper.COLUMN_PASSWORD + " =?",
                        new String[]{mail.getText().toString(), pass.getText().toString()});

                if(mail.getText().toString().equals("")||
                        pass.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Username and Password can't be empty", Toast.LENGTH_LONG).show();
                    return;
                }

                if (cursor != null) {
                    if (cursor.getCount() > 0) {
                        cursor.moveToFirst();

                        Toast.makeText(Connexion.this, "Logged In succesfully!",
                                Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Connexion.this, AcceuilClient.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Connexion.this, "Invalid username or password!",
                                Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

    }

    public void showPass(){
        show.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }


    public void onBackPressed()
    {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No", null).show();
    }
}