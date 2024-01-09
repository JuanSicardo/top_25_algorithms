package breadth_first_search;

import common.GraphNode;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BreadthFirstSearchTest {

    @Test
    void shouldThrowNullPointerExceptionIfRootIsNull() {
        assertThrows(NullPointerException.class, () -> BreadthFirstSearch.breadthFirstSearch(null, 156));
    }

    @Test
    void shouldReturnEmptyOptionalIfTargetCantBeFoundInOneNode() {
        GraphNode root = new GraphNode(-35);
        Optional<GraphNode> result = BreadthFirstSearch.breadthFirstSearch(root, 263);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnCorrectGraphNodeIfTargetCanBeFoundInOneNode() {
        GraphNode root = new GraphNode(0);
        Optional<GraphNode> result = BreadthFirstSearch.breadthFirstSearch(root, 0);

        assertTrue(result.isPresent());
        assertEquals(root, result.get());
    }

    @Test
    void shouldReturnEmptyOptionalIfTargetCantBeFoundInGraphWithoutLoops() {
        GraphNode nodeA = new GraphNode(366);
        GraphNode nodeB = new GraphNode(-12);
        GraphNode nodeC = new GraphNode(63);
        GraphNode nodeD = new GraphNode(885);
        GraphNode nodeE = new GraphNode(0);
        GraphNode nodeF = new GraphNode(669);
        GraphNode nodeG = new GraphNode(111111);
        GraphNode nodeH = new GraphNode(-6335);
        GraphNode nodeI = new GraphNode(7895);
        GraphNode nodeJ = new GraphNode(-333666);

        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeA.addNeighbor(nodeH);
        nodeB.addNeighbor(nodeD);
        nodeB.addNeighbor(nodeF);
        nodeC.addNeighbor(nodeE);
        nodeF.addNeighbor(nodeI);
        nodeI.addNeighbor(nodeG);
        nodeE.addNeighbor(nodeJ);

        Optional<GraphNode> result = BreadthFirstSearch.breadthFirstSearch(nodeA, 129);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnCorrectGraphNodeIfTargetCanBeFoundInGraphWithoutLoops() {
        int target = 932;

        GraphNode nodeA = new GraphNode(-6699);
        GraphNode nodeB = new GraphNode(468);
        GraphNode nodeC = new GraphNode(17);
        GraphNode nodeD = new GraphNode(0);
        GraphNode nodeE = new GraphNode(33665);
        GraphNode nodeF = new GraphNode(-10);
        GraphNode nodeG = new GraphNode(3669);
        GraphNode nodeH = new GraphNode(654654);
        GraphNode nodeI = new GraphNode(147836);
        GraphNode targetNode = new GraphNode(target);

        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeD);
        nodeB.addNeighbor(nodeI);
        nodeB.addNeighbor(nodeF);
        nodeD.addNeighbor(nodeE);
        nodeD.addNeighbor(nodeG);
        nodeC.addNeighbor(nodeH);
        nodeC.addNeighbor(targetNode);

        Optional<GraphNode> result = BreadthFirstSearch.breadthFirstSearch(nodeA, target);

        assertTrue(result.isPresent());
        assertEquals(targetNode, result.get());
    }

    @Test
    void shouldReturnEmptyOptionalIfTargetCantBeFoundInGraphWithLoops() {
        GraphNode nodeA = new GraphNode(5447);
        GraphNode nodeB = new GraphNode(155);
        GraphNode nodeC = new GraphNode(3669);
        GraphNode nodeD = new GraphNode(-885);
        GraphNode nodeE = new GraphNode(1);
        GraphNode nodeF = new GraphNode(-122);
        GraphNode nodeG = new GraphNode(-1);
        GraphNode nodeH = new GraphNode(6336);
        GraphNode nodeI = new GraphNode(-188);
        GraphNode nodeJ = new GraphNode(6599);

        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeA.addNeighbor(nodeJ);
        nodeB.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeE);
        nodeC.addNeighbor(nodeF);
        nodeJ.addNeighbor(nodeF);
        nodeF.addNeighbor(nodeD);
        nodeD.addNeighbor(nodeG);
        nodeD.addNeighbor(nodeH);
        nodeD.addNeighbor(nodeI);
        nodeI.addNeighbor(nodeA);

        Optional<GraphNode> result = BreadthFirstSearch.breadthFirstSearch(nodeA, -182);

        assertTrue(result.isEmpty());
    }

    @Test
    void shouldReturnCorrectGraphNodeIfTargetCanBeFoundInGraphWithLoops() {
        int target = 33;
        GraphNode nodeA = new GraphNode(6336);
        GraphNode nodeB = new GraphNode(-955);
        GraphNode nodeC = new GraphNode(34);
        GraphNode nodeD = new GraphNode(-8885);
        GraphNode nodeE = new GraphNode(336);
        GraphNode nodeF = new GraphNode(-2);
        GraphNode nodeG = new GraphNode(12);
        GraphNode nodeH = new GraphNode(366);
        GraphNode nodeI = new GraphNode(9663);
        GraphNode nodeTarget = new GraphNode(target);

        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);
        nodeA.addNeighbor(nodeD);
        nodeB.addNeighbor(nodeC);
        nodeB.addNeighbor(nodeE);
        nodeB.addNeighbor(nodeF);
        nodeC.addNeighbor(nodeG);
        nodeC.addNeighbor(nodeH);
        nodeC.addNeighbor(nodeC);
        nodeF.addNeighbor(nodeTarget);
        nodeTarget.addNeighbor(nodeI);
        nodeTarget.addNeighbor(nodeA);

        Optional<GraphNode> result = BreadthFirstSearch.breadthFirstSearch(nodeA, target);

        assertTrue(result.isPresent());
        assertEquals(nodeTarget, result.get());
    }
}