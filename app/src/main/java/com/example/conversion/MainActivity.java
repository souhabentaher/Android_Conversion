package com.example.conversion;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import static com.example.conversion.R.id.buttonConversion;

public class MainActivity extends AppCompatActivity {

    private Button bConversion;
    private EditText monnaie ;
    private RadioButton radioButton01;
    private RadioButton radioButton02 ;
    private TextView resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.monnaie = (EditText) this.findViewById(R.id.monnaie);
        this.radioButton01 = (RadioButton) this.findViewById(R.id.radioButton01);
        this.radioButton02 = (RadioButton) this.findViewById(R.id.radioButton02);
        this.bConversion= (Button) this.findViewById(buttonConversion);
        this.resultat= (TextView) this.findViewById(R.id.resultat);
        bConversion.setOnClickListener(new View.OnClickListener(){

            @Override

            public void onClick(View view){
            }
                public void conertir(){
            if(TextUtils.isEmpty(monnaie.getText().toString())){
            Snackbar.make(findViewById(R.id.monnaie), "Veuillez saisir une somme", Snackbar.LENGTH_LONG)
                    .setAction("Retry", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                        }
                    })
                  .show();
            }else {
                float valeurInitiale=Float.valueOf(monnaie.getText().toString());
                float resultat;
                if (radioButton01.isChecked()){
                    resultat= radioButton01(valeurInitiale);
                }else{
                    resultat=radioButton02(valeurInitiale);
        }
                monnaie.setText(String.valueOf(resultat));
        }

    }
    public float radioButton01(float valeurEuro){ return (float)(valeurEuro * 3.24); }
    public float radioButton02(float valeurDinar){ return (float)(valeurDinar * 0.31); }

            public void onCreatContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        }

    });
}
}




