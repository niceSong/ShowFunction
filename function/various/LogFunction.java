package function.various;

import function.base.Function;

public class LogFunction extends Function{

    private double a;
    //y=logax

    public LogFunction(double a) {
        this.a = a;
    }

    public void printtest(){
        System.out.println("LogPicture");
    }

    public boolean result(int x, int y) {
        if(Math.log(x) / Math.log(a) == y){
            return true;
        }else {
            return false;
        }

    }
}