package cs5004.animator.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import cs5004.animator.util.Motion;
import cs5004.animator.util.Shape;

/**
 * A class implements TextualView.
 * 
 * @author nanchen
 *
 */
public class TextualViewImpl implements TextualView {
  private Appendable out;

  /**
   * Construct the TextualView taking the appendable.
   * 
   * @param out the output resourse
   */
  public TextualViewImpl(Appendable out) {
    this.out = out;
  }

  /*
   * Return the initial state of shapes according to nameAppearState, speed,
   * nameDisappearTime.
   * 
   * @param nameAppearState the linkedHashMap whose keys represent the name of the
   * shapes and the values represents the appear state in the animation.
   * 
   * @param speed the speed of the animation.
   * 
   * @param nameDisappearTime the linkedHashMap whose keys represent the name of
   * the shapes and the values represents its disappear time.
   * 
   * @return the initial state of shapes according to nameAppearState, speed,
   * nameDisappearTime.
   */
  private String shapeString(LinkedHashMap<String, Shape> nameAppearState, int speed,
      HashMap<String, Integer> nameDisappearTime) {
    String outputString = "Shapes:\n";
    for (Map.Entry<String, Shape> e : nameAppearState.entrySet()) {
      outputString += e.getValue().nameString() + "\n" + e.getValue().typeString() + "\n"
          + e.getValue().positionString() + ", " + e.getValue().dimensionString() + ", " + "Color:"
          + e.getValue().colorString() + "\n" + "Appears at t="
          + (int) Motion.changeFromTickToTime(e.getValue().getTick(), speed) + "\n"
          + "Disappears at t="
          + (int) Motion.changeFromTickToTime(nameDisappearTime.get(e.getKey()), speed) + "\n"
          + "\n";
    }
    return outputString;
  }

  /*
   * Return the animation string according to orderedMotionShapes and speed.
   * 
   * @param orderedMotionShapes the linkedlist which represents the sorted
   * animation states according to the tick number.
   * 
   * @param speed the speed of the animation.
   * 
   * @return the animation string according to orderedMotionShapes and speed.
   */
  private String animationString(LinkedList<Shape> orderedMotionShapes, int speed) {

    String outputString = "";
    int i = 0;
    while (i < orderedMotionShapes.size()) {
      outputString += Motion.motionText(orderedMotionShapes.get(i), orderedMotionShapes.get(i + 1),
          speed);
      i += 2;
    }
    return outputString;
  }

  @Override
  public void showTextualAnimations(LinkedHashMap<String, Shape> nameAppearState,
      LinkedList<Shape> orderedMotionShapes, int speed,
      HashMap<String, Integer> nameDisappearTime) {

    ((PrintStream) out).println(shapeString(nameAppearState, speed, nameDisappearTime));
    ((PrintStream) out).println(animationString(orderedMotionShapes, speed));
  }

  @Override
  public void writeTextualAnimations(LinkedHashMap<String, Shape> nameAppearState,
      LinkedList<Shape> orderedMotionShapes, int speed,
      HashMap<String, Integer> nameDisappearTime) {

    try {
      ((FileWriter) out).append(shapeString(nameAppearState, speed, nameDisappearTime));
      ((FileWriter) out).append(animationString(orderedMotionShapes, speed));
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    try {
      ((FileWriter) out).close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
