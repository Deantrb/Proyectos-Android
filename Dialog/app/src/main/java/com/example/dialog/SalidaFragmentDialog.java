package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;


import androidx.fragment.app.DialogFragment;

// Para usar el com.example.dialog.SalidaFragmentDialog:
// new com.example.dialog.SalidaFragmentDialog(parametros).show(getSupportFragmentManager(), "SimpleDialog");

public class SalidaFragmentDialog extends DialogFragment {

    private String titulo, mensaje,textoBotonPositivo, textoBotonNegativo;

    public SalidaFragmentDialog(String titulo,String mensaje,String textoBotonPositivo,String textoBotonNegativo) {
        this.titulo=titulo;
        this.mensaje=mensaje;
        this.textoBotonPositivo=textoBotonPositivo;
        this.textoBotonNegativo=textoBotonNegativo;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(mensaje)
                .setTitle(titulo)
                .setPositiveButton(textoBotonPositivo, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        getActivity().finish();
                    }
                })
                .setNegativeButton(textoBotonNegativo, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
