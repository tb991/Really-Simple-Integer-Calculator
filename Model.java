import java.time.format.TextStyle;

public class Model {
   Integer A;
   Integer B;
   Integer out;
   String op;
   public static void main(String[] args) {
       /*
    test(1, 2, "ADD", 3);
    test(1, 2, "MULT", 2);
    test(1, 2, "SUB", 1);
    test(1, 2, "DIV", 2);

    test(5, 7, "ADD", 12);
    test(5, 7, "MULT", 35);
    test(5, 7, "SUB", 2);
    test(5, 7, "DIV", 1);
    */
   }
   private static void test(int A, int B, String oper, int expectation){
       Model m = new Model();
        m.resetMemory();
        m.setA(A);
        m.setB(B);
        m.setOp(oper);
        m.exec(0);
        expect(m, expectation);
        System.out.println(String.valueOf(A) + " " + oper + " " + String.valueOf(B) + "->" + expectation);

   }
   public void updateA(String in){
        String prior;
        prior = String.valueOf(A);
        String next;
        next = prior + in;
        A = Integer.parseInt(next);
        aSet = true;
   }
   /* // we dont touch B once it's in memory
   public void updateB(String in){
        String prior;
        prior = String.valueOf(B);
        String next;
        next = prior + in;
        B = Integer.parseInt(next);
   }*/
   public boolean opSet(){
       return op.equals("NULL");
   }
   private static void expect(Model m, int in){
       String out;
        if (m.getOut()==in){
            out = m.getOp() + " succeeded";
        }
        else{
            out = m.getOp() + " failed";
        }
        System.out.println(out);
   }
   public String getOp(){
       return op;
   }
   public Model(){

   }
   public int push(int in){
        try{
            B = A;
        }
        catch(Exception ex){
            System.out.println("PUSH error, A not set");
        }
        A = in;
        return 0;
   }
   public void resetMemory(){

   }
   int pushCount = 0;
   public int exec(int optionalIn){
       int out;
        if (op.equals("ADD")){
            out = add();
        }
        else if (op.equals("SUB")){
            out = sub();
        }
        else if (op.equals("MULT")){
            out = mult();
        }
        else if (op.equals("DIV")){
            out = div();
        }
        else if (op.equals("PUSH")){
            out = push(optionalIn);
        }
        else if (op.equals("CLEAR")){
            resetMemory();
            out = 0;
        }
        else{
            out =  0;;
        }
        return out;
   }
   boolean bSet = false;
   public boolean setOp(String c){
       boolean success = false;
       String[] ops = {"ADD", "SUB", "MULT", "DIV", "PUSH", "CLEAR"};
        for (int i = 0; i < ops.length; i++){
                if (c.equals(ops[i])){
                    op = c;
                    success = true;
                }
        }
       return success;
   }
   boolean aSet = false;
   // called by pushing only
   public void setA(int in){
       A = in;
       aSet = true;
   } 
   
   public void setB(int in){
        B = in;
        bSet = true;
   } 
   public int getA(){
       return A;
   }
   public int getB(){
       return B;
   }
   public int getOut(){
       return out;
   }
   public int add(){
       out = A+B;
       return out;
   }
   public int sub(){
       out = B - A;
       return out;
   }
   public int mult(){
       out = A*B;
       return out;
   }
   public int div(){
       out = B/A;
       return out;
   }
}
