/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import java.util.*;
import java.util.function.*;


/**
 *
 * @author Jacopo_Wolf
 * @param <A>
 */
public interface IWeightMapPath<A> extends IPath<A>
{
    /**
     * 
     * @return the function called to calculate weight of every arch between nodes
     */
    public Function<A,Integer> getCalculateArchWeightBehaviour();
    
    
    /**
     * 
     * @return this Path's weight map
     */
    public Map<IGraphNode<?,A>,Integer> getWeightMap();
    
    /**
     * finds the shortest path between source and destination node
     * @param source the source node
     * @param destination the destination node
     * @return the shortest path from source to destination
     * @throws PathNotFoundException 
     */
    public IWeightMapPath<A> shortestPath ( IGraphNode<?,A> source, IGraphNode<?,A> destination ) throws PathNotFoundException;
    
    /**
     * finds the shortest path between source and destination node
     * @param source the source node
     * @param destination the destination node
     * @param stopAtDestination if the destination node is reached, then stop calculating
     * @return the shortest path from source to destination
     * @throws PathNotFoundException 
     */
    public IWeightMapPath<A> shortestPath ( IGraphNode<?,A> source, IGraphNode<?,A> destination, boolean stopAtDestination  ) throws PathNotFoundException;
    
    /**
     * generates weight map of every reachable Graphnode from source and returns it.
     * @param source
     * @return 
     */
    public Map<IGraphNode<?,A>,Integer> generateWeightMap( IGraphNode<?,A> source );
    
}
