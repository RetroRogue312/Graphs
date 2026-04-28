import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class Graph
{
    public void buildGraph(String sequence)
    {
        String[] seq = sequence.split(" ");


        int[][] matrix = new int[seq.length][seq.length];
        for (int i = 0; i < matrix.length; i++)//O(V)
        {
            Arrays.fill(matrix[i], 0);
        }

        for(int i = 0; i < seq.length; i++)//O(V)
        {
            int out1 = (2 * i + 1) % seq.length;
            int out2 = (2 * i + 2) % seq.length;

            matrix[i][out1] = 1;
            matrix[i][out2] = 1;
        }

        drawGraph(matrix, seq);
    }

    public void drawGraph(int[][] matrix, String[] strings)
    {
        String horizontal = "";
        int maxLength = 0;
        for (int i = 0; i < strings.length; i++)//O(V)
        {
            if (maxLength < strings[i].length())
                maxLength = strings[i].length();
        }

        String format = "%-" + (maxLength + 1) + "s";
        String numFormat = "%-" + (maxLength + 1) + "d";

        System.out.print(String.format(format, " "));
        for (String s : strings)//O(V)
            System.out.print(String.format(format, s));
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(String.format(format, strings[i]));
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(String.format(numFormat, matrix[i][j]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Graph g = new Graph();
        String sequence = "ANT CUN BOG AMA DC TOL SAN";
        g.buildGraph(sequence);
    }




}
