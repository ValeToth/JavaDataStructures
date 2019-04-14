/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import java.util.*;
import java.util.stream.*;

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
       
    

    @Override
    public GraphNodeIterator iterator()
    {
        return new GraphNodeIterator(this);
    }

    
    @Override
    public Stream<GraphNode<T,A>> stream()
    {
        return IGraphNode.reachableGraphnodes(this).stream();
    }
    
    @Override
    public Stream<GraphNode<T,A>> parallelStream()
    {
        return IGraphNode.reachableGraphnodes(this).stream();
    }
    
    
    
    
    

    @Override
    public String toString()
    {
        return "GraphNode [ " + this.content.toString() + ", " + this.connections.size() + " connections ]";
    }
    
}