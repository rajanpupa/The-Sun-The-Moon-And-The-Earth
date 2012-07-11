/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graph_ics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

/**
 *
 * @author power
 */
public class Surface {
    Point a;//top left
    Point b;//bottom left
    Point c;//bottom right
    Point d;//top right
    Graphics g;
    Color color=Color.red;
    int margin=0;
    Polygon p=new Polygon();
    Surface(){}
    Surface(Point a,Point b,Point c,Point d){
//        this.a=new Point(a.x+margin,a.y+margin,a.z);
//        this.b=new Point(a.x+margin,a.y-margin,a.z);
//        this.c=new Point(a.x-margin,a.y-margin,a.z);
//        this.d=new Point(a.x-margin,a.y+margin,a.z);
        p.addPoint(a.getX() +margin,a.getY()+margin);
        p.addPoint(a.getX() +margin,a.getY()-margin);
        p.addPoint(a.getX() -margin,a.getY()-margin);
        p.addPoint(a.getX() -margin,a.getY()+margin);
    }   
       // Polygon p=new Polygon();
        
        
    public void setGraphics(Graphics g){
        this.g=g;
    }
    public void setColor(Color clr){
        color=clr;
    }
    public void fillColor(){
     
        //g.setColor(color);
        g.fillPolygon(p);
        System.out.println("filling color");
    }
    
}
