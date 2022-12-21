package cs5004.animator.view;

import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import cs5004.animator.util.Canvas;
import cs5004.animator.util.Shape;

/**
 * A class implements VisualView.
 * 
 * @author nanchen
 *
 */
public class VisualViewImpl extends JFrame implements VisualView {

  private AnimationPanel ap;

  /**
   * Construct the VisualViewImp.And set the frame window, panel.
   */
  public VisualViewImpl() {
    super("Animation");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);
    this.ap = new AnimationPanel();
    this.add(this.ap);

  }

  @Override
  public void setCanvas(Canvas canvas) {
    this.setBounds(canvas.getCanvasCoordX(), canvas.getCanvasCoordY(), canvas.getCanvasWidth() + 25,
        canvas.getCanvasHeight() + 50);
    this.ap.setCanvas(canvas);
    this.ap.setBounds(0, 0, canvas.getCanvasWidth(), canvas.getCanvasHeight());
  }

  @Override
  public void update(LinkedHashMap<String, Shape> motionShapeMap) {
    this.ap.setMotion(motionShapeMap);
    this.ap.repaint();
  }

  @Override
  public void showMessage(String message) {
    JOptionPane.showMessageDialog(this, message);

  }

}
