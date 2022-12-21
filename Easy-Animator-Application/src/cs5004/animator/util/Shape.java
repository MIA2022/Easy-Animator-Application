package cs5004.animator.util;

/**
 * This interface contains all operations that all types of shapes should
 * support.
 *
 * @author nanchen
 *
 */
public interface Shape {
  /**
   * Get the x-position(top-left) of the shape.
   * 
   * @return the x-position of the shape.
   */
  double getxPosition();

  /**
   * Get the x-position of the shape according to the requirements of the svg
   * file. If the shape is ellipse, it represents the center x-position of the
   * shape.
   * 
   * @return the x-position of the shape according to the requirements of the svg
   *         file.
   */
  double getSVGxPosition();

  /**
   * Get the y-position(top-left) of the shape.
   * 
   * @return the y-position of the shape.
   */
  double getyPosition();

  /**
   * Get the y-position of the shape according to the requirements of the svg
   * file. If the shape is ellipse, it represents the center y-position of the
   * shape.
   * 
   * @return the y-position of the shape according to the requirements of the svg
   *         file.
   */
  double getSVGyPosition();

  /**
   * Get the width or x-diameter of the shape.
   * 
   * @return the width or x-diameter of the shape.
   */
  double getxDimension();

  /**
   * Get the width or x-radius of the shape.
   * 
   * @return the width or x-radius of the shape.
   */
  double getSVGxDimension();

  /**
   * Get the height or y-diameter of the shape.
   * 
   * @return the height or y-diameter of the shape.
   */
  double getyDimension();

  /**
   * Get the height or y-radius of the shape.
   * 
   * @return the height or y-radius of the shape.
   */
  double getSVGyDimension();

  /**
   * Get the r value of the color.
   * 
   * @return the r value of the color.
   */
  double getrColorValue();

  /**
   * Get the g value of the color.
   * 
   * @return the g value of the color.
   */
  double getgColorValue();

  /**
   * Get the b value of the color.
   * 
   * @return the b value of the color.
   */
  double getbColorValue();

  /**
   * Get the tick of the shape.
   * 
   * @return the tick of the shape.
   */
  int getTick();

  /**
   * Return the string represents the name of the shape.
   * 
   * @return the string represents the name of the shape.
   */
  String getName();

  /**
   * Return the string represents the type of the shape.
   * 
   * @return the string represents the type of the shape.
   */
  String getType();

  /**
   * Return the string represents top-left positon of the shape.
   * 
   * @return the string represents top-left positon of the shape.
   */
  String positionGeneral();

  /**
   * Return the string represents top-left positon of the shape.
   * 
   * @return the string represents top-left positon of the shape.
   */
  String positionString();

  /**
   * Return the string represents dimension of the shape.
   * 
   * @return the string represents dimension of the shape.
   */
  String dimensionString();

  /**
   * Return the string represents the color of the shape.
   * 
   * @return the string represents the color of the shape.
   */
  String colorString();

  /**
   * Return the string represents the tick of the shape.
   * 
   * @return the string represents the tick of the shape.
   */
  String tickString();

  /**
   * Return the string represents the name of the shape.
   * 
   * @return the string represents the name of the shape.
   */
  String nameString();

  /**
   * Return the string represents the type of the shape.
   * 
   * @return the string represents the type of the shape.
   */
  String typeString();

  /**
   * Return the svg string represents the initial state of the shape.
   * 
   * @return the svg string represents the initial state of the shape.
   */
  String svgShapeString();

  /**
   * Return the svg string represents the animation of the XPosition.
   * 
   * @param begin          the beginning time of the animation
   * @param duration       the duration time of the animation
   * @param startXPosition the initial state of XPosition
   * @param endXPosition   the end state of XPosition
   * @return the svg string represents the animation of the XPosition
   */
  String svgXPosition(int begin, int duration, int startXPosition, int endXPosition);

  /**
   * Return the svg string represents the animation of the YPosition.
   * 
   * @param begin          the beginning time of the animation
   * @param duration       the duration time of the animation
   * @param startYPosition the initial state of YPosition
   * @param endYPosition   the end state of YPosition
   * @return the svg string represents the animation of the YPosition
   */
  String svgYPosition(int begin, int duration, int startYPosition, int endYPosition);

  /**
   * Return the svg string represents the animation of the XDimension.
   * 
   * @param begin           the beginning time of the animation
   * @param duration        the duration time of the animation
   * @param startXDimension the initial state of XDimension
   * @param endXDimension   the end state of YPosition
   * @return the svg string represents the animation of the XDimension
   */
  String svgXDimension(int begin, int duration, int startXDimension, int endXDimension);

  /**
   * Return the svg string represents the animation of the YDimension.
   * 
   * @param begin           the beginning time of the animation
   * @param duration        the duration time of the animation
   * @param startYDimension the initial state of YDimension
   * @param endYDimension   the end state of YPosition
   * @return the svg string represents the animation of the YDimension
   */
  String svgYDimension(int begin, int duration, int startYDimension, int endYDimension);

  /**
   * Return the end part of the SVGString.
   * 
   * @return the end part of the SVGString.
   */
  String endSVGString();

  @Override
  String toString();

  /**
   * Return a new shape whose values are change to svg value.
   * 
   * @return a new shape whose values are change to svg value.
   */
  Shape changeToSVGShape();
}
