Breadth First Search
====================

This algorithm allows you to search for a specific value in a graph (including trees). In it, we search first the
starting node, and then it's neighbors, that way we go from the closest nodes to the start to the farthest.

General Idea
============

In this algorithm we use a queue to keep the order in which we need to traverse the graph. Because the graph can have
loops, we need to keep a memory of which nodes we have already visited.

The algorithm would go something like this:

1. Add the starting node to the queue.
2. While there are elements inside the queue:
    1. Get the next node in the queue.
    2. Check if the current node is the element you are looking for, if so return it, if not:
        1. Mark the current node as visited.
        2. Add its neighbors to the queue.
3. if the queue empties with no return value, then the element was not present in the graph.

Complexity
==========

If: `n` is the number of nodes in the graph.

* Time complexity: `O(n)`
* Space complexity: `O(n)`