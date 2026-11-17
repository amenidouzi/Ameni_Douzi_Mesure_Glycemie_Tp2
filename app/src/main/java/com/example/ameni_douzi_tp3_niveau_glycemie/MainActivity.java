package com.example.ameni_douzi_tp3_niveau_glycemie;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ameni_douzi_mesure_glycemie.R;

public class MainActivity extends AppCompatActivity {

    private Button btnconsulter;
    private SeekBar sbAge;
    private RadioButton rboui, rbnon;
    private EditText etvaleur;
    private TextView tvAge;
    private TextView msg;
    private int age = 0;

    private void init() {
        btnconsulter = findViewById(R.id.btnconsulter);
        sbAge = findViewById(R.id.sbAge);
        rboui = findViewById(R.id.rbtoui);
        rbnon = findViewById(R.id.rbtnon);
        etvaleur = findViewById(R.id.etvaleur);
        tvAge = findViewById(R.id.tvAge);
        msg = findViewById(R.id.msg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        // Listener du SeekBar
        sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("information", "onProgressChanged() " + progress);
                age = progress;                                   // on mémorise l'âge
                tvAge.setText("Votre âge : " + progress + " ans");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        // Listener explicite du bouton CONSULTER (dans onCreate)
        btnconsulter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                consulterGlycemie();                              // appel de la méthode
            }
        });
    }

    private void consulterGlycemie() {
        String valeurString = etvaleur.getText().toString().trim();
        if (valeurString.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer la valeur mesurée", Toast.LENGTH_SHORT).show();
            return;
        }

        double valeur = Double.parseDouble(valeurString);
        boolean aJeun = rboui.isChecked();
        double min, max;
        String resultat;

        if (aJeun) {
            if (age >= 13) {
                min = 5.0;
                max = 7.2;
            } else if (age >= 6) {
                min = 5.0;
                max = 10.0;
            } else {
                min = 5.5;
                max = 10.0;
            }
        } else {
            min = 5.0;
            max = 10.5;
        }

        if (valeur < min) {
            resultat = "La valeur de glycémie est trop basse";
        } else if (valeur > max) {
            resultat = "La valeur de glycémie est trop élevée";
        } else {
            resultat = "La valeur de glycémie est normale";
        }

        msg.setText(resultat);                                    // affichage du résultat
    }
}