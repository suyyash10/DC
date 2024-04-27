import java.io.*;
import java.net.*;
public class ME_MutualServer implements Runnable {
  private Socket socket;
  private static ServerSocket ss;
  ME_MutualServer(Socket newSocket) {
    this.socket = newSocket;
  }
  public static void main(String[] args) {
    try {
      ss = new ServerSocket(7000);
      System.out.println("Server Started");
      while (true) {
        Socket s = ss.accept();
        ME_MutualServer es = new ME_MutualServer(s);
        Thread t = new Thread(es);
        t.start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void run() {
    try {
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String message;
      while ((message = in.readLine()) != null) {
        System.out.println("Received: " + message);
      }
      System.out.println("Client disconnected.");
      socket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}