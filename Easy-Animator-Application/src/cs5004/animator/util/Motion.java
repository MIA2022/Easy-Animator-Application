package cs5004.animator.util;

/**
 * A helper to decide how the shapes animate.
 * 
 * @author nanchen
 *
 */
public class Motion {

  /**
   * Return true if the tick of initial state of the shape is different from the
   * final state of the shape. Otherwise, return false.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @return true if the tick of initial state of the shape is different from the
   *         final state of the shape. Otherwise, return false.
   */
  public static boolean motion(Shape startShape, Shape endShape) {
    return startShape.getTick() != endShape.getTick();
  }

  /**
   * Return true if the x-position of initial state of the shape is different from
   * the final state of the shape. Otherwise, return false.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @return true if the x-position of initial state of the shape is different
   *         from the final state of the shape. Otherwise, return false.
   */
  public static boolean moveX(Shape startShape, Shape endShape) {
    return motion(startShape, endShape) && (startShape.getxPosition() != endShape.getxPosition());
  }

  /**
   * Return true if the y-position of initial state of the shape is different from
   * the final state of the shape. Otherwise, return false.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @return true if the y-position of initial state of the shape is different
   *         from the final state of the shape. Otherwise, return false.
   */
  public static boolean moveY(Shape startShape, Shape endShape) {
    return motion(startShape, endShape) && (startShape.getyPosition() != endShape.getyPosition());
  }

  /**
   * Return true if the x-dimension of initial state of the shape is different
   * from the final state of the shape. Otherwise, return false.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @return true if the x-dimension of initial state of the shape is different
   *         from the final state of the shape. Otherwise, return false.
   */
  public static boolean scaleX(Shape startShape, Shape endShape) {
    return motion(startShape, endShape) && (startShape.getxDimension() != endShape.getxDimension());
  }

  /**
   * Return true if the y-dimension of initial state of the shape is different
   * from the final state of the shape. Otherwise, return false.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @return true if the y-dimension of initial state of the shape is different
   *         from the final state of the shape. Otherwise, return false.
   */
  public static boolean scaleY(Shape startShape, Shape endShape) {
    return motion(startShape, endShape) && (startShape.getyDimension() != endShape.getyDimension());
  }

  /**
   * Return true if the color of initial state of the shape is different from the
   * final state of the shape. Otherwise, return false.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @return true if the color of initial state of the shape is different from the
   *         final state of the shape. Otherwise, return false.
   */
  public static boolean changeColor(Shape startShape, Shape endShape) {
    return motion(startShape, endShape)
        && ((startShape.getrColorValue() != endShape.getrColorValue())
            || (startShape.getgColorValue() != endShape.getgColorValue())
            || (startShape.getbColorValue() != endShape.getbColorValue()));
  }

  /**
   * Change the given tick to the correspoding time according to the given speed.
   * 
   * @param tick  the tick time
   * @param speed the speed represents the speed of the animation
   * @return the correspoding time calculated by tick
   */
  public static double changeFromTickToTime(int tick, int speed) {
    double time = 1;
    if (tick > 1) {
      time = (double) tick / speed;
    }
    return time;
  }

  /**
   * Return the string represents the change of from the initial state to the
   * final state of the shape and change the tick to time according to speed.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @param speed      the speed represents the speed of the animation
   * @return the string represents the change of from the initial state to the
   *         final state of the shape
   */
  public static String motionText(Shape startShape, Shape endShape, int speed) {
    String output = "";

    if (moveX(startShape, endShape) || moveY(startShape, endShape)) {
      output += "Shape " + startShape.getName() + " moves from " + startShape.positionGeneral()
          + " to " + endShape.positionGeneral() + " from t="
          + (int) changeFromTickToTime(startShape.getTick(), speed) + " to t="
          + (int) changeFromTickToTime(endShape.getTick(), speed) + "\n";
    }
    if (scaleX(startShape, endShape) || scaleY(startShape, endShape)) {
      output += "Shape " + startShape.getName() + " scales from " + startShape.dimensionString()
          + " to " + endShape.dimensionString() + " from t="
          + (int) changeFromTickToTime(startShape.getTick(), speed) + " to t="
          + (int) changeFromTickToTime(endShape.getTick(), speed) + "\n";
    }
    if (changeColor(startShape, endShape)) {
      output += "Shape " + startShape.getName() + " changes color from " + startShape.colorString()
          + " to " + endShape.colorString() + " from t="
          + (int) changeFromTickToTime(startShape.getTick(), speed) + " to t="
          + (int) changeFromTickToTime(endShape.getTick(), speed) + "\n";
    }

    return output;
  }

