/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import JDS.patterns.composite.IElement;
import java.util.*;
import java.util.function.*;

/**
 * basic implementation for IGraphNode.
 * @author Jacopo_Wolf
 * @param <T> 
 */
public class GraphNode<T> implements IGraphNode<T>
{

    /*
        variables
    */
    
    private T content;
    private Function<T, IGraphNode<T>> func;
    private ArrayList<IArch> connections;
    
    
    /**
     * 
     * @return this node's content
     */
    @Override
    public T getContent()
    {
        return this.content;
    }

    /**
     * set this node's content
     * @param content 
     */
    @Override
    public void setContent( T content )
    {
        this.content = content;
    }
    
    /**
     * 
     * @return the code to execute when deciding the next node
     */
    @Override
    public Function<T, IGraphNode<T>> function()
    {
        return this.func;
    }

    /**
     * 
     * @return a list of the arches which start from this node
     */
    @Override
    public Collection<? extends IArch> getArches()
    {
        return this.connections;
    }

    


   
    /*
        constructurs
    */
    
    /**
     * initializes a new GraphNode
     * @param connections the connection to generate on initialization
     */
    public GraphNode( IGraphNode<T>...connections )
    {
        for ( IGraphNode<T> node : connections)
            this.connections.add( new Arch<>(null,node) );
        
    }

    
    /*
        methods
    */
    
    /**
     * add a connection with empty parameters to this Node
     * @param node the node to add an arch to
     */
    @Override
    public void addGraphNode( IGraphNode<T> node )
    {
        this.connections.add( new Arch(node) );
    }
    
    /**
     * 
     * @return all the elements reachable from this node
     */
    @Override
    public final Collection<? extends IGraphNode<T>> getSubElements()
    {
        ArrayList<IGraphNode<T>> out = new ArrayList<>();
        for ( IArch arch : this.connections )
            out.add( arch.pointsTo() );
        return out;
    }
    
    /**
     * returns if the specified element is reachable from this node
     * @param predicate
     * @return if the node is reachable
     */
    @Override
    public boolean containsRecursive( Predicate<IElement> predicate )
    {
        return IGraphNode.getAllGraphsRecursive( this ).stream().anyMatch(predicate);
    }

    /**
     * seaches through all the reachable Nodes
     * @param predicate the condition to satisfy
     * @return a collection of the GraphNodes which satisfy the predicate
     */
    @Override
    public Collection<IGraphNode> findRecursive( Predicate<IElement> predicate )
    {
        ArrayList<IGraphNode> out = new ArrayList<>();
        IGraphNode.getAllGraphsRecursive(this).stream().filter(predicate).forEach( el -> out.add(el) );
        return out;
    }
    
    
    
    
}
