package cs5004.animator.view;

import java.io.FileWriter;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import cs5004.animator.util.Canvas;
import cs5004.animator.util.Motion;
import cs5004.animator.util.Shape;

/**
 * A class implements SVGView.
 * 
 * @author nanchen
 *
 */
public class SVGViewImpl implements SVGView {
  private Appendable out;

  /**
   * Construct the SVGViewImpl taking the appendable.
   * 
   * @param out the output resourse
   */
  public SVGViewImpl(Appendable out) {
    this.out = out;
  }

  /*
   * Construct the svg string according to the data of nameTickShapeMap, canvas,
   * speed, nameDisappearTime.
   * 
   * @param nameTickShapeMap the linkedHashMap whose keys represent the name of
   * the shapes and the values represents all motion states.
   * 
   * @param canvas the canvas of the animation.
   * 
   * @param speed the speed of the animation.
   * 
   * @param nameDisappearTime the linkedHashMap whose keys represent the name of
   * the shapes and the values represents its disappear time.
   * 
   * @return the svg string.
   */
  private String svgString(LinkedHashMap<String, LinkedList<Shape>> nameTickShapeMap, Canvas canvas,
      int speed, HashMap<String, Integer> nameDisappearTime) {
    String output = "";
    output += canvas.svgCanvasString();
    output += "\n";
    for (Entry<String, LinkedList<Shape>> entry : nameTickShapeMap.entrySet()) {
      LinkedList<Shape> animationList = entry.getValue();
      Shape initialShape = animationList.get(0);
      output += initialShape.svgShapeString();
      output += Motion.svgVisiable(initialShape.getTick(), speed);
      int i = 0;
      while (i < animationList.size()) {
        output += Motion.svgAnimation(animationList.get(i), animationList.get(i + 1), speed);
        i = i + 2;
      }
      output += Motion.svgHidden(nameDisappearTime.get(initialShape.getName()), speed);
      output += initialShape.endSVGString();
      output += "\n";
    }
    output += "</svg>";
    return output;
  }

  @Override
  public void showSVGAnimations(LinkedHashMap<String, LinkedList<Shape>> nameTickShapeMap,
      Canvas canvas, int speed, HashMap<String, Integer> nameDisappearTime) {
    ((PrintStream) out).println(svgString(nameTickShapeMap, canvas, speed, nameDisappearTime));

  }

  @Override
  public void writeSVGAnimations(LinkedHashMap<String, LinkedList<Shape>> nameTickShapeMap,
      Canvas canvas, int speed, HashMap<String, Integer> nameDisappearTime) {
    try {
      ((FileWriter) out).append(svgString(nameTickShapeMap, canvas, speed, nameDisappearTime));
    } catch (IOException e1) {
      throw new IllegalStateException("Cannot write into file");
    }
    try {
      ((FileWriter) out).close();
    } catch (IOException e) {
      throw new IllegalStateException("Cannot close file");
    }

  }

}
