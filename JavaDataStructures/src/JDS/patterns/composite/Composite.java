/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

import java.util.*;
import java.util.stream.*;

/**
 *
 * @author Jacopo
 * @param <T>
 */
public abstract class Composite<T> extends Element<T> implements IComposite<T>
{

    @Override
    public abstract Collection<? extends IElement> getSubElements();

    @Override
    public CompositeIterator<? extends IElement> iterator()
    {
        return new CompositeIterator<>(this);
    }

    @Override
    public Stream<? extends IElement> parallelStream()
    {
        ArrayList<? extends IElement> out = new ArrayList<>();
        IComposite.getAllRecursive(this, out, false);
        return out.stream();
    }

    @Override
    public Stream<? extends IElement> stream()
    {
        ArrayList<? extends IElement> out = new ArrayList<>();
        IComposite.getAllRecursive(this, out, false);
        return out.parallelStream();
    }
    
}
