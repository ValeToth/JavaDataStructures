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
    
    /**
     * Check if a Composite refers to an already checked Element when reading the structure.
     * If false might generate a stackOverflow but greately increase performance.
     */
    public boolean checkStackOverflow = true;
    
    private Iterator<E> iterator;

    
    /**
     * new instance of GraphNodeIterator starting from the specified Node
     * @param source
     */
    public CompositeIterator( IComposite source )
    {
        LinkedList<E> reachableNodes = new LinkedList<>();
        IComposite.getAllRecursive( source , reachableNodes, checkStackOverflow);
        this.iterator = reachableNodes.iterator();
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
