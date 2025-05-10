// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, 
// and city b is connected directly with city c, then city a is connected indirectly with city c.
// A province is a group of directly or indirectly connected cities and no other cities outside of the group.
// You are given an n x n matrix isConnected where isConnected[i][j] = 1
// if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
// Return the total number of provinces.

// Example 1:
// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2
// Example 2:
// Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int [] visited=new int[isConnected.length];
        int numOfProvince=0;
        for(int i=0;i<isConnected.length;i++){
                if(visited[i]==0){
                     dfs(isConnected,visited,i);
                        numOfProvince++;
                }
            }
            return numOfProvince;
        }
        
        private void dfs(int[][] isConnected, int []visited, int row){
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[row][j]==1 && visited[j]==0){
                    visited[j]=1;
                    dfs(isConnected,visited,j);
                }

            }
            
        }
}

-------------------
Time: O(n²)
Space: O(n) (due to visited[] and recursion stack)

------------Explanation------------------------------------
  
1. visited[] keeps track of cities that have already been explored.
2. Loop through each city i:
3. If it’s not visited, call dfs() to explore all cities in its province.
4. After the DFS, increment numOfProvince by 1.
5. dfs() marks all directly or indirectly connected cities from a starting city.



