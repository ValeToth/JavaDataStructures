/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;


/**
 * implements IArch, rappresents uniateral connection between two nodes.
 * @author Jacopo_Wolf
 * @param <T> The type of content 
 */
public class Arch<T> implements IArch<T>
{
    private T data;
            IGraphNode pointsto;
    
            
    /**
     * 
     * @return the data stored in this arch
     */
    @Override
    public T getData()
    {
        return this.data;
    }
    /**
     * sets the data contained in this arch
     * @param data new data
     */
    public void setData( T data)
    {
        this.data = data;
    }

    
    /**
     * 
     * @return the IGraphNode this Arch points to
     */
    @Override
    public IGraphNode pointsTo()
    {
        return this.pointsto;
    }
    
    
    /**
     * initializes a new Arch
     * @param data set the data of the Arch
     * @param pointsto the node this Arch will point to
     */
    public Arch( T data, IGraphNode pointsto )
    {
        this.data = data;
        this.pointsto = pointsto;
    }
    /**
     * initializes a new Arch
     * @param pointsto the node this arch will point to
     */
    public Arch( IGraphNode pointsto )
    {
        this.data = null;
        this.pointsto = pointsto;
    }
    /**
     * initializes a new Arch
     */
    public Arch()
    {
        this.data = null;
        this.pointsto = null;
    }
    
    
    
    
    
}
