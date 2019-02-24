package function.various;

import function.base.Function;

public class CircleFunction extends Function{

    private double radius;
    //y=logax

    public CircleFunction(double radius) {
        this.radius = radius;
    }

    public void printtest(){
        System.out.println("CirclePicture");
    }

    public boolean result(int x, int y) {
        if((x*x+y*y) == radius*radius){
            return true;
        }else {
            return false;
        }

    }
}
