package function.base;

import display.Canvas;
import function.various.PolylineSwingFunc;

import javax.swing.*;
import java.awt.*;

public abstract class Function {
    /*
     * X/Y --match?--> function
     * diffrent subclass have diffrent match method
     */
    public abstract void add(Function func);
    public abstract void remove(Function func);
    public abstract String Getname();
    /* 填充画布 */
    public abstract void view(Canvas canvas);

}//Function
