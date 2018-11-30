package sudoku_ga3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GUI extends JFrame
{
   //edit this line to change input puzzle
   ReadingInput inPuzz = new ReadingInput("puzzA.txt");     //easy
   //ReadingInput inPuzz = new ReadingInput("puzzB.txt");   //medium
   //ReadingInput inPuzz = new ReadingInput("puzzC.txt");   //hard
   
   //edit this line to change puzzle to respective soln
   ReadingInput outPuzz = new ReadingInput("puzzA_soln.txt");
   //ReadingInput outPuzz = new ReadingInput("puzzB_soln.txt");
   //ReadingInput outPuzz = new ReadingInput("puzzC_soln.txt");
   
   private int [][] puzzle = inPuzz.getArray();
   private int [][] solution = outPuzz.getArray();
   private boolean[][] empty =new boolean[9][9];
   private JTextField[][] inputs = new JTextField[9][9];
   private JPanel[][] borders = new JPanel[3][3];
   private JPanel center_grid;
   private JPanel checkbutton;
   private JTextField check;
   private JButton submit;
   private JButton give_up;
   private long StartTime;
   private long endTime;
   private double time;
   private static int counter =0;

   public GUI()
   {

	super();
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//setLayout(new GridLayout(3,3));
	setLayout(new BorderLayout());
	setSize(900,900);	
	center_grid=new JPanel();
	center_grid.setLayout(new GridLayout(3,3));
	add(center_grid,BorderLayout.CENTER);
	checkbutton = new JPanel();
	add(checkbutton,BorderLayout.SOUTH);	
	check = new JTextField("Type 'c' to Check work");
	check.addKeyListener(new keylistener());
	check.addMouseListener(new mouselistener());
	check.setName("taher");
	checkbutton.add(check);
	submit = new JButton("Submit Solution");
	submit.setName("Solution Button");
	submit.addMouseListener(new mouselistener());
	checkbutton.add(submit);
	empty = mask(empty);

	give_up = new JButton("Give Up");
	give_up.addMouseListener(new mouselistener());
	give_up.setName("Give Up Button");
	checkbutton.add(give_up);
        StartTime = System.currentTimeMillis();



//	JPanel pane = new JPanel();
//	pane.setBorder(BorderFactory.createLineBorder(Color.black));

        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
		borders[i][j] = new JPanel();
		borders[i][j].setLayout(new GridLayout(3,3));
		borders[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
		center_grid.add(borders[i][j]);
            }


	for(int i=0;i<9;i++)
		for(int j=0;j<9;j++)
		{
		inputs[i][j] = new JTextField();
		inputs[i][j].setBorder(BorderFactory.createLineBorder(new Color(214,212,247)));
		inputs[i][j].setBackground(new Color(240,240,240));	
                inputs[i][j].setHorizontalAlignment(JTextField.CENTER);			
		inputs[i][j].setForeground(Color.BLACK);
		inputs[i][j].setFont(new Font("Monospaced",Font.BOLD,21));
		inputs[i][j].setFocusable(true);
		inputs[i][j].addActionListener(new Listener(inputs[i][j]));
		inputs[i][j].addKeyListener(new keylistener());
		inputs[i][j].setName(i+""+j+"");
                    if(puzzle[i][j]<=0)
                    {
                        inputs[i][j].setText("");
                        inputs[i][j].setEditable(true);			
                    }
                    else{
                        inputs[i][j].setText(puzzle[i][j]+"");
                        inputs[i][j].setEditable(false);
			}				
		}


for(int i=0;i<9;i++)
	for(int j=0;j<9;j++)
	{
		
		
		if(i>=0 && i<3 && j>=0 && j<3)
			borders[0][0].add(inputs[i][j]);
		if(i>=0 && i<3 && j>=3 && j<6)
			borders[0][1].add(inputs[i][j]);
		if(i>=0 && i<3 && j>=6 && j<9)
			borders[0][2].add(inputs[i][j]);



		if(i>=3 && i<6 && j>=0 && j<3)
			borders[1][0].add(inputs[i][j]);
		if(i>=3 && i<6 && j>=3 && j<6)
			borders[1][1].add(inputs[i][j]);
		if(i>=3 && i<6 && j>=6 && j<9)
			borders[1][2].add(inputs[i][j]);



		if(i>=6 && i<9 && j>=0 && j<3)
			borders[2][0].add(inputs[i][j]);
		if(i>=6 && i<9 && j>=3 && j<6)
			borders[2][1].add(inputs[i][j]);
		if(i>=6 && i<9 && j>=6 && j<9)
			borders[2][2].add(inputs[i][j]);
	}





}

private boolean[][] mask(boolean[][] arr)
{
    for(int i=0;i<9;i++)
        for(int j=0;j<9;j++)
        {
	if (puzzle[i][j]<=0)
            arr[i][j]=false;
	else
            arr[i][j]=true;
        }
	return arr;
}


private class mouselistener implements MouseListener
{
	public void mouseClicked(MouseEvent e)
	{
		
		check.setText("");
		
		String button;
		
		if((e.getSource()).getClass().getSimpleName().equals("JButton"))
			 button = ((JButton) e.getSource()).getName();		
		else
			button="";
			
        if(button.equals("Give Up Button"))
        {
        	for(int i=0;i<9;i++)
        		for(int j=0;j<9;j++)
        		{
        			inputs[i][j].setText(solution[i][j]+"");
        			inputs[i][j].setEditable(false);
        			if(!empty[i][j])
 						inputs[i][j].setForeground(Color.MAGENTA);
        		}
        }
        else if(button.equals("Solution Button"))        	
        {
        //	submit window = new submit();
        //	window.setVisible(true);
            
        	endTime = System.currentTimeMillis();
        	time = (endTime - StartTime) / 1000.0/60.0;
        	     //    System.out.println("\nElapsed Time is:  " + time);
                Formatter fmt = new Formatter();
    
                fmt = new Formatter();
                fmt.format("%6.2e", time);
    //System.out.println(fmt);

        	JOptionPane.showMessageDialog(new GUI(), "Thank You For Playing, Your overall play time was"+fmt+"[min]",  
                                          "Game End",  
                                          JOptionPane.INFORMATION_MESSAGE);	
        	
        	dispose();
        	System.exit(0);
        }
       
	}
	    
	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}




}

