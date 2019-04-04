/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

/**
 *
 * @author JacopoWolf
 */
public class PathNotFoundException extends Exception
{
    private final IGraphNode source, destination;

    public IGraphNode getSource()
    {
        return source;
    }

    public IGraphNode getDestination()
    {
        return destination;
    }

    public PathNotFoundException( IGraphNode source, IGraphNode destination )
    {
        this.source = source;
        this.destination = destination;
    }

    public PathNotFoundException( IGraphNode source, IGraphNode destination, String message )
    {
        super(message);
        this.source = source;
        this.destination = destination;
    }
    
    
    
    
}
