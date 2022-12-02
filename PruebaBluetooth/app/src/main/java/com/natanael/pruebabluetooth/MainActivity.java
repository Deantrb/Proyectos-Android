package com.natanael.pruebabluetooth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

public class MainActivity extends Activity {
    private static final int REQUEST_ENABLE_BT = 1;
    private BluetoothAdapter btAdapter = null;
    private BluetoothSocket btSocket = null;
    private OutputStream outStream = null;
    private InputStream inStream = null;
    private boolean amarillo, rojo, verde;
    // Identificador único universal para el dispositivo bluetooth donde corre esta aplicación
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    // Dirección MAC del dispositivo remoto
    private static String address = "0C:DC:7E:5E:94:62";
    Button btn;
    TextView tv1;
    ImageView iv;
    // Se invoca este método al crear la actividad, creando la vista así como la creación y verificación
    // de estado del adaptador bluetooth
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 =  findViewById(R.id.textView);
        amarillo = rojo = verde = false;

        btn= findViewById(R.id.button);

        iv= findViewById(R.id.imageView);

        // Se obtiene adaptador BT
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        // Verifica estado del adaptador BT
        checkBTState();
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=1;i<=10;i++)
                {

                    sendDataWithoutResponse(65);
                    sendDataWithoutResponse(82);
                    sendDataWithoutResponse(86);

                    try{
                        Thread.sleep(300);
                    }catch (Exception e){}

                    sendDataWithoutResponse(97);
                    sendDataWithoutResponse(118);
                    sendDataWithoutResponse(114);

                    try{
                        Thread.sleep(100);
                    }catch (Exception e){}
                }
            }
        });
        iv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!amarillo) {
                    sendDataWithoutResponse(65);
                    iv.setImageResource(R.drawable.swit);
                    amarillo=true;
                }else{
                    sendDataWithoutResponse(97);
                    iv.setImageResource(R.drawable.swit2);
                    amarillo=false;
                }
            }
        });
    }

    // Se invoca este método cuando la aplicación está a punto de hacerse visible para el usuario


    @SuppressLint("MissingPermission")
    @Override
    public void onResume() {
        super.onResume();
        // Se obtiene dispositivo Bluetooth
        BluetoothDevice device = btAdapter.getRemoteDevice(address);

        try {
            // Se obtiene socket
            btSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e) {
            errorExit("Error fatal", "En onResume() falla al crear socket: " + e.getMessage() + ".");
        }

        // Se cancela la función de descubrimiento
        btAdapter.cancelDiscovery();

        try {
            // Se establece conexión con el socket
            btSocket.connect();
        } catch (IOException e) {
            try {
                // Si hay problemas el conectar al socket éste se cierra
                btSocket.close();
            } catch (IOException e2) {
                errorExit("Erro fatal", "En onResume() falla al cerrar el socket al fallar intento de conexión" + e2.getMessage() + ".");
            }
        }

        try {
            // Se abren flujos de entrada y salida a través de la conexión establecida
            outStream = btSocket.getOutputStream();
            inStream = btSocket.getInputStream();
        } catch (IOException e) {
            errorExit("Error fatal", "En onResume() falla la crear flujos de salida y/o entrada" + e.getMessage() + ".");
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (outStream != null) {
            try {
                // Se limpian los flujos
                outStream.flush();
            } catch (IOException e) {
                errorExit("Error fatal", "En onPause() falla al liberar el flujo de salida" + e.getMessage() + ".");
            }
        }
        try {
            btSocket.close();
        } catch (IOException e2) {
            errorExit("Error fatal", "En onPause() falla al cerrar el socket." + e2.getMessage() + ".");
        }
    }

    @SuppressLint("MissingPermission")
    private void checkBTState() {
        if (btAdapter == null) {
            errorExit("Error fatal", "Bluetooth no soportado");
        } else {
            if (!btAdapter.isEnabled()) {
                // Si el adaptador no está habilitado se habilita
                Intent enableBtIntent = new Intent(btAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
            } else {
                // Estado habilitado
            }
        }
    }
    private void errorExit(String title, String message){
        Toast msg = Toast.makeText(getBaseContext(),
                title + " - " + message, Toast.LENGTH_SHORT);
        msg.show();
        tv1.setText(message);
        //finish();
    }

    // Envia un dato al dispositivo remoto sin recibir respuesta.
    private void sendDataWithoutResponse(int m) {

        try {

            outStream.write(m);

        } catch (IOException e) {
            String msg = "En onResume() excepción ocurrida al escribir en el flujo: " + e.getMessage();
            if (address.equals("00:14:02:20:25:23"))
                msg = msg + ".\n\nModifique la dirección del servidor a AB:CD:DE:00:11:22 como dirección correcta";
            msg = msg + ".\n\nChequear que el SPP UUID: " + MY_UUID.toString() + " exista.\n\n";

            errorExit("Error fatal", msg);
        }
    }


    // Envía un dato m recibiendo respuesta del dispositivo remoto recibiendo caracteres hasta encontrar una arroba como
    // caracter de terminación. El caracter de terminación depende del que se programe en el dispositivo remoto.
    private void sendData(int m) {

        try {
            outStream.write(m);
            try{Thread.sleep(250);}catch(Exception e){}
            int dato=inStream.read();
            while (dato!=64){
                tv1.append(String.format("%c",dato));
                dato=inStream.read();
            }

            tv1.append("\n");
        } catch (IOException e) {
            String msg = "En onResume() excepción ocurrida al escribir en el flujo: " + e.getMessage();
            if (address.equals("00:14:02:20:25:23"))
                msg = msg + ".\n\nModifique la dirección del servidor a AB:CD:DE:00:11:22 como dirección correcta";
            msg = msg + ".\n\nChequear que el SPP UUID: " + MY_UUID.toString() + " exista.\n\n";

            errorExit("Error fatal", msg);
        }
    }
}