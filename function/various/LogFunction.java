package function.various;

import function.base.Function;
import display.Canvas;

public class LogFunction extends Function{
    private String funcname;
    private double a;
    private int hight;
    private int width;
    //y=logax

    public LogFunction(double a, String funcname,Canvas canvas) {
        this.a = a;
        this.funcname = funcname;
        this.hight = canvas.GetHight();
        this.width = canvas.Getwidth();
    }


    public String Getname(){
        return funcname;
    }

    public void add(Function func){ }
    public void remove(Function func){ }

    @Override
    public void view(Canvas canvas) {
        for(int x = 1; x < (width/2); x++){
                double y = Math.log(x) / Math.log(a);
                    canvas.SetImage(x + 400, (int)y+400);
                }
        }

}//class LogFunction