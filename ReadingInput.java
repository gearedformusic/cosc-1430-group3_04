import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadingInput
{
	private int sudokuInputs[];
	// Reads the input from the file and puts into an int array.
	// *Note* make sure the text file is changed so its separated into 9 lines not just 1.
	public ReadingInput()
	{
		sudokuInputs = new int[81];
		Scanner scanner = null;
		try
		{
			scanner = new Scanner(new FileReader("samplesudoku1.txt"));
			while(scanner.hasNext())
			{
				for(int i = 0; i < 81; i++)
				{
					sudokuInputs[i] = scanner.nextInt();
				}
			}
			scanner.close();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	// Test to see if numbers in array.
	/*public static void main(String[] args)
	{
		ReadingInput a = new ReadingInput();
		for(int i = 0; i < 81; i++)
			System.out.println(a.sudokuInputs[i]);
	}*/
}
