/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import java.util.*;
import java.util.function.*;

/**
 * rappresents a path between two connected Graphnodes
 * @author Jacopo_Wolf
 * @param <A> type of data contained in the Arches
 */
public class Path< A > extends LinkedList<IGraphNode<?,A>> implements IWeightMapPath<A>
{
    /*
        variables
    */

    /**
     * behaviour used to calculate the weight of the connections
     */
    protected   Function<A,Integer> archWeightCalculationBehaviour;
    
    private     HashMap<IGraphNode<?,A>,Integer> weightMap;
    private     boolean weightMapIsIncomplete = true;

    
    /**
     * 
     * @return if this path's current weightmap is a complete map of every reachable node or
     * some nodes are missing due to opimization from last calculations
     */
    public boolean isWeightMapIncomplete()
    {
        return weightMapIsIncomplete;
    }    


    @Override 
    public Function<A, Integer> getCalculateArchWeightBehaviour()
    {
        return archWeightCalculationBehaviour;
    }  
    

    @Override
    public <NodeT extends IGraphNode<?,A>> NodeT getSourceNode()
    {
        return (NodeT)this.getFirst();
    }
    
    @Override
    public <NodeT extends IGraphNode<?,A>> NodeT getDestinationNode()
    {
        return (NodeT)this.getLast();
    }
    

    /**
     * 
     * @return a Map containing a reference of every reachable graphnode and the total weight to reach it
     */
    @Override
    public Map<IGraphNode<?, A>, Integer> getWeightMap()
    {
        return this.weightMap;
    }
    
    
    /*
        constructors
    */

    /**
     * create a new Path instance with default calculation 
     */
    public Path()
    {
        this.archWeightCalculationBehaviour = ( A a ) -> 1 ;
    }
    
    /**
     *
     * @param calculateArchWeight
     */
    public Path( Function<A, Integer> calculateArchWeight )
    {
        this.archWeightCalculationBehaviour = calculateArchWeight;
    }

    
    
    
    
    
    /*
        methods
    */
    
    @Override
    public Path<A> shortestPath ( IGraphNode<?,A> source, IGraphNode<?,A> destination ) throws PathNotFoundException
    {
        return this.shortestPath(source, destination,false);
    }

    @Override 
    public Path<A> shortestPath ( IGraphNode<?,A> source, IGraphNode<?,A> destination, boolean stopAtDestination ) throws PathNotFoundException
    {
        //checks if the destination is reachable
        if ( source.parallelStream().noneMatch( e -> e.equals(destination) ) )
            throw new PathNotFoundException(source, destination, "There's no path between source and destination nodes!");
        
        this.clear();
        
        
        HashMap<IGraphNode<?,A>,IGraphNode<?,A>> precedentMap = new HashMap<>();
        
        
        generateWeightMap( source, destination, true, precedentMap );
        
        
        // updates this path object
        IGraphNode<?,A> currentNode = destination;
        while ( currentNode != source )
        {
            this.add(0, currentNode);
            currentNode = precedentMap.get(currentNode);
        }
        this.add(0, source);
        
        return this;
    } 

    
    

    @Override
    public Map<IGraphNode<?,A>,Integer> generateWeightMap( IGraphNode<?,A> source )
    {
        generateWeightMap( source, null, false, new HashMap<>() );
        return this.weightMap;
    }
    
    
    /**
     * calculates the weight to reach every node from source, with the destination 
     * @param source
     * @param destination
     * @param stopAtDestination
     * @param reversePathMap
     */
    protected void generateWeightMap 
    ( 
        IGraphNode<?,A> source, 
        IGraphNode<?,A> destination,
        boolean stopAtDestination,
        Map< IGraphNode<?,A>, IGraphNode<?,A> > reversePathMap
    )
    {
      
        //a list of all reachable graphnodes
        LinkedList<IGraphNode<?,A>> nodesToCheck = new LinkedList<>( IGraphNode.reachableGraphnodes(source) );
           
        
        //maps every reachable node and the weight to reach it, by default set to MAX_VALUE
        this.weightMap = new HashMap<>();
        
        for ( IGraphNode<?,A> node : nodesToCheck )
            this.weightMap.put(node, Integer.MAX_VALUE );
        
        
        //inits source
        this.weightMap.put(source, 0);
        nodesToCheck.add(source);
        
        this.weightMapIsIncomplete = true;
        
        
        //the current node
        IGraphNode<?,A> currentNode;
        
        // while there are nodes to check ->
        while ( !nodesToCheck.isEmpty() )
        {
            // set the current node to the node with the minimum weight from the nodes still to check
            currentNode =
                nodesToCheck.parallelStream()
                .min( (a, b) -> weightMap.get(a) - weightMap.get(b) )
                .get();
                
                
            
            //for every connection in current node
            for ( IArch<A> arch : currentNode.getArches() )
            {
                IGraphNode nextNode = arch.pointsTo();
                
                // if it has alraedy been checked, avoid checking it again
                if ( !nodesToCheck.parallelStream().anyMatch( node -> node.equals(nextNode)) )
                    continue;
                
                
                // total distance from source
                int totalDistance = weightMap.get(currentNode) + archWeightCalculationBehaviour.apply( arch.getMetadata() );

                // if the new calculated distance is less than the actual distance
                if ( totalDistance < weightMap.get( nextNode ) )
                {
                    weightMap.put( nextNode, totalDistance );
                    reversePathMap.put( nextNode , currentNode );

                    // if the destination has been reached, we're done
                    if ( stopAtDestination && (nextNode == destination) )
                        return;
                }
            }
            
            //removes current node from nodes to check
            nodesToCheck.remove(currentNode);
                        
        }
        
        //at this point it means the whole graph has been checked, therefore the map can't be incomplete
        this.weightMapIsIncomplete = false;
        
    }
        
}