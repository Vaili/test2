package com.weblog;

import java.io.IOException;
import java.net.*;

public class Main {

    public static void main(String[] args) throws UnknownHostException, SocketException {
        String host;
        try {
            host = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            host = "localhost";
        }

        for (int i = 0; i < 1024; i++) {
            try {
                Socket s = new Socket(host, i);

                System.out.println("Esiste un servizio sulla porta " + i + "\n");
            } catch (UnknownHostException uhe) {
                System.out.println("Host sconosciuto\n");
                break;
            } catch (IOException ioe) {
                System.out.println("Non esiste un servizio sulla porta " + i + "\n");
            }
        }
    }
}
