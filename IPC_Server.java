import java.net.*;
import java.io.*;

public class IPC_Server {
    public static void main(String args[]) {
        System.out.println("\n**** INTERPROCESS COMMUNICATION ****\n");
        System.out.println("\n*** SERVER PROCESS STARTED ***\n");

        try {
            int portNumber = 1200;
            System.out.println("\n* SERVER IS READY AND WAITING TO RECEIVE DATA FROM CLIENT PROCESS ON PORT " + portNumber);

            ServerSocket ss = new ServerSocket(portNumber);
            Socket clientSocket = ss.accept();

            System.out.println("\n* Client is connected with IP address " + clientSocket.getInetAddress() +
                    " and port Number " + clientSocket.getPort());

            DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());

            int a = dis.readInt();
            System.out.println("\nSERVER RECEIVED\nNumber 1 ====>" + a);

            int b = dis.readInt();
            System.out.println("\nNumber 2 ====>" + b);

            int c = a + b;

            dos.writeInt(c);
            System.out.println("\nSERVER PROCESS HAS EXECUTED REQUESTED PROCESS AND SENT RESULT " + c + " TO THE CLIENT\n");

            clientSocket.close();
            System.out.println("\nSERVER PROCESS EXITING..");
            ss.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