private class Listener implements ActionListener
{
	public Listener(JTextField input)
	{}


	public void actionPerformed(ActionEvent e)
	{}	


}


private class keylistener implements KeyListener
{


	   public void keyTyped(KeyEvent e) {

	   	check.setText("");
      
     //   System.out.println(e);
         
        
        
        	//e.consume();
        
    }

    
    public void keyPressed(KeyEvent e) {
    
    	int i=0,j=0;
    	String result;
        String index=((JTextField) e.getSource()).getName();

        i = (int) index.charAt(0);
        j = (int) index.charAt(1);

        if(e.getKeyChar()=='c' && index.equals("taher"))
        {	      
            for( i=0;i<9;i++)
        	for( j=0;j<9;j++)
        	{
                    result=inputs[i][j].getText();
                    if(!result.equals(""))
                    {
        		if( Integer.parseInt(result) == solution[i][j] )
        		{
                            inputs[i][j].setEditable(false);
                            inputs[i][j].setForeground(Color.GREEN);
                            empty[i][j]=true;
        		}
        		else
                        {
                            inputs[i][j].setForeground(Color.BLUE);
        		}

                    }
                }	


        }
        

if(!index.equals("taher")){
    //    System.out.println(i+"_"+j);
      	int arrow= e.getKeyCode();
      	        //System.out.println(e.getName());
     // System.out.println(Integer.parseInt(index.substring(1,2)));
      i = Integer.parseInt(index.substring(0,1));
      j=Integer.parseInt(index.substring(1,2));
        //  System.out.println(i+"_"+j);
      	switch(arrow)
      	{
      		case 38:
      			for(int k=i-1;k>=0;k--)
      			{	//System.out.println("hahah"+"_"+inputs[k][j].getText());
      			//	System.out.println(k+"____"+j);
      				if(inputs[k][j].getText().equals(""))
      					{	
      						inputs[k][j].requestFocusInWindow();
      						break;
      					}
      			}
      			break;

			case 40:
      			for(int k=i+1;k<=8;k++)
      			{	//System.out.println("hahah"+"_"+inputs[k][j].getText());
      				//System.out.println(k+"____"+j);
      				if(inputs[k][j].getText().equals(""))
      					{	
      						inputs[k][j].requestFocusInWindow();
      						break;
      					}
      			}
      			break;      	


      		case 39:
      				for(int k=j+1;k<=8;k++)
      			{	//System.out.println("hahah"+"_"+inputs[i][k].getText());
      			//	System.out.println(k+"____"+j);
      				if(inputs[i][k].getText().equals(""))
      					{	
      						inputs[i][k].requestFocusInWindow();
      						break;
      					}
      			}


      			break;

      	
      		case 37:
      				for(int k=j-1;k>=0;k--)
      			{	//System.out.println("hahah"+"_"+inputs[i][k].getText());
      			//	System.out.println(k+"____"+j);
      				if(inputs[i][k].getText().equals(""))
      					{	
      						inputs[i][k].requestFocusInWindow();
      						break;
      					}
      			}


      			break;



      	}



        
        }
      
    }

    
    public void keyReleased(KeyEvent e){}



}



}