package cs5004.animator.util;

/**
 * A class represents rectangle.
 * 
 * @author nanchen
 *
 */
public class Rectangle extends AnimationShape {

  /**
   * A constructor of the rectangle.
   * 
   * @param name The name of the shape
   * @param t   The tick time of this transformation
   * @param x   The x-position of the shape
   * @param y   The y-position of the shape
   * @param w   The width of the shape
   * @param h  The height of the shape
   * @param r   The red color-value of the shape
   * @param g   The green color-value of the shape
   * @param b   The blue color-value of the shape
   */
  public Rectangle(String name, String type, int t, double x, double y, double w, double h,
      double r, double g, double b) {
    super(name, type, t, x, y, w, h, r, g, b);
  }

  @Override
  public String positionString() {
    return String.format("Min corner: (%d, %d) ", (int) this.xPosition, (int) this.yPosition);
  }

  @Override
  public String dimensionString() {
    return String.format("Width: %d, Height: %d ", (int) this.xDimension, (int) this.yDimension);
  }

  @Override
  public String svgShapeString() {
    return String.format(
        "<rect id=\"%s\" x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" "
        + "fill=\"rgb%s\" visibility=\"hidden\" >\n",
        this.getName(), (int) this.getxPosition(), (int) this.getyPosition(),
        (int) this.getxDimension(), (int) this.getyDimension(), this.colorString());
  }

  @Override
  public String typeString() {
    return "Type: Rectangle";
  }

  @Override
  public String svgXPosition(int begin, int duration, int startXPosition, int endXPosition) {
    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
        + "attributeName=\"x\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
        begin, duration, startXPosition, endXPosition);
  }

  @Override
  public String svgYPosition(int begin, int duration, int startYPosition, int endYPosition) {
    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
        + "attributeName=\"y\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
        begin, duration, startYPosition, endYPosition);
  }

  @Override
  public String svgXDimension(int begin, int duration, int startXDimension, int endXDimension) {

    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
        + "attributeName=\"width\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
        begin, duration, startXDimension, endXDimension);
  }

  @Override
  public String svgYDimension(int begin, int duration, int startYDimension, int endYDimension) {

    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
        + "attributeName=\"height\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
        begin, duration, startYDimension, endYDimension);
  }

  @Override
  public Shape changeToSVGShape() {
    return new Rectangle(name, type, this.tick, this.xPosition, this.yPosition, this.xDimension,
        this.yDimension, this.rColorValue, this.gColorValue, this.bColorValue);
  }

  @Override
  public String endSVGString() {
    String output = "";
    output += "</rect>\n";
    return output;
  }

}
