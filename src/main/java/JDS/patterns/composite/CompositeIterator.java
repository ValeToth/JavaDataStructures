/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;


import java.util.*;


/**
 * the iterator of a composite Element
 * @author JacopoWolf
 * @param <E>
 */
public class CompositeIterator< E extends IElement > implements Iterator< E >
{

    
    private Iterator<E> iterator;

    
    /**
     * new instance of GraphNodeIterator starting from the specified Node
     * @param source
     */
    public CompositeIterator( IComposite source )
    {
        this.iterator = IComposite.getAll(source).iterator();
    }
    
    @Override
    public boolean hasNext()
    {
        return iterator.hasNext();
    }

    @Override
    public E next()
    {
        return iterator.next();
    }   
}
