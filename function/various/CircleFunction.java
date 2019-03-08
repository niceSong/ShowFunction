package function.various;

import function.base.Function;
import display.Canvas;
import java.lang.Math;

public class CircleFunction extends Function{
    private String funcname;
    private int radius;
    private int hight;
    private int width;

    public CircleFunction(int radius, String funcname, Canvas canvas) {
        this.radius = radius;
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
        for(int x = 0; x < width/2; x++){
            int ysquare = radius*radius - x*x ;
            if( ysquare > 0 ){
                int y = (int)Math.sqrt(ysquare);
                canvas.SetImage(width/2 + x, hight/2 + y);
                canvas.SetImage(width/2 + x, hight/2 - y);
            }
        }
        for(int x = 0; x > -width/2; x--) {
            int ysquare = radius*radius - x*x ;
            if( ysquare > 0 ){
                int y = (int)Math.sqrt(ysquare);
                canvas.SetImage(width/2 + x, hight/2 + y);
                canvas.SetImage(width/2 + x, hight/2 - y);
            }
        }

    }

}//CircleFunction
