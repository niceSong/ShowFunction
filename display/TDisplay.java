package display;

import function.base.Function;
import function.various.Composite;

import javax.swing.*;
import java.awt.*;
import java.lang.String;


public class TDisplay{
    public Canvas canvas;
    public Composite composite;
    public Function function;

    public TDisplay(){
        canvas = new Canvas.Builder(800, 800).build();
        composite = new Composite();
    }


    /* 显示画布 */
    public void DisplayCanvas(Canvas canvas, Graphics gr){

        for(int x = 0; x < canvas.GetHight(); x++){
            for(int y = 0; y < canvas.Getwidth(); y++){
                switch(canvas.GetImage(x, y)){
                    case 0:
                        gr.setColor(Color.PINK);
                        gr.fillOval(x, canvas.GetHight()-y, 2, 2);
                        break;
                    case 3:
                        //System.out.println("坐标值是："+y+" "+x);
                        gr.setColor(Color.BLUE);
                        gr.fillOval(x, canvas.GetHight()-y, 2, 2);
                        break;

                    default:
                        break;
                }
            }
        }
    }


    private class NewJPanel extends JPanel {
        @Override
        public void paint(Graphics g) {
            super.paint(g);//加上这一句，窗体背景色就会画出来
            Graphics gr = g;
            //gr.setColor(Color.PINK);
            canvas.ShowAxis();
            //画Image
            function.view(canvas);
            DisplayCanvas(canvas, gr);
        }
    }//class NewJPanel

    public void Show(){
        JFrame frame = new JFrame();
        //frame.getContentPane().setBackground(Color.BLUE);
        frame.setTitle("Show Polyline");
        frame.setSize(800, 800);
        Container contentPane = frame.getContentPane();
        contentPane.add(new NewJPanel());
        frame.show();
    }

    /*
     * select function from Hashmap,
     * and write data in Image array.
     */
    public void ShowImage(String FuncName){
        function =  composite.ReturnFunc(FuncName);
        //显示Image
        Show();
    }



}//TDisplay


