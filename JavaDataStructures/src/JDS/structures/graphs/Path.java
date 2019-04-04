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
public class Path<E,A> extends LinkedList<IGraphNode<E,A>>
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


    
    /*
        constructors
    */
    
    public Path()
    {
        this.calculateArchWeight = ( A a ) -> 1 ;
    }
    
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
     * @throws PathNotFoundException 
     */
    public Path<E,A> shortestPath ( IGraphNode<E,A> source, IGraphNode<E,A> destination ) throws PathNotFoundException
    {        
        //checks if the destination is reachable
        if ( !source.containsRecursive((el) -> el.equals(destination) ))
            throw new PathNotFoundException(source, destination, "There's no path between source and destination nodes!");
        
        HashMap<IGraphNode,IGraphNode> precedentMap = new HashMap<>();
        Map<IGraphNode<E,A>,Integer> weightMap = generateWeightMap(source, precedentMap );
        
        // updates this path object
        IGraphNode currentNode = destination;
        while ( currentNode != source )
        {
            this.add(0, currentNode);
            currentNode = precedentMap.get(currentNode);
        }
        this.add(0, source);
        
        return this;
    }
    
    
    
    
    /**
     * calculates the weight to reach every node from source, with the destination 
     * @param source
     * @return 
     */
    public Map<IGraphNode<E,A>,Integer> generateWeightMap( IGraphNode<E,A> source )
    {
        return generateWeightMap(source, new HashMap<>() );
    }
    
    /**
     * calculates the weight to reach every node from source, with the destination 
     * @param source
     * @param OUT_previousToMap
     * @return 
     */
    public Map<IGraphNode<E,A>,Integer> generateWeightMap( IGraphNode<E,A> source, Map<IGraphNode,IGraphNode> OUT_previousToMap  )
    {
      
        //a list of all reachable graphnodes
        Collection<IGraphNode> reachableGraphNodes = IGraphNode.getAllGraphsRecursive(source);
           
        
        //maps every reachable node and the weight to reach it.
        LinkedHashMap<IGraphNode<E,A>, Integer> weightMap = new LinkedHashMap<>();
        for ( IGraphNode node : reachableGraphNodes )
            weightMap.put(node, defaultWeight);
        
        //inits source
        weightMap.put(source, 0);
        reachableGraphNodes.add(source);
        
        
        //finds shortest path
        IGraphNode<E,A> currentNode;
        
        // while there are nodes to check
        while ( !reachableGraphNodes.isEmpty() )
        {
            // the node with the minimum weight in the unchecked nodes
            currentNode = reachableGraphNodes.stream().min
            ( 
                (a, b) -> Integer.compare( weightMap.get(a) , weightMap.get(b) )
            ).get();
            
            //for every connection in current node
            for ( IArch<A> arch : currentNode.getArches() )
            {
                //if it has alraedy been checked, skip checking ir again.
                if ( !reachableGraphNodes.contains(arch.pointsTo()) )
                    continue;
                
                // total distance from source
                int dist = weightMap.get(currentNode) + calculateArchWeight.apply(arch.getData());
                
                if ( dist < weightMap.get( arch.pointsTo() ))
                {
                    weightMap.put( arch.pointsTo(), dist );
                
                    //updates previus graphnode tracking map
                    OUT_previousToMap.put(arch.pointsTo(), currentNode);
                }
                
            }
            
            //removes current node from nodes to check
            reachableGraphNodes.remove(currentNode);
                        
        }
        
        
        return weightMap;

    }
    
    
}