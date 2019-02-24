
import java.util.Map;
import java.lang.Thread;
import java.util.Scanner;
import display.TDisplay;
import function.base.Function;
import function.various.CircleFunction;
import function.various.LogFunction;


public class ShowTest{

    public static void main(String[] args){
        TDisplay displayer = new TDisplay.Builder(60, 60).build();
        Function circlefunction = new CircleFunction(30);
        Function logfunction = new LogFunction(2);

        displayer.addmap("Circle", circlefunction);
        displayer.addmap("Log", logfunction);

        /* ����������ʾͼƬ */
        System.out.println("Please select an image output from below:");
        for(String name : displayer.FunctionMap.keySet()) {
            System.out.println("--> "+name);
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("the image you selected:");
        String FuncName = scan.nextLine();

        while( 0 != FuncName.length() ){
            displayer.ShowCoordinate();
            displayer.ShowImage(FuncName);
            displayer.ClearImage();

            System.out.println("you can choose again:");
            FuncName = scan.nextLine();
        }
    }

}