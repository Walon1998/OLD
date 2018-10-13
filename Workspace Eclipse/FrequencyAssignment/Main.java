//NB: Do not add a package

//NB: Importing and/or using classes in other packages is NOT ALLOWED
//(with the exception of java.lang.*)
import java.util.Scanner;

// NB: For the judge to run the program, do not modify the declaration of the class Main or
// method main() below. The class has to be declared as "class Main { ... }"
// and the method as "public static void main(String[] args) { ... }"
class Main
{		

	//N is the number of channels
	//m is the number of companies
	//For i,j>0 v[i][j] (resp. h[i][j]) contains the value v_{i,j} (resp. h_{i,j)} the the problem statement.
	//For i=0 or j=0 v[i][j] (resp. h[i][j]) is unused and is equal to 0.
	static int solve(int N, int m, int[][] v, int[][] h)
	{
		//TODO Solve the problem
		return 0;
	}
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int ntestcases = scanner.nextInt();
		
		for(int testno=0; testno<ntestcases; testno++)
		{			
			int N = scanner.nextInt();			
			int m = scanner.nextInt();
			
			int[][] v = new int[m+1][N+1];
			int[][] h = new int[m+1][N+1];

			for(int j=1; j<=m; j++)
			{
				for(int i=1; i<=N; i++)
					v[j][i] = scanner.nextInt();

				for(int i=1; i<=N-2; i++)
					h[j][i] = scanner.nextInt();
			}

			System.out.println(solve(N, m, v, h));
		}
		
		scanner.close();
	}
}
