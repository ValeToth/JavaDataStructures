/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.patterns.composite;

import java.util.*;
import java.util.stream.*;

/**
 * abstract implementation of IComposite
 * @author Jacopo
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
