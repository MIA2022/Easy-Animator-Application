package cs5004.animator.controller;

import static org.junit.Assert.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

import org.junit.Test;

import cs5004.animator.model.IModel;
import cs5004.animator.util.AnimationBuilderImp;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.SVGView;
import cs5004.animator.view.SVGViewImpl;
import cs5004.animator.view.TextualView;
import cs5004.animator.view.TextualViewImpl;

/**
 * A test for controller.
 * 
 * @author nanchen
 *
 */
public class IControllerTest {

  /**
   * Test SVGConsoleGo().
   */
  @Test
  public void testSVGConsoleGo() {
    IModel model;
    try {
      model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));
      String expectedOutput = "<svg width=\"560\" height=\"430\" version=\"1.1\" "
          + "xmlns=\"http://www.w3.org/2000/svg\">\n"
          + "\n"
          + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" "
          + "fill=\"rgb(255, 0, 0)\" visibility=\"hidden\" >\n"
          + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" "
          + "attributeName=\"x\" from=\"200\" to=\"300\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"10000ms\" dur=\"40000ms\" "
          + "attributeName=\"y\" from=\"200\" to=\"300\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"51000ms\" dur=\"19000ms\" "
          + "attributeName=\"width\" from=\"50\" to=\"25\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"70000ms\" dur=\"30000ms\" "
          + "attributeName=\"x\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"70000ms\" dur=\"30000ms\" "
          + "attributeName=\"y\" from=\"300\" to=\"200\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"100000ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n"
          + "</rect>\n" + "\n"
          + "<ellipse id=\"C\" cx=\"500\" cy=\"100\" rx=\"60\" ry=\"30\" "
          + "fill=\"rgb(0, 0, 255)\" visibility=\"hidden\" >\n"
          + "<animate attributeType=\"xml\" begin=\"6000ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"20000ms\" dur=\"30000ms\" "
          + "attributeName=\"cy\" from=\"100\" to=\"280\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"50000ms\" dur=\"20000ms\" "
          + "attributeName=\"cy\" from=\"280\" to=\"400\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"50000ms\" dur=\"20000ms\" "
          + "attributeName=\"fill\" from=\"rgb(0, 0, 255)\" to=\"rgb(0, 170, 85)\" "
          + "fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"70000ms\" dur=\"10000ms\" "
          + "attributeName=\"fill\" from=\"rgb(0, 170, 85)\" to=\"rgb(0, 255, 0)\" "
          + "fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"100000ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n"
          + "</ellipse>\n" + "\n" + "</svg>\n" + "";
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(outStream);
      SVGView view = new SVGViewImpl(out);
      IController controller = new AnimationController(model, view);
      controller.svgConsoleGo();

      String actualOutput = outStream.toString();
      assertEquals(expectedOutput, actualOutput);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      model = AnimationReader.parseFile(new FileReader("toh-3.txt"), new AnimationBuilderImp(5));
      String expectedOutput = "<svg width=\"555\" height=\"270\" version=\"1.1\" "
          + "xmlns=\"http://www.w3.org/2000/svg\">\n"
          + "\n"
          + "<rect id=\"disk1\" x=\"190\" y=\"180\" width=\"20\" height=\"30\" "
          + "fill=\"rgb(0, 49, 90)\" visibility=\"hidden\" >\n"
          + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"5000ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"180\" to=\"50\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"7200ms\" dur=\"2000ms\" "
          + "attributeName=\"x\" from=\"190\" to=\"490\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"9400ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"17800ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"20000ms\" dur=\"2000ms\" "
          + "attributeName=\"x\" from=\"490\" to=\"340\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"22200ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"50\" to=\"210\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"30600ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"210\" to=\"50\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"32800ms\" dur=\"2000ms\" "
          + "attributeName=\"x\" from=\"340\" to=\"190\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"35000ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"43400ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"45600ms\" dur=\"2000ms\" "
          + "attributeName=\"x\" from=\"190\" to=\"490\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"47800ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"50\" to=\"180\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"49800ms\" dur=\"1600ms\" "
          + "attributeName=\"fill\" from=\"rgb(0, 49, 90)\" to=\"rgb(0, 255, 0)\" "
          + "fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"60400ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n"
          + "</rect>\n" + "\n"
          + "<rect id=\"disk2\" x=\"167\" y=\"210\" width=\"65\" height=\"30\" "
          + "fill=\"rgb(6, 247, 41)\" visibility=\"hidden\" >\n"
          + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"11400ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"210\" to=\"50\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"13600ms\" dur=\"2000ms\" "
          + "attributeName=\"x\" from=\"167\" to=\"317\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"15800ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"37000ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"39200ms\" dur=\"2000ms\" "
          + "attributeName=\"x\" from=\"317\" to=\"467\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"41400ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"50\" to=\"210\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"43400ms\" dur=\"1600ms\" "
          + "attributeName=\"fill\" from=\"rgb(6, 247, 41)\" to=\"rgb(0, 255, 0)\" "
          + "fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"60400ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" "
          + "fill=\"freeze\" />\n"
          + "</rect>\n" + "\n"
          + "<rect id=\"disk3\" x=\"145\" y=\"240\" width=\"110\" height=\"30\" "
          + "fill=\"rgb(11, 45, 175)\" visibility=\"hidden\" >\n"
          + "<animate attributeType=\"xml\" begin=\"1000ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"24200ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"240\" to=\"50\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"26400ms\" dur=\"2000ms\" "
          + "attributeName=\"x\" from=\"145\" to=\"445\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"28600ms\" dur=\"2000ms\" "
          + "attributeName=\"y\" from=\"50\" to=\"240\" fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"30600ms\" dur=\"1600ms\" "
          + "attributeName=\"fill\" from=\"rgb(11, 45, 175)\" to=\"rgb(0, 255, 0)\" "
          + "fill=\"freeze\" />\n"
          + "<animate attributeType=\"xml\" begin=\"60400ms\" dur=\"1ms\" "
          + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n"
          + "</rect>\n" + "\n" + "</svg>\n" + "";
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(outStream);
      SVGView view = new SVGViewImpl(out);
      IController controller = new AnimationController(model, view);
      controller.svgConsoleGo();

