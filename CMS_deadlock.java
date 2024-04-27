import java.util.*;
class Message {
  public int initiator;
  public int from;
  public int to;
  public Message(int i, int j, int k) {
    initiator = i;
    from = j;
    to = k;
  }
  public String toString() {
    return "(" + initiator + "," + from + ", " + to + ")";
  }
}
public class CMS_deadlock {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int graph[][];
    boolean isDeadlock = false;
    System.out.println("Enter the number of processes");
    int n = sc.nextInt();
    graph = new int[n][n];
    System.out.println("Enter the wait for graph:");
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        graph[i][j] = sc.nextInt();
      }
    }
    System.out.println("The wait for graph is:");
    Display(graph);
    System.out.println("Enter the process initiating probe");
    int init = sc.nextInt();
    System.out.println("Initiating probe...");
    List < Message > mess_list = new ArrayList < Message > ();
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (graph[i][j] == 1) {
          Message m = new Message(init, i, j);
          mess_list.add(m);
          count += 1;
        }
      }
    }
    System.out.println(mess_list);
    for (int i = 0; i < count; i++) {
      for (int j = 0; j < count; j++) {
        if (mess_list.get(i).initiator == mess_list.get(j).to) {
          isDeadlock = true;
        }
      }
    }
    if (isDeadlock) {
      System.out.println("The Deadlock has been detected...");
    } else {
      System.out.println("No Deadlock has been detected...");
    }
  }
  public static void Display(int graph[][]) {
    int n = graph.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(graph[i][j] + " ");
      }
      System.out.println();
    }
  }
}