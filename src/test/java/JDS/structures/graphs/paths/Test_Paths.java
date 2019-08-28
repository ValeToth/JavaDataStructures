/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDS.structures.graphs.paths;

import JDS.structures.graphs.*;
import java.util.*;
import org.junit.*;

/**
 *
 * @author Jacopo_Wolf
 */
public class Test_Paths
{
    ArrayList<WeightedGraphNode<String>> graph = new ArrayList<>();
    WeightedGraphNode<String> node0 = new WeightedGraphNode<>("0");
    
    @Before
    public void prepareTestPathFindingExpansive()
    {
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
        
    }
    
    // with the current implementation it takes 10 seconds for a total of 32.000 nodes
    @Test( timeout = 10000 )
    public void testPathFindingExpansive() 
    {
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
}
