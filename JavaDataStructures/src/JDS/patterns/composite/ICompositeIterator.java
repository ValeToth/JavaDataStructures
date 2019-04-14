/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;


import java.util.*;


/**
 *
 * @author JacopoWolf
 * @param <E>
 */
public interface ICompositeIterator<E extends IElement> extends Iterator< E >
{

    @Override
    public E next();

    @Override
    public boolean hasNext();
    
    
    
}
