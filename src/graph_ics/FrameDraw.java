/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameDraw.java
 *
 * Created on Aug 17, 2011, 5:07:34 PM
 */
package graph_ics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

/**
 *
 * @author power
 */
public class FrameDraw extends javax.swing.JFrame {
Sphere sp=new Sphere();
Sphere earth=new Sphere();
Sphere sun=new Sphere();
Point sunCenter=new Point(600,400,-1500);
Point earthCenter=new Point(1600,400,-1500);
Point spCenter=new Point(2000,400,-1500);
int viewAngle=0;
//Point ForRevolution=new Point(700,0,-1500);
//Surfaces surfaces=new Surfaces();
Graphics g;//=this.getGraphics();
    /** Creates new form FrameDraw */
public void increaseZ(){
        int increment=50;
        earthCenter=new Point(earthCenter.x,earthCenter.y,earthCenter.z+increment);
        spCenter=new Point(spCenter.x,spCenter.y,spCenter.z+increment);
        sunCenter=new Point(sunCenter.x,sunCenter.y,sunCenter.z+increment);
    }
    public void decreaseZ(){
        int increment=-50;
        spCenter=new Point(spCenter.x,spCenter.y,spCenter.z+increment);
        earthCenter=new Point(earthCenter.x,earthCenter.y,earthCenter.z+increment);
        sunCenter=new Point(sunCenter.x,sunCenter.y,sunCenter.z+increment);
    }
public void setCenters(){
    sp.set_Center(spCenter);
        earth.set_Center(earthCenter);
        sun.set_Center(sunCenter);
}
public void fillColor(){
        //System.out.println("filling color");
//    Point a=new Point(0,100,100);
//    Point b=new Point(100,200,100);
//    Point c=new Point(200,200,100);
//    Point d=new Point(400,50,100);
//    Color color=Color.red;
////        Polygon p=new Polygon();
////        
////        p.addPoint(a.getX(),a.getY());
////        p.addPoint(b.getX(),b.getY());
////        p.addPoint(c.getX(), c.getY());
////        p.addPoint(d.getX(), d.getY());
////        p.addPoint(a.getX(), a.getY());
////        g.setColor(color);
////        g.fillPolygon(p);
//    Surface sur=new Surface(a,b,c,d);
//    sur.setGraphics(this.getGraphics());
//    sur.setColor(Color.red);
//    sur.fillColor();
    }
    public void arrangeGraphicObjects(){
        earth.initialize();
        sp.initialize();
        sun.initialize();
        
        
        sp.setGraphics(this.getGraphics());
        earth.setGraphics(this.getGraphics());
        sun.setGraphics(this.getGraphics());
        sp.setColor(Color.white);
        earth.setColor(Color.blue);
        sun.setColor(Color.red);
       // this.getGraphics().setColor(Color.red);
        //surfaces.g=this.getGraphics();
        //g=this.getGraphics();
        earth.rotateAlongX(20);
        earth.rotateAlongY(5);
        sp.rotateAlongX(50);
        sp.rotateAlongY(30);
//        sun.rotateAlongX(30);
//        sun.rotateAlongY(30);
        //surfaces.earth_center=earth.center;
        //surfaces.sun_center=new Point(-1000,200,-400);
        //surfaces.earth_center=earth.center;
        //surfaces.initiateSurfaceTable(sp);
    }
    public FrameDraw() {
        this.setBackground(Color.black);
        initComponents();
        this.setSize(1000,800);
        this.setCenters();
        
        earth.setRadius(100);
        sp.setRadius(40);
        sun.setRadius(200);
        
        this.arrangeGraphicObjects();
        
        //g.clearRect(0, 20, this.getWidth(), this.getHeight());
        earth.prospectiveView();
        sun.prospectiveView();
        sp.prospectiveView();
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 651, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        
        
        //sp.paint();
        //sp.fillSurface();
        g=this.getGraphics();
        if(evt.getKeyCode()==KeyEvent.VK_LEFT){
            g.clearRect(0, 20, this.getWidth(), this.getHeight());
//            sp.rotateAlongTheta(5);
            earth.rotateAlongZ(5);
            earth.prospectiveView();
        }
        if(evt.getKeyCode()==KeyEvent.VK_RIGHT){
          g.clearRect(0, 20, this.getWidth(), this.getHeight());
//            sp.rotateAlongY(2);
//            sp.drawLatitudes();
//            sp.drawLongitudes();
//            earth.prospectiveView();
           // earth.rotateAlongTheta(2);
//            viewAngle-=5;
//            viewAngle%=360;
//            Point p=sun.center;//new Point (600,400,-2000);
//            earth.RotateViewPoint(viewAngle,p);
//            sun.RotateViewPoint(viewAngle, p);
//            sp.RotateViewPoint(viewAngle, p);
        }
        if(evt.getKeyCode()==KeyEvent.VK_UP){
            //g.clearRect(20, 20, 500, 500);
            
//            //sp.rotateAlongTheta(5);
//            
//            sp.RevolveAlongY(5,earth.center);
//            sp.prospectiveView();
//            earth.prospectiveView();
//            earth.rotateAlongX(2);
            viewAngle-=5;
            viewAngle%=360;
            Point p=sun.center;//new Point (600,400,-2000);
            g.clearRect(0, 20, this.getWidth(), this.getHeight());
            earth.RotateViewPoint(viewAngle,p);
            sun.RotateViewPoint(viewAngle, p);
            sp.RotateViewPoint(viewAngle, p);
        }else if (evt.getKeyCode()==KeyEvent.VK_DOWN){
            viewAngle+=5;
            viewAngle%=360;
            Point p=sun.center;//new Point (600,400,-2000);
            g.clearRect(0, 20, this.getWidth(), this.getHeight());
            earth.RotateViewPoint(viewAngle,p);
            sun.RotateViewPoint(viewAngle, p);
            sp.RotateViewPoint(viewAngle, p);
        }
        if(evt.getKeyCode()==KeyEvent.VK_L){
//            sp.set_Center(sp.center.getX()+5, sp.center.getY(), sp.center.getZ());
//            g.clearRect(20, 20, 500, 500);
//            sp.prospectiveView();
//            earth.prospectiveView();
//            earth.rotateAlongY(2);
            earth.drawLongitudes();
        }
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            g.clearRect(0, 20, this.getWidth(), this.getHeight());
            //sp.rotateAlongTheta(5);
            
            sp.RevolveAlongY(10,earth.center);
            //sp.rotateAlongY(WIDTH);
            sp.rotateAlongY(3);
            earth.rotateAlongY(1);
            earth.RevolveAlongY(1, sun.center);
            sun.rotateAlongY(1);
//            sp.prospectiveView();
//            earth.prospectiveView();
//            sun.prospectiveView();
            Point p=sun.center;//new Point (600,400,-2000);
            earth.RotateViewPoint(viewAngle,p);
            sun.RotateViewPoint(viewAngle, p);
            sp.RotateViewPoint(viewAngle, p);
            
        }
        if(evt.getKeyCode()==KeyEvent.VK_1){
            g.clearRect(0, 20, this.getWidth(), this.getHeight());
            sp.RevolveAlongY(5,earth.center);
            earth.rotateAlongY(2);
            //surfaces.moon_center=sp.center;
            sp.prospectiveView();
            earth.prospectiveView();
//            surfaces.initiateSurfaceTable(sp);
//            surfaces.initiateSurfaceTable(earth);
            
        }
        if(evt.getKeyCode()==KeyEvent.VK_C){
            g.clearRect(0, 20, this.getWidth(), this.getHeight());
        }
        if(evt.getKeyCode()==KeyEvent.VK_D){
            fillColor();
        }
    }//GEN-LAST:event_formKeyPressed

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        // TODO add your handling code here:
        int code=evt.getWheelRotation();
        if(code<0){
            this.increaseZ();
            this.setCenters();
            this.arrangeGraphicObjects();
            g.clearRect(0, 20, this.getWidth(), this.getHeight());
            Point p=sun.center;//new Point (600,400,-2000);
            earth.RotateViewPoint(viewAngle,p);
            sun.RotateViewPoint(viewAngle, p);
            sp.RotateViewPoint(viewAngle, p);
        }
        if(code>0){
           this.decreaseZ();
           this.setCenters();
           this.arrangeGraphicObjects();
            g.clearRect(0, 20, this.getWidth(), this.getHeight());
            Point p=sun.center;//new Point (600,400,-2000);
            earth.RotateViewPoint(viewAngle,p);
            sun.RotateViewPoint(viewAngle, p);
            sp.RotateViewPoint(viewAngle, p);
        }
    }//GEN-LAST:event_formMouseWheelMoved
    @Override
    public void paint(Graphics g){
        
        g.drawString("scrool mouse for shifting the viewing plane", 100, 100);
        g.drawString("press up/down arrow to change the angle of view", 100, 120);
        g.drawString("press space to rotate", 100, 140);
        //g.setColor(Color.white);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrameDraw().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
