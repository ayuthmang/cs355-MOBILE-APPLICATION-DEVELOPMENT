package com.example.ayuth.androidpresentationremoteclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private RemoteSocket remoteSocket;
    private Button btnConnectToRemoteServer, btnDisconnectFromRemoteServer,
            btnStartPresentation, btnStopPresentation,
            btnGotoFirstSlide, btnGotoPreviousSlide, btnGotoNextSlide, btnGotoLastSlide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();
    }

    private void initInstances() {
        remoteSocket = RemoteSocket.getInstance();

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
            remoteSocket.connect("http://192.168.1.37:3000");
            Toast.makeText(this, "Connected", Toast.LENGTH_SHORT).show();
        } else if (v == btnDisconnectFromRemoteServer) {
            remoteSocket.getSocket().disconnect();
            Toast.makeText(this, "Disconnected", Toast.LENGTH_SHORT).show();
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
}
