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
public interface ICompositeIterator<E extends IElement> extends Iterator< E >
{

    /**
     * 
     * @return the next IElement in the list
     */
    @Override
    public E next();

    /**
     * 
     * @return if ther's a next element
     */
    @Override
    public boolean hasNext();    
}
