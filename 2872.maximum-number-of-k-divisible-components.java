/*
 * @lc app=leetcode id=2872 lang=java
 *
 * [2872] Maximum Number of K-Divisible Components
 */

// @lc code=start
class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Map<Integer,List<Integer>> adjList = new HashMap<>() ;
        for(int i=0; i<n;i++)
            adjList.put(i, new ArrayList<>()) ;
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]) ;
            adjList.get(edge[1]).add(edge[0]) ;
        }
        long[] maxComponents = getDivisibleComponents(0, adjList, -1, k, values) ;
        return (int)maxComponents[0] ;
    }

    private long[] getDivisibleComponents(int curr, Map<Integer,List<Integer>> adjList, int parent, int k, int[] values){
        long child_component_count = 0;
        long child_sum = 0 ;
        for(int neighbor : adjList.get(curr)){
            if(neighbor == parent)
                continue ;
            long[] childComponents = getDivisibleComponents(neighbor, adjList, curr, k, values) ;
            child_component_count += childComponents[0] ;
            child_sum += childComponents[1] ;
        }
        long[] result = new long[2]  ;
        if((child_sum + values[curr])%k == 0){
            result[0] = child_component_count+1 ;
            result[1] = 0 ;
        }
        else{
            result[0] = child_component_count ;
            result[1] = child_sum + values[curr] ;
        }
        return result ;
    }
}
// @lc code=end

