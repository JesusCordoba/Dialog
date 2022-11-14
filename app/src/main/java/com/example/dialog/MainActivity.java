package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Dialogo.DialogListener{
    Button btn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Crear dialog
                DialogFragment dialog = new Dialogo();
                dialog.show(getSupportFragmentManager(), "Dialog");
            }
        });

    }

    // Metodo onclick boton positivo dialogo
    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        txt.setText("Start");
    }

    // Metodo onclick boton negativo dialogo
    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        txt.setText("Cancel");
    }
}