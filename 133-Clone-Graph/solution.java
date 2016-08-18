/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // DFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // use a map to store all unique nodes
        HashMap<Integer, UndirectedGraphNode> map = new HashMap();
        return clone(node, map);
    }
    
    public UndirectedGraphNode clone(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
        if(node==null) return node;
        // this node has already been visited as a neighbor
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        // create new clone
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        map.put(res.label, res);
        for(UndirectedGraphNode neighbor : node.neighbors){
            res.neighbors.add(clone(neighbor, map));
        }
        return res;
    }
}