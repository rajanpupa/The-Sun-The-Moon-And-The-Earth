/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_ics;

import java.awt.Graphics;

/**
 *
 * @author power
 */
public class Surfaces {
    /*
     * pass the point table here and generate a surface table
     */
    Surface sur_table[][];
    public Point moon_center;
    public Point earth_center;
    public Point sun_center;
    public int sun_rad;
    public int moon_rad;
    public int earth_rad;
    Graphics g;
    public void initiateSurfaceTable(Sphere sp){
        sur_table=new Surface[sp.numOfRows][sp.numOfCols];
         for(int i=0;i<sp.numOfRows-1;i++){
            for(int j=0;j<sp.numOfCols-1;j++){
                sur_table[i][j]=new Surface(sp.mat1[i][j],sp.mat1[i+1][j],sp.mat1[i+1][j+1],sp.mat1[i][j+1]);
              //  sur_table[i][j].setGraphics(g);
               // sur_table[i][j].fillColor();
            }//j
         }//i
         for(int i=0;i<sp.numOfRows-1;i++){
            for(int j=0;j<sp.numOfCols-1;j++){
                //sur_table[i][j]=new Surface(sp.mat1[i][j],sp.mat1[i+1][j],sp.mat1[i+1][j+1],sp.mat1[i][j+1]);
                sur_table[i][j].setGraphics(g);
                sur_table[i][j].fillColor();
            }//j
         }//i
    }
   
}
