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
    // the final list to return
    private HashSet< IElement > checked;
    private Queue< IElement > toCheck;
    
    private IElement current;
    
    /**
     * new instance of GraphNodeIterator starting from the specified Node
     * @param source
     */
    public CompositeIterator( IComposite source )
    {
        this.checked = new HashSet<>();
        this.toCheck = new LinkedList<>();
        
        this.toCheck.add(source);
        
        // processes source element
        this.next(); 
    }
    
    @Override
    public boolean hasNext()
    {
        return !this.toCheck.isEmpty();
    }

    @Override
    public E next()
    {

        current = toCheck.poll();
        checked.add(current);
        
        if ( current instanceof IComposite )
            ((IComposite)current)
            .getConnectedElements()
            .parallelStream()
            .filter( el -> !checked.contains(el) && !toCheck.contains(el) )
            .forEach( el -> toCheck.add((IElement)el) );
        
        return (E)current;
    }   
}
