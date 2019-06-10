/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs.paths;


import JDS.structures.graphs.*;

/**
 *
 * @author Jacopo_Wolf
 * @param <T>
 * @param <A>
 */
public interface IFunctionalPath<T,A> extends IPath<A,FunctionalGraphNode<T,A>>
{
    
    /**
     * 
     * @return if this path contains an infinite loop.
     */
    boolean hasInfiniteLoop();
    
    
    /**
     * calculate the path starting from the specified node.
     * @param root
     * @return 
     */
    IFunctionalPath<T,A> startFrom ( FunctionalGraphNode<T,A> root );
    
}
