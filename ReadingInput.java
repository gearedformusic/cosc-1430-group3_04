package sudoku_ga3;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadingInput
{
	private int sudokuInputs[][];
	// Reads the input from the file and puts into an int array.
	// *Note* make sure the text file is changed so its separated into 9 lines.
	// Default Constructor
	public ReadingInput()
	{
		sudokuInputs = new int[9][9];
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(new FileReader("samplesudoku1.txt"));
			while(scanner.hasNext())
			{
				for(int j = 0; j < 9; j++)
					for(int i = 0; i < 9; i++)
					{
						sudokuInputs[i][j] = scanner.nextInt();
					}
			}
			scanner.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
        
	// Constructor with an input
	public ReadingInput(String input)
	{
		sudokuInputs = new int[9][9];
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(new FileReader(input));
			while(scanner.hasNext())
			{
				for(int j = 0; j < 9; j++)
					for(int i = 0; i < 9; i++)
					{
                                        if (scanner.hasNext("\n")){
                                            scanner.skip("\n");
                                        }
					sudokuInputs[i][j] = scanner.nextInt();
					}
			}
			scanner.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	// Accessor for array
	public int[][] getArray()
	{
		return java.util.Arrays.copyOf(sudokuInputs, sudokuInputs.length);
	}
	public static void main(String[] args)
	{
		// Test to see if numbers in array
		/*
		ReadingInput a = new ReadingInput("samplesudoku2.txt");
		for(int i = 0; i < 9; i++)
		{
			System.out.println( );
			for(int j = 0; j < 9; j++)
				System.out.print(a.sudokuInputs[j][i]);
		}
		*/
		// Test getArray function
		/*
		ReadingInput a = new ReadingInput();
		int array[][] = a.getArray();
		for(int i = 0; i < 9; i++)
		{
			System.out.println( );
			for(int j = 0; j < 9; j++)
				System.out.print(array[j][i]);
		}
		*/
	}
}