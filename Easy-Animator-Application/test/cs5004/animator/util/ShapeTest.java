package cs5004.animator.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * A test for shape.
 * @author nanchen
 *
 */
public class ShapeTest {
  /**
   * Test for method in shape.
   */
  @Test
  public void test() {
    Shape rectangle = new Rectangle("R", "rectangle", 1, 200, 200, 50, 100, 255, 0, 0);
    Shape oval = new Oval("C", "ellipse", 20, 440, 70, 120, 60, 0, 0, 255);
    assertEquals(200, rectangle.getxPosition(), 0.01);
    assertEquals(440, oval.getxPosition(), 0.01);
    assertEquals(200, rectangle.getSVGxPosition(), 0.01);
    assertEquals(500, oval.getSVGxPosition(), 0.01);
    assertEquals(200, rectangle.getyPosition(), 0.01);
    assertEquals(70, oval.getyPosition(), 0.01);
    assertEquals(200, rectangle.getSVGyPosition(), 0.01);
    assertEquals(100, oval.getSVGyPosition(), 0.01);
    assertEquals(50, rectangle.getxDimension(), 0.01);
    assertEquals(120, oval.getxDimension(), 0.01);
    assertEquals(50, rectangle.getSVGxDimension(), 0.01);
    assertEquals(60, oval.getSVGxDimension(), 0.01);
    assertEquals(100, rectangle.getyDimension(), 0.01);
    assertEquals(60, oval.getyDimension(), 0.01);
    assertEquals(100, rectangle.getSVGyDimension(), 0.01);
    assertEquals(30, oval.getSVGyDimension(), 0.01);
    assertEquals(255, rectangle.getrColorValue(), 0.01);
    assertEquals(0, rectangle.getgColorValue(), 0.01);
    assertEquals(0,rectangle.getbColorValue(), 0.01);
    assertEquals(0, oval.getrColorValue(), 0.01);
    assertEquals(0, oval.getgColorValue(), 0.01);
    assertEquals(255,oval.getbColorValue(), 0.01);
    assertEquals(1, rectangle.getTick());
    assertEquals(20, oval.getTick());
    assertEquals("R", rectangle.getName());
    assertEquals("C", oval.getName());
    assertEquals("rectangle", rectangle.getType());
    assertEquals("ellipse", oval.getType());
    assertEquals("(200, 200)", rectangle.positionGeneral());
    assertEquals("(440, 70)", oval.positionGeneral());
    assertEquals("Min corner: (200, 200) ", rectangle.positionString());
    assertEquals("Center: (440, 70) ", oval.positionString());
    assertEquals("Width: 50, Height: 100 ", rectangle.dimensionString());
    assertEquals("X radius: 120, Y radius: 60 ", oval.dimensionString());
    assertEquals("(255, 0, 0)", rectangle.colorString());
    assertEquals("(0, 0, 255)", oval.colorString());
    assertEquals("t=1", rectangle.tickString());
    assertEquals("t=20", oval.tickString());
    assertEquals("Name: R", rectangle.nameString());
    assertEquals("Name: C", oval.nameString());
    assertEquals("Type: Rectangle", rectangle.typeString());
    assertEquals("Type: Ellipse", oval.typeString());
    assertEquals("<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" "
        + "fill=\"rgb(255, 0, 0)\" visibility=\"hidden\" >\n",
        rectangle.svgShapeString());
    assertEquals("<ellipse id=\"C\" cx=\"500\" cy=\"100\" rx=\"60\" "
        + "ry=\"30\" fill=\"rgb(0, 0, 255)\" visibility=\"hidden\" >\n",
        oval.svgShapeString());
    assertEquals("<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"300ms\" attributeName=\"x\" from=\"200\" to=\"100\" fill=\"freeze\" />\n", 
        rectangle.svgXPosition(1000, 300, 200, 100));
    assertEquals("<animate attributeType=\"xml\" begin=\"1000ms\" "
        + "dur=\"300ms\" attributeName=\"cx\" from=\"200\" to=\"100\" fill=\"freeze\" />\n", 
        oval.svgXPosition(1000, 300, 200, 100));
    assertEquals("<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"300ms\" "
        + "attributeName=\"y\" from=\"200\" to=\"100\" fill=\"freeze\" />\n", 
        rectangle.svgYPosition(1000, 300, 200, 100));
    assertEquals("<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"300ms\" "
        + "attributeName=\"cy\" from=\"200\" to=\"100\" fill=\"freeze\" />\n", 
        oval.svgYPosition(1000, 300, 200, 100));
    assertEquals("<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"300ms\" "
        + "attributeName=\"width\" from=\"200\" to=\"100\" fill=\"freeze\" />\n", 
        rectangle.svgXDimension(1000, 300, 200, 100));
    assertEquals("<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"300ms\" "
        + "attributeName=\"rx\" from=\"200\" to=\"100\" fill=\"freeze\" />\n", 
        oval.svgXDimension(1000, 300, 200, 100));
    assertEquals("<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"300ms\" "
        + "attributeName=\"height\" from=\"200\" to=\"100\" fill=\"freeze\" />\n", 
        rectangle.svgYDimension(1000, 300, 200, 100));
    assertEquals("<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"300ms\" "
        + "attributeName=\"ry\" from=\"200\" to=\"100\" fill=\"freeze\" />\n", 
        oval.svgYDimension(1000, 300, 200, 100));
    assertEquals("</rect>\n", rectangle.endSVGString());
    assertEquals("</ellipse>\n", oval.endSVGString());
    assertEquals("Name: R Type: Rectangle t=1 Min corner: (200, 200) Width: 50, "
        + "Height: 100 (255, 0, 0)", rectangle.toString());
    assertEquals("Name: C Type: Ellipse t=20 Center: (440, 70) X radius: 120, "
        + "Y radius: 60 (0, 0, 255)", oval.toString());
    assertEquals("Name: R Type: Rectangle t=1 Min corner: (200, 200) Width: 50, "
        + "Height: 100 (255, 0, 0)", rectangle.changeToSVGShape().toString());
    assertEquals("Name: C Type: Ellipse t=20 Center: (500, 100) X radius: 60, "
        + "Y radius: 30 (0, 0, 255)", oval.changeToSVGShape().toString());
    
  }

}
