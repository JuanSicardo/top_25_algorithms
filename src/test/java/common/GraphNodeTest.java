package common;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphNodeTest {

    @Test
    void shouldModifyGraphNodeValue() {
        int newValue = -136;

        GraphNode graphNode = new GraphNode(1963);
        graphNode.setValue(newValue);

        assertEquals(newValue, graphNode.getValue());
    }

    @Test
    void shouldCreateGraphNodeWithValueOnlyThenGetValueAndEmptyNeighborSet() {
        int value = 117;

        GraphNode graphNode = new GraphNode(value);

        assertEquals(value, graphNode.getValue());
        assertTrue(graphNode.getNeighbors().isEmpty());
    }

    @Test
    void shouldCreateGraphNodeWithNeighborArrayThenGetNeighbors() {
        GraphNode[] neighbors = new GraphNode[]{
                new GraphNode(1901),
                new GraphNode(-1963),
                new GraphNode(0)
        };

        GraphNode graphNode = new GraphNode(-900, neighbors);

        List<GraphNode> neighborsAsList = Arrays.asList(neighbors);
        graphNode.getNeighbors().forEach((GraphNode retrievedNeighbor) ->
                assertTrue(neighborsAsList.contains(retrievedNeighbor))
        );
    }

    @Test
    void shouldCreateGraphNodeWithNeighborCollectionThenGetNeighbors() {
        List<GraphNode> neighbors = new ArrayList<>() {{
            add(new GraphNode(932));
            add(new GraphNode(-1948));
            add(new GraphNode(-36));
        }};

        GraphNode graphNode = new GraphNode(0, neighbors);

        graphNode.getNeighbors().forEach((GraphNode retrievedNeighbor) ->
                assertTrue(neighbors.contains(retrievedNeighbor))
        );
    }

    @Test
    void shouldReturnFalseWhenGraphNodeHasNoNeighbors() {
        GraphNode graphNode = new GraphNode(4654);

        assertFalse(graphNode.hasNeighbors());
    }

    @Test
    void shouldReturnTrueWhenGraphNodeHasNeighbors() {
        GraphNode graphNode = new GraphNode(666333);
        graphNode.addNeighbor(new GraphNode(4694654));

        assertTrue(graphNode.hasNeighbors());
    }

    @Test
    void shouldCreateGraphNodeWithoutNeighborsThenAddOneNeighbor() {
        GraphNode neighborToAdd = new GraphNode(363);

        GraphNode graphNode = new GraphNode(-87);
        graphNode.addNeighbor(neighborToAdd);

        graphNode.getNeighbors().forEach((GraphNode retrievedNeighbor) ->
                assertEquals(neighborToAdd, retrievedNeighbor)
        );
    }

    @Test
    void shouldCreateGraphNodeWithNeighborsThenAddOneNeighbor() {
        List<GraphNode> neighbors = new ArrayList<>() {{
            add(new GraphNode(7325689));
            add(new GraphNode(-196548));
            add(new GraphNode(0));
        }};
        GraphNode neighborToAdd = new GraphNode(65798);

        GraphNode graphNode = new GraphNode(633, neighbors);
        graphNode.addNeighbor(neighborToAdd);

        assertTrue(graphNode.getNeighbors().contains(neighborToAdd));
        graphNode.getNeighbors().forEach((GraphNode retrievedNeighbor) ->
                assertTrue(neighbors.contains(retrievedNeighbor) || retrievedNeighbor.equals(neighborToAdd))
        );
    }

    @Test
    void shouldCreateNodeGraphWithoutNeighborsThenAddVariousNeighbors() {
        List<GraphNode> neighbors = new ArrayList<>() {{
            add(new GraphNode(366));
            add(new GraphNode(6546));
            add(new GraphNode(-8765684));
        }};
        GraphNode[] neighborsToAdd = new GraphNode[]{
                new GraphNode(65465),
                new GraphNode(-654654),
                new GraphNode(0)
        };
        List<GraphNode> neighborsToAddAsList = Arrays.asList(neighborsToAdd);

        GraphNode graphNode = new GraphNode(69982, neighbors);
        graphNode.addNeighbors(neighborsToAdd);

        neighborsToAddAsList.forEach((GraphNode addedNeighbor) ->
                assertTrue(graphNode.getNeighbors().contains(addedNeighbor))
        );
        graphNode.getNeighbors().forEach((GraphNode retrievedNeighbor) ->
                assertTrue(neighbors.contains(retrievedNeighbor) || neighborsToAddAsList.contains(retrievedNeighbor))
        );
    }

    @Test
    void shouldCreateNodeGraphWithoutNeighborsThenAddVariousNeighborsInCollection() {
        List<GraphNode> neighbors = new ArrayList<>() {{
            add(new GraphNode(366));
            add(new GraphNode(6546));
            add(new GraphNode(-8765684));
        }};
        List<GraphNode> neighborsToAdd = new ArrayList<>() {{
            add(new GraphNode(65465));
            add(new GraphNode(-654654));
            add(new GraphNode(0));
        }};

        GraphNode graphNode = new GraphNode(69982, neighbors);
        graphNode.addNeighbors(neighborsToAdd);

        neighborsToAdd.forEach((GraphNode addedNeighbor) ->
                assertTrue(graphNode.getNeighbors().contains(addedNeighbor))
        );
        graphNode.getNeighbors().forEach((GraphNode retrievedNeighbor) ->
                assertTrue(neighbors.contains(retrievedNeighbor) || neighborsToAdd.contains(retrievedNeighbor))
        );
    }

    @Test
    void shouldCreateGraphNodeWithNeighborsAndRemoveOne() {
        GraphNode neighborToRemove = new GraphNode(5454);
        List<GraphNode> otherNeighbors = new ArrayList<>() {{
            add(new GraphNode(635));
            add(new GraphNode(0));
        }};
        List<GraphNode> neighbors = new ArrayList<>() {{
            add(neighborToRemove);
            addAll(otherNeighbors);
        }};

        GraphNode graphNode = new GraphNode(654, neighbors);
        graphNode.removeNeighbor(neighborToRemove);

        graphNode.getNeighbors().forEach((GraphNode retrievedNeighbor) ->
                assertTrue(otherNeighbors.contains(retrievedNeighbor))
        );
    }

    @Test
    void shouldCreateGraphNodeWithNeighborsAndRemoveAll() {
        List<GraphNode> neighbors = new ArrayList<>() {{
            add(new GraphNode(635));
            add(new GraphNode(0));
            add(new GraphNode(654654));
        }};

        GraphNode graphNode = new GraphNode(3546, neighbors);
        graphNode.removeAllNeighbors();

        assertTrue(graphNode.getNeighbors().isEmpty());
    }
}