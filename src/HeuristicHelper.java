import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

public class HeuristicHelper
{
    //Just using java to make it easier/quicker to calculate the Heuristic values for each A* Traversal(Problem 2).

    static class Node
    {
        String name;
        double x,y;

        Node(String name, double x, double y)
        {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }

    public static void printH(Map<String, Node> nodes, String goal)
    {
        System.out.println("Heuristics with goal " + goal + ":");
        Node target = nodes.get(goal);
        for (Node n: nodes.values())
        {
            double h = Math.sqrt(Math.pow(target.x - n.x, 2) + Math.pow(target.y - n.y, 2));
            System.out.printf("%s %.2f%n", n.name, h);
        }
    }

    public static void main(String[] args)
    {
        Map<String, Node> nodes = new HashMap<>();
        nodes.put("Anya", new Node("Anya", 2.5, 1.5));
        nodes.put("frog", new Node("frog", 1.0, 1.9));
        nodes.put("Orca", new Node("Orca", 6.5, 1.0));
        nodes.put("Dog", new Node("Dog", 2.0, 3.5));
        nodes.put("Penguin", new Node("Penguin", 3.0, 3.0));
        nodes.put("Elephant", new Node("Elephant", 4.5, 3.1));
        nodes.put("Wolf", new Node("Wolf", 6.0, 2.5));
        nodes.put("Sloth", new Node("Sloth", 4.0, 4.0));
        nodes.put("Rhino", new Node("Rhino", 6.5, 4.0));
        nodes.put("Rabbit", new Node("Rabbit", 1.3, 5.5));
        nodes.put("Bond", new Node("Bond", 4.2, 5.7));
        nodes.put("Bear", new Node("Bear", 6.0, 5.6));

        printH(nodes, "Wolf");
    }
}
