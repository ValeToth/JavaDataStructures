/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

import java.util.*;
import java.util.stream.*;


/**
 * base interface for Composite elements
 * @author Jacopo_Wolf
 * @param <T>
 */
public interface IComposite<T> extends IElement<T>, Iterable
{
    /**
     * 
     * @return the elements directly connected to this
     */
    public Collection<? extends IElement> getConnectedElements();

    
    /**
     * @return in iterator which'll iterate through every recursively reachable element
     * from this instance
     */
    @Override
    public CompositeIterator<? extends IElement> iterator();
    
    
    /**
     * 
     * @return a stream of every recursively reachable elements from this instance
     */
    public Stream<? extends IElement> stream();
    
    /**
     * 
     * @return a parallelStream of every recursively reachable elements from this instance
     */
    
    public Stream<? extends IElement> parallelStream();
    
    
    
    
    /*
        STATIC METHODS 
    */
    
    
    
    /**
     * returns all connected elements of root, checking for reference to already checked elements.
     * @param <A> the content of the elements
     * @param <Out> the type of the IElement in the out collection
     * @param root the root element
     * @return the collection of all reachable elements from root.
     */
    public static <A, Out extends IElement<A> > Collection<Out> getAll( IComposite<A> root )
    {   
        // the final list to return
        Collection<Out> out = new ArrayList<>();
        
        // variables for the research
        Queue< IComposite<A> > toCheck = new LinkedList<>();
        toCheck.add(root);
        
        IComposite<A> current;
        while ( (current = toCheck.poll()) != null )
        {
            for ( IElement<A> el : current.getConnectedElements()  )
            {
                if ( out.parallelStream().anyMatch( x -> x.equals(el) ) )
                    continue;
                    
                out.add((Out)el);
                
                if ( el instanceof IComposite )
                    toCheck.add((IComposite<A>)el);
            }
            
        }
        
        return out;
    }
    
    /**
     * recursively returns all sub elements of root, checking for reference to already checked elements only when specified.
     * if checkStackOverflow if false, the algorithm will be faster, but it doesn't guarantee error-free execution.
     * This means if the structure is not well constructed, this might generate a StackOverflowError.
     * @param <A> the content of the elements
     * @param <O> the IElement type of the out list
     * @param root the root element
     * @param out the Collection to wich add the elements
     * @param avoidLoops
     */
    public static <A, O extends IElement<A>> void getAllRecursive
        ( 
                IComposite<A> root, 
                Collection<O> out, 
                boolean avoidLoops 
        ) 
        throws StackOverflowError
    {
        for ( IElement<A> el : root.getConnectedElements() )
        {
            // doesn't check for second condition of the first is true.
            if ( !avoidLoops || !out.contains(el) ) 
            {
                out.add((O)el);
            
                if ( el instanceof IComposite )
                    IComposite.getAllRecursive( (IComposite<A>)el , out, avoidLoops );   
            }
        }
    }
}