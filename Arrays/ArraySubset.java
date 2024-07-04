// 8 4
// 1 2 3 4 5 6 7 8
// 1 2 3 1

// output
// No

class Compute {
    public String isSubset( long a1[], long a2[], long n, long m) {
    ArrayList<Long>list=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            list.add(a1[i]);
        }
        
        for(int j=0;j<m;j++){
            if(!  list.contains(a2[j])){
                return "No";
            }
            else if(list.contains(a2[j])){
                list.remove(a2[j]);
            }
          
        }
        return "Yes";
    }
}









//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long n = Long.parseLong(stt.nextToken());
            long m = Long.parseLong(stt.nextToken());
            long a1[] = new long[(int)(n)];
            long a2[] = new long[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a1[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                a2[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Compute obj = new Compute();
            System.out.println(obj.isSubset( a1, a2, n, m));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


