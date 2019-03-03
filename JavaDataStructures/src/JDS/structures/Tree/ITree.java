/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.Tree;

import java.util.stream.Stream;

/**
 *
 * @author Jacopo_Wolf
 * @param <Node> the type of node accepted by this tree
 */
public interface ITree< Node extends ITreeNode >
{
    
    public Node getRoot();
    public void setRoot( Node node );
    
    public Stream< Node > getAllNodesStream();
    
}
