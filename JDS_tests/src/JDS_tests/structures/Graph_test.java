/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS_tests.structures;

import JDS.structures.graphs.*;
import JDS.structures.graphs.specific.*;

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
    
    public static void main( String[] args ) throws InterruptedException
    {
        
        GraphNode<String,Integer>
                a   = new GraphNode<>("A"),
                b   = new GraphNode<>("B"),
                c   = new GraphNode<>("C"),
                d   = new GraphNode<>("D"),
                e   = new GraphNode<>("E"),
                f   = new GraphNode<>("F"),
                g   = new GraphNode<>("G");
        
        
        a.addGraphNode(e, 10);  a.addGraphNode(b,3);    a.addGraphNode(f,10); 
        b.addGraphNode(d, 3);   b.addGraphNode(c,1);
        c.addGraphNode(d, 1);   c.addGraphNode(a, 2);
        d.addGraphNode(e, 2);   d.addGraphNode(a, 5);
        e.addGraphNode(f, 2);   e.addGraphNode(g, 10);
        f.addGraphNode(e, 10);  f.addGraphNode(g,7);
        g.addGraphNode(b, 3);
        
        GraphNode[] nodes = { a,b,c,d,e,f };
        
        
        try
        {
            long startTime = System.currentTimeMillis();
            
            Path path = new WeightedPath();
            
            System.out.println("path initialization: " + (System.currentTimeMillis() - startTime) + "ms\n-----\n" );
            
            
            // evey shortestPath call should take around 1 - 3 ms on mid-low performance PCs
            for ( int i = 0; i < 50; i++ ) 
            {
                
            
                IGraphNode  a1 = nodes[ (int)( Math.random() * nodes.length ) ];
                Thread.sleep(20);
                IGraphNode  a2 = nodes[ (int)( Math.random() * nodes.length ) ];
                
                System.out.println( "from " + a1.getContent() + " to " + a2.getContent() );
                
                
                
                startTime = System.currentTimeMillis();
                
                printPath ( path.shortestPath(a1,a2,true) );
                
                System.out.println("time taken: " + (System.currentTimeMillis() - startTime) + "ms\n" );
                
            }
            
            
            

        }
        catch( PathNotFoundException ex )
        {
            System.out.println("no path found");
        }
    }
    
    
}
