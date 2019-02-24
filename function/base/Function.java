package function.base;

import display.TDisplay;


public abstract class Function {
    /*
     *X��Y�Ƿ����㺯��
     */
    public abstract boolean result(int x, int y);

    public abstract void printtest();

    /*
     *���������б�ʾ����������X Y
     */
    public int[][] WriteImage(int[][] Image){
        int xlength = Image.length;
        int ylength = Image[0].length;

        System.out.println("xlength = "+xlength);
        System.out.println("ylength = "+ylength);

        for(int x = -(xlength/2); x < (xlength/2); x++){
            for(int y = -(ylength/2); y < (ylength/2); y++){
                if(result(x, y)) {
                    Image[x+ xlength/2 ][y + ylength/2] = 3;
                }

            }
        }

        return Image;
    }
}
