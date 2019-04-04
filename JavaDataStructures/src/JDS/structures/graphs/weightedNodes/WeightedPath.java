/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs.weightedNodes;

import JDS.structures.graphs.*;

/**
 *
 * @author JacopoWolf
 * @param <N>
 */
public class WeightedPath< N extends IGraphNode<?, Integer> > extends Path< Integer , N >
{

    public WeightedPath(  )
    {
        super( (Integer i) -> i  );
    }
    
}
