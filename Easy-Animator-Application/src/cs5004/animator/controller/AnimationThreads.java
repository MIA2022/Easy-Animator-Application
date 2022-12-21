package cs5004.animator.controller;

import java.util.LinkedHashMap;

import cs5004.animator.model.IModel;
import cs5004.animator.util.Shape;
import cs5004.animator.view.GUIView;
import cs5004.animator.view.IView;

/**
 * Construct a thread for GUI animation.
 * 
 * @author nanchen
 *
 */
public class AnimationThreads implements Runnable {

  private boolean flag;
  private boolean loopFlag;
  private int counter;
  private int sleepTime;
  private IModel model;
  private IView view;

  /**
   * Taking model and view as parameters, construct a thread for animation.
   * 
   * @param model the animation data model
   * @param view  the view to show animation
   */
  public AnimationThreads(IModel model, IView view) {
    this.model = model;
    this.view = view;
    this.flag = true;
    this.loopFlag = false;
    this.counter = 0;
    this.sleepTime = 2000;

  }

  @Override
  public void run() {
    while (flag) {
      try {
        Thread.sleep(sleepTime);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      int t = model.getAnimationAppearTime();
      int tick = t + counter;
      if (tick != 1) {
        tick = tick * model.getSpeed();
      }
      ((GUIView) view).update((LinkedHashMap<String, Shape>) model.move(tick));
      counter++;

      if (tick > model.getAnimationDisappearTime()) {
        if (loopFlag) {
          counter = 0;
        } else {
          flag = false;
          ((GUIView) view).setButtonState();
          ((GUIView) view).showMessage("Animation Done!");
        }
      }
    }
  }

  /**
   * Stop the thread using flag.
   */
  public void stopThread() {
    flag = false;
  }

  /**
   * Resume the thread and update the counter number.
   * 
   * @param resumeCounter the counter number to update the animation
   */
  public void resumeThread(int resumeCounter) {
    flag = true;
    this.counter = resumeCounter;
  }

  /**
   * Set the sleep time for the thread.
   * 
   * @param time the sleep time for the thread
   */
  public void setSleepTime(int time) {
    sleepTime = time;
  }

  /**
   * Set the loop flag.
   * 
   * @param loopFlag if true the animation will restart automatically. Otherwise,
   *                 it will be false.
   */
  public void setLoopFlag(boolean loopFlag) {
    this.loopFlag = loopFlag;
  }

  /**
   * Return the flag.
   * 
   * @return true if the thread is alive. Otherwise false.
   */
  public boolean isFlag() {
    return flag;
  }

  /**
   * Return the loop flag.
   * 
   * @return true if the animation can restart automatically. Otherwise false.
   */
  public boolean isLoopFlag() {
    return loopFlag;
  }

  /**
   * Return the counter number.
   * 
   * @return the counter number.
   */
  public int getCounter() {
    return counter;
  }

  /**
   * Return the sleep time.
   * 
   * @return the sleep time.
   */
  public int getSleepTime() {
    return sleepTime;
  }

}
