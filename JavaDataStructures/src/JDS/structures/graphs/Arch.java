/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS.structures.graphs;


public class Arch<T> implements IArch<T>
{
    private T data;
            IGraphNode pointsto;
    
    @Override
    public T getData()
    {
        return this.data;
    }
    public void setData( T data)
    {
        this.data = data;
    }

    
    @Override
    public IGraphNode pointsTo()
    {
        return this.pointsto;
    }
    
    

    public Arch( T data, IGraphNode pointsto )
    {
        this.data = data;
        this.pointsto = pointsto;
    }

    public Arch( IGraphNode pointsto )
    {
        this.data = null;
        this.pointsto = pointsto;
    }
    public Arch()
    {
        this.data = null;
        this.pointsto = null;
    }
    
    
    
    
    
}
