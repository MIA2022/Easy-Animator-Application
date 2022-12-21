package cs5004.animator.model;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import cs5004.animator.util.Canvas;
import cs5004.animator.util.Oval;
import cs5004.animator.util.Rectangle;
import cs5004.animator.util.Shape;

/**
 * A class implements the model.
 * 
 * @author nanchen
 *
 */
public class AnimationModel implements IModel {

  private Canvas canvas;
  private int animationAppearTime;
  private int animationDisappearTime;
  private int speed;
  private LinkedHashMap<String, String> nameTypeMap;
  private LinkedHashMap<String, LinkedList<Shape>> nameTickShapeMap;
  private LinkedHashMap<String, Shape> nameAppearState;
  private LinkedHashMap<String, Integer> nameDisappearTime;
  private LinkedHashMap<String, Integer> nameAppearTime;
  private LinkedList<Shape> orderedMotionShapes;

  /**
   * Take the speed given by command-line arguments ang construct the animation
   * model.
   * 
   * @param speed the speed given by command-line arguments
   */
  public AnimationModel(int speed) {
    this.canvas = null;
    this.animationAppearTime = Integer.MAX_VALUE;
    this.animationDisappearTime = -1;
    this.speed = speed;
    this.nameTypeMap = new LinkedHashMap<String, String>();
    this.nameTickShapeMap = new LinkedHashMap<String, LinkedList<Shape>>();
    this.nameAppearState = new LinkedHashMap<String, Shape>();
    this.nameDisappearTime = new LinkedHashMap<String, Integer>();
    this.nameAppearTime = new LinkedHashMap<String, Integer>();
    this.orderedMotionShapes = new LinkedList<Shape>();
  }

  @Override
  public void addCanvas(int x, int y, int width, int height) {
    this.canvas = new Canvas(x, y, width, height);

  }

  @Override
  public void addShape(String name, String type) {
    if (!this.nameTypeMap.containsKey(name)) {
      this.nameTypeMap.put(name, type);
    }
  }

  /*
   * Take shape in start tick and the shape in end tick, insert them in an sorted
   * list according to the start tick and return this list.
   * 
   * @param startShape the shape at the beginning of one motion.
   * 
   * @param endShape the shape at the end of one motion.
   * 
   * @param shapeList the sorted shape list according to the tick of startshape
   * 
   * @return the sorted shapelist
   */
  private static LinkedList<Shape> addShapesSorted(Shape startShape, Shape endShape,
      LinkedList<Shape> shapeList) {
    if (shapeList.size() == 0) {
      shapeList.add(startShape);
      shapeList.add(endShape);
    } else if (shapeList.get(0).getTick() > startShape.getTick()) {
      shapeList.add(0, startShape);
      shapeList.add(1, endShape);
    } else if (shapeList.get(shapeList.size() - 2).getTick() <= startShape.getTick()) {
      shapeList.add(shapeList.size(), startShape);
      shapeList.add(shapeList.size(), endShape);
    } else {
      int i = 0;
      while (shapeList.get(i).getTick() <= startShape.getTick()) {
        i += 2;
      }
      shapeList.add(i, startShape);
      shapeList.add(i + 1, endShape);
    }
    return shapeList;

  }

