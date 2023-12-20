import java.util.Scanner;

class xogame {
    public static void main(String args[]) {
        System.out.println("enter size of the board ");
        Scanner a = new Scanner(System.in);

        int n = a.nextInt();
        int range = n * n;
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 0;
            }
        }

        int k = 1;
        int pos = 0;
        int result1 = 0, result2 = 0, result3 = 0, result4 = 0;

        while (k <= n * n) {
            if (k % 2 != 0) {
                // player 1
                System.out.println("player 1 enter the position: ");
                Scanner getpos = new Scanner(System.in);
                pos = getpos.nextInt();

                if (pos > 0 && pos <= n * n) {
                    int row = (pos - 1) / n;
                    int col = (pos - 1) % n;

                    if (board[row][col] == 0) {
                        board[row][col] = 1;
                        k++;
                        System.out.println("Updated board:");
                        displayBoard(n, board);
                    } else {
                        System.out.println("place already occupied");
                        k--;
                    }
                } else {
                    System.out.println("enter the position within 0 to " + range);
                    k--;
                }

                if ((n*2)-1<=k) {
                    result1 = rightdiagonal(n, board);
                    result2 = leftdiagonal(n, board);
                    result3 = rowcheck(n, board);
                    result4 = colcheck(n, board);
                }

                if (result1 > 0 || result2 > 0 || result3 > 0 || result4 > 0) {
                    System.out.println("player 1 won");
                    break;
                }
            } else {
                // player 2
                System.out.println("player 2 enter the position: ");
                Scanner getpos = new Scanner(System.in);
                pos = getpos.nextInt();

                if (pos > 0 && pos <= n * n) {
                    int row = (pos - 1) / n;
                    int col = (pos - 1) % n;

                    if (board[row][col] == 0) {
                        board[row][col] = 2;
                        k++;
			System.out.println("Updated board:");
                        displayBoard(n, board);
                    } else {
                        System.out.println("place already occupied");
                        k--;
                    }
                } else {
                    System.out.println("enter the position within 0 to " + range);
                    k--;
                }

               

                if ((n*2)-1<=k) {
                    result1 = rightdiagonal(n, board);
                    result2 = leftdiagonal(n, board);
                    result3 = rowcheck(n, board);
                    result4 = colcheck(n, board);
                }

                if (result1 > 0 || result2 > 0 || result3 > 0 || result4 > 0) {
                    System.out.println("player 2 won");
                    break;
                }
            }

            
        }
    }

    static void displayBoard(int n, int[][] board) {
        for (int l = 0; l < n; l++) {
            for (int g = 0; g < n; g++) {
                System.out.print(board[l][g] + " ");                     //player 1 row check working correct not column check
            }
            System.out.println();
        }
        System.out.println();
    }

   public static int rightdiagonal(int n, int[][] board) {
    int flag = 1;
    for (int i = 1; i < n; i++) {
        if (board[i][i] == board[0][0]) {
            flag++;
        } else {
            return 0;
        }
        if (flag == n) {
            return 1;
        }
    }
    return 0;
}

public static int leftdiagonal(int n, int[][] board) {
    int flag = 1;
    for (int i = 1; i < n; i++) {
        if (board[i][n - 1 - i] == board[0][n - 1]) {
            flag++;
        } else {
            return 0;
        }
        if (flag == n) {
            return 1;
        }
    }
    return 0;
}


    public static int rowcheck(int n, int[][] board) {
        int flag = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (board[i][0] == board[i][j]) {
                    flag++;
                }
                else
		{
                 return 0;
                }
                if (flag == n) {
                    return 1;
                }
            }
        }
        return 0;
    }

   public static int colcheck(int n, int[][] board) {
   for(int i=0;i<n;i++)
	{
		int flag=1;
		for(int j=1;j<n;j++)
		{
			if(board[0][i] == board[j][i])
			{
				flag++;
			}
			if(flag==n)
			{
				return 1;
			}
		}
      }
	return 0;


}
}
