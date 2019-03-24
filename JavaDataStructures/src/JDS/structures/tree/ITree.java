/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.tree;

import java.util.Collection;

/**
 *
 * @author Jacopo_Wolf
 * @param <Node> the type of node accepted by this tree
 * @param <T>
 */
public interface ITree< Node extends ITreeNode, T >
{
    
    public Node getRoot();
    public void setRoot( Node node );
    
    public Collection< ITreeNode<T> > getAllNodes();
    
}
