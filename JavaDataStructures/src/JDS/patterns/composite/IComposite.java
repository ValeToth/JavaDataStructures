/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

import java.util.Collection;
import java.util.function.Predicate;

/**
 * basic interface for Composite elements
 * @author Jacopo_Wolf
 * @param <T>
 */
public interface IComposite<T> extends IElement<T>
{
    /**
     * 
     * @return the elements in this Composite
     */
    public Collection< ? extends IElement<T> > getSubElements();
    
    /**
     * 
     * @param predicate the condition 
     * @return if any subElement satisfies the predicate
     */
    public boolean containsRecursive( Predicate<IElement<T>> predicate );
    
    /**
     * 
     * @param predicate the condition
     * @return finds any subElement that satisfies the predicate
     */
    public Collection< ? extends IElement<T> > findRecursive(Predicate<IElement<T>> predicate );
   
    
    /*
        static methods
    */
    
    
    
    /**
     * recursively returns all sub elements of root, checking for reference to already inderted elements.
     * @param <A> the content of the elements
     * @param root the root element
     * @param out the Collection to wich add the elements
     */
    public static <A> void getAllRecursive( IComposite<A> root, Collection<IElement<A>> out)
    {   
        IComposite.getAllRecursive(root, out, true);
    }
    
    /**
     * recursively returns all sub elements of root, checking for reference to already inderted elements only when specified.
     * if checkStackOverflow if false, the algorithm will be faster, but it doesn't guarantee error-free execution.
     * This means if the structure is not well constructed, this might generate a StackOverflowError.
     * @param <A> the content of the elements
     * @param root the root element
     * @param out the Collection to wich add the elements
     * @param checkStackOverflow
     */
    public static <A> void getAllRecursive( IComposite<A> root, Collection<IElement<A>> out, boolean checkStackOverflow ) throws StackOverflowError
    {
        for ( IElement<A> el : root.getSubElements() )
        {
            // doesn't check for second condition of the first is true.
            if ( !checkStackOverflow || !out.contains(el) ) 
            {
                out.add(el);
            
                if ( el instanceof IComposite )
                    IComposite.getAllRecursive( (IComposite<A>)el , out, checkStackOverflow);   
            }
        }
    }

}
