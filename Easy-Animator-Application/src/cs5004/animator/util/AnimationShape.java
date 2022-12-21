package cs5004.animator.util;

/**
 * An abstract class which implements Shape interface.
 * 
 * @author nanchen
 *
 */
public abstract class AnimationShape implements Shape {

  protected String name;
  protected String type;
  protected double xPosition;
  protected double yPosition;
  protected double xDimension;
  protected double yDimension;
  protected double rColorValue;
  protected double gColorValue;
  protected double bColorValue;
  protected int tick;

  /**
   * A constructor of the shape.
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
  public AnimationShape(String name, String type, int t, double x, double y, double w, double h,
      double r, double g, double b) {
    this.name = name;
    this.type = type;
    this.tick = t;
    this.xPosition = x;
    this.yPosition = y;
    this.xDimension = w;
    this.yDimension = h;
    this.rColorValue = r;
    this.gColorValue = g;
    this.bColorValue = b;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public double getxPosition() {
    return xPosition;
  }

  @Override
  public double getSVGxPosition() {
    return xPosition;
  }

  @Override
  public double getyPosition() {
    return yPosition;
  }

  @Override
  public double getSVGyPosition() {
    return yPosition;
  }

  @Override
  public double getxDimension() {
    return xDimension;
  }

  @Override
  public double getSVGxDimension() {
    return xDimension;
  }

  @Override
  public double getyDimension() {
    return yDimension;
  }

  @Override
  public double getSVGyDimension() {
    return yDimension;
  }

  @Override
  public double getrColorValue() {
    return rColorValue;
  }

  @Override
  public double getgColorValue() {
    return gColorValue;
  }

  @Override
  public double getbColorValue() {
    return bColorValue;
  }

  @Override
  public int getTick() {
    return tick;
  }

  @Override
  public String positionGeneral() {
    return String.format("(%d, %d)", (int) this.xPosition, (int) this.yPosition);
  }

  @Override
  public String colorString() {
    return String.format("(%d, %d, %d)", (int) this.rColorValue, (int) this.gColorValue,
        (int) this.bColorValue);
  }

  @Override
  public String tickString() {
    return "t=" + this.tick;
  }

  @Override
  public String nameString() {
    return "Name: " + this.name;
  }

  @Override
  public String toString() {
    return this.nameString() + " " + this.typeString() + " " + this.tickString() + " "
        + this.positionString() + this.dimensionString() + this.colorString();
  }

}
