package cs5004.animator.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.LinkedHashMap;
import javax.swing.Timer;
import cs5004.animator.model.IModel;
import cs5004.animator.util.Shape;
import cs5004.animator.view.IView;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.VisualView;
import cs5004.animator.view.GUIView;

/**
 * Represents a Controller for Animation. User can handle animation in textual,
 * svg, visual, playback pattern.
 *
 * @author nanchen
 *
 */
public class AnimationController implements IController, ActionListener, ItemListener {

  private IView view;
  private IModel model;
  private AnimationThreads animation;
  private int animationPauseFlag;

  /**
   * Construct a controller and pass it with model and view.
   * 
   * @param model the animation data model
   * @param view  the view to show animation
   */
  public AnimationController(IModel model, IView view) {
    this.model = model;
    this.view = view;
    this.animation = new AnimationThreads(model, view);
    this.animationPauseFlag = 0;
  }

  @Override
  public void guiViewGo() {
    ((GUIView) view).setCanvas(model.getCanvas());
    ((GUIView) view).display(this);
  }

  /**
   * Actions taken when the JCheckBox "Looping", "Increase speed", "Decrease
   * speed" is selected.
   */
  @Override
  public void itemStateChanged(ItemEvent e) {
    Component c = (Component) e.getSource();
    if (c.getName().equals("EnableLooping")) {
      if (e.getStateChange() == ItemEvent.SELECTED) {
        this.animation.setLoopFlag(true);
      } else {
        this.animation.setLoopFlag(false);
      }
    } else {
      if (c.getName().equals("IncreaseSpeed") && e.getStateChange() == ItemEvent.SELECTED) {
        this.animation.setSleepTime(500);
      } else if (c.getName().equals("DecreaseSpeed") && e.getStateChange() == ItemEvent.SELECTED) {
        this.animation.setSleepTime(2000);
      } else {
        this.animation.setSleepTime(1000);
      }
    }
  }

  /**
   * Actions taken when the JButton "Start", "Pause", "Resume", "Restart" is
   * selected.
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    Component c = (Component) e.getSource();
    if (c.getName().equals("Start")) {
      new Thread(this.animation).start();
    }
    if (c.getName().equals("Pause")) {
      this.animationPauseFlag = this.animation.getCounter();
      this.animation.stopThread();

    }
    if (c.getName().equals("Resume")) {
      this.animation.resumeThread(this.animationPauseFlag);
      new Thread(this.animation).start();
    }
    if (c.getName().equals("Restart")) {
      if (this.animation.isFlag()) {
        this.animation.stopThread();
        this.animation.resumeThread(0);
      } else {
        this.animation.resumeThread(0);
        new Thread(this.animation).start();
      }
    }
  }

  @Override
  public void visualGo() {
    ((VisualView) view).setCanvas(model.getCanvas());
    ActionListener action = new ActionListener() {
      private int counter = 0;

      @Override
      public void actionPerformed(ActionEvent e) {
        int t = model.getAnimationAppearTime();
        int tick = t + counter;
        if (tick != 1) {
          tick = tick * model.getSpeed();
        }
        ((VisualView) view).update((LinkedHashMap<String, Shape>) model.move(tick));
        counter++;
        if ((t + counter) * model.getSpeed() > model.getAnimationDisappearTime()) {
          ((Timer) e.getSource()).stop();
          ((VisualView) view).showMessage("Animation Done!");
        }
      }
    };
    Timer timer = new Timer(1000, action);
    timer.start();
  }

  @Override
  public void textualConsoleGo() {
    ((TextualView) view).showTextualAnimations(model.getNameAppearState(),
        model.getOrderedMotionShapes(), model.getSpeed(), model.getNameDisappearTime());
  }

  @Override
  public void textualFileGo() {
    ((TextualView) view).writeTextualAnimations(model.getNameAppearState(),
        model.getOrderedMotionShapes(), model.getSpeed(), model.getNameDisappearTime());
  }

  @Override
  public void svgConsoleGo() {
    ((SVGView) view).showSVGAnimations(model.getNameTickShapeMap(), model.getCanvas(),
        model.getSpeed(), model.getNameDisappearTime());
  }

  @Override
  public void svgFileGo() {
    ((SVGView) view).writeSVGAnimations(model.getNameTickShapeMap(), model.getCanvas(),
        model.getSpeed(), model.getNameDisappearTime());
  }

}
