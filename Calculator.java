class Calculator{
    Model model;
    Controller controller;
    GUI view;
    public Calculator(){
        model = new Model();
        view = new GUI(400, 400, "center");
        controller = new Controller(model, view);
    }
    public static void main(String[] args){
        Calculator c;
        c = new Calculator();
    }
}