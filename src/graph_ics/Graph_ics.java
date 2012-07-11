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
public class Graph_ics {

    /**
     * @param args the command line arguments
     */
    public static FrameDraw frame=new FrameDraw();
    public void paint(){
        
        Graphics g=frame.getGraphics();
        g.drawLine(5, 6, 111, 111);
    }
    public void RotateAlongYaxis(double angle){
        
    }
    public static void main(String[] args) {
        // TODO code application logic here
//        Point p=new Point(100,0,0);
//        int i=0;
//        while(i++<20){
//            System.out.print("i="+i+" ");
//            p.viewPoint();
//            p=p.rotateAlongY(90);
//            
//        }
        frame.setVisible(true);
       // TestClass tc=new TestClass();
       // tc.draw();
//        Sphere sp=new Sphere();
//        sp.set_Center(200,200,-400);
//        sp.initialize();
//        sp.setGraphics(frame.getGraphics());
//        sp.paint();
//        sp.drawLatitudes();
//        sp.drawLongitudes();
        
        //System.out.println(Math.rint(2.6));
    }
}
