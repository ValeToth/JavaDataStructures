/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import java.util.Map;
import java.util.function.Function;


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
    Function<A,Integer> getCalculateArchWeight();
    
    /**
     * finds the shortest path between source and destination node
     * @param source
     * @param destination
     * @return
     * @throws PathNotFoundException 
     */
    IPath<A> shortestPath ( IGraphNode<?,A> source, IGraphNode<?,A> destination ) throws PathNotFoundException;
    
    /**
     * generates weight map of every reachable source Graphnode
     * @param source
     * @return 
     */
    public Map<IGraphNode<?,A>,Integer> generateWeightMap( IGraphNode<?,A> source);
    
}
