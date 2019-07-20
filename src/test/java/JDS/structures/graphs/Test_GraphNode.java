/*
 *  see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import JDS.structures.graphs.paths.*;
import java.util.*;
import org.junit.*;


/**
 *
 * @author Jacopo_Wolf
 */
public class Test_GraphNode
{
    GraphNode[] nodes;
    
    @Before
    public void start()
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
        
        this.nodes = new GraphNode[] { a,b,c,d,e,f,g };
        
    }
    
    
    @Test
    public void testGetSetContent()
    {
        GraphNode<String,Object> instance = new GraphNode<>("No");
        instance.setContent( "Test" );
        Assert.assertEquals("Test", instance.getContent() );
    }
    
    @Test
    public void testConnections()
    {
        Assert.assertArrayEquals
        ( 
            new GraphNode[]    
            {
                nodes[4],
                nodes[1],
                nodes[5]
            }
            , 
            nodes[0].getConnectedElements().toArray()
        );
        
    }
    
    @Test(timeout = 1000)
    public void testPathFinding() throws PathNotFoundException
    {
        WeightMapPath<Integer> instance = new WeightMapPath<>();
        instance.shortestPath
        (
                nodes[6],
                nodes[0]
        );
        printPath(instance);
        Assert.assertArrayEquals
        (
            new GraphNode[]    
            {
                nodes[6],
                nodes[1],
                nodes[3],
                nodes[0]
            },
            instance.toArray()
        );
    }
    
    // with the current implementation it takes 10 seconds for a total of 32.000 nodes
    @Test( timeout = 10000 )
    public void testPathFindingExpansive() 
    {
        ArrayList<WeightedGraphNode<String>> graph = new ArrayList<>();
        WeightedGraphNode<String> node0 = new WeightedGraphNode<>("0");
        graph.add(node0);
        
        for ( int i = 0; i < 1500; i++ )
        {
            WeightedGraphNode<String> node = new WeightedGraphNode<>();
            node.addGraphNode( graph.get( graph.size() - 1) );
            graph.add( node );
        }
        
        
        for ( int j = 0; j < 20; j++ )
        {
        
            ArrayList<WeightedGraphNode<String>> branch1 = new ArrayList<>();
            WeightedGraphNode<String> node_branch1 = new WeightedGraphNode<>("branch"+j);
            
            branch1.add(node_branch1);

            for ( int i = 0; i < 1500; i++ )
            {
                WeightedGraphNode<String> node = new WeightedGraphNode<>();
                node.addGraphNode( branch1.get( branch1.size() - 1) );
                branch1.add( node );
            }
            
            // adds to the last nodes
            (graph.get(new Random().nextInt( graph.size() )))
                    .addGraphNode(branch1.get(branch1.size() - 1));
            
        }
        
        
        WeightMapPath path = new WeightMapPath();
        try
        {
            path.shortestPath( graph.get( graph.size() - 1), node0, true );
        }
        catch( PathNotFoundException e )
        {
            Assert.fail();
        }
        
    }
    
    
    public static <A> void printPath ( WeightMapPath<A> path ) 
    {
        for ( IGraphNode node : path )
            {
                System.out.print( node.getContent() + "->");
            }
            System.out.println("\b\b");
    }
    
}
