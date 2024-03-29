/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;

/**
 * implements IArch, rappresents uniateral connection between two nodes.
 * @author Jacopo_Wolf
 * @param <A> The type of content 
 */
public class Arch<A> implements IArch<A>
{
    
    /**
     *  metadata contained in this arch
     */
    protected A metadata;

    /**
     * the node this arch points to
     */
    protected IGraphNode pointsto;

    
            

    @Override
    public A getMetadata()
    {
        return this.metadata;
    }
    
    /**
     * sets the metadata contained in this arch
     * @param metadata new metadata
     */
    public void setMetadata( A metadata )
    {
        this.metadata = metadata;
    }


    @Override
    public IGraphNode pointsTo()
    {
        return this.pointsto;
    }
    
    
    /**
     * initializes a new Arch
     * @param data set the metadata of the Arch
     * @param pointsto the node this Arch will point to
     */
    public Arch( A data, IGraphNode pointsto )
    {
        this.metadata = data;
        this.pointsto = pointsto;
    }
    /**
     * initializes a new Arch
     * @param pointsto the node this arch will point to
     */
    public Arch( IGraphNode pointsto )
    {
        this.metadata = null;
        this.pointsto = pointsto;
    }
    /**
     * initializes a new Arch
     */
    public Arch()
    {
        this.metadata = null;
        this.pointsto = null;
    }

    
    
    @Override
    public String toString()
    {
        return "Arch [ " + this.metadata.toString() + ", points to " + this.pointsto.toString() + " ]";
    }
    
    
    
    
    
    
}
