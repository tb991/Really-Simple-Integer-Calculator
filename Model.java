public class Model {
   int A = 0;
   int B = 0;
   int out;
   String op = "ADD";
   String lastOp = "ADD"; 
   int[] memory = new int[100]; // LIFO, currently unused
   int idx = 0;
   public static void main(String[] args) {
       /*
       Model m;
       m = new Model();
       m.setA(5);
       m.setB(7);
       m.setOp("ADD");
       m.exec();
       expect(m, 12);
       m.setOp("SUB");
       m.exec();
       expect(m, -2);
       m.setOp("MULT");
       m.exec();
       expect(m, 35);
       m.setOp("DIV");
       m.exec();
       expect(m, 0);*/
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
        memory[idx] = B;
        idx++;
        B = A;
        A = in;
        return 0;
   }
   public void resetMemory(){
       while (idx > 0){
           memory[idx-1] = 0;
           idx -= 1;
       }
       idx = 0;
       A = 0;
       B = 0;
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
                    lastOp = op;
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
