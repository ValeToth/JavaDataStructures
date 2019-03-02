/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.Tree;

import java.util.stream.BaseStream;

/**
 *
 * @author Jacopo_Wolf
 * @param <Node> the type of node accepted by this tree
 */
public interface ITree< Node extends ITreeNode > extends BaseStream< Node, ITree<Node> > 
{
    
    public Node getNode();
    public void setNode( Node node );
    
}
