# Applied Algorithm and Data Structure
## Increamental Algorithms - Convex Hull
Convex Hull is a polygon that encloses all of the points, the vertices maximize the area while minimizing the circumference. Following are two algorithms to calculate it.
- Grahm Scan
- Jarvis March (method I chose in assignment 1)
## Divide and Conquer
A divide-and-conquer algorithm recursively breaks down a problem into two or more sub-problems of the same or related type, until these become simple enough to be solved directly. The solutions to the sub-problems are then combined to give a solution to the original problem.
- Divide phase: Divide the problem into sub-problems
- Conquer phase: Conquer/solve the sub-problems (recursively)
- Combine phase: Combine the solutions to the sub-problems into a solution for the whole problem
    
Examples: Binary Search, Merge Sort, Quick Sort, etc.

We can use either The Master Theorem or The Iteration/Recursion-Tree Method to analyze the run time. 
## Dynamic Programming
Like divide-and-conquer, DP is an algorithmic technique for solving a problem by recursively breaking it down into simpler sub-problems, but it using result of the sub-problems to find the optimum solution of the main problem.

Comparison Example: Fibonacci Sequence
```java
public class Fibonacci {

  int divideAndConquerMethod(int n) {
    // base case
    if (n < 2) return n;
    else return divideAndConquerMethod(n - 1) + divideAndConquerMethod(n - 2);
  }

  int dynamicProgramingMethod(int n) {
    if (n <= 1) {
      return n;
    }
    int res = 0;
    int pre1 = 0;
    int pre2 = 1;
    for (int i = 2; i <= n; i++) {
      res = pre1 + pre2;
      pre1 = pre2;
      pre2 = res;
    }
    return res;
  }

}
```

Example 2: Longest Increasing Subsequence
```java
public class LongestIncreasingSub {

  public static void main(String[] args) {
    int[] example = new int[]{5, 2, 8, 6, 3, 6, 9, 7};
    dpMethod(example); // 2, 3, 6, 9 (or 7) (4 numbers in increasing order)
  }

  static void dpMethod(int[] list) {
    int length = 0;
    int[] dp = new int[list.length];
    Arrays.fill(dp, 1);
    for (int i = 1; i < list.length; i++) {
      for (int j = 0; j < i; j++) {
        if (list[i] > list[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    for (int c: dp) {
      length = Math.max(length, c);
    }
    System.out.println("Longest Increasing Subsequence length is " + length);
  }
}
```
## Greedy Algorithms
A greedy algorithm is a simple, intuitive algorithm that is used in optimization problems. The algorithm makes the optimal choice at each step as it attempts to find the overall optimal way to solve the entire problem. Greedy algorithms are quite successful in some problems, such as Huffman encoding which is used to compress data, or Dijkstra's algorithm, which is used to find the shortest path through a graph.

However, in many problems, a greedy strategy does not produce an optimal solution. For example, in the animation below, the greedy algorithm seeks to find the path with the largest sum. It does this by selecting the largest available number at each step. The greedy algorithm fails to find the largest sum, however, because it makes decisions based only on the information it has at any one step, without regard to the overall problem.
## NP-Completeness