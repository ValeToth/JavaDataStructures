/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS_tests.structures;

import JDS.structures.graphs.*;
import JDS.structures.graphs.weightedNodes.WeightedPath;

/**
 *
 * @author JacopoWolf
 */
public class Graph_test
{
    
    public static <E,A> void printPath ( Path<E,A> path ) 
    {
        for ( IGraphNode node : path )
            {
                System.out.print(node.getContent() + "->");
            }
            System.out.println("\b\b");
    }
    
    public static void main( String[] args )
    {
        IGraphNode<String,Integer>
                a   = new GraphNode<>("A"),
                b   = new GraphNode<>("B"),
                c   = new GraphNode<>("C"),
                d   = new GraphNode<>("D"),
                e   = new GraphNode<>("E"),
                f   = new GraphNode<>("F");
        
        a.addGraphNode(e, 10);  a.addGraphNode(b,3);    a.addGraphNode(f,10);
        b.addGraphNode(d, 3);   b.addGraphNode(c,1);
        c.addGraphNode(d, 1);
        d.addGraphNode(e, 2);
        e.addGraphNode(f, 2);
        f.addGraphNode(e, 10);
        
        
        try
        {
        
            printPath( new Path<String,Integer>().shortestPath(a, f) );
            printPath( new WeightedPath<String>().shortestPath(a, f) );
            printPath( new Path<String,Integer>().shortestPath(f, a) );
        }
        catch( PathNotFoundException ex )
        {
            System.out.println("no path found");
        }
    }
    
    
}
