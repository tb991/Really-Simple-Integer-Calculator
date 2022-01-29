import java.awt.*;
import javax.swing.*;
public class GUI{

	JFrame frame;
	JButton btn[]; // digit buttons
	JTextField ent;
	int btnCount = 0;
	int windowHeight;
	int windowWidth;
	public GUI(int width, int height, String command){
		frame = new JFrame("title");
		btn = new JButton[16];
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);

		if (command.equals("center")){
			//go(width, height);
			windowHeight = height;
			windowWidth = width;

			// prepare screen
			frame.setSize(width, height);
			// get scr dims
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();;
			frame.setLocation((int)screenSize.getWidth()/2 - width/2, (int)screenSize.getHeight()/2 - height/2);
	
			frame.setLayout(null);
			double btnHeight = 0.1;
			double btnWidth = 0.15;
			double initY = 0.05;
			double ySpacing = 0.12;
			double initX = 0.05;
			double xSpacing = 0.18;
			this.addBtn(initX, initY, btnWidth, btnHeight, "9");
			this.addBtn(initX + xSpacing, initY, btnWidth, btnHeight, "8");
			this.addBtn(initX+ 2*xSpacing, initY, btnWidth, btnHeight, "7");
		
			this.addBtn(initX, initY + ySpacing, btnWidth, btnHeight, "6");
			this.addBtn(initX + xSpacing, initY + ySpacing, btnWidth, btnHeight, "5");
			this.addBtn(initX + 2*xSpacing, initY + ySpacing, btnWidth, btnHeight, "4");

			this.addBtn(initX, initY + 2*ySpacing, btnWidth, btnHeight, "3");
			this.addBtn(initX + xSpacing, initY + 2*ySpacing, btnWidth, btnHeight, "2");
			this.addBtn(initX + 2*xSpacing, initY + 2*ySpacing, btnWidth, btnHeight, "1");

			this.addBtn(initX, initY+3*ySpacing, 2*xSpacing + btnWidth, btnHeight, "0");

			double nfWidth = (2*xSpacing + btnWidth)*width;
			double nfHeight = btnHeight*height;
			ent = new JTextField("");
			//print(String.valueOf(ent));
			ent.setSize( (int)nfWidth, (int) nfHeight);
			double x = initX*width;
			double y = height*(initY+3*ySpacing + ySpacing);
			ent.setLocation((int) x, (int)y);
			ent.setFont(new Font("Arial", Font.PLAIN, 30));
			frame.add(ent);

			this.addBtn(initX, (initY+5*ySpacing), 2*xSpacing + btnWidth, btnHeight, "PUSH");
			this.addBtn(initX, (initY+6*ySpacing), 2*xSpacing + btnWidth, 2*btnHeight-initY, "CLEAR");
			
			this.addBtn(initX + 3*xSpacing, initY, initX + 1-(4*xSpacing), ySpacing + btnHeight, "ADD");
			this.addBtn(initX + 3*xSpacing, initY+2*ySpacing, initX + 1-(4*xSpacing), ySpacing + btnHeight, "SUB");
			this.addBtn(initX + 3*xSpacing, initY+4*ySpacing, initX + 1-(4*xSpacing), ySpacing + btnHeight, "MULT");
			this.addBtn(initX + 3*xSpacing, initY+6*ySpacing, initX + 1-(4*xSpacing), 2*btnHeight-initY, "DIV");


			frame.setVisible(true);
		}

	}
	String currVal = "";
	// x, y, w, h: 0->100$ or 0-1, rightwards and downwards
	public void addBtn(double x, double y, double w, double h, String text){
		double xLoc, yLoc, width, height;
		xLoc = (x*(double)windowWidth);
		yLoc = ((double) y*windowHeight);
		width = (double)(w * windowWidth);
		height = (double) (h * windowHeight);

		//System.out.print(xLoc + " " + yLoc + " " + width + " " + height);
		btn[btnCount] = new JButton(text);
		btn[btnCount].setBounds((int)xLoc, (int)yLoc, (int)width, (int)height);
		btn[btnCount].setBackground(Color.BLUE);;
		btn[btnCount].setForeground(Color.WHITE);
		btn[btnCount].setFont(new Font("Arial", Font.PLAIN, 30));		/*
		btn[btnCount].addActionListener(e ->
		{
			String val = ((JButton)(e.getSource())).getText();
			if (!(currVal.equals("") && val.equals("0"))){
				currVal = currVal + val;
				this.ent.setText(currVal);
			}
			else{
				currVal = "";
				this.ent.setText("");
			}
		});
		*/ // this should be invokable
		frame.add(btn[btnCount]);
		btnCount++;
	}
	// display of the number
	private JTextField getEnt(){
		return this.ent;
	}
	public String getVal(){	
		JTextField j;
		j = this.getEnt();		
		String val = j.getText();
		return val;
	}
	public JButton getButton(String txt){
		JButton b = new JButton("blank");
		for (int i = 0; i < btnCount; i++){
			if (btn[i].getText().equals(txt)){
				b = btn[i];;
			}
		}
		if (b.getText().equals("blank")){
			b = null;
		}
		return b;
	}
	public void setVal(String newVal){	
		JTextField j;
		j = this.getEnt();		
		j.setText(newVal);
	}
	void print(String in){
		System.out.println(in);
	}
}