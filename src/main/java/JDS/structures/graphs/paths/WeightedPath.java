/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs.paths;

/**
 * a path which uses Intger metadata.
 * @author Jacopo_Wolf
 */
public class WeightedPath extends WeightMapPath< Integer >
{

    /**
     *  create a new instance of weighted path.
     */
    public WeightedPath(  )
    {
        super( (Integer i) -> Math.abs( i )  );
    }
    
}
