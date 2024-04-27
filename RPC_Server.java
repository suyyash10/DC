import java.io.*;
import java.net.*;

class RPC_Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server ready");

        while (true) {
            try (Socket socket = serverSocket.accept();
                 BufferedReader receiveRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter pwrite = new PrintWriter(socket.getOutputStream(), true)) {

                String fun = receiveRead.readLine();
                if (fun != null) {
                    System.out.println("Operation: " + fun);
                }

                int a = 0, b = 0;
                try {
                    a = Integer.parseInt(receiveRead.readLine());
                    System.out.println("Parameter 1: " + a);

                    b = Integer.parseInt(receiveRead.readLine());
                    System.out.println("Parameter 2: " + b);

                    int result;
                    switch (fun) {
                        case "add":
                            result = a + b;
                            pwrite.println("Addition = " + result);
                            break;
                        case "sub":
                            result = a - b;
                            pwrite.println("Subtraction = " + result);
                            break;
                        case "mul":
                            result = a * b;
                            pwrite.println("Multiplication = " + result);
                            break;
                        case "div":
                            if (b == 0) {
                                pwrite.println("Error: Division by zero");
                            } else {
                                result = a / b;
                                pwrite.println("Division = " + result);
                            }
                            break;
                        default:
                            pwrite.println("Error: Invalid operation");
                            break;
                    }
                } catch (NumberFormatException e) {
                    pwrite.println("Error: Invalid input");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
