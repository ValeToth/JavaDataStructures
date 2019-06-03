/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs.specific;

import JDS.structures.graphs.*;

/**
 * a path which uses Intger metadata.
 * @author Jacopo_Wolf
 */
public class WeightedPath extends Path< Integer >
{

    /**
     *  create a new instance of weighted path.
     */
    public WeightedPath(  )
    {
        super( (Integer i) -> Math.abs( i )  );
    }
    
}
