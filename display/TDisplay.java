package display;

import function.base.Function;
import java.util.Map;
import java.util.HashMap;
import java.lang.String;


public class TDisplay {
    /* ���������ݳ�Ա�����������顢map<��������Function> */
    private final int Xcoordinate;
    private final int Ycoordinate;
    private int[][] Image;
    public Map<String, Function> FunctionMap;


    /* Builder��ʽ��ʼ�����ݳ�Ա */
    public static class Builder {
        private final int Xcoordinate;
        private final int Ycoordinate;

        public Builder(int ImageX, int ImageY) {
            this.Xcoordinate = ImageX;
            this.Ycoordinate = ImageY;
        }

        public TDisplay build(){
            return new TDisplay(this);
        }


    }//Builder

    private TDisplay(Builder builder){
        Xcoordinate = builder.Xcoordinate;
        Ycoordinate = builder.Ycoordinate;
        Image = new int[builder.Xcoordinate][builder.Ycoordinate];
        FunctionMap = new HashMap<String, Function>();
    }

    public void XYreturn(){
        System.out.println("xlength = "+Image.length);
        System.out.println("ylength = "+Image[0].length);
    }

    /* ��ʾ����ϵ���� */
    public void ShowCoordinate() {
        for(int x = 0; x < Xcoordinate; x++){
            Image[x][Ycoordinate / 2] = 1;  //x����ϵ
        }
        for(int y = 0; y < Ycoordinate; y++){
            Image[Xcoordinate / 2][y] = 2;  //y����ϵ
        }
    }

    /* HashMap ���*/
    public void addmap(String FuncName, Function function){
        FunctionMap.put(FuncName, function);
    }


    /* HashMap ɾ�� */
    public void deletemap(String FuncName) {
        FunctionMap.remove(FuncName);
    }


    /* HashMap���ң�ͼ��д������ */
    public void findmap(String FuncName){
        Function function = FunctionMap.get(FuncName);
        Image = function.WriteImage(Image);
    }

    /* ��ʾ����ͼ�� */
    public void ShowImage(String FuncName) {
        this.findmap(FuncName);

        for(int i = 0; i < Xcoordinate; ++i){
            for(int j = 0; j < Ycoordinate; ++j){
                switch(Image[i][j]){
                    case 0:
                        System.out.print("   ");
                        break;
                    case 1:
                        System.out.print(" | ");
                        break;
                    case 2:
                        System.out.print(" -- ");
                        break;
                    case 3:
                        System.out.print(" * ");
                        break;
                }
            }
            System.out.println("");
        }

    }

    public void ClearImage(){
        Image = new int[Xcoordinate][Ycoordinate];
    }

}//TDisplay
