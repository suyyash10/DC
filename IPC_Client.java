import java.net.*;
import java.io.*;

public class IPC_Client {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("localhost", 1200);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            System.out.println("\n************* CLIENT PROCESS STARTED *************\n");
            System.out.println("Please enter the value of Number 1:");
            int a = Integer.parseInt(br.readLine());
            System.out.println("Number 1 ====> " + a);
            dos.writeInt(a);

            System.out.println("Please enter the value of Number 2:");
            int b = Integer.parseInt(br.readLine());
            System.out.println("Number 2 ====> " + b);
            dos.writeInt(b);

            int result = dis.readInt();
            System.out.println("\nCLIENT PROCESS HAS RECEIVED RESULT FROM SERVER.\n");
            System.out.println("The addition of " + a + " and " + b + " is " + result);

            socket.close();
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
