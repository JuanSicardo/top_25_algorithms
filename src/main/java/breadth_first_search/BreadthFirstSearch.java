package breadth_first_search;

import common.GraphNode;

import java.util.Optional;

public class BreadthFirstSearch {

    /*
     * This method receives a graph node inside a graph to search and a target value to search for.
     * If the target value is found in the graph, it returns an optional with the node that contains it, else it returns
     * an empty optional.
     *
     * This method is intended for graphs where all the values are unique to have a deterministic result.
     * This method can work with graphs with cycles.
     *
     * If GraphNode is node this method will through a NullPointerException, not handling this exception by returning
     * and empty optional is done so bugs are more easily debugged.
     */
    public static Optional<GraphNode> breadthFirstSearch(GraphNode root, int target) {
        return Optional.empty();
    }
}
