public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=0 || prerequisites==null || prerequisites.length==0) return true;
        
        // build prerequisites as graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList();
        boolean[] visited = new boolean[numCourses];
        
        // initiate graph
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        
        // add all prerequisite courses to graph
        for(int i=0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        // if can't visit all edges(has cycle) return false
        for(int j=0; j<numCourses; j++){
            if(!dfs(graph, visited, j)) return false;
        }
        return true;
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