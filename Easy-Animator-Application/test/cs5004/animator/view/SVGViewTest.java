package cs5004.animator.view;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

import org.junit.Test;

import cs5004.animator.model.IModel;
import cs5004.animator.util.AnimationBuilderImp;
import cs5004.animator.util.AnimationReader;

/**
 * A test for SVGView.
 * @author nanchen
 *
 */
public class SVGViewTest {

  /**
   * Test the output for the SVGView.
   */
  @Test
  public void test() {
    try {
      String expectedOutput = "<svg width=\"560\" height=\"430\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">\n"
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
          + "</rect>\n"
          + "\n"
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
          + "</ellipse>\n"
          + "\n"
          + "</svg>\n"
          + "";
      IModel model = AnimationReader.parseFile(new FileReader("smalldemo.txt"), 
          new AnimationBuilderImp(1));
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(outStream);
      SVGView view = new SVGViewImpl(out);
      view.showSVGAnimations(model.getNameTickShapeMap(), model.getCanvas(), 
          model.getSpeed(), model.getNameDisappearTime());
      String actualOutput = outStream.toString(); 
      assertEquals(expectedOutput, actualOutput);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    
    try {
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
          + "</rect>\n"
          + "\n"
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
          + "attributeName=\"visibility\" from=\"visible\" to=\"hidden\" fill=\"freeze\" />\n"
          + "</rect>\n"
          + "\n"
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
          + "</rect>\n"
          + "\n"
          + "</svg>\n"
          + "";
      IModel model = AnimationReader.parseFile(new FileReader("toh-3.txt"), 
          new AnimationBuilderImp(5));
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(outStream);
      SVGView view = new SVGViewImpl(out);
      view.showSVGAnimations(model.getNameTickShapeMap(), model.getCanvas(), 
          model.getSpeed(), model.getNameDisappearTime());
      String actualOutput = outStream.toString(); 
      assertEquals(expectedOutput, actualOutput);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

}
