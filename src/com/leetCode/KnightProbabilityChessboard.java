package com.leetCode;

/*
On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).
A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.
Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.
 */

public class KnightProbabilityChessboard {
    // array with moves for x and y co-ordinates. the possible locations where the knight can move
    private static int[] xMoves = new int[]{1,2,2,1,-1,-2,-2,-1};
    private static int[] yMoves = new int[]{2,1,-1,-2,-2,-1,1,2};

    public static void main(String args[]){
        System.out.print(knightProbability(3,2,0,0));
        System.out.print(knightProbability(1,1,0,0));
    }

    //function to check whether the move made is inside the chessboard
    public static boolean inside(int x, int y, int N){
        if(x >= 0 && x <N && y >=0 && y <N) return true;
        return false;
    }

    public static double knightProbability(int N, int K, int r, int c){

        // 3D array to store the probabilities. Can make use of 2 2D arrays, will have to keep storing and updating
        //the two arrays as you only need the current and previous array to calculate
        double dp[][][] = new double[N][N][K+1];

        //probability of staying inside the chessboard with 0 steps is 1 hence initialising k=0 to 1
        for(int i = 0; i<N;i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j][0] = 1;
            }
        }
        //iterate from calculating for k=1 moves
        //calculate the probability of each location. This is bottom up approach, here we are calculating
        //the probability of reaching to the current location rather than calculating the probability of
        //going to a particular location. Which is the way you'll think at first. Think ulta. Always try to think ulta
        //in such problems.
        for(int s = 1; s <= K; s++){
            for(int x = 0; x < N; x++){
                for(int y = 0; y < N; y++){
                    double probability = 0.0;
                    for(int i = 0; i <8;i++){
                        int nextX = x+xMoves[i];
                        int nextY = y+yMoves[i];

                        if(inside(nextX,nextY,N)){
                            probability = probability + (dp[nextX][nextY][s-1])/8.0;
                        }
                    }
                    dp[x][y][s] = probability;
                }
            }
        }
        //finally returning the probability of the start location.
        return dp[r][c][K];
    }

}
