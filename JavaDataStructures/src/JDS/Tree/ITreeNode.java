/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.Tree;

/**
 * base interface for TreeNodes
 * @author Jacopo_Wolf
 * @param <T> type of content
 */
public interface ITreeNode<T>
{
    T getContent();
    void setContent(T content);
}
