/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.tree;

import java.util.*;

/**
 *
 * @author Jacopo_Wolf
 * @param <Node> the type of node accepted by this tree
 * @param <T>
 */
public interface ITree< Node extends ITreeNode, T >
{
 
    /**
     * 
     * @return the root node
     */
    public Node getRoot();
    
    /**
     * sets the root node
     * @param node the new root node
     */
    public void setRoot( Node node );
    
    
    /**
     * 
     * @return evey ITreeNode in this Tree
     */
    public Collection< ITreeNode<T> > getAllNodes();
    
}
