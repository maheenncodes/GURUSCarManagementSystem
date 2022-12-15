/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admin;

/**
 *
 * @author user
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JComponent;

class Slice 
{
public  double value;
 public  Color color;

  public Slice(double value, Color color)
  {
    this.value = value;
    this.color = color;
  }
}

class MyComponent extends JComponent 
{
    int sold;
    int ava;
      Slice[] slices = new Slice[2];

        MyComponent(int s,int a) 
        {
            this.sold=s;
            this.ava = a;

              slices[0] = new Slice(sold,Color.red);
              slices[1] = new Slice(ava, Color.blue);
            
        
        }
        
       
        
        public void paint(Graphics g) {
          drawPie((Graphics2D) g, getBounds(), slices);
        }

        void drawPie(Graphics2D g, Rectangle area, Slice[] slices) {
          double total = 0.0D;
          for (int i = 0; i < slices.length; i++) {
            total += slices[i].value;
          }

          double curValue = 0.0D;
          int startAngle = 0;
          for (int i = 0; i < slices.length; i++) {
            startAngle = (int) (curValue * 360 / total);
            int arcAngle = (int) (slices[i].value * 360 / total);

            g.setColor(slices[i].color);
            g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
            curValue += slices[i].value;
          }
  }
}