      String actualOutput = outStream.toString();
      assertEquals(expectedOutput, actualOutput);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test textualConsoleGo().
   */
  @Test
  public void testtextualConsoleGo() {
    IModel model;
    try {
      model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));
      String expectedOutput = "Shapes:\n" + "Name: R\n" + "Type: Rectangle\n"
          + "Min corner: (200, 200) , Width: 50, Height: 100 , Color:(255, 0, 0)\n"
          + "Appears at t=1\n" + "Disappears at t=100\n" + "\n" + "Name: C\n" + "Type: Ellipse\n"
          + "Center: (500, 100) , X radius: 60, Y radius: 30 , Color:(0, 0, 255)\n"
          + "Appears at t=6\n" + "Disappears at t=100\n" + "\n" + "\n"
          + "Shape R moves from (200, 200) to (300, 300) from t=10 to t=50\n"
          + "Shape C moves from (500, 100) to (500, 280) from t=20 to t=50\n"
          + "Shape C moves from (500, 280) to (500, 400) from t=50 to t=70\n"
          + "Shape C changes color from (0, 0, 255) to (0, 170, 85) from t=50 to t=70\n"
          + "Shape R scales from Width: 50, Height: 100  to "
          + "Width: 25, Height: 100  from t=51 to t=70\n"
          + "Shape R moves from (300, 300) to (200, 200) from t=70 to t=100\n"
          + "Shape C changes color from (0, 170, 85) to (0, 255, 0) from t=70 to t=80\n" + "\n"
          + "";
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(outStream);
      TextualView view = new TextualViewImpl(out);
      IController controller = new AnimationController(model, view);
      controller.textualConsoleGo();
      String actualOutput = outStream.toString();
      assertEquals(expectedOutput, actualOutput);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      model = AnimationReader.parseFile(new FileReader("toh-3.txt"), new AnimationBuilderImp(5));
      String expectedOutput = "Shapes:\n" + "Name: disk1\n" + "Type: Rectangle\n"
          + "Min corner: (190, 180) , Width: 20, Height: 30 , Color:(0, 49, 90)\n"
          + "Appears at t=1\n" + "Disappears at t=60\n" + "\n" + "Name: disk2\n"
          + "Type: Rectangle\n"
          + "Min corner: (167, 210) , Width: 65, Height: 30 , Color:(6, 247, 41)\n"
          + "Appears at t=1\n" + "Disappears at t=60\n" + "\n" + "Name: disk3\n"
          + "Type: Rectangle\n"
          + "Min corner: (145, 240) , Width: 110, Height: 30 , Color:(11, 45, 175)\n"
          + "Appears at t=1\n" + "Disappears at t=60\n" + "\n" + "\n"
          + "Shape disk1 moves from (190, 180) to (190, 50) from t=5 to t=7\n"
          + "Shape disk1 moves from (190, 50) to (490, 50) from t=7 to t=9\n"
          + "Shape disk1 moves from (490, 50) to (490, 240) from t=9 to t=11\n"
          + "Shape disk2 moves from (167, 210) to (167, 50) from t=11 to t=13\n"
          + "Shape disk2 moves from (167, 50) to (317, 50) from t=13 to t=15\n"
          + "Shape disk2 moves from (317, 50) to (317, 240) from t=15 to t=17\n"
          + "Shape disk1 moves from (490, 240) to (490, 50) from t=17 to t=19\n"
          + "Shape disk1 moves from (490, 50) to (340, 50) from t=20 to t=22\n"
          + "Shape disk1 moves from (340, 50) to (340, 210) from t=22 to t=24\n"
          + "Shape disk3 moves from (145, 240) to (145, 50) from t=24 to t=26\n"
          + "Shape disk3 moves from (145, 50) to (445, 50) from t=26 to t=28\n"
          + "Shape disk3 moves from (445, 50) to (445, 240) from t=28 to t=30\n"
          + "Shape disk1 moves from (340, 210) to (340, 50) from t=30 to t=32\n"
          + "Shape disk3 changes color from (11, 45, 175) to (0, 255, 0) from t=30 to t=32\n"
          + "Shape disk1 moves from (340, 50) to (190, 50) from t=32 to t=34\n"
          + "Shape disk1 moves from (190, 50) to (190, 240) from t=35 to t=37\n"
          + "Shape disk2 moves from (317, 240) to (317, 50) from t=37 to t=39\n"
          + "Shape disk2 moves from (317, 50) to (467, 50) from t=39 to t=41\n"
          + "Shape disk2 moves from (467, 50) to (467, 210) from t=41 to t=43\n"
          + "Shape disk1 moves from (190, 240) to (190, 50) from t=43 to t=45\n"
          + "Shape disk2 changes color from (6, 247, 41) to (0, 255, 0) from t=43 to t=45\n"
          + "Shape disk1 moves from (190, 50) to (490, 50) from t=45 to t=47\n"
          + "Shape disk1 moves from (490, 50) to (490, 180) from t=47 to t=49\n"
          + "Shape disk1 changes color from (0, 49, 90) to (0, 255, 0) from t=49 to t=51\n" + "\n"
          + "";
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(outStream);
      TextualView view = new TextualViewImpl(out);
      IController controller = new AnimationController(model, view);
      controller.textualConsoleGo();
      String actualOutput = outStream.toString();
      assertEquals(expectedOutput, actualOutput);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
