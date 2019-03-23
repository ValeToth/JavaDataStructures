/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import JDS.patterns.composite.IElement;
import java.util.*;
import java.util.function.*;


public class GraphNode<T> implements IGraphNode<T>
{

    private T content;
    private Function<T, IGraphNode<T>> func;
    private ArrayList<IArch> connections;
    
    
    
    @Override
    public T getContent()
    {
        return this.content;
    }

    @Override
    public void setContent( T content )
    {
        this.content = content;
    }
    
    @Override
    public Function<T, IGraphNode<T>> function()
    {
        return this.func;
    }

    @Override
    public Collection<? extends IArch> getArches()
    {
        return this.connections;
    }

    @Override
    public final Collection<? extends IGraphNode<T>> getSubElements()
    {
        ArrayList<IGraphNode<T>> out = new ArrayList<>();
        for ( IArch arch : this.connections )
            out.add( arch.pointsTo() );
        return out;
    }

    
    
    
    @Override
    public void addGraphNode( IGraphNode<T> node )
    {
        this.connections.add( new Arch(node) );
    }
    
    public GraphNode( IGraphNode<T>...connections )
    {
        for ( IGraphNode<T> node : connections)
            this.connections.add( new Arch<>(null,node) );
        
    }

    
    
    
    
    
    
    @Override
    public boolean containsRecursive( Predicate<IElement> predicate )
    {
        return IGraphNode.getAllGraphsRecursive( this ).stream().anyMatch(predicate);
    }

    @Override
    public Collection<IGraphNode> findRecursive( Predicate<IElement> predicate )
    {
        ArrayList<IGraphNode> out = new ArrayList<>();
        IGraphNode.getAllGraphsRecursive(this).stream().filter(predicate).forEach( el -> out.add(el) );
        return out;
    }
    
    
    
    
}
