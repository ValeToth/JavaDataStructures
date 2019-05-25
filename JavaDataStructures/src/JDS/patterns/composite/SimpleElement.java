/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

/**
 * Base implementation of the simple element.
 * @author JacopoWolf
 * @param <T>
 */
public abstract class SimpleElement<T> implements IElement<T>
{
    private T content;

    @Override
    public T getContent()
    {
        return this.content;
    }

    @Override
    public void setContent( T content )
    {
        this.content = content;
    }
    
}
