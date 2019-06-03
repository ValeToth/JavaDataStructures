/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs.specific;


import JDS.structures.graphs.*;
import java.util.function.*;

/**
 * a graphnode incorporating a function for path calculation
 * @author Jacopo_Wolf
 * @param <T>
 * @param <A>
 */
public class FunctionalGraphNode<T,A> extends GraphNode<T, A> 
{
    private BiFunction<T, A, T> behaviour;

    /**
     *
     * @return
     */
    public BiFunction<T, A, T> Behaviour()
    {
        return behaviour;
    }

    /**
     *
     * @param behaviour
     */
    public FunctionalGraphNode( BiFunction<T, A, T> behaviour )
    {
        this.behaviour = behaviour;
    }

    /**
     *
     * @param behaviour
     * @param content
     */
    public FunctionalGraphNode( BiFunction<T, A, T> behaviour, T content )
    {
        super(content);
        this.behaviour = behaviour;
    }
    
    
    


}
