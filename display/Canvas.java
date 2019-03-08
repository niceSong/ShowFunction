package display;

import function.various.PolylineSwingFunc;

import javax.swing.*;
import java.awt.*;

/* 画布 */
public class Canvas{
    private final int hight;
    private final int width;
    private int[][] Image;

    /* Builder Constructor */
    public static class Builder {
        private final int hight;
        private final int width;

        public Builder(int hight, int width){
            this.hight = hight;
            this.width = width;
        }

        public Canvas build(){
            return new Canvas(this);
        }
    }//Builder

    private Canvas(Builder builder){
        this.hight = builder.hight;
        this.width = builder.width;
        this.Image = new int[builder.hight][builder.width];
    }

    public int GetHight(){ return hight; }
    public int Getwidth(){ return width; }

    public void test(){
        for(int x = 0; x < hight; x++){
            for(int y = 0; y < hight; y++){
                if(3 == Image[x][y]){
                    System.out.println("Image hava value is 3");
                }
            }
        }
    }

    public void SetImage(int x, int y) {
        Image[y][x] = 3;
    }

    public int GetImage(int x, int y){
        return Image[y][x];
    }


    /*
     * Image中显示xy坐标
     */
    public void ShowAxis() {
        for(int x = 0; x < width; x++){
            SetImage(x, hight/2);
        }
        for(int y = 0; y < hight; y++){
            SetImage(width/2, y);
        }
    }

    /* 置空画布 */
    public void ClearImage(){
        Image = new int[width][hight];
    }

}//Canvas