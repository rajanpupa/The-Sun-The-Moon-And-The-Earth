/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_ics;
import java.lang.Math;
/**
 *
 * @author power
 */
public class Point {
    public double x;
    public double y;
    public double z;
    Point(){}
    Point(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }
    public void viewPoint(){
        System.out.println("("+x+","+y+","+z+")");
    }
    int getX(){
        int i=(int)Math.rint(x);
        return i;
    }
    int getY(){
        int i=(int)Math.rint(y);
        return i;
    }
    int getZ(){
        int i=(int)Math.rint(z);
        return i;
    }
    
    public Point getRotateAlongTheta(int radius,double theta,Point center){
        double tx=x-center.x,ty=y-center.y,tz=z-center.z;
        double tx1,ty1,tz1;
         tx1=tx*Math.cos(Math.toRadians(theta))-tz*Math.sin(Math.toRadians(theta));
         tz1=tx*Math.sin(Math.toRadians(theta))+tz*Math.cos(Math.toRadians(theta));
         tx=tx1+center.x;
         //ty=ty1+center.y;
         tz=tz1+center.z;
        Point p=new Point(tx,y,tz);
        return p;
    }
    public Point getRotateAlongPhi(int radius,double phi,Point center){
        double tx=x-center.x,ty=y-center.y,tz=z-center.z;
        double tx1,ty1,tz1;
         tx1=tx*Math.cos(Math.toRadians(phi))-tz*Math.sin(Math.toRadians(phi));
         ty1=tx*Math.sin(Math.toRadians(phi))+tz*Math.cos(Math.toRadians(phi));
         tx=tx1+center.x;
         //ty=ty1+center.y;
         ty=ty1+center.y;
        Point p=new Point(tx,ty,z);
        return p;
    }
    public double getL(){
        double a=x/Math.sqrt(x*x+y*y+z*z);
        return a;
    }
    public double getM(){
        double a=y/Math.sqrt(x*x+y*y+z*z);
        return a;
    }
    public double getN(){
        double a=z/Math.sqrt(x*x+y*y+z*z);
        return a;
    }
    //project coordiantes functions
    public int getViewX(int cz){
        int a=(int)Math.rint(cz*x/z);
        return a;
    }
    public int getViewY(int cz){
        int a=(int)Math.rint((cz)*y/z);
        return a;
    }
    public int getViewZ(int cz){
        int a=(cz);
        return a;
    }
    //3d translations functions
    public Point translate(Point p){
        Point a=new Point(x-p.x,y=p.y,z-p.z);
        return a;
    }
    public Point inverseTranslate(Point p){
        Point a=new Point(x+p.x,y+p.y,z+p.z);
        return a;
    }
    public void RotateAlongTheta( double theta,Point center){
        //ie rotating along y axix , clockwise//working
       // System.out.print("rotating theta: "+x+":"+z);
        double tx=(x-center.x)*Math.cos(Math.toRadians(theta))-(z-center.z)*Math.sin(Math.toRadians(theta));
        double tz=(x-center.x)*Math.sin(Math.toRadians(theta))+(z-center.z)*Math.cos(Math.toRadians(theta));
        x=tx+center.x;
        z=tz+center.z;
       // System.out.println("\t result:"+x+":"+z);
    }
    public void RotateAlongPhi( double phi,Point center){
        //ie rotating along x axix , clockwise//not working
       // System.out.print("rotating phi: "+x+":"+z);
        double tz=(z-center.z)*Math.cos(Math.toRadians(-phi))-(y-center.y)*Math.sin(Math.toRadians(-phi));
        double ty=(z-center.z)*Math.sin(Math.toRadians(-phi))+(y-center.y)*Math.cos(Math.toRadians(-phi));
        y=ty+center.y;
        z=tz+center.z;
       // System.out.println("\t result:"+x+":"+z);
    }
    
    public Point RotateAlongX(int theta,Point center){
        //x does not change
        double tz=(z-center.z)*Math.cos(Math.toRadians(-theta))-(y-center.y)*Math.sin(Math.toRadians(-theta));
       // double ty=(z-center.z)*Math.sin(Math.toRadians(-theta))+(y-center.y)*Math.cos(Math.toRadians(-theta));
         double ty=(z-center.z)*Math.sin(Math.toRadians(-theta))+(y-center.y)*Math.cos(Math.toRadians(-theta));
//        y=ty+center.y;
//        z=tz+center.z;
         return new Point(x,ty+center.y,tz+center.z);
    }
    public Point RotateAlongY( int theta,Point center){
        //ie rotating along y axix , clockwise//working
       // System.out.print("rotating theta: "+x+":"+z);
        double tx=(x-center.x)*Math.cos(Math.toRadians(theta))-(z-center.z)*Math.sin(Math.toRadians(theta));
        double tz=(x-center.x)*Math.sin(Math.toRadians(theta))+(z-center.z)*Math.cos(Math.toRadians(theta));
//        x=tx+center.x;
//        z=tz+center.z;
        return new Point(tx+center.x,y,tz+center.z);
       // System.out.println("\t result:"+x+":"+z);
    }
    public Point RotateAlongZ(int theta,Point center){
        //z constant
        double tx=(x-center.x)*Math.cos(Math.toRadians(theta))-(y-center.y)*Math.sin(Math.toRadians(theta));
        double ty=(x-center.x)*Math.sin(Math.toRadians(theta))+(y-center.y)*Math.cos(Math.toRadians(theta));
//        x=tx+center.x;
//        y=ty+center.y;
        return new Point(tx+center.x,ty+center.y,z);
    }

    //prospectiv e view coordinate giving functions
    public void RevolveAlongY(double theta,Point sample){
        //exactly as rotateAlongY  but the point sample which is passed is other than the center
        double tx=(x-sample.x)*Math.cos(Math.toRadians(theta))-(z-sample.z)*Math.sin(Math.toRadians(theta));
        double tz=(x-sample.x)*Math.sin(Math.toRadians(theta))+(z-sample.z)*Math.cos(Math.toRadians(theta));
        x=tx+sample.x;
        z=tz+sample.z;
    }
    public void RevolveAlongX(double theta,Point sample){
        
    }
    public Point getPerspective(Point viewPoint){
        //the view plane is xy plane ie z=0
        //working great.........//view point (200,200.1000) working fine
        double xp=x-(-z)/(viewPoint.z-z)*(x-viewPoint.x);
        double yp=y-(-z)/(viewPoint.z-z)*(y-viewPoint.y);
        double zp=0;
        return new Point(xp,yp,zp);
    }
    public Point rotateAlongY(double angle){
        double x2=x*Math.cos(Math.toRadians(angle))-z*Math.sin(Math.toRadians(angle));
        double y2=x*Math.sin(Math.toRadians(angle))+z*Math.cos(Math.toRadians(angle));
//        x2=(float)(x2);
//        y2=(float)y2;
        return new Point(x2,y2,z);
    }
}
