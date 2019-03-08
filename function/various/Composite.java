package function.various;

import display.Canvas;
import function.base.Function;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Function {
    String funcname;
    private List<Function> funclist;

    public Composite(){
        funclist = new ArrayList<Function>();
        funcname = "composite";
    }

    @Override
    public void add(Function func) {
        funclist.add(func);
    }

    @Override
    public void remove(Function func) {
        funclist.remove(func);
    }

    @Override
    public String Getname() { return funcname; }

    @Override
    public void view(Canvas canvas) { }

    public Function ReturnFunc(String funcname) {
        for (Function function : funclist) {
            if (function.Getname().equals(funcname)){
                System.out.println("function is:"+function.Getname());
                return function;
            }
        }
        System.out.println("error: funclist is empty!");
        return null;
    }

    public void GetListComponent(){
        for(Function function: funclist){
            System.out.println("-->"+ function.Getname());
        }
    }

}//Composite