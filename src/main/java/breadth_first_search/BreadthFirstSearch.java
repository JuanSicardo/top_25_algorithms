package breadth_first_search;

import common.GraphNode;

import java.util.*;

public class BreadthFirstSearch {

    /*
     * This method receives a graph node inside a graph to search and a target value to search for.
     * If the target value is found in the graph, it returns an optional with the node that contains it, else it returns
     * an empty optional.
     *
     * This method is intended for graphs where all the values are unique to have a deterministic result.
     * This method can work with graphs with cycles.
     *
     * If GraphNode is null this method will throw a NullPointerException, not handling this exception by returning
     * and empty optional is done so bugs are more easily debugged.
     */
    public static Optional<GraphNode> breadthFirstSearch(GraphNode root, int target) {
        if(root == null)
            throw new IllegalArgumentException("Root cannot be null");

        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visitedNodes = new HashSet<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            if(currentNode.getValue() == target) return Optional.of(currentNode);

            for(GraphNode neighbor : currentNode.getNeighbors())
                if(!visitedNodes.contains(neighbor)) {
                    visitedNodes.add(neighbor);
                    queue.add(neighbor);
                }
        }

        return Optional.empty();
    }
}
