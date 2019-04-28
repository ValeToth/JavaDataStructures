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
public class Path< A > extends LinkedList<IGraphNode<?,A>> implements IPath<A>
{
    /*
        variables
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

    /**
     * 
     * @return the function used to calculate the weight of every arch
     */
    @Override 
    public Function<A, Integer> getCalculateArchWeight()
    {
        return archWeightCalculationBehaviour;
    }  
    
    /**
     * 
     * @return the source node ( o starting node ) of this path
     */
    @Override
    public IGraphNode<?, A> getSourceNode()
    {
        return this.getFirst();
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
    
    public Path()
    {
        this.archWeightCalculationBehaviour = ( A a ) -> 1 ;
    }
    
    public Path( Function<A, Integer> calculateArchWeight )
    {
        this.archWeightCalculationBehaviour = calculateArchWeight;
    }

    
    
    
    
    
    /*
        methods
    */
    
    
    /**
     * finds the shortest path between source and destination node. 
     * @param source
     * @param destination
     * @return
     * @throws PathNotFoundException 
     */
    @Override 
    public Path<A> shortestPath ( IGraphNode<?,A> source, IGraphNode<?,A> destination ) throws PathNotFoundException
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

    
    
    /**
     * calculates the weight to reach every node from source
     * @param source
     * @return 
     */
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
        Map<IGraphNode<?,A>,IGraphNode<?,A>> reversePathMap
    )
    {
      
        //a list of all reachable graphnodes
        LinkedList<IGraphNode<?,A>> reachableGraphNodes = new LinkedList<>( IGraphNode.reachableGraphnodes(source) );
           
        
        //maps every reachable node and the weight to reach it.
        this.weightMap = new HashMap<>();
        
        for ( IGraphNode<?,A> node : reachableGraphNodes )
            this.weightMap.put(node, Integer.MAX_VALUE );
        
        //inits source
        this.weightMap.put(source, 0);
        reachableGraphNodes.add(source);
        this.weightMapIsIncomplete = true;
        
        
        //finds shortest path
        IGraphNode<?,A> currentNode;
        
        // while there are nodes to check
        while ( !reachableGraphNodes.isEmpty() )
        {
            // the node with the minimum weight in the unchecked nodes
            currentNode =
                reachableGraphNodes.parallelStream()
                .min( (a, b) -> Integer.compare( weightMap.get(a) , weightMap.get(b) ))
                .get();
                
                
            
            //for every connection in current node
            for ( IArch<A> arch : currentNode.getArches() )
            {
                IGraphNode nextNode = arch.pointsTo();
                
                // if it has alraedy been checked, skip checking ir again
                if ( !reachableGraphNodes.contains( nextNode )) 
                    continue;
                
                // total distance from source
                int dist = weightMap.get(currentNode) + archWeightCalculationBehaviour.apply(arch.getData());
                
                // if the new calculated distance is less than the actual distance
                if ( dist < weightMap.get( nextNode ) )
                {
                    weightMap.put( nextNode, dist );
                    reversePathMap.put( nextNode , currentNode );
                    
                    if ( !stopAtDestination && (nextNode == destination) )
                        return;
                }

                
            }
            
            //removes current node from nodes to check
            reachableGraphNodes.remove(currentNode);
                        
        }
        
        //at this point it means the whole graph has been checked, therefore the map can't be incomplete
        this.weightMapIsIncomplete = false;
        
    }
        
}