  /*
   * Return the two shapes as a shape array according to the given parameters.
   * 
   * @param name The name of the shape
   * 
   * @param t1 The start time of this transformation
   * 
   * @param x1 The initial x-position of the shape
   * 
   * @param y1 The initial y-position of the shape
   * 
   * @param w1 The initial width of the shape
   * 
   * @param h1 The initial height of the shape
   * 
   * @param r1 The initial red color-value of the shape
   * 
   * @param g1 The initial green color-value of the shape
   * 
   * @param b1 The initial blue color-value of the shape
   * 
   * @param t2 The end time of this transformation
   * 
   * @param x2 The final x-position of the shape
   * 
   * @param y2 The final y-position of the shape
   * 
   * @param w2 The final width of the shape
   * 
   * @param h2 The final height of the shape
   * 
   * @param r2 The final red color-value of the shape
   * 
   * @param g2 The final green color-value of the shape
   * 
   * @param b2 The final blue color-value of the shape
   * 
   * @return the two shapes as a shape array according to the given parameters.
   */
  private Shape[] constructShapes(String name, int t1, int x1, int y1, int w1, int h1, int r1,
      int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    Shape visualStartShape;
    Shape visualEndShape;
    String type = this.nameTypeMap.get(name);
    if (type.equals("rectangle")) {
      visualStartShape = new Rectangle(name, type, t1, x1, y1, w1, h1, r1, g1, b1);
      visualEndShape = new Rectangle(name, type, t2, x2, y2, w2, h2, r2, g2, b2);
    } else {
      visualStartShape = new Oval(name, type, t1, x1, y1, w1, h1, r1, g1, b1);
      visualEndShape = new Oval(name, type, t2, x2, y2, w2, h2, r2, g2, b2);
    }
    return new Shape[] { visualStartShape, visualEndShape };
  }

