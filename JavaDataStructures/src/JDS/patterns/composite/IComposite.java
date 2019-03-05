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
    public Collection< ? extends IElement<T> > getSubElements();
    
    
    public boolean containsRecursive( Predicate<IElement<T>> predicate );
    
    public Collection< ? extends IElement<T> > findRecursive(Predicate<IElement<T>> predicate );
   
    /**
     * recursively returns all sub elements of root
     * @param <A> the content of the elements
     * @param root the root element
     * @param out the Collection to wich add the elements
     */
    public static <A> void getAllRecursive( IComposite<A> root, Collection<IElement<A>> out )
    {
        for ( IElement<A> el : root.getSubElements() )
        {
            out.add(el);
            
            if ( el instanceof IComposite )
                IComposite.getAllRecursive( (IComposite<A>)el , out);
        }
    }

}
