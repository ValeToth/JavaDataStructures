/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS_tests.structures;

import JDS.structures.graphs.GraphNode;
import JDS.structures.graphs.IGraphNode;
import JDS.structures.graphs.Path;
import JDS.structures.graphs.PathNotFoundException;
import JDS.structures.graphs.weightedNodes.WeightedPath;

/**
 *
 * @author JacopoWolf
 */
public class Graph_test
{
    
    public static <A> void printPath ( Path<A> path ) 
    {
        for ( IGraphNode node : path )
            {
                System.out.print( node.getContent() + "->");
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
        
            
            long startTime = System.currentTimeMillis();
            // A->F
            printPath(  new Path().shortestPath(a, f)  );
            
            System.out.println("time taken: " + (System.currentTimeMillis() - startTime) + "ms" );
            
            
            
            startTime = System.currentTimeMillis();
            
            // A->B->C->D->E->F
            printPath(  new WeightedPath().shortestPath(a, f) );
            
            
            System.out.println("time taken: " + (System.currentTimeMillis() - startTime) + "ms" );
            

        }
        catch( PathNotFoundException ex )
        {
            System.out.println("no path found");
        }
    }
    
    
}
