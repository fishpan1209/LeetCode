public class Solution {
    // BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] degree = new int[numCourses];
        // if it's a pre course, count
        for(int i=0; i<prerequisites.length; i++) {
            degree[prerequisites[i][1]]++;
        }
        
        Queue<Integer> queue = new LinkedList();
        for(int i=0; i<numCourses; i++) {
            // courses not a pre to any other courses
            if(degree[i] == 0) queue.add(i);
        }
        
        while(!queue.isEmpty()) {
            int course = queue.poll();
            for(int i=0; i<prerequisites.length; i++) {
                if(prerequisites[i][0] == course) { // if found this course as a current one
                    degree[prerequisites[i][1]]--;  // decrease count of it's pre course
                    if(degree[prerequisites[i][1]] == 0) { // if the pre course of this current course is not a pre of any other course(taken this pair out), add to queue
                        queue.offer(prerequisites[i][1]);
                    }
                }
            }
        }
        
        for(int i=0; i<degree.length; i++) {
            if(degree[i] != 0) return false;
        }
        return true;
    }
    
    public void display(int[] output) {
        System.out.println(java.util.Arrays.toString(output));
    }
    /*
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // DFS/ topological sort
        // a list to store pre courses in topolotical order: pre->cur
        ArrayList[] DAG = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            DAG[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<prerequisites.length; i++) {
            DAG[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        
        // for each course, check if there's a cycle in the graph
        for(int i=0; i<numCourses; i++) {
            if (hasCycle(DAG, visited, i)) return false;
        }
        
        return true;
    }
    
    public boolean hasCycle(ArrayList[] DAG, boolean[] visited, int course) {
        // if it has been visited as current course, shouldn't see it again in pre
        if(visited[course]) return true;
        // else put current course to visited pool
        else visited[course] = true;
        
        for(int i=0; i<DAG[course].size(); i++) {
            if(hasCycle(DAG, visited, (int) DAG[course].get(i))) return true;
        }
        visited[course] = false;
        return false;
    }
    */
}
