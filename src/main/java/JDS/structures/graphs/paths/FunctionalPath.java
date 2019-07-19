/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs.paths;

import JDS.structures.graphs.*;
import java.util.*;

/**
 *
 * @author Jacopo
 * @param <T>
 * @param <A>
 */
public class FunctionalPath<T, A> extends ArrayList<FunctionalGraphNode<T,A>> implements IFunctionalPath<T, A>
{

    protected boolean inifiteLoop = false;
    
    @Override
    public boolean hasInfiniteLoop()
    {
        return this.inifiteLoop;
    }
    
    public FunctionalPath()
    {
        
    }

    

    @Override
    public IFunctionalPath<T, A> startFrom( FunctionalGraphNode<T, A> root )
    {
        this.clear();
        this.inifiteLoop = false;
        
        
        T currentData = null;
        FunctionalGraphNode<T,A> currentNode = root;
        this.add(root);
        
        do
        {
            FunctionalGraphNodeDelegate.FunctionalGraphNodeReturn<T,A> 
                calcResult = currentNode.getBehaviour().apply
                            (
                                currentData, 
                                currentNode.getContent(), 
                                currentNode.getArches() 
                            );
            
            if ( calcResult == null )
                break;
            
            currentData = calcResult.modifiedData;
            currentNode = calcResult.nextNode;
            
            if ( this.contains(currentNode) )
            {
                this.inifiteLoop = true;
                break;
            }
            
            this.add(currentNode);
            
        }
        while( currentNode != null );
            
        
        return this;
    }

    
}
