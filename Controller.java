
class Controller{

	public static void main(String[] args){
	}
	public Controller(Model m, GUI v){
		changeText(v, "");
		// add some response to each digit
		makeDigitsClickable(v, m);
		makeOpsClickable(v, m);
	}
	static String digits = "0123456789";
	private static void makeDigitsClickable(GUI g, Model m){
		for (int i = 0; i < digits.length(); i++){
			addBtnResponse(g, String.valueOf(digits.charAt(i)), m);
		}
	}
	static String[] ops = {"ADD", "SUB", "DIV", "MULT", "CLEAR", "PUSH"};
	private static void makeOpsClickable(GUI g, Model m){
		for (int i = 0; i < ops.length; i++){
			addBtnResponse(g, ops[i], m);
		}
	}

	private static boolean changeText(GUI calc, String newStr){
		calc.setVal(newStr);
		return true;
	}
	private static void addBtnResponse(GUI g, String btnText, Model m){
		g.getButton(btnText).addActionListener(e ->
		{
			System.out.println(btnText);
			if (btnText.length() == 1 && digits.contains(btnText)){
				System.out.println("Digit press detected");
				g.setVal(g.getVal()+btnText);
				//System.out.println("A update: " + String.valueOf(m.getA()));
			}
			else if (ops[5].equals(btnText) && !g.getVal().equals("")){ // push
				m.setOp("PUSH");
				m.exec(Integer.parseInt(g.getVal()));
				g.setVal("");
				System.out.println(m.getB());
				System.out.println(m.getA());
			}
			else if (ops[3].equals(btnText) || ops[2].equals(btnText) || ops[1].equals(btnText) || ops[0].equals(btnText)){
					// arithmetic operators
					m.setOp(btnText);
					m.exec(0);
					g.setVal(String.valueOf(m.getOut()));
			}
			else if (ops[4].equals(btnText)){ // clear
					m.setOp(btnText);
					m.exec(0);
					g.setVal("");
			}
		});
	}
	// setVal() will change the text
}
