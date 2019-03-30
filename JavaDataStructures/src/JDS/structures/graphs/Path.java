/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import java.util.*;
import java.util.function.Function;

/**
 *
 * @author Jacopo_Wolf
 * @param <A>
 */
public class Path<A> extends ArrayList<IGraphNode<?,A>>
{

    protected int defaultWeight = Integer.MAX_VALUE;
    protected Function<A,Integer> calculateArchWeight;

    
    public Path( Function<A, Integer> calculateArchWeight )
    {
        this.calculateArchWeight = calculateArchWeight;
    }
    
    
    
    
    public Path shortestPath( IGraphNode source, IGraphNode destination )
    {
        
        
        
    }
    
    
}
