/*
 *  see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import JDS.patterns.composite.*;
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
    public void testIterator()
    {
        GraphNode[] iterationAssertion =  Arrays.copyOfRange(nodes, 1, 6);
        ArrayList<GraphNode> currentIteration = new ArrayList<>();
        
        for( CompositeIterator<GraphNode> it = nodes[0].iterator(); it.hasNext(); )
        {
            currentIteration.add( it.next() );
        }
        
        Assert.assertArrayEquals( iterationAssertion, currentIteration.toArray() );
        
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
    
    
    
    
    public static <A> void printPath ( WeightMapPath<A> path ) 
    {
        for ( IGraphNode node : path )
        {
            System.out.print( node.getContent() + "->");
        }
        System.out.println("\b\b");
    }
    
}
