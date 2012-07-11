/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_ics;
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;
/**
 *
 * @author power
 */
public class Sphere {
    /**
     * The porperties that define a sphere are--
     * To use this class
     * first set patameters
     * pass a graphic context
     * initialize()
     * paint()
     */
    Point center;
    Point viewPoint=new Point(600,400,2000);
    int radius;
    Graphics g;
    int delphi;//used to determine the number of rows in mat[][] ie point matrix
    int deltheta;//determine the num of cols in the mat
    int numOfRows;
    int numOfCols;
    Point mat[][];//matrix of points// actual world coordinates
    Point mat1[][];//to hold projected coordinates
    Point mat2[][];//matrix according to view points angle with the z axis;;
    Surface surface[][];
    int angle=0;
    Sphere(){
        center=new Point(0,0,0);
        //viewPoint=new Point(0,0,0);
        radius=100;
        deltheta=20;
        delphi=20;
        numOfRows=180/delphi;
        numOfCols=360/deltheta;
    }
    //to draw
    
    /**
     * theta is the angle made by position vector from center to the point 
     * measured from x axis towords z axis in clockwise direction
     * 
     * phi is the angel made by  same but 
     * towards y-axis in anticlockwise, ie up direction
     * 
     * Result, any point can be uniquely identified from a set of {theta, phi} 
     *
     * delX where x=phi or theta determines the interval between two points taken
     * num of rows=180/delphi
     * num of cols=360/deltheta;
     */
    
    public void setGraphics(Graphics gh){
        //pass the graphics context of the frame on which 
        //this sphere is to be drawn
        g=gh;
        
    }
    public void setColor(Color c){
        g.setColor(c);
    }
    public void set_Center(Point p){
        //this funciton should be called at the beginning only
        center=p;
    }
    public void set_viewer(int x,int y,int z){
        viewPoint=new Point(x,y,z);
    }
    public void set_Center(int x,int y,int z){
        center=new Point(x,y,z);
    }
    public void setRadius(int r){
        radius=r;
    }
    
    public void initialize(){
        numOfRows=180/delphi+1;
        numOfCols=360/deltheta+1;
        mat=new Point[numOfRows][numOfCols];
        mat1=new Point[numOfRows][numOfCols];
        mat2=new Point[numOfRows][numOfCols];
        System.out.print("center=");
        center.viewPoint();
        System.out.println("radius="+this.radius);
        double theta=0;
        double phi=90;
        for(int row=0;row<numOfRows;row++){
            for(int col=0;col<numOfCols;col++){
                mat[row][col]=new Point(
                        center.x+radius*Math.cos(Math.toRadians(theta))*Math.cos(Math.toRadians(phi))
                        ,center.y+radius*Math.sin(Math.toRadians(phi))
                        ,center.z+radius*Math.sin(Math.toRadians(theta))*Math.cos(Math.toRadians(phi))
                        );
                mat1[row][col]=mat[row][col].getPerspective(viewPoint);
                //if(col==1)
                if(false){
                    System.out.print("theta="+theta+" phi="+phi+" ");
                    mat[row][col].viewPoint();
                }
               // else
                  //  System.out.println("phi="+phi);
                theta+=deltheta;
                theta%=360;
               // mat2[row][col]=mat[row][col].getRotateAlongTheta(radius, 0,center);
            }//for j
            phi-=delphi;
            theta=0;
        }//for i
        //this.initializeSurface();
    }//initialize
    
