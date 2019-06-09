##### [Home](../README.md)
-----

# Patterns

## The Composite pattern
 "The composite pattern describes a group of objects that is treated the same way as a single instance of the same type of object. The intent of a composite is to "compose" objects into tree structures to represent part-whole hierarchies. Implementing the composite pattern lets clients treat individual objects and compositions uniformly."
 ###### from [Wikipedia](https://en.wikipedia.org/wiki/Composite_pattern)

<center>
<img src="CompositePattern.png" width="40%"  >

##### the composite pattern UML diagram
</center>
 

# Structures

### Graphs
"a graph is a structure amounting to a set of objects in which some pairs of the objects are in some sense related."
###### from [Wikipedia](https://en.wikipedia.org/wiki/Graph_(discrete_mathematics))


In this library graphs are based upon the __composite pattern__ and are of the __Directed__ type, meaning the edges (or arches) from node to node are unilateral.

#### Example
Nodes are called GraphNodes, and take to generic parameters:
- __T__ is the type of the _content_ of the Graph
- __A__ is the type of the _metadata of the Arch_ 

```java
GraphNode<T,A>
```

<br>

This is an example code to recreate the rappresented structure.

<center>
<img src="GraphExample.png" width="250px" alt="insert structure image here">
</center>

```java
GraphNode<String, Double> nodeA = new GraphNode<>("A");
GraphNode<String, Double> nodeB = new GraphNode<>("B");

nodeA.addGraphNode(nodeB, 10.0);
nodeB.addGraphNode(nodeA, 10.0);
```

let's now say you want to get a list of every node reachable from node _A_
```java
Collection<IGraphNode> nodesReachableFromA = IGraphNode.reachableGraphnodes( nodeA );
```
