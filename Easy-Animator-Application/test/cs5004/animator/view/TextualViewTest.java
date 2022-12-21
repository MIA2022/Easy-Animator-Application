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
 * A test for TextualView.
 * 
 * @author nanchen
 *
 */
public class TextualViewTest {

  /**
   * Test the output for the TextualView.
   */
  @Test
  public void test() {
    try {
      String expectedOutput = "Shapes:\n" + "Name: R\n" + "Type: Rectangle\n"
          + "Min corner: (200, 200) , Width: 50, Height: 100 , Color:(255, 0, 0)\n"
          + "Appears at t=1\n" + "Disappears at t=100\n" + "\n" + "Name: C\n" + "Type: Ellipse\n"
          + "Center: (500, 100) , X radius: 60, Y radius: 30 , Color:(0, 0, 255)\n"
          + "Appears at t=6\n" + "Disappears at t=100\n" + "\n" + "\n"
          + "Shape R moves from (200, 200) to (300, 300) from t=10 to t=50\n"
          + "Shape C moves from (500, 100) to (500, 280) from t=20 to t=50\n"
          + "Shape C moves from (500, 280) to (500, 400) from t=50 to t=70\n"
          + "Shape C changes color from (0, 0, 255) to (0, 170, 85) from t=50 to t=70\n"
          + "Shape R scales from Width: 50, Height: 100  to Width: 25, Height: 100  "
          + "from t=51 to t=70\n"
          + "Shape R moves from (300, 300) to (200, 200) from t=70 to t=100\n"
          + "Shape C changes color from (0, 170, 85) to (0, 255, 0) from t=70 to t=80\n" + "\n"
          + "";
      IModel model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(outStream);
      TextualView view = new TextualViewImpl(out);
      view.showTextualAnimations(model.getNameAppearState(), model.getOrderedMotionShapes(),
          model.getSpeed(), model.getNameDisappearTime());
      String actualOutput = outStream.toString();
      assertEquals(expectedOutput, actualOutput);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
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
      IModel model = AnimationReader.parseFile(new FileReader("toh-3.txt"),
          new AnimationBuilderImp(5));
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(outStream);
      TextualView view = new TextualViewImpl(out);
      view.showTextualAnimations(model.getNameAppearState(), model.getOrderedMotionShapes(),
          model.getSpeed(), model.getNameDisappearTime());
      String actualOutput = outStream.toString();
      assertEquals(expectedOutput, actualOutput);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

}
