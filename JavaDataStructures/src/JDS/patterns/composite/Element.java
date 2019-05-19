/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

/**
 *
 * @author Jacopo
 * @param <T>
 */
public abstract class Element<T> implements IElement<T>
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
