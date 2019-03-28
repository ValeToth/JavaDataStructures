/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs.weightedNodes;

import JDS.structures.graphs.Arch;
import JDS.structures.graphs.GraphNode;
import JDS.structures.graphs.IGraphNode;

/**
 *
 * @author Jacopo_Wolf
 * @param <T>
 */
public class WeightedGraphNode<T> extends GraphNode<T, Integer>
{

    public WeightedGraphNode ()
    {
    }
    
    public WeightedGraphNode( T content )
    {
        super(content);
    }
    
    public WeightedGraphNode( T content, WeightedGraphNode<T>... connections )
    {
        super(content,connections);
    }

    
    
    
    @Override
    public void addGraphNode ( IGraphNode<T, Integer> node, Integer archValue)
    {
        this.connections.add( new Arch<>(archValue, node) );
    }

    @Override
    public void addGraphNode( IGraphNode<T, Integer> node )
    {
        this.connections.add( new Arch<>(Integer.MAX_VALUE, node) );
    }
    
    
}
