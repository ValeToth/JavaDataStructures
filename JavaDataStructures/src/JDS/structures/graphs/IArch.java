/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

/**
 *  an arch, the arrow pointing at another graph.
 * 
 * @author Jacopo_Wolf
 * @param <A>
 */
public interface IArch<A>
{
    /**
     * 
     * @return the information of this arch
     */
    public A getMetadata();
    
    /**
     * 
     * @param <E> type of graphnode
     * @return the GraphNode this arch points to
     */
    public < E extends IGraphNode<?,A> > E pointsTo ( );

    
}
