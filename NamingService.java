import java.io.*;
import java.net.*;

public class NamingService {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Website URL to resolve its Name to address:");
        String name = br.readLine();
        
        try {
            // Resolve the website URL to InetAddress
            InetAddress ip = InetAddress.getByName(name);
            System.out.println("\nAddress: " + ip.getHostAddress());
        } catch (UnknownHostException e) {
            // Handle UnknownHostException (host not found)
            System.out.println("No host is present.");
            System.out.println("Please try again with a valid website URL.");
        }
    }
}
