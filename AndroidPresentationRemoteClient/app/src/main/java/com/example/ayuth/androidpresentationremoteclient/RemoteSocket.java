package com.example.ayuth.androidpresentationremoteclient;


import android.net.Uri;
import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class RemoteSocket {

    private static volatile RemoteSocket remoteSocketInstance;
    private Socket mSocket;
    private boolean isConnected;

    private RemoteSocket() {
        if (remoteSocketInstance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
        isConnected = false;
    }  // private constructor.

    public static RemoteSocket getInstance() {
        if (remoteSocketInstance == null) { // if there is no instance available... create new one
            synchronized (RemoteSocket.class) {   // Check for the second time.
                if (remoteSocketInstance == null) remoteSocketInstance = new RemoteSocket();
            }
        }

        return remoteSocketInstance;
    }

    public void connect(String uri) throws URISyntaxException {
        mSocket = IO.socket(uri);
        mSocket.connect();
    }

    public void sendCommand(RemoteCommand remoteCommand) {
        JSONObject command = new JSONObject();
        try {
            command.put("command", remoteCommand.toString());
            Log.i("RemoteSocket", remoteCommand.toString());
        } catch (JSONException ex) {
            Log.e("RemoteSocket", ex.getMessage());
        }
        if (remoteCommand == RemoteCommand.START_PRESENTATION) {
            mSocket.emit("command", command);
        } else if (remoteCommand == RemoteCommand.STOP_PRESENTATION) {
            mSocket.emit("command", command);
        } else if (remoteCommand == RemoteCommand.GOTO_FIRST_SLIDE) {
            mSocket.emit("command", command);
        } else if (remoteCommand == RemoteCommand.GOTO_FIRST_SLIDE) {
            mSocket.emit("command", command);
        } else if (remoteCommand == RemoteCommand.GOTO_PREVIOUS_SLIDE) {
            mSocket.emit("command", command);
        } else if (remoteCommand == RemoteCommand.GOTO_NEXT_SLIDE) {
            mSocket.emit("command", command);
        } else if (remoteCommand == RemoteCommand.GOTO_LAST_SLIDE) {
            mSocket.emit("command", command);
        }
    }

    public Socket getSocket() {
        return this.mSocket;
    }

    // Make singleton from serialize and deserialize operation.
    protected RemoteSocket readResolve() {
        return getInstance();
    }
}
