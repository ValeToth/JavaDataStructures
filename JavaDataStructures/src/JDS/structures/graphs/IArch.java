/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

/**
 *  an arch, the arrow pointing at another graph.
 * 
 * @author Jacopo_Wolf
 * @param <T>
 */
public interface IArch<T>
{
    /**
     * 
     * @return the information of this arch
     */
    public T getData();
    
    /**
     * 
     * @return the GraphNode this arch is pointing to
     */
    public IGraphNode pointsTo ();
    
}
