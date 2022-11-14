package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

public class Dialogo extends DialogFragment {

    // Metodos a implementar
    public interface DialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Instanciamos el listener que vamos a usar
    DialogListener listener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (DialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(getActivity().toString()
                    + " must implement NoticeDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Creamos el Alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_start_game) // Titulo del dialog
                .setPositiveButton(R.string.start, new DialogInterface.OnClickListener() { // Crear boton positivo
                    public void onClick(DialogInterface dialog, int id) {
                        // Mandar el evento del boton positivo a la actividad que lo implementara
                        listener.onDialogPositiveClick(Dialogo.this);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // Crear boton negativo
                    public void onClick(DialogInterface dialog, int id) {
                        // Mandar el evento del boton negativo a la actividad que lo implementara
                        listener.onDialogNegativeClick(Dialogo.this);
                    }
                });
        return builder.create();
    }

}
