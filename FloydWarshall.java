//James Panagis


package graph;

//When implementing the class we were discusing how would we should declare constant as a double positive infinity or not.
public class FloydWarshall
{
//constant INF for infinity( we thought this was more easier to implemnt)
private final static int INF = 999999999;

// The main function
public static void main(String[] args)
{      
    // The adjacency matrix
	int[][] adjacencyMatrix =
                {{0, 3, 8, INF, -4},
                {INF, 0, INF, 1, 7},
                {INF, 4, 0, INF, INF},
                {2, INF, -5, 0, INF},
                {INF, INF, INF, 6, 0}};
  
    int[][] shortestDistances = Floyd_Warshall(adjacencyMatrix);
  // Print text for the display
    System.out.println(" The Adjacency Matrix of Distance:");
    Display(adjacencyMatrix);
  
    System.out.println("\n\n The Pairwise Shortest Distance:");
    Display(shortestDistances);
}

// Implementing FloydWarshall function 
// For the implementing the function that we used the adj matric and set a temporrary int as the max int.

// What made this part difficult was forgeting the small parts like a ";" or an int
public static int[][] Floyd_Warshall(int[][] w)
{
    int n = w.length;
    int d[][] = new int[n][n];  
  
    for(int i = 0; i < n; i++){
        
        for(int j = 0; j < n; j++){
           
            d[i][j] = w[i][j];}
    }
  
    for(int k = 0; k < n; k++){
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < n; j++){
                if (d[i][k] + d[k][j] < d[i][j]){
                    d[i][j] = d[i][k] + d[k][j];}
}
 }
}
  
    return d;
}

// Implementing the display 

//This is used for displaying the shortest and matrix path for us to see through the print statement. 
public static void Display(int[][] d)
{
    int n = d.length;      
  
    for(int i = 0; i < n; i++)
        System.out.print("\t" + (i + 1));
    System.out.println("\n |******************************");
    
    for(int i = 0; i < n; i++){
        System.out.print((i+1) + " | ");
        
        for(int j = 0; j < n; j++){
            if(d[i][j] == INF)
                System.out.print( "\tINF");
            else
                System.out.print( "\t" + d[i][j]);}
        System.out.println(); }
} 

} 