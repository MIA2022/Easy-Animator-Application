package cs5004.animator.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import cs5004.animator.util.Canvas;
import cs5004.animator.util.Shape;

/**
 * An interface contains the methods the SVGView supports.
 * 
 * @author nanchen
 *
 */
public interface SVGView extends IView {
  /**
   * Show the svg strings to the console.
   * 
   * @param nameTickShapeMap  the linkedHashMap whose keys represent the name of
   *                          the shapes and the values represents the appear
   *                          state in the animation.
   * @param canvas            the canvas of the animation.
   * @param speed             the speed of the animation.
   * @param nameDisappearTime the linkedHashMap whose keys represent the name of
   *                          the shapes and the values represents its appear
   *                          time.
   */
  void showSVGAnimations(LinkedHashMap<String, LinkedList<Shape>> nameTickShapeMap, Canvas canvas,
      int speed, HashMap<String, Integer> nameDisappearTime);

  /**
   * Show the svg strings to the file.
   * 
   * @param nameTickShapeMap  the linkedHashMap whose keys represent the name of
   *                          the shapes and the values represents the appear
   *                          state in the animation.
   * @param canvas            the canvas of the animation.
   * @param speed             the speed of the animation.
   * @param nameDisappearTime the linkedHashMap whose keys represent the name of
   *                          the shapes and the values represents its appear
   *                          time.
   */
  void writeSVGAnimations(LinkedHashMap<String, LinkedList<Shape>> nameTickShapeMap, Canvas canvas,
      int speed, HashMap<String, Integer> nameDisappearTime);
}