  /**
   * Return the beginnin time and the durarion time of the change of from the
   * initial state to the final state of the shape according to the speed.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @param speed      the speed represents the speed of the animation
   * @return an int array which contains the beginnin time and the durarion time
   */
  private static int[] calculateSVGTime(Shape startShape, Shape endShape, int speed) {
    int beginTime = (int) (changeFromTickToTime(startShape.getTick(), speed) * 1000);
    int durationTime = (int) ((changeFromTickToTime(endShape.getTick(), speed) * 1000)
        - (changeFromTickToTime(startShape.getTick(), speed) * 1000));
    return new int[] { beginTime, durationTime };
  }

  /**
   * Return the svg string represents the animation of XPosition.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @param speed      the speed represents the speed of the animation
   * @return the svg string represents the animation of XPosition.
   */
  public static String svgXPosition(Shape startShape, Shape endShape, int speed) {
    String output = "";
    if (moveX(startShape, endShape)) {
      output += startShape.svgXPosition(calculateSVGTime(startShape, endShape, speed)[0],
          calculateSVGTime(startShape, endShape, speed)[1], (int) startShape.getSVGxPosition(),
          (int) endShape.getSVGxPosition());
    }
    return output;
  }

  /**
   * Return the svg string represents the animation of YPosition.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @param speed      the speed represents the speed of the animation
   * @return the svg string represents the animation of YPosition.
   */
  public static String svgYPosition(Shape startShape, Shape endShape, int speed) {
    String output = "";
    if (moveY(startShape, endShape)) {
      output += startShape.svgYPosition(calculateSVGTime(startShape, endShape, speed)[0],
          calculateSVGTime(startShape, endShape, speed)[1], (int) startShape.getSVGyPosition(),
          (int) endShape.getSVGyPosition());
    }
    return output;
  }

  /**
   * Return the svg string represents the animation of XDimension.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @param speed      the speed represents the speed of the animation
   * @return the svg string represents the animation of XDimension.
   */
  public static String svgXDimension(Shape startShape, Shape endShape, int speed) {
    String output = "";
    if (scaleX(startShape, endShape)) {
      output += startShape.svgXDimension(calculateSVGTime(startShape, endShape, speed)[0],
          calculateSVGTime(startShape, endShape, speed)[1], (int) startShape.getSVGxDimension(),
          (int) endShape.getSVGxDimension());
    }
    return output;
  }

  /**
   * Return the svg string represents the animation of YDimension.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @param speed      the speed represents the speed of the animation
   * @return the svg string represents the animation of YDimension.
   */
  public static String svgYDimension(Shape startShape, Shape endShape, int speed) {
    String output = "";
    if (scaleY(startShape, endShape)) {
      output += startShape.svgYDimension(calculateSVGTime(startShape, endShape, speed)[0],
          calculateSVGTime(startShape, endShape, speed)[1], (int) startShape.getSVGyDimension(),
          (int) endShape.getSVGyDimension());
    }
    return output;
  }

  /**
   * Return the svg string represents the animation of color.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @param speed      the speed represents the speed of the animation
   * @return the svg string represents the animation of color.
   */
  public static String svgColor(Shape startShape, Shape endShape, int speed) {
    String output = "";
    if (changeColor(startShape, endShape)) {
      output += String.format(
          "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
          + "attributeName=\"fill\" from=\"rgb%s\" to=\"rgb%s\" fill=\"freeze\" />\n",
          calculateSVGTime(startShape, endShape, speed)[0],
          calculateSVGTime(startShape, endShape, speed)[1], startShape.colorString(),
          endShape.colorString());
    }
    return output;
  }

  /**
   * Return the svg string represents the change from hidden to visiable.
   * 
   * @param tick  the beginning time of the change
   * @param speed the speed represents the speed of the animation
   * @return the svg string represents the change from hidden to visiable.
   */
  public static String svgVisiable(int tick, int speed) {
    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"1ms\" "
        + "attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n",
        (int) (changeFromTickToTime(tick, speed) * 1000));
  }

  /**
   * Return the svg string represents the change from visiable to hidden.
   * 
   * @param tick  the beginning time of the change
   * @param speed the speed represents the speed of the animation
   * @return the svg string represents the change from visiable to hidden.
   */
  public static String svgHidden(int tick, int speed) {
    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"1ms\" "
        + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n",
        (int) (changeFromTickToTime(tick, speed) * 1000));
  }

  /**
   * Return the svg string represents the animation from the start state of the
   * shape to the end state of the shape.
   * 
   * @param startShape initial state of the shape
   * @param endShape   the final state of the shape
   * @param speed      the speed represents the speed of the animation
   * @return the svg string represents the animation from the start state of the
   *         shape to the end state of the shape.
   */
  public static String svgAnimation(Shape startShape, Shape endShape, int speed) {
    String output = "";
    output += svgXPosition(startShape, endShape, speed);
    output += svgYPosition(startShape, endShape, speed);
    output += svgXDimension(startShape, endShape, speed);
    output += svgYDimension(startShape, endShape, speed);
    output += svgColor(startShape, endShape, speed);
    return output;
  }
}
