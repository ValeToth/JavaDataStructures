/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

/**
 * a graphnode incorporating a function for path calculation
 * @author Jacopo_Wolf
 * @param <T>
 * @param <A>
 */
public class FunctionalGraphNode<T,A> extends GraphNode<T, A> 
{
    private FunctionalGraphNodeDelegate<T,A> behaviour;

    public FunctionalGraphNodeDelegate<T,A> getBehaviour()
    {
        return behaviour;
    }

    
    
    public FunctionalGraphNode( FunctionalGraphNodeDelegate<T,A> behaviour )
    {
        this.behaviour = behaviour;
    }

    public FunctionalGraphNode( T content, FunctionalGraphNodeDelegate<T,A> behaviour )
    {
        super(content);
        this.behaviour = behaviour;
    }
    
    
    
    
    
    
}