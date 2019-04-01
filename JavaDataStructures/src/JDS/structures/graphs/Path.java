/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import java.util.*;
import java.util.function.Function;

/**
 *
 * @author Jacopo_Wolf
 * @param <E>
 * @param <A>
 */
public class Path<E,A> extends ArrayList<IGraphNode<E,A>>
{
    /*
        variables
    */
    protected int defaultWeight = Integer.MAX_VALUE;
    protected Function<A,Integer> calculateArchWeight;

    public int getDefaultWeight()
    {
        return defaultWeight;
    }

    public void setDefaultWeight( int defaultWeight )
    {
        this.defaultWeight = defaultWeight;
    }

    public Function<A, Integer> getCalculateArchWeight()
    {
        return calculateArchWeight;
    }

    public void setCalculateArchWeight( Function<A, Integer> calculateArchWeight )
    {
        this.calculateArchWeight = calculateArchWeight;
    }

    
    
    /*
        constructor
    */
    
    
    public Path( Function<A, Integer> calculateArchWeight )
    {
        this.calculateArchWeight = calculateArchWeight;
    }
    
    
    /*
        methods
    */
    
    /**
     * finds the shortest path between source and destination node
     * @param source
     * @param destination
     * @return 
     * @throws JDS.structures.graphs.PathNotFoundException 
     */
    public Path<E,A> shortestPath( IGraphNode<E,A> source, IGraphNode<E,A> destination ) throws PathNotFoundException
    {
      
        //a list of all reachable graphnodes
        Collection<IGraphNode> reachableGraphNodes = IGraphNode.getAllGraphsRecursive(source);
        
        if ( !reachableGraphNodes.contains(destination) )
            throw new PathNotFoundException(source, destination, "There's no path between the source and destination nodes!");
        
        
        
        //maps every reachable node and the weight to reach it.
        LinkedHashMap<IGraphNode<E,A>, Integer>     weightMap = new LinkedHashMap<>(),
                                                    definitiveMap = new LinkedHashMap<>();
        weightMap.put(source, 0);
        
        
        
        
        //finds shortest path
        while ( reachableGraphNodes.size() > 0 )
        {
             
        }
        
        
        return this;

    }
    
    
}