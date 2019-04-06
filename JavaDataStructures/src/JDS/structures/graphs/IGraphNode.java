/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import JDS.patterns.composite.IComposite;
import java.util.ArrayList;
import java.util.Collection;

/**
 * rappresents the node of a Graph
 * @author Jacopo_Wolf
 * @param <T>
 * @param <A>
 */
public interface IGraphNode<T,A> extends IComposite<T>

    /**
     * 
     * @return the arches starting from this node
     */
    public Collection<? extends IArch<A>> getArches();
    
    
    
    /**
     * add an IGraphNode to this node, with default Arch parameters.
     * @param node 
     */
    public void addGraphNode(IGraphNode<T,A> node);
    
    public void addGraphNode(IGraphNode<T,A> node, A archValue );
    
    
    /**
     * 
     * @return all the elements directly connected to this GraphNode.
     */
    @Override
    public Collection<? extends IGraphNode<T,A>> getSubElements();
    
    
    /**
     * finds every reachable graphnode from the starting node root
     * @param <E> type of root
     * @param root the root node
     * @return  all the reachable graphnodes from root
     */
    public static <E extends IGraphNode> Collection<E> reachableGraphnodes ( E root )
    {
        ArrayList<E> out = new ArrayList<>();
        IComposite.getAllRecursive( root, out);        
        return out;
    }
    
}
