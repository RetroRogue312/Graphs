public class EveryPath
{
    public void CyclesOfFour(int[][] adjMatrix)
    {
        int n = adjMatrix.length;
        for(int node1 = 0; node1 < n; node1++)
        {
            for(int node2 = 0; node2 < n; node2++)
            {
                if (adjMatrix[node1][node2] > 0 && node2 != node1)
                {
                    for(int node3 = 0; node3 < n; node3++)
                    {
                        if(adjMatrix[node2][node3] > 0 && node3 != node2)
                        {
                            for(int node4 = 0; node4 < n; node4++)
                            {
                                if(adjMatrix[node3][node4] > 0 && node4 != node3 && node4 != node2 && node4 != node1)
                                {
                                    if (adjMatrix[node4][node1] > 0)
                                    {
                                        System.out.println(node1 + " - " + node2 + " - " + node3 + " - " + node4 + " - " + node1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[][] matrix = {
                {0,5,0,0},
                {0,0,12,0},
                {0,0,0,5},
                {5,0,0,0}

        };

        EveryPath e = new EveryPath();
        e.CyclesOfFour(matrix);
    }

}
