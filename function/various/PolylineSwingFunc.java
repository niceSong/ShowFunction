package function.various;

import display.Canvas;
import function.base.Function;
import sun.security.util.PolicyUtil;

import javax.swing.*;
import java.awt.*;

public class PolylineSwingFunc extends Function {
    private int[] Xpoint;
    private int[] Ypoint;
    private int Npoint;  //number of line is: (nPoint -1)
    //y = k * x + b
    private double[] k;
    private double[] b;

    private String funcname;

    /* builder Constructor ... */
    public static class Builder{
        private final int[] Xpoint;
        private final int[] Ypoint;
        private final int Npoint;
        private String funcname;

        public Builder(int[] xpoint, int[] ypoint, int npoint, String funcname, Canvas canvas) {
            this.Xpoint = xpoint;
            this.Ypoint = ypoint;
            this.Npoint = npoint;
            this.funcname = funcname;
        }

        public PolylineSwingFunc build(){return new PolylineSwingFunc(this);};

    }//Builder

    private PolylineSwingFunc(Builder builder){
        Xpoint = builder.Xpoint;
        Ypoint = builder.Ypoint;
        Npoint = builder.Npoint;
        funcname = builder.funcname;
        k = new double[Npoint -1];
        b = new double[Npoint -1];

        for(int i = 0; i < (Npoint - 1); i++ ) {
            if (Npoint != Ypoint.length)
                System.out.println(" Npoint number is incorrect! ");
            k[i] = ((double)Ypoint[i + 1] - (double)Ypoint[i])/((double)Xpoint[i + 1] - (double)Xpoint[i]);
            b[i] = (double)Ypoint[i] - k[i] * (double)Xpoint[i];

        }
    }


    public String Getname(){
        return funcname;
    }

    public void add(Function func){ }
    public void remove(Function func){ }

    @Override
    public void view(Canvas canvas) {
        //图像优化：k > 1和k < 1，为两种不同处理方式
        for (int i = 0; i < k.length; i++) {
            double Newk = k[i];
            //x变化一点，y会变化很多，所以遍历y，x四舍五入
            if (Newk >= 1) {
                for (int y = Ypoint[i]; y < Ypoint[i + 1]; y++) {
                    int x = (int) ((y - b[i]) / k[i]);
                    canvas.SetImage(x + 400, y + 400);
                }
            }
            else if(Newk <= -1 ){
                for(int y = Ypoint[i+1]; y < Ypoint[i]; y++){
                    int x = (int) ((y - b[i]) / k[i]);
                    canvas.SetImage(x + 400, y + 400);
                }
            }
            //y变化一点，x会变化很多，所以遍历x，y四舍五入
            else{
                for (int x = Xpoint[i]; x < Xpoint[i + 1]; x++) {
                    int y = (int) (k[i] * x + b[i]);
                    canvas.SetImage(x + 400, y + 400);
                }
            }
        }
    }
}//class PolylineSwingFunc