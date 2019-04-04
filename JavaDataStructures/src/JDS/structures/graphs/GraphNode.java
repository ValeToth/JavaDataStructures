/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import JDS.patterns.composite.IElement;
import java.util.*;
import java.util.function.Predicate;

/**
 * basic implementation for IGraphNode.
 * @author Jacopo_Wolf
 * @param <T> 
 * @param <A> 
 */
public class GraphNode<T,A> implements IGraphNode<T,A>
{

    /*
        variables
    */
    
    protected T content;
    protected ArrayList<IArch<A>> connections = new ArrayList<>();
    
    
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
     * @return a list of the arches which start from this node
     */
    @Override
    public Collection<? extends IArch<A>> getArches()
    {
        return this.connections;
    }

    


   
    /*
        constructurs
    */
    
    /**
     *  initializes a new Empty GraphNode
     */
    public GraphNode ()
    {
        
    }
    
    /**
     * initializes a new node and sets its content
     * @param content 
     */
    public GraphNode( T content )
    {
        this.content = content;
    }
    
    /**
     * initializes a new GraphNode
     * @param content
     * @param connections the connection to generate on initialization
     */
    public GraphNode( T content, IGraphNode<T,A>...connections )
    {
        this.content = content;
        for ( IGraphNode<T,A> node : connections)
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
    public void addGraphNode( IGraphNode<T,A> node )
    {
        this.connections.add( new Arch(node) );
    }
    
    /**
     * add a connection with empty parameters to this Node
     * @param node the node to add an arch to
     * @param archValue default arch value
     */
    @Override
    public void addGraphNode( IGraphNode<T, A> node, A archValue )
    {
        this.connections.add( new Arch<>(archValue, node) );
    }
    
    
    
    
    /**
     * 
     * @return the elements directly connected to this node
     */
    @Override
    public final Collection<? extends IGraphNode<T,A>> getSubElements()
    {
        ArrayList<IGraphNode<T,A>> out = new ArrayList<>();
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
        return IGraphNode.reachableGraphnodes( this ).stream().anyMatch(predicate);
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
        IGraphNode.reachableGraphnodes(this).stream().filter(predicate).forEach( el -> out.add(el) );
        return out;
    }    
    

    @Override
    public String toString()
    {
        return "GraphNode [ " + this.content.toString() + ", " + this.connections.size() + " connections ]";
    }
    
}