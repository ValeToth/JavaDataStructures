/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

/**
 *
 * @author Jacopo_Wolf
 * @param <T>
 */
public interface IElement<T>
{
    T getContent();
    void setContent(T content);
    
}
