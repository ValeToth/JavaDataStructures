/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

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
    
    public WeightedGraphNode( WeightedGraphNode<T>... connections )
    {
        super(null,connections);
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

    
    public long weightToReach( WeightedGraphNode<T> destination )
    {
        // implement
        throw new UnsupportedOperationException();
    }
    
    
}
