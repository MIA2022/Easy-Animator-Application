package cs5004.animator.view;

import java.util.LinkedHashMap;

import cs5004.animator.controller.AnimationController;
import cs5004.animator.util.Canvas;
import cs5004.animator.util.Shape;

/**
 * An interface contains the methods the GUIView supports.
 * 
 * @author nanchen
 *
 */
public interface GUIView extends IView {
  /**
   * Display the animation given the controller.
   * 
   * @param control the AnimationController
   */
  void display(AnimationController control);

  /**
   * Update the animation according to the shapes in the motionShapeMap.
   * 
   * @param motionShapeMap the linkedHashMap whose keys represent the name of the
   *                       shapes and the values represents the shapes in the
   *                       given tick.
   */
  void update(LinkedHashMap<String, Shape> motionShapeMap);

  /**
   * Set the button state in the GUIView.
   */
  void setButtonState();

  /**
   * Show the given string.
   * 
   * @param string the string to be shown.
   */
  void showMessage(String string);

  /**
   * Set the canvas data of the GUIView.
   * 
   * @param canvas the canvas data of the GUIView.
   */
  void setCanvas(Canvas canvas);

}
