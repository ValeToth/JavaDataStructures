/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

import java.util.*;


/**
 * Function used to calculate the next node.
 * Returns null if there's no way to go.
 * @author Jacopo_Wolf
 */
@FunctionalInterface
public interface FunctionalGraphNodeDelegate
{
    <T,A> FunctionalGraphNodeReturn<T,A> apply( T baseValue, T nodeValue , Collection< IArch<A> > directions );
    
    
    /**
     * wrapper class for multiple value return od FunctionalGraphNodeDelegate
     * @param <T>
     * @param <A> 
     */
    public class FunctionalGraphNodeReturn<T,A>
    {
        public final FunctionalGraphNode<T,A> nextNode;
        public final T modifiedData;

        public FunctionalGraphNodeReturn( FunctionalGraphNode<T, A> nextNode, T modifiedData )
        {
            this.nextNode = nextNode;
            this.modifiedData = modifiedData;
        }
        
        
        
    }
    
}