  @Override
  public void addMotion(String name, int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
      int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {

    Shape textualSVGStartShape;
    Shape textualSVGEndShape;
    Shape visualStartShape;
    Shape visualEndShape;
    Shape[] shapeArray;
    shapeArray = constructShapes(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2,
        b2);
    textualSVGStartShape = shapeArray[0].changeToSVGShape();
    textualSVGEndShape = shapeArray[1].changeToSVGShape();
    visualStartShape = shapeArray[0];
    visualEndShape = shapeArray[1];

    this.orderedMotionShapes = addShapesSorted(textualSVGStartShape, textualSVGEndShape,
        this.orderedMotionShapes);

    if (this.nameTickShapeMap.containsKey(name)) {
      LinkedList<Shape> list = this.nameTickShapeMap.get(name);
      list = addShapesSorted(visualStartShape, visualEndShape, list);
      // update disappear time of shape
      if (this.nameDisappearTime.get(name) < t2) {
        this.nameDisappearTime.put(name, t2);
      }
      // update disappear time of animation
      if (this.animationDisappearTime < t2) {
        this.animationDisappearTime = t2;
      }
    } else {
      this.nameAppearState.put(name, textualSVGStartShape);

      // get appear time of one shape
      this.nameAppearTime.put(name, t1);
      // get disappear time of one shape
      this.nameDisappearTime.put(name, t2);
      // get appear time of animation
      if (t1 < this.animationAppearTime) {
        this.animationAppearTime = t1;
      }
      // get disappear time of animation
      this.animationDisappearTime = t2;

      LinkedList<Shape> newMap = new LinkedList<Shape>();
      newMap.add(visualStartShape);
      newMap.add(visualEndShape);
      this.nameTickShapeMap.put(name, newMap);
    }
  }

  /*
   * The value at the given tick.
   * 
   * @param beginValue the “initial state” of shape at the initial tick
   * 
   * @param endValue the “final state” of shape at the final tick
   * 
   * @param appearTime the initial tick
   * 
   * @param disapperTime the final tick
   * 
   * @param tick the given tick
   * 
   * @return the value at the given tick.
   */
  private double computeTickValue(double beginValue, double endValue, int appearTime,
      int disapperTime, int tick) {
    int interval = disapperTime - appearTime;
    return (double) beginValue * (disapperTime - tick) / interval
        + endValue * (tick - appearTime) / interval;
  }

  /*
   * Return a shape at the given tick according to its “initial state” and “final
   * state”.
   * 
   * @param startShape “initial state” of one shape
   * 
   * @param endShape “final state” of one shape
   * 
   * @param tick the given tick
   * 
   * @return a shape at the given tick according to its “initial state” and “final
   * state”.
   */
  private Shape calculateTickState(Shape startShape, Shape endShape, int tick) {
    if (startShape.getTick() == endShape.getTick()) {
      return startShape;
    }
    double tickXPosition = computeTickValue(startShape.getxPosition(), endShape.getxPosition(),
        startShape.getTick(), endShape.getTick(), tick);
    double tickYPosition = computeTickValue(startShape.getyPosition(), endShape.getyPosition(),
        startShape.getTick(), endShape.getTick(), tick);
    double tickXDimension = computeTickValue(startShape.getxDimension(), endShape.getxDimension(),
        startShape.getTick(), endShape.getTick(), tick);
    double tickYDimension = computeTickValue(startShape.getyDimension(), endShape.getyDimension(),
        startShape.getTick(), endShape.getTick(), tick);
    double tickRColor = computeTickValue(startShape.getrColorValue(), endShape.getrColorValue(),
        startShape.getTick(), endShape.getTick(), tick);
    double tickGColor = computeTickValue(startShape.getgColorValue(), endShape.getgColorValue(),
        startShape.getTick(), endShape.getTick(), tick);
    double tickBColor = computeTickValue(startShape.getbColorValue(), endShape.getbColorValue(),
        startShape.getTick(), endShape.getTick(), tick);
    if (startShape.getType().equals("rectangle")) {
      return new Rectangle(startShape.getName(), startShape.getType(), tick, tickXPosition,
          tickYPosition, tickXDimension, tickYDimension, tickRColor, tickGColor, tickBColor);
    }
    return new Oval(startShape.getName(), startShape.getType(), tick, tickXPosition, tickYPosition,
        tickXDimension, tickYDimension, tickRColor, tickGColor, tickBColor);
  }

  /*
   * Find the nearest two shapes of the given tick in the given sorted linked
   * list.
   * 
   * @param list the given sorted linked list.
   * 
   * @param tick the given tick.
   * 
   * @return the shape array which has the nearest initial and final state.
   */
  private Shape[] findNearestShape(LinkedList<Shape> list, int tick) {
    Shape startShape = null;
    Shape endShape = null;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getTick() == tick) {
        startShape = list.get(i);
        endShape = list.get(i);
        break;
      }
      if (list.get(i).getTick() < tick && list.get(i + 1).getTick() > tick) {
        startShape = list.get(i);
        endShape = list.get(i + 1);
        break;
      }
    }
    return new Shape[] { startShape, endShape };
  }

  @Override
  public LinkedHashMap<String, Shape> move(int tick) {
    LinkedHashMap<String, Shape> motionShapeMap = new LinkedHashMap<String, Shape>();
    for (Entry<String, LinkedList<Shape>> entry : this.nameTickShapeMap.entrySet()) {
      LinkedList<Shape> list = entry.getValue();
      if (tick >= this.nameAppearTime.get(entry.getKey())
          && tick <= this.nameDisappearTime.get(entry.getKey())) {
        Shape[] nearestShapes = findNearestShape(list, tick);
        Shape tickState = calculateTickState(nearestShapes[0], nearestShapes[1], tick);
        motionShapeMap.put(entry.getKey(), tickState);
      } else {
        motionShapeMap.put(entry.getKey(), null);
      }
    }
    return motionShapeMap;
  }

  @Override
  public int getSpeed() {
    return speed;
  }

  @Override
  public Canvas getCanvas() {
    return this.canvas;
  }

  @Override
  public LinkedHashMap<String, Integer> getNameDisappearTime() {
    return nameDisappearTime;
  }

  @Override
  public LinkedHashMap<String, Integer> getNameAppearTime() {
    return nameAppearTime;
  }

  @Override
  public int getAnimationAppearTime() {
    return animationAppearTime;
  }

  @Override
  public int getAnimationDisappearTime() {
    return animationDisappearTime;
  }

  @Override
  public LinkedHashMap<String, LinkedList<Shape>> getNameTickShapeMap() {
    return nameTickShapeMap;
  }

  @Override
  public LinkedHashMap<String, Shape> getNameAppearState() {
    return nameAppearState;
  }

  @Override
  public LinkedList<Shape> getOrderedMotionShapes() {
    return orderedMotionShapes;
  }

}
