package cs5004.animator.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.JPanel;

import cs5004.animator.util.Canvas;
import cs5004.animator.util.Shape;

/**
 * A class represents the animation panel.
 * 
 * @author nanchen
 *
 */
public class AnimationPanel extends JPanel {
  private LinkedHashMap<String, Shape> motionShapeMap;
  private Canvas canvas;

  /**
   * Contruct a AnimationPanel.
   */
  public AnimationPanel() {
    super(true);
    this.setBackground(Color.white);
    this.motionShapeMap = new LinkedHashMap<String, Shape>();
    this.canvas = null;
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Map.Entry<String, Shape> e : this.motionShapeMap.entrySet()) {
      if (e.getValue() != null) {
        g.setColor(new Color((int) e.getValue().getrColorValue(),
            (int) e.getValue().getgColorValue(), (int) e.getValue().getbColorValue()));
        if (e.getValue().getType().equals("ellipse")) {
          g.fillOval((int) e.getValue().getxPosition() - canvas.getCanvasCoordX(),
              (int) e.getValue().getyPosition() - canvas.getCanvasCoordY(),
              (int) e.getValue().getxDimension(), (int) e.getValue().getyDimension());
        }
        if (e.getValue().getType().equals("rectangle")) {
          g.fillRect((int) e.getValue().getxPosition() - canvas.getCanvasCoordX(),
              (int) e.getValue().getyPosition() - canvas.getCanvasCoordY(),
              (int) e.getValue().getxDimension(), (int) e.getValue().getyDimension());
        }
      }
    }
  }

  /**
   * Set the motionShapeMap of this panel using the given motionShapeMap.
   * 
   * @param motionShapeMap the linkedHashMap represents the shapes in the pamel
   */
  public void setMotion(LinkedHashMap<String, Shape> motionShapeMap) {
    this.motionShapeMap = motionShapeMap;
  }

  /**
   * Set the canvas data of this panel.
   * 
   * @param canvas the canvas data.
   */
  public void setCanvas(Canvas canvas) {
    this.canvas = canvas;
  }
}
