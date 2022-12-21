package cs5004.animator.util;

/**
 * A class represents oval.
 * 
 * @author nanchen
 *
 */
public class Oval extends AnimationShape {

  /**
   * A constructor of the rectangle.
   * 
   * @param name The name of the shape
   * @param t   The tick time of this transformation
   * @param x   The x-position of the shape
   * @param y   The y-position of the shape
   * @param w   The width of the shape
   * @param h   The height of the shape
   * @param r   The red color-value of the shape
   * @param g   The green color-value of the shape
   * @param b   The blue color-value of the shape
   */
  public Oval(String name, String type, int t, double x, double y, double w, double h, double r,
      double g, double b) {
    super(name, type, t, x, y, w, h, r, g, b);
  }

  @Override
  public double getSVGxPosition() {
    return this.xPosition + this.xDimension / 2;
  }

  @Override
  public double getSVGyPosition() {
    return this.yPosition + this.yDimension / 2;
  }

  @Override
  public double getSVGxDimension() {
    return xDimension / 2;
  }

  @Override
  public double getSVGyDimension() {
    return yDimension / 2;
  }

  @Override
  public String positionString() {
    return String.format("Center: (%d, %d) ", (int) this.xPosition, (int) this.yPosition);
  }

  @Override
  public String dimensionString() {
    return String.format("X radius: %d, Y radius: %d ", (int) this.xDimension,
        (int) this.yDimension);
  }

  @Override
  public String typeString() {
    return "Type: Ellipse";
  }

  @Override
  public String svgShapeString() {
    return String.format(
        "<ellipse id=\"%s\" cx=\"%d\" cy=\"%d\" rx=\"%d\" "
        + "ry=\"%d\" fill=\"rgb%s\" visibility=\"hidden\" >\n",
        this.getName(), (int) this.getSVGxPosition(), (int) this.getSVGyPosition(),
        (int) this.getSVGxDimension(), (int) this.getSVGyDimension(), this.colorString());
  }

  @Override
  public String svgXPosition(int begin, int duration, int startXPosition, int endXPosition) {

    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" "
        + "dur=\"%dms\" attributeName=\"cx\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
        begin, duration, startXPosition, endXPosition);
  }

  @Override
  public String svgYPosition(int begin, int duration, int startYPosition, int endYPosition) {
    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" "
        + "dur=\"%dms\" attributeName=\"cy\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
        begin, duration, startYPosition, endYPosition);
  }

  @Override
  public String svgXDimension(int begin, int duration, int startXDimension, int endXDimension) {

    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
        + "attributeName=\"rx\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
        begin, duration, startXDimension, endXDimension);
  }

  @Override
  public String svgYDimension(int begin, int duration, int startYDimension, int endYDimension) {

    return String.format(
        "<animate attributeType=\"xml\" begin=\"%dms\" dur=\"%dms\" "
        + "attributeName=\"ry\" from=\"%d\" to=\"%d\" fill=\"freeze\" />\n",
        begin, duration, startYDimension, endYDimension);
  }

  @Override
  public Shape changeToSVGShape() {
    return new Oval(name, type, this.tick, this.xPosition + this.xDimension / 2,
        this.yPosition + this.yDimension / 2, this.xDimension / 2, this.yDimension / 2,
        this.rColorValue, this.gColorValue, this.bColorValue);
  }

  @Override
  public String endSVGString() {
    String output = "";
    output += "</ellipse>\n";
    return output;
  }
}
