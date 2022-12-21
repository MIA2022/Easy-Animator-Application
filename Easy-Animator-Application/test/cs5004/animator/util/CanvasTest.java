package cs5004.animator.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A test for canvas.
 * @author nanchen
 *
 */
public class CanvasTest {
  /**
   * Test methods in canvas.
   */
  @Test
  public void test() {
    Canvas canvas = new Canvas(200, 70, 360, 360);
    assertEquals(200, canvas.getCanvasCoordX());
    assertEquals(70, canvas.getCanvasCoordY());
    assertEquals(360, canvas.getCanvasWidth());
    assertEquals(360, canvas.getCanvasHeight());
    assertEquals("Top-left corner (200,70), dimensions 360x360", canvas.toString());
    assertEquals("<svg width=\"560\" height=\"430\" version=\"1.1\""
        + " xmlns=\"http://www.w3.org/2000/svg\">\n", canvas.svgCanvasString());
  }
}
