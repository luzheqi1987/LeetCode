package lzq.leetcode.initial.normal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import lzq.leetcode.model.UndirectedGraphNode;

public class CloneGraph {
	/**
	 * Clone an undirected graph. Each node in the graph contains a label and a
	 * list of its neighbors.
	 * 
	 * 
	 * OJ's undirected graph serialization: Nodes are labeled uniquely.
	 * 
	 * We use # as a separator for each node, and , as a separator for node
	 * label and each neighbor of the node. As an example, consider the
	 * serialized graph {0,1,2#1,2#2,2}.
	 * 
	 * The graph has a total of three nodes, and therefore contains three parts
	 * as separated by #.
	 * 
	 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second
	 * node is labeled as 1. Connect node 1 to node 2. Third node is labeled as
	 * 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
	 * Visually, the graph looks like the following:
	 * 
	 * 1 / \ / \ 0 --- 2 / \ \_/
	 * 
	 * @param node
	 * @return
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		if (null == node) {
			return null;
		}
		Map<Integer, UndirectedGraphNode> visitTable = new HashMap<Integer, UndirectedGraphNode>();
		return clone(node, visitTable);
	}

	protected UndirectedGraphNode clone(UndirectedGraphNode node,
			Map<Integer, UndirectedGraphNode> table) {
		if (node == null)
			return null;

		if (table.containsKey(node.label))
			return table.get(node.label);

		UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
		// cache the new node, inorder to should not create it next time
		table.put(newnode.label, newnode);

		for (int i = 0; i < node.neighbors.size(); i++) {
			UndirectedGraphNode neighbor = clone(node.neighbors.get(i), table);
			newnode.neighbors.add(neighbor);
		}

		return newnode;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode u1 = new UndirectedGraphNode(0);
		ArrayList<UndirectedGraphNode> cpyneighbors = new ArrayList<UndirectedGraphNode>();
		cpyneighbors.add(u1);
		cpyneighbors.add(u1);
		u1.neighbors.addAll(cpyneighbors);
		new CloneGraph().cloneGraph(u1);
	}

}
