public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if(prerequisites==null || prerequisites.length==0) return res;
        
        // add courses to graph as (pre, new Course)
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        for(int i=0; i<numCourses; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        
        for(int i=0; i<numCourses; i++){
            if(!dfs(graph, visited, i)){
                res.add(i);
            }
        }
        return res;
    }
    
     public boolean dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int newCourse){
        // System.out.println(newCourse);
        if(visited[newCourse]) return false;
        visited[newCourse] = true;
        //
        for(int i=0; i<graph.get(newCourse).size();i++){
                if(!dfs(graph,visited,(int)graph.get(newCourse).get(i)))
                    return false;
            }
        
        visited[newCourse] = false;
        return true;
    }
}