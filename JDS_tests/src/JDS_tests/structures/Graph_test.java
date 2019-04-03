/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS_tests.structures;

import JDS.structures.graphs.*;

/**
 *
 * @author JacopoWolf
 */
public class Graph_test
{
    
    public static void main( String[] args )
    {
        IGraphNode<String,Integer>
                a   = new GraphNode<>("A"),
                b   = new GraphNode<>("B"),
                c   = new GraphNode<>("C"),
                d   = new GraphNode<>("D"),
                e   = new GraphNode<>("E");
        
        a.addGraphNode( e, 10 );a.addGraphNode(b,3);
        b.addGraphNode(d,3); b.addGraphNode(c,1);
        c.addGraphNode(d, 1);
        d.addGraphNode(e,2);
        
        Path<String,Integer> path = new Path( (i) -> i );
        
        try
        {
            path.shortestPath(a, e);
        }
        catch( PathNotFoundException ex )
        {
            System.err.println("no path found");
        }
        
        
        for ( IGraphNode<String,Integer> node : path  )            
        {
            System.out.print(node.getContent() + "->");
        }
        
        
    }
    
    
}
