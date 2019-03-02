/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.Tree;

import java.util.Collection;

/**
 * base interface for TreeNodes
 * @author Jacopo_Wolf
 * @param <T> type of content
 */
public interface ITreeNode<T> extends Collection< ITreeNode<T> >
{
    T getContent();
    void setContent(T content);
    
    boolean hasNeighbors();
}
