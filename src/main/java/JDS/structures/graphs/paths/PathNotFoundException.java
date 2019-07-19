/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs.paths;

import JDS.structures.graphs.IGraphNode;

/**
 * thrown when there's no possible path between two specified GraphNodes
 * 
 * @author JacopoWolf
 */
public class PathNotFoundException extends Exception
{
    
    private final IGraphNode    source, 
                                destination;

    /**
     * 
     * @return the source node
     */
    public IGraphNode getSource()
    {
        return source;
    }

    /**
     * 
     * @return the unreachable destination node
     */
    public IGraphNode getDestination()
    {
        return destination;
    }

    
    /**
     * new instance of PathNotFoundException
     * @param source source node
     * @param destination destination node
     */
    public PathNotFoundException( IGraphNode source, IGraphNode destination )
    {
        this.source = source;
        this.destination = destination;
    }

    /**
     * new instance of PathNotFoundException
     * @param source source node
     * @param destination destination node
     * @param message specify this exception's message
     */
    public PathNotFoundException( IGraphNode source, IGraphNode destination, String message )
    {
        super(message);
        this.source = source;
        this.destination = destination;
    }
    
    
    
    
}
