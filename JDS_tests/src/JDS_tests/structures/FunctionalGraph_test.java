/*
 * see licence at https://github.com/JacopoWolf/JavaDataStructures/blob/master/LICENSE
 */
package JDS_tests.structures;


import JDS.structures.graphs.*;
import JDS.structures.graphs.paths.*;


/**
 *
 * @author Jacopo_Wolf
 */
public class FunctionalGraph_test
{
    
    public static <T,A> void printPath ( FunctionalPath<T,A> path ) 
    {
        for ( IGraphNode node : path )
            System.out.print( "'" + node.getContent() + "'" + "->");
        
        System.out.println("\b\b");
    }
    
    
    public static void main( String[] args )
    {
        
        FunctionalGraphNodeDelegate<String, Integer> defaultBehaviour = 
                ( token , nodeValue, directions ) -> 
                {
                    for ( IArch<Integer> arch : directions )
                        if ( nodeValue.length() > ( token != null ? token.length() : 0 ) + arch.getMetadata() )
                            return new FunctionalGraphNodeDelegate.FunctionalGraphNodeReturn<>( arch.pointsTo(), nodeValue );
                    
                    return null;
                };
        
        
        FunctionalGraphNode<String, Integer> 
                a   =   new FunctionalGraphNode<>( "node  A", defaultBehaviour ),
                b   =   new FunctionalGraphNode<>( "nodeB", defaultBehaviour ),
                c   =   new FunctionalGraphNode<>( "node C", ( token, value, directions) -> null ),
                d   =   new FunctionalGraphNode<>( "nD", defaultBehaviour );
        
        a.addGraphNode( b , 1 ); a.addGraphNode( d , 3 );
        b.addGraphNode( c , 3 );
        c.addGraphNode( d );
        d.addGraphNode( c, 0 );
        
        
        FunctionalPath<String,Integer> path = new FunctionalPath<>();
        
        path.startFrom(a);
        
        printPath(path);
        
        
    }
}