    public void paint(){
        //System.out.println("drawing sphere");
        //useless
        //just draws the points
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
                g.drawOval(mat[i][j].getX(), mat[i][j].getY(), 0, 0);
            }
        }///for i
    }//paint
    
    public void drawLatitudes(){
        int cz=-20;
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<(numOfCols-1);j++){
                //g.drawLine(mat[i][j].getViewX(cz), mat[i][j].getViewY(cz), mat[i][j+1].getViewX(cz), mat[i][j+1].getViewY(cz));
                //g.drawLine(mat[i][j].getX(), mat[i][j].getY(), mat[i][j+1].getX(), mat[i][j+1].getY());
                g.drawLine(mat[i][j].getX(), mat[i][j].getY(), mat[i][j+1].getX(), mat[i][j+1].getY());
            }
        }
    }
    public void drawLongitudes(){
       // int j=0;
        int cz=0;
        for(int i=0;i<numOfRows-1;i++){
            for(int j=0;j<numOfCols;j++){
                //g.drawLine(mat[i][j].getViewX(cz), mat[i][j].getViewY(cz), mat[i+1][j].getViewX(cz), mat[i+1][j].getViewY(cz));
                 //g.drawLine(mat[i][j].getX(), mat[i][j].getY(), mat[i+1][j].getX(), mat[i+1][j].getY());
                g.drawLine(mat[i][j].getX(), mat[i][j].getY(), mat[i+1][j].getX(), mat[i+1][j].getY());
            }
        }
    }//drawlongitudes
    
    
    public void rotateAlongX(int angle){
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
               // mat[i][j]=mat[i][j].getRotateAlongTheta(radius, angle,center) ;
               mat[i][j]=mat[i][j].RotateAlongX(angle,center);//perfect
            }
        }
    }
    public void rotateAlongY(int angle){
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
               // mat[i][j]=mat[i][j].getRotateAlongTheta(radius, angle,center) ;
              mat[i][j]= mat[i][j].RotateAlongY(angle,center);//perfect
            }
        }
    }
    public void rotateAlongZ(int angle){
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
               // mat[i][j]=mat[i][j].getRotateAlongTheta(radius, angle,center) ;
               mat[i][j]=mat[i][j].RotateAlongZ(angle,center);//perfect
            }
        }
    }
    
     public void RevolveAlongY(int angle,Point p){
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
               // mat[i][j]=mat[i][j].getRotateAlongTheta(radius, angle,center) ;
               mat[i][j]=mat[i][j].RotateAlongY(angle,p);//perfect
            }
        }//for i
        center.RotateAlongTheta(angle,p);
    }
     public void RevolveAlongX(int angle,Point p){
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
               // mat[i][j]=mat[i][j].getRotateAlongTheta(radius, angle,center) ;
               mat[i][j]=mat[i][j].RotateAlongX(angle,p);//perfect
            }
        }//for i
        center.RotateAlongTheta(angle,p);
    }
     public void RevolveAlongZ(int angle,Point p){
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
               // mat[i][j]=mat[i][j].getRotateAlongTheta(radius, angle,center) ;
               mat[i][j]=mat[i][j].RotateAlongZ(angle,p);//perfect
            }
        }//for i
        center.RotateAlongTheta(angle,p);
    }
     
    public void updatePerspective(){
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
                //g.drawOval(mat[i][j].getViewX(cz), mat[i][j].getViewY(cz), 0, 0);
                //mat1[i][j]=new Point(mat[i][j].getViewX(cz),mat[i][j].getViewY(cz),mat[i][j].getViewZ(cz));//working
                mat1[i][j]=mat[i][j].getPerspective(viewPoint);
            }
        }///for i
    }
    public void calculatePrespective(){
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
                //g.drawOval(mat[i][j].getViewX(cz), mat[i][j].getViewY(cz), 0, 0);
                //mat1[i][j]=new Point(mat[i][j].getViewX(cz),mat[i][j].getViewY(cz),mat[i][j].getViewZ(cz));//working
                mat1[i][j]=mat[i][j].getPerspective(viewPoint);
            }
        }///for i
    }
    public void prospectiveView(){
        calculatePrespective();
       viewTheLines(mat1);
    }
    public void viewTheLines(Point mat1[][]){
         //longitute
        for(int i=0;i<numOfRows-1;i++){
            for(int j=0;j<numOfCols;j++){
                //g.drawLine(mat[i][j].getViewX(cz), mat[i][j].getViewY(cz), mat[i+1][j].getViewX(cz), mat[i+1][j].getViewY(cz));
                g.drawLine(mat1[i][j].getX(), mat1[i][j].getY(), mat1[i+1][j].getX(), mat1[i+1][j].getY());
                //g.drawLine(mat1[i][j].getX(), mat1[i][j].getY(), mat1[i+1][j].getX(), mat1[i+1][j].getY());
            }
        }
        //latitude
        for(int i=0;i<numOfRows;i++){
            for(int j=0;j<(numOfCols-1);j++){
                //g.drawLine(mat[i][j].getViewX(cz), mat[i][j].getViewY(cz), mat[i][j+1].getViewX(cz), mat[i][j+1].getViewY(cz));
                //g.drawLine(mat[i][j].getX(), mat[i][j].getY(), mat[i][j+1].getX(), mat[i][j+1].getY());
                g.drawLine(mat1[i][j].getX(), mat1[i][j].getY(), mat1[i][j+1].getX(), mat1[i][j+1].getY());
            }
        }
    }
    public void RotateViewPoint(int viewAngle,Point AxisSamplePoint){
         //rotate points of mat1 by angle along with x axis and assign to mat2
       // int cz=-200;
        calculatePrespective();//caluclates the mat1
       for(int i=0;i<numOfRows;i++){
            for(int j=0;j<numOfCols;j++){
                mat2[i][j]=mat[i][j].RotateAlongX(viewAngle, AxisSamplePoint);
                mat2[i][j]=mat2[i][j].getPerspective(viewPoint);
            }
        }///for i
       //g.setColor(Color.red);
        viewTheLines(mat2);
    }
    public void initializeSurface(){
        surface=new Surface[numOfRows][numOfCols];
         for(int i=0;i<numOfRows-1;i++){
            for(int j=0;j<numOfCols-1;j++){
                surface[i][j]=new Surface(mat[i][j],mat[i+1][j],mat[i+1][j+1],mat[i][j+1]);
            }//j
         }//i
    }
    public void fillSurface(){
        //surface=new Surface[numOfRows-1][numOfCols-1];
         for(int i=0;i<numOfRows-1;i++){
            for(int j=0;j<numOfCols-1;j++){
                //surface[i][j]=new Surface(mat[i][j],mat[i+1][j],mat[i+1][j+1],mat[i][j+1]);
                surface[i][j].setGraphics(g);
                surface[i][j].fillColor();
            }//j
         }//i
    }

}
