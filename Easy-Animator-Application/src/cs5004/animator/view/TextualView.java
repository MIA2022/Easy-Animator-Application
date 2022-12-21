package cs5004.animator.view;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import cs5004.animator.util.Shape;

/**
 * An interface contains the methods the TextualView supports.
 * 
 * @author nanchen
 *
 */
public interface TextualView extends IView {
  /**
   * Show the animation strings to the console.
   * 
   * @param nameAppearState     the linkedHashMap whose keys represent the name of
   *                            the shapes and the values represents the appear
   *                            state in the animation.
   * @param orderedMotionShapes the linkedlist which represents the sorted
   *                            animation states according to the tick number.
   * @param speed               the speed of the animation.
   * @param nameDisappearTime   the linkedHashMap whose keys represent the name of
   *                            the shapes and the values represents its disappear
   *                            time.
   */
  void showTextualAnimations(LinkedHashMap<String, Shape> nameAppearState,
      LinkedList<Shape> orderedMotionShapes, int speed, HashMap<String, Integer> nameDisappearTime);

  /**
   * Show the animation strings to the file.
   * 
   * @param nameAppearState     the linkedHashMap whose keys represent the name of
   *                            the shapes and the values represents the appear
   *                            state in the animation.
   * @param orderedMotionShapes the linkedlist which represents the sorted
   *                            animation states according to the tick number.
   * @param speed               the speed of the animation.
   * @param nameDisappearTime   the linkedHashMap whose keys represent the name of
   *                            the shapes and the values represents its disappear
   *                            time.
   */
  void writeTextualAnimations(LinkedHashMap<String, Shape> nameAppearState,
      LinkedList<Shape> orderedMotionShapes, int speed, HashMap<String, Integer> nameDisappearTime);

}
