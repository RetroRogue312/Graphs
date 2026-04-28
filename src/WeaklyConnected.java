import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WeaklyConnected
{
    public boolean BFS(int[][] graph, int start, int target)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];

        q.add(start);
        visited[start] = true;


        while(!q.isEmpty())
        {
            int node = q.remove();

            for (int i = 0; i < graph.length; i++)
            {
                if (graph[node][i] == 1 && !visited[i])
                {
                    visited[i] = true;
                    q.add(i);

                    if (i == target)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isWeaklyConnected(int[][] matrix)
    {
        int[][] undirected = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                if (matrix[i][j] == 1 || matrix[j][i] == 1)
                {
                    undirected[i][j] = 1;
                    undirected[j][i] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                if (!BFS(undirected, i, j))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {1,0,1,0},
                {0,0,1,0},
                {0,1,1,0},
                {0,1,0,1}
        };

        WeaklyConnected w =  new WeaklyConnected();
        if(w.isWeaklyConnected(matrix))
            System.out.print("Weakly Connected");
        else
            System.out.print("Not weakly Connected");
    }
}
