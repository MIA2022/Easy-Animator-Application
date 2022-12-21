package cs5004.animator.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedHashMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.util.Canvas;
import cs5004.animator.util.Shape;

/**
 * A class implements GUIView.
 * 
 * @author nanchen
 *
 */
public class GUIViewImpl extends JFrame implements GUIView, ActionListener, ItemListener {

  private JPanel bottonPane1;
  private JPanel bottonPane2;
  private JCheckBox loopCheckBox;
  private JCheckBox speedCheckBox1;
  private JCheckBox speedCheckBox2;
  private JButton startButton;
  private JButton pauseButton;
  private JButton resumeButton;
  private JButton restartButton;
  private AnimationPanel ap;

  /**
   * Construct the GUIViewImpl.And set the frame window, panel, checkBoxes and
   * buttons.
   */
  public GUIViewImpl() {
    super("Playback Animation");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);

    ap = new AnimationPanel();
    this.add(this.ap);
    bottonPane1 = new JPanel(true);
    bottonPane2 = new JPanel(true);
    loopCheckBox = new JCheckBox("Looping");
    speedCheckBox1 = new JCheckBox("Increase speed");
    speedCheckBox2 = new JCheckBox("Decrease speed");
    startButton = new JButton("Start");
    pauseButton = new JButton("Pause");
    resumeButton = new JButton("Resume");
    restartButton = new JButton("Restart");
    JButton exitButton = new JButton("Exit");

    this.loopCheckBox.setName("EnableLooping");
    this.loopCheckBox.addItemListener(this);
    loopCheckBox.setSelected(false);

    this.speedCheckBox1.setName("IncreaseSpeed");
    this.speedCheckBox1.addItemListener(this);
    speedCheckBox1.setSelected(false);

    this.speedCheckBox2.setName("DecreaseSpeed");
    this.speedCheckBox2.addItemListener(this);
    speedCheckBox2.setSelected(false);

    this.bottonPane1.add(loopCheckBox);
    this.bottonPane1.add(speedCheckBox1);
    this.bottonPane1.add(speedCheckBox2);

    this.startButton.setName("Start");
    this.startButton.addActionListener(this);
    this.bottonPane2.add(startButton);

    this.pauseButton.setName("Pause");
    this.pauseButton.addActionListener(this);
    pauseButton.setEnabled(false);
    this.bottonPane2.add(pauseButton);

    this.resumeButton.setName("Resume");
    this.resumeButton.addActionListener(this);
    resumeButton.setEnabled(false);
    this.bottonPane2.add(resumeButton);

    this.restartButton.setName("Restart");
    this.restartButton.addActionListener(this);
    restartButton.setEnabled(false);
    this.bottonPane2.add(restartButton);

    exitButton.setName("Exit");
    exitButton.addActionListener(this);
    this.bottonPane2.add(exitButton);

    this.add(bottonPane1);
    this.add(bottonPane2);
  }

  @Override
  public void itemStateChanged(ItemEvent e) {
    Component c = (Component) e.getSource();
    if (c.getName().equals("IncreaseSpeed")) {
      if (speedCheckBox1.isSelected()) {
        speedCheckBox2.setEnabled(false);
      } else {
        speedCheckBox2.setEnabled(true);
      }
    }
    if (c.getName().equals("DecreaseSpeed")) {
      if (speedCheckBox2.isSelected()) {
        speedCheckBox1.setEnabled(false);
      } else {
        speedCheckBox1.setEnabled(true);
      }
    }
  }

  @Override
  public void display(AnimationController control) {
    this.speedCheckBox1.addItemListener(control);
    this.speedCheckBox2.addItemListener(control);
    this.loopCheckBox.addItemListener(control);
    this.startButton.addActionListener(control);
    this.pauseButton.addActionListener(control);
    this.resumeButton.addActionListener(control);
    this.restartButton.addActionListener(control);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    Component c = (Component) e.getSource();
    if (c.getName().equals("Start")) {
      pauseButton.setEnabled(true);
      resumeButton.setEnabled(false);
      restartButton.setEnabled(true);

    }
    if (c.getName().equals("Pause")) {
      pauseButton.setEnabled(false);
      startButton.setEnabled(false);
      resumeButton.setEnabled(true);
      restartButton.setEnabled(true);
    }
    if (c.getName().equals("Resume")) {
      resumeButton.setEnabled(false);
      startButton.setEnabled(false);
      pauseButton.setEnabled(true);
      restartButton.setEnabled(true);
    }
    if (c.getName().equals("Restart")) {
      startButton.setEnabled(false);
      resumeButton.setEnabled(false);
      pauseButton.setEnabled(true);
    }
    if (c.getName().equals("Exit")) {
      System.exit(0);
    }
  }

  @Override
  public void setButtonState() {
    startButton.setEnabled(false);
    pauseButton.setEnabled(false);
    resumeButton.setEnabled(false);
    restartButton.setEnabled(true);
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

  @Override
  public void setCanvas(Canvas canvas) {
    int width = Math.max(canvas.getCanvasWidth() + 25, 800);
    int height = Math.max(canvas.getCanvasHeight() + 150, 800);
    this.setBounds(canvas.getCanvasCoordX(), canvas.getCanvasCoordY(), width, height);
    this.ap.setCanvas(canvas);
    this.ap.setBounds(0, 0, canvas.getCanvasWidth(), canvas.getCanvasHeight());
    this.bottonPane1.setBounds(0, canvas.getCanvasCoordY() + canvas.getCanvasHeight() + 25,
        canvas.getCanvasWidth(), 50);
    this.bottonPane2.setBounds(0, canvas.getCanvasCoordY() + canvas.getCanvasHeight() + 75,
        canvas.getCanvasWidth(), 75);
  }

}
