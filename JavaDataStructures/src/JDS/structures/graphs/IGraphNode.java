/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import JDS.patterns.composite.IComposite;
import JDS.patterns.composite.IElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

/**
 * rappresents the node of a Graph
 * @author Jacopo_Wolf
 * @param <T>
 */
public interface IGraphNode<T> extends IComposite<T>
{
    /**
     * the operation this node will do when called
     * @return a connected node basing on function.
     */
    public Function<T,IGraphNode<T>> function();
    
    
    /**
     * 
     * @return the arches starting from this node
     */
    public Collection<? extends IArch> getArches();
    
    /**
     * add an IGraphNode to this node, with default Arch parameters.
     * @param node 
     */
    public void addGraphNode(IGraphNode<T> node);
            
    
    @Override
    public Collection<? extends IGraphNode<T>> getSubElements();
    
    
    /**
     * puts every reachable GraphNode in out
     * @param root
     * @return  
     */
    public static Collection<IGraphNode> getAllGraphsRecursive ( IGraphNode root )
    {
        ArrayList<IElement> tmp = new ArrayList<>();
        JDS.patterns.composite.IComposite.getAllRecursive(root, tmp );
        
        ArrayList<IGraphNode> out = new ArrayList<>();
        tmp.forEach( el -> out.add((IGraphNode)el) );
        
        return out;
    }
    
}
