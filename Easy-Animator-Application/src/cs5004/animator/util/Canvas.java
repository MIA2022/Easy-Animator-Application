package cs5004.animator.util;

/**
 * A class represents the canvas.
 * 
 * @author nanchen
 *
 */
public class Canvas {
  private int canvasCoordX;
  private int canvasCoordY;
  private int canvasWidth;
  private int canvasHeight;

  /**
   * A constructor for the canvas.
   * 
   * @param canvasCoordX the top-left x positon of the canvas.
   * @param canvasCoordY the top-left y positon of the canvas.
   * @param canvasWidth  the width of the canvas.
   * @param canvasHeight the height of the canvas
   */
  public Canvas(int canvasCoordX, int canvasCoordY, int canvasWidth, int canvasHeight) {
    this.canvasCoordX = canvasCoordX;
    this.canvasCoordY = canvasCoordY;
    this.canvasWidth = canvasWidth;
    this.canvasHeight = canvasHeight;
  }

  /**
   * Get the top-left x positon of the canvas.
   * 
   * @return the top-left x positon of the canvas.
   */
  public int getCanvasCoordX() {
    return canvasCoordX;
  }

  /**
   * Get the top-left y positon of the canvas.
   * 
   * @return the top-left y positon of the canvas.
   */
  public int getCanvasCoordY() {
    return canvasCoordY;
  }

  /**
   * Get the width of the canvas.
   * 
   * @return the width of the canvas.
   */
  public int getCanvasWidth() {
    return canvasWidth;
  }

  /**
   * Get the height of the canvas.
   * 
   * @return the height of the canvas.
   */
  public int getCanvasHeight() {
    return canvasHeight;
  }

  @Override
  public String toString() {
    return String.format("Top-left corner (%d,%d), dimensions %dx%d", this.canvasCoordX,
        this.canvasCoordY, this.canvasWidth, this.canvasHeight);
  }

  /**
   * Get the svg string represents the canvas.
   * 
   * @return the svg string represents the canvas.
   */
  public String svgCanvasString() {
    int canvasWidth = Math.abs(this.getCanvasCoordX()) + this.getCanvasWidth();
    int canvasHeight = Math.abs(this.getCanvasCoordY()) + this.getCanvasHeight();
    String output = "";

    output += String.format("<svg width=\"%d\" height=\"%d\" version=\"1.1\""
        + " xmlns=\"http://www.w3.org/2000/svg\">\n", canvasWidth, canvasHeight);
    return output;
  }
}
