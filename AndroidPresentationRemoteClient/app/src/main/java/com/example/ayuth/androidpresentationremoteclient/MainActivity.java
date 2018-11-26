package com.example.ayuth.androidpresentationremoteclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;

import java.net.URISyntaxException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RemoteSocket remoteSocket;
    private Button btnConnectToRemoteServer, btnDisconnectFromRemoteServer,
            btnStartPresentation, btnStopPresentation,
            btnGotoFirstSlide, btnGotoPreviousSlide, btnGotoNextSlide, btnGotoLastSlide;
    private EditText etUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
        enableControls(false); // set everything disabled before we're connected
    }

    private void initInstances() {
        remoteSocket = RemoteSocket.getInstance();

        etUri = findViewById(R.id.etUri);

        btnConnectToRemoteServer = findViewById(R.id.btnConnectToRemoteServer);
        btnConnectToRemoteServer.setOnClickListener(this);
        btnDisconnectFromRemoteServer = findViewById(R.id.btnDisconnectFromRemoteServer);
        btnDisconnectFromRemoteServer.setOnClickListener(this);
        btnStartPresentation = findViewById(R.id.btnStartPresentation);
        btnStartPresentation.setOnClickListener(this);
        btnStopPresentation = findViewById(R.id.btnStopPresentation);
        btnStopPresentation.setOnClickListener(this);
        btnGotoFirstSlide = findViewById(R.id.btnGotoFirstSlide);
        btnGotoFirstSlide.setOnClickListener(this);
        btnGotoPreviousSlide = findViewById(R.id.btnGotoPreviousSlide);
        btnGotoPreviousSlide.setOnClickListener(this);
        btnGotoNextSlide = findViewById(R.id.btnGotoNextSlide);
        btnGotoNextSlide.setOnClickListener(this);
        btnGotoLastSlide = findViewById(R.id.btnGotoLastSlide);
        btnGotoLastSlide.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnConnectToRemoteServer) {
            String uri = etUri.getText().toString();
            // append http:// if not exists
            if (!(uri.indexOf("http://") >= 0)) {
                uri = "http://" + uri;
            }

            try {
                remoteSocket.connect(uri);
                if (remoteSocket.getSocket().connected()) {
                    enableControls(true);
                    Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
                } else {
                    enableControls(false);
                    Toast.makeText(this, "Unable to connect " + uri, Toast.LENGTH_SHORT).show();
                }
            } catch (URISyntaxException ex) {
                enableControls(false);
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("MainActivity", ex.getMessage());
            }
        } else if (v == btnDisconnectFromRemoteServer) {
            try {
                remoteSocket.getSocket().disconnect();
                enableControls(false);
                Toast.makeText(this, "Disconnected", Toast.LENGTH_SHORT).show();
            } catch (Exception ex) {
                Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
            }

        } else if (v == btnStartPresentation) {
            remoteSocket.sendCommand(RemoteCommand.START_PRESENTATION);
        } else if (v == btnStopPresentation) {
            remoteSocket.sendCommand(RemoteCommand.STOP_PRESENTATION);
        } else if (v == btnGotoFirstSlide) {
            remoteSocket.sendCommand(RemoteCommand.GOTO_FIRST_SLIDE);
        } else if (v == btnGotoPreviousSlide) {
            remoteSocket.sendCommand(RemoteCommand.GOTO_PREVIOUS_SLIDE);
        } else if (v == btnGotoNextSlide) {
            remoteSocket.sendCommand(RemoteCommand.GOTO_NEXT_SLIDE);
        } else if (v == btnGotoLastSlide) {
            remoteSocket.sendCommand(RemoteCommand.GOTO_LAST_SLIDE);
        }
    }

    private void enableControls(boolean enable) {
        if (enable) {
            etUri.setEnabled(false);
            btnConnectToRemoteServer.setEnabled(false);
            btnDisconnectFromRemoteServer.setEnabled(true);
            btnStartPresentation.setEnabled(true);
            btnStopPresentation.setEnabled(true);
            btnGotoFirstSlide.setEnabled(true);
            btnGotoPreviousSlide.setEnabled(true);
            btnGotoNextSlide.setEnabled(true);
            btnGotoLastSlide.setEnabled(true);
        } else {
            etUri.setEnabled(true);
            btnConnectToRemoteServer.setEnabled(true);
            btnDisconnectFromRemoteServer.setEnabled(false);
            btnStartPresentation.setEnabled(false);
            btnStopPresentation.setEnabled(false);
            btnGotoFirstSlide.setEnabled(false);
            btnGotoPreviousSlide.setEnabled(false);
            btnGotoNextSlide.setEnabled(false);
            btnGotoLastSlide.setEnabled(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        remoteSocket.getSocket().disconnect();
    }
}