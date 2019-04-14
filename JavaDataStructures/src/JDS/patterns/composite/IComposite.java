/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

import java.util.*;
import java.util.stream.*;


/**
 * basic interface for Composite elements
 * @author Jacopo_Wolf
 * @param <T>
 */
public interface IComposite<T> extends IElement<T>, Iterable< IElement >
{
    /**
     * 
     * @return the elements in this Composite
     */
    public Collection< ? extends IElement > getSubElements();

    /**
     * 
     * @return 
     */
    @Override
    public ICompositeIterator iterator();
    
    /**
     * 
     * @return 
     */
    public Stream<? extends IElement> stream();
    
    public Stream<? extends IElement> parallelStream();
    
    
    /*
        STATIC METHODS 
    */
    
    
    
    /**
     * recursively returns all sub elements of root, checking for reference to already inderted elements.
     * @param <A> the content of the elements
     * @param <O> the IElement type of the out list
     * @param root the root element
     * @param out the Collection to wich add the elements
     */
    public static <A, O extends IElement<A>> void getAllRecursive( IComposite root, Collection<O> out )
    {   
        IComposite.getAllRecursive(root, out, true);
    }
    
    /**
     * recursively returns all sub elements of root, checking for reference to already inderted elements only when specified.
     * if checkStackOverflow if false, the algorithm will be faster, but it doesn't guarantee error-free execution.
     * This means if the structure is not well constructed, this might generate a StackOverflowError.
     * @param <A> the content of the elements
     * @param <O> the IElement type of the out list
     * @param root the root element
     * @param out the Collection to wich add the elements
     * @param checkStackOverflow
     */
    public static <A, O extends IElement<A>> void getAllRecursive
        ( 
                IComposite<A> root, 
                Collection<O> out, 
                boolean checkStackOverflow 
        ) 
        throws StackOverflowError
    {
        for ( IElement<A> el : root.getSubElements() )
        {
            // doesn't check for second condition of the first is true.
            if ( !checkStackOverflow || !out.contains(el) ) 
            {
                out.add((O)el);
            
                if ( el instanceof IComposite )
                    IComposite.getAllRecursive( (IComposite<A>)el , out, checkStackOverflow);   
            }
        }
    }
        
    

}