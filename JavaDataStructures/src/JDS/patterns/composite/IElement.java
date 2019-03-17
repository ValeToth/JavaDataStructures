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
    /**
     * 
     * @return the content of this element
     */
    T getContent();
    
    /**
     * sets the content to the param
     * @param content 
     */
    void setContent(T content);
}
