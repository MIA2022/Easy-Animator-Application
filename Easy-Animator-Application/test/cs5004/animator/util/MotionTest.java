package cs5004.animator.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * A test for Motion.
 * 
 * @author nanchen
 *
 */
public class MotionTest {

  /**
   * Test the motions when the shape is rectangle.
   */
  @Test
  public void testRectangleMotion() {
    Shape rectangle = new Rectangle("R", "rectangle", 1, 200, 200, 50, 100, 255, 0, 0);
    Shape rectangle1 = new Rectangle("R", "rectangle", 1, 200, 200, 50, 100, 255, 0, 0);
    Shape rectangle2 = new Rectangle("R", "rectangle", 5, 300, 500, 25, 70, 0, 255, 0);
    Shape rectangle3 = new Rectangle("R", "rectangle", 5, 200, 200, 50, 100, 255, 0, 0);

    assertFalse(Motion.moveX(rectangle, rectangle1));
    assertFalse(Motion.moveX(rectangle, rectangle3));
    assertTrue(Motion.moveX(rectangle, rectangle2));
    assertFalse(Motion.moveY(rectangle, rectangle1));
    assertFalse(Motion.moveY(rectangle, rectangle3));
    assertTrue(Motion.moveY(rectangle, rectangle2));
    assertFalse(Motion.scaleX(rectangle, rectangle1));
    assertFalse(Motion.scaleX(rectangle, rectangle3));
    assertTrue(Motion.scaleX(rectangle, rectangle2));
    assertFalse(Motion.scaleY(rectangle, rectangle1));
    assertFalse(Motion.scaleY(rectangle, rectangle3));
    assertTrue(Motion.scaleY(rectangle, rectangle2));
    assertFalse(Motion.changeColor(rectangle, rectangle1));
    assertFalse(Motion.changeColor(rectangle, rectangle3));
    assertTrue(Motion.changeColor(rectangle, rectangle2));

    String expectedMotionText = "Shape R moves from (200, 200) to (300, 500) from t=1 to t=5\n"
        + "Shape R scales from Width: 50, Height: 100  to Width: 25, Height: 70  from t=1 to t=5\n"
        + "Shape R changes color from (255, 0, 0) to (0, 255, 0) from t=1 to t=5\n";
    assertEquals(expectedMotionText, Motion.motionText(rectangle, rectangle2, 1));

    String expectedSVGXPosition = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"x\" from=\"200\" to=\"300\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGXPosition, Motion.svgXPosition(rectangle, rectangle2, 1));

    String expectedSVGYPosition = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"y\" from=\"200\" to=\"500\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGYPosition, Motion.svgYPosition(rectangle, rectangle2, 1));

    String expectedSVGXDimension = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"width\" from=\"50\" to=\"25\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGXDimension, Motion.svgXDimension(rectangle, rectangle2, 1));

    String expectedSVGYDimension = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"height\" from=\"100\" to=\"70\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGYDimension, Motion.svgYDimension(rectangle, rectangle2, 1));

    String expectedSVGColor = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"fill\" from=\"rgb(255, 0, 0)\" "
        + "to=\"rgb(0, 255, 0)\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGColor, Motion.svgColor(rectangle, rectangle2, 1));

    String expectedSVGVisible = "<animate attributeType=\"xml\" begin=\"5000ms\" "
        + "dur=\"1ms\" attributeName=\"visibility\" from=\"hidden\" "
        + "to=\"visible\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGVisible, Motion.svgVisiable(5, 1));
    String expectedSVGVisible1 = "<animate attributeType=\"xml\" begin=\"2500ms\" dur=\"1ms\" "
        + "attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGVisible1, Motion.svgVisiable(5, 2));

    String expectedSVGHidden = "<animate attributeType=\"xml\" begin=\"5000ms\" dur=\"1ms\" "
        + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGHidden, Motion.svgHidden(5, 1));
    String expectedSVGHidden1 = "<animate attributeType=\"xml\" begin=\"3000ms\" dur=\"1ms\" "
        + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGHidden1, Motion.svgHidden(9, 3));

    String expectedSVGAnimation = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"x\" from=\"200\" to=\"300\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" "
        + "attributeName=\"y\" from=\"200\" to=\"500\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" "
        + "attributeName=\"width\" from=\"50\" to=\"25\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" "
        + "attributeName=\"height\" from=\"100\" to=\"70\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" "
        + "attributeName=\"fill\" from=\"rgb(255, 0, 0)\" to=\"rgb(0, 255, 0)\" "
        + "fill=\"freeze\" />\n";
    assertEquals(expectedSVGAnimation, Motion.svgAnimation(rectangle, rectangle2, 1));
  }

  /**
   * Test the motions when the shape is oval.
   */
  @Test
  public void testOvalMotion() {
    Shape oval = new Oval("C", "ellipse", 1, 200, 200, 50, 100, 255, 0, 0);
    Shape oval1 = new Oval("C", "ellipse", 1, 200, 200, 50, 100, 255, 0, 0);
    Shape oval2 = new Oval("C", "ellipse", 5, 300, 500, 30, 70, 0, 255, 0);
    Shape oval3 = new Oval("C", "ellipse", 5, 200, 200, 50, 100, 255, 0, 0);

    assertFalse(Motion.moveX(oval, oval1));
    assertFalse(Motion.moveX(oval, oval3));
    assertTrue(Motion.moveX(oval, oval2));
    assertFalse(Motion.moveY(oval, oval1));
    assertFalse(Motion.moveY(oval, oval3));
    assertTrue(Motion.moveY(oval, oval2));
    assertFalse(Motion.scaleX(oval, oval1));
    assertFalse(Motion.scaleX(oval, oval3));
    assertTrue(Motion.scaleX(oval, oval2));
    assertFalse(Motion.scaleY(oval, oval1));
    assertFalse(Motion.scaleY(oval, oval3));
    assertTrue(Motion.scaleY(oval, oval2));
    assertFalse(Motion.changeColor(oval, oval1));
    assertFalse(Motion.changeColor(oval, oval3));
    assertTrue(Motion.changeColor(oval, oval2));

    String expectedMotionText = "Shape C moves from (200, 200) to (300, 500) from t=1 to t=5\n"
        + "Shape C scales from X radius: 50, Y radius: 100  to "
        + "X radius: 30, Y radius: 70  from t=1 to t=5\n"
        + "Shape C changes color from (255, 0, 0) to (0, 255, 0) from t=1 to t=5\n";
    assertEquals(expectedMotionText, Motion.motionText(oval, oval2, 1));

    String expectedSVGXPosition = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"cx\" from=\"225\" to=\"315\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGXPosition, Motion.svgXPosition(oval, oval2, 1));

    String expectedSVGYPosition = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"cy\" from=\"250\" to=\"535\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGYPosition, Motion.svgYPosition(oval, oval2, 1));

    String expectedSVGXDimension = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"rx\" from=\"25\" to=\"15\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGXDimension, Motion.svgXDimension(oval, oval2, 1));

    String expectedSVGYDimension = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"ry\" from=\"50\" to=\"35\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGYDimension, Motion.svgYDimension(oval, oval2, 1));

    String expectedSVGColor = "<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"4000ms\" attributeName=\"fill\" from=\"rgb(255, 0, 0)\" to=\"rgb(0, 255, 0)\" "
        + "fill=\"freeze\" />\n";
    assertEquals(expectedSVGColor, Motion.svgColor(oval, oval2, 1));

    String expectedSVGVisible = "<animate attributeType=\"xml\" begin=\"5000ms\" "
        + "dur=\"1ms\" attributeName=\"visibility\" from=\"hidden\" to=\"visible\" "
        + "fill=\"freeze\" />\n";
    assertEquals(expectedSVGVisible, Motion.svgVisiable(5, 1));
    String expectedSVGVisible1 = "<animate attributeType=\"xml\" begin=\"2500ms\" "
        + "dur=\"1ms\" attributeName=\"visibility\" from=\"hidden\" to=\"visible\" "
        + "fill=\"freeze\" />\n";
    assertEquals(expectedSVGVisible1, Motion.svgVisiable(5, 2));

    String expectedSVGHidden = "<animate attributeType=\"xml\" begin=\"5000ms\" dur=\"1ms\" "
        + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGHidden, Motion.svgHidden(5, 1));
    String expectedSVGHidden1 = "<animate attributeType=\"xml\" begin=\"3000ms\" dur=\"1ms\" "
        + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n";
    assertEquals(expectedSVGHidden1, Motion.svgHidden(9, 3));

    String expectedSVGAnimation = "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" "
        + "attributeName=\"cx\" from=\"225\" to=\"315\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" "
        + "attributeName=\"cy\" from=\"250\" to=\"535\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" "
        + "attributeName=\"rx\" from=\"25\" to=\"15\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" "
        + "attributeName=\"ry\" from=\"50\" to=\"35\" fill=\"freeze\" />\n"
        + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"4000ms\" "
        + "attributeName=\"fill\" from=\"rgb(255, 0, 0)\" to=\"rgb(0, 255, 0)\" "
        + "fill=\"freeze\" />\n";
    assertEquals(expectedSVGAnimation, Motion.svgAnimation(oval, oval2, 1));
  }

}
