
import java.util.Scanner;
import display.TDisplay;
import display.Canvas;
import function.base.Function;
import function.various.CircleFunction;
import function.various.Composite;
import function.various.LogFunction;
import function.various.PolylineSwingFunc;

import javax.xml.xpath.XPath;


public class ShowTest{
    private static int[] Xpoint = new int[50];
    private static int[] Ypoint = new int[50];
    private static int Npoint;

    public static void main(String[] args){

        TDisplay display = new TDisplay();
        Function circle = new CircleFunction(100, "circle", display.canvas);
        Function log = new LogFunction(2, "log", display.canvas);

        /* add object */
        Scanner scanstring = new Scanner(System.in);
        System.out.println("本次操作是否显示折线吗？--> y or n");
        String showpoly = scanstring.nextLine();
        if(showpoly.equals("y")){
            addpoly(display, display.composite);
        }
        display.composite.add(circle);
        display.composite.add(log);


        /* users can enter the following content */
        System.out.println("select an image output from below:");
        display.composite.GetListComponent();

        System.out.println("please input your favorite Image");
        String FuncName = scanstring.nextLine();

        while( 0 != FuncName.length() ){
            display.ShowImage(FuncName);
            display.canvas.ClearImage();
            System.out.println("you can choose again:");
            FuncName = scanstring.nextLine();
        }
    }

    private static void addpoly(TDisplay display, Composite composite){
        Scanner scanint = new Scanner(System.in);
        System.out.println("折线图有几个折点: ");
        Npoint = scanint.nextInt();
        System.out.println("根据提示输入每个点xy坐标***warning：坐标请不超过400");
        for(int i = 0; i < Npoint; i++){
            System.out.println("x"+i+" is: ");
            Xpoint[i] = scanint.nextInt();
            System.out.println("y"+i+" is: ");
            Ypoint[i] = scanint.nextInt();
        }
        Function polyline = new PolylineSwingFunc.Builder(Xpoint, Ypoint, Npoint, "polyline", display.canvas).build();
        composite.add(polyline);
    }

}