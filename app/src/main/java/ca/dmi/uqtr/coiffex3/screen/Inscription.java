package ca.dmi.uqtr.coiffex3.screen;

import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.ImageView;
import android.widget.Toast;

import ca.dmi.uqtr.coiffex3.R;
import ca.dmi.uqtr.coiffex3.db.DBHelper;

public class Inscription extends AppCompatActivity {
    EditText nom, prenom,numero,mail, pass, cnfrmpass;
    Button signup;
    ImageView rback;
    Cursor cursor;
    SQLiteDatabase db;
    CheckBox rshow;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        dbHelper = new DBHelper(this);

        nom = (EditText) findViewById(R.id.edit_nom);
        pass = (EditText) findViewById(R.id.edit_password);
        cnfrmpass = (EditText) findViewById(R.id.edit_confirmation_password);
        prenom = (EditText) findViewById(R.id.edit_prenom);
        numero = (EditText) findViewById(R.id.edit_number);
        mail = (EditText) findViewById(R.id.edit_email);
        rshow = (CheckBox) findViewById(R.id.rshowPass);
        signup = (Button) findViewById(R.id.button_singup);
        rback = (ImageView) findViewById(R.id.rback);

        showPass();


        rback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Inscription.this, Connexion.class);
                startActivity(intent);
                finish();
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signupBtn(v);
            }
        });
    }

    public void signupBtn(View view) {

        if(nom.getText().toString().equals("")||
                mail.getText().toString().equals("")||
                pass.getText().toString().equals("")||cnfrmpass.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Please Enter Your Details", Toast.LENGTH_LONG).show();
            return;
        }
//check if mail is valid
        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(mail.getText().toString()).matches())
        {
            Toast.makeText(getApplicationContext(), "Please Enter Valid Email", Toast.LENGTH_LONG).show();
            return;
        }
        // check if both password matches
        if(!pass.getText().toString().equals(cnfrmpass.getText().toString()))
        {
            Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
        }



        else {
            dbHelper.addUser(nom.getText().toString(),
                    prenom.getText().toString(), numero.getText().toString(), mail.getText().toString(),
                     pass.getText().toString(),
                    cnfrmpass.getText().toString());

            Toast.makeText(Inscription.this, "Data Inserted", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(Inscription.this, Connexion.class);
            startActivity(intent);
        }

    }

//use signupBtn(View view) method to insert data into database when user click on signup button

    public void showPass(){
        rshow.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    pass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    cnfrmpass.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                } else {
                    pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    cnfrmpass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    public void onBackPressed()
    {
        Intent intent = new Intent(Inscription.this, Connexion.class);
        startActivity(intent);
        finish();
    }
}
