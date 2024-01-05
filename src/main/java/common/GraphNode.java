package common;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GraphNode {

    @Getter
    @Setter
    @NonNull
    private int value;

    @NonNull
    private Set<GraphNode> neighbors;

    public GraphNode(int value) {
        this.value = value;
        neighbors = new HashSet<>();
    }

    public GraphNode(int value, GraphNode[] neighbors) {
        this.value = value;
        this.neighbors = new HashSet<>();
        addNeighbors(neighbors);
    }

    public GraphNode(int value, Collection<GraphNode> neighbors) {
        this.value = value;
        this.neighbors = new HashSet<>();
        addNeighbors(neighbors);
    }

    public Set<GraphNode> getNeighbors() {
        return Collections.unmodifiableSet(neighbors);
    }

    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }

    public void addNeighbors(GraphNode[] neighbors) {
        Collections.addAll(this.neighbors, neighbors);
    }

    public void addNeighbors(Collection<GraphNode> neighbors) {
        this.neighbors.addAll(neighbors);
    }

    public void removeNeighbor(GraphNode neighbor) {
        neighbors.remove(neighbor);
    }

    public void removeAllNeighbors() {
        neighbors = new HashSet<>();
    }

    public boolean hasNeighbors() {
        return !neighbors.isEmpty();
    }
}
