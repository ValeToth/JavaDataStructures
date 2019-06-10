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
    private FunctionalGraphNodeDelegate behaviour;

    public FunctionalGraphNodeDelegate getBehaviour()
    {
        return behaviour;
    }

    
    
    public FunctionalGraphNode( FunctionalGraphNodeDelegate behaviour )
    {
        this.behaviour = behaviour;
    }

    public FunctionalGraphNode( T content, FunctionalGraphNodeDelegate behaviour )
    {
        super(content);
        this.behaviour = behaviour;
    }
    
    
    
    
    
    
}