/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

import java.util.*;
import java.util.stream.*;




/**
 * Base implementation of the composite element
 * @author JacopoWolf
 * @param <T>
 */
public abstract class CompositeElement<T> extends SimpleElement<T> implements IComposite<T>
{

    @Override
    public abstract Collection<? extends IElement> getConnectedElements();

    @Override
    public CompositeIterator<? extends IElement> iterator()
    {
        return new CompositeIterator<>(this);
    }

    @Override
    public Stream<? extends IElement> parallelStream()
    {
        return IComposite.getAll(this).parallelStream();
    }

    @Override
    public Stream<? extends IElement> stream()
    {
        return IComposite.getAll(this).stream();
    }
    
}
