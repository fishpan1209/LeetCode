/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    
    // BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null) return node;
        // use a map to avoid duplicate
        HashMap<Integer, UndirectedGraphNode> map = new HashMap();
        UndirectedGraphNode res = new UndirectedGraphNode(node.label);
        
        map.put(res.label, res);
        
        // create a queue to store all nodes
        LinkedList<UndirectedGraphNode> queue = new LinkedList();
        queue.add(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode current = queue.pop();
            for(UndirectedGraphNode neighbor : current.neighbors){
                // if not visited, add to map and queue
                if(!map.containsKey(neighbor.label)){
                    // must create a new graph node
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                // else add this node as a neighbor of current node
                map.get(current.label).neighbors.add(map.get(neighbor.label));
            }
        }
        return res;
    }
    /*
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
    */
}