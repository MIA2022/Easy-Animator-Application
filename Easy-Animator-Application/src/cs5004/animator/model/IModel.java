package cs5004.animator.model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import cs5004.animator.util.Canvas;
import cs5004.animator.util.Shape;

/**
 * A model takes the attributes datas of canvas and shapes. Then store the
 * shapes in the animation in ticks as well as the appear time and disappear
 * time of each kinds of shapes and animation.
 * 
 * @author nanchen
 *
 */
public interface IModel {

  /**
   * Add the bounding data to be used for the animation.
   * 
   * @param x      The leftmost x value
   * @param y      The topmost y value
   * @param width  The width of the bounding box
   * @param height The height of the bounding box
   */
  void addCanvas(int x, int y, int width, int height);

  /**
   * Add the name and type data for the shapes in the animation.
   * 
   * @param name the name of the shape
   * @param type the type of the shape
   */
  void addShape(String name, String type);

  /**
   * Add the data of shapes in two different ticks.
   * 
   * @param name The name of the shape
   * @param t1   The start time of this transformation
   * @param x1   The initial x-position of the shape
   * @param y1   The initial y-position of the shape
   * @param w1   The initial width of the shape
   * @param h1   The initial height of the shape
   * @param r1   The initial red color-value of the shape
   * @param g1   The initial green color-value of the shape
   * @param b1   The initial blue color-value of the shape
   * @param t2   The end time of this transformation
   * @param x2   The final x-position of the shape
   * @param y2   The final y-position of the shape
   * @param w2   The final width of the shape
   * @param h2   The final height of the shape
   * @param r2   The final red color-value of the shape
   * @param g2   The final green color-value of the shape
   * @param b2   The final blue color-value of the shape
   */
  void addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
      int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2);

  /**
   * The shapes in the animation canvas during the given tick.
   * 
   * @param tick the tick units
   * @return the linkedHashMap whose keys represent the name of the shapes and the
   *         values represents the shapes in the given tick.
   */
  LinkedHashMap<String, Shape> move(int tick);

  /**
   * Get the speed of the animation.
   * 
   * @return the speed of the animation.
   */
  int getSpeed();

  /**
   * Get the canvas of the animation.
   * 
   * @return the canvas of the animation.
   */
  Canvas getCanvas();

  /**
   * Get the appear time of the animation.
   * 
   * @return the appear time of the animation.
   */
  int getAnimationAppearTime();

  /**
   * Get the disappear time of the animation.
   * 
   * @return the disappear time of the animation.
   */
  int getAnimationDisappearTime();

  /**
   * Get the linkedHashMap whose keys represent the name of the shapes and the
   * values represents its disappear time.
   * 
   * @return the linkedHashMap whose keys represent the name of the shapes and the
   *         values represents its disappear time.
   */
  LinkedHashMap<String, Integer> getNameDisappearTime();

  /**
   * Get the linkedHashMap whose keys represent the name of the shapes and the
   * values represents its appear time.
   * 
   * @return the linkedHashMap whose keys represent the name of the shapes and the
   *         values represents its appear time.
   */
  LinkedHashMap<String, Integer> getNameAppearTime();

  /**
   * Get the linkedHashMap whose keys represent the name of the shapes and the
   * values represents all motion states.
   * 
   * @return the linkedHashMap whose keys represent the name of the shapes and the
   *         values represents all motion states.
   */
  LinkedHashMap<String, LinkedList<Shape>> getNameTickShapeMap();

  /**
   * Get the linkedHashMap whose keys represent the name of the shapes and the
   * values represents the appear state in the animation.
   * 
   * @return the linkedHashMap whose keys represent the name of the shapes and the
   *         values represents the appear state in the animation.
   */
  LinkedHashMap<String, Shape> getNameAppearState();

  /**
   * Get the linkedlist which represents the sorted animation states according to
   * the tick number.
   * 
   * @return the linkedlist which represents the sorted animation states according
   *         to the tick number.
   */
  LinkedList<Shape> getOrderedMotionShapes();

}
