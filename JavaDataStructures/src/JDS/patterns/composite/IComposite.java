/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

import java.util.Collection;
import java.util.function.Predicate;

/**
 *
 * @author Jacopo_Wolf
 * @param <T>
 */
public interface IComposite<T> extends IElement<T>
{
    public Collection< ? extends IElement<T> > getSubElements();
    
    
    public boolean containsRecursive( Predicate<IElement<T>> predicate );
    
    public Collection< ? extends IElement<T> > findRecursive(Predicate<IElement<T>> predicate );
}
