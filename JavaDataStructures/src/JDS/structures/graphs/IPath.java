/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import java.util.*;
import java.util.function.*;


/**
 *
 * @author JacopoWolf
 */
interface IPath<A>
{
    
    /**
     * 
     * @return the function called to calculate weight of every arch between nodes
     */
    public Function<A,Integer> getCalculateArchWeightBehaviour();
    /**
     * 
     * @return the source node of this Path object
     */
    public IGraphNode<?,A> getSourceNode();
    
    /**
     * 
     * @return this Path's weight map
     */
    public Map<IGraphNode<?,A>,Integer> getWeightMap();
    
    /**
     * finds the shortest path between source and destination node
     * @param source
     * @param destination
     * @return
     * @throws PathNotFoundException 
     */
    public IPath<A> shortestPath ( IGraphNode<?,A> source, IGraphNode<?,A> destination ) throws PathNotFoundException;
    
    /**
     * finds the shortest path between source and destination node
     * @param source
     * @param destination
     * @return
     * @throws PathNotFoundException 
     */
    public IPath<A> shortestPath ( IGraphNode<?,A> source, IGraphNode<?,A> destination, boolean stopAtDestination  ) throws PathNotFoundException;
    
    /**
     * generates weight map of every reachable Graphnode from source and returns it.
     * @param source
     * @return 
     */
    public Map<IGraphNode<?,A>,Integer> generateWeightMap( IGraphNode<?,A> source );
    
    
    
    
}
