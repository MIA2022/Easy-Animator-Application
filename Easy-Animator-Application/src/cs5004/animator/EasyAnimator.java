package cs5004.animator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import cs5004.animator.controller.AnimationController;
import cs5004.animator.controller.IController;
import cs5004.animator.model.IModel;
import cs5004.animator.util.AnimationBuilderImp;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.view.GUIViewImpl;
import cs5004.animator.view.IView;
import cs5004.animator.view.SVGViewImpl;
import cs5004.animator.view.TextualViewImpl;
import cs5004.animator.view.VisualViewImpl;

/**
 * Run Easy Animator as textual, svg, visual, GUI pattern.
 * 
 * @author nanchen
 *
 */
public class EasyAnimator {

  /**
   * Take inputs as command-line arguments. Use the data in inputfile to construct
   * model and use view parameter to construct concrete view class. Pass model and
   * view to controller. Give the control to controller. If no enough arguments or
   * no inputfile or no view is given, it will show error message in JOptionPane.
   * 
   * @param args command-line arguments
   * @throws IOException If it cannot pass data to the output file.
   */
  public static void main(String[] args) throws IOException {
    String inputFile = "";
    String viewName = "";
    String outputFile = "";
    int speed = 1;

    if (args.length < 4) {
      JOptionPane.showMessageDialog(null, "No enough arguments provided.");
    }
    for (int i = 0; i < args.length - 1; i++) {
      if (args[i].equals("-in")) {
        inputFile = args[i + 1];
      }
      if (args[i].equals("-view")) {
        viewName = args[i + 1];
      }
      if (args[i].equals("-out")) {
        outputFile = args[i + 1];
      }
      if (args[i].equals("-speed")) {
        speed = Math.max(1, Integer.parseInt(args[i + 1]));
      }
    }

    if (inputFile.equals("")) {
      JOptionPane.showMessageDialog(null, "No input file provided.");
    }

    if (!(viewName.equals("text") || viewName.equals("visual") || viewName.equals("svg")
        || viewName.equals("playback"))) {
      JOptionPane.showMessageDialog(null, "No qualified view provided.");
    }

    IView view;
    IController controller;
    IModel model;
    model = AnimationReader.parseFile(new FileReader(inputFile), new AnimationBuilderImp(speed));

    switch (viewName) {
      case "text":
        if (outputFile.equals("")) {
          view = new TextualViewImpl(System.out);
          controller = new AnimationController(model, view);
          controller.textualConsoleGo();
        } else {
          try {
            File myFoo = new File(outputFile);
            view = new TextualViewImpl(new FileWriter(myFoo, false));
            controller = new AnimationController(model, view);
            controller.textualFileGo();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        break;
      case "visual":
        view = new VisualViewImpl();
        controller = new AnimationController(model, view);
        controller.visualGo();
        break;
      case "svg":
        if (outputFile.equals("")) {
          view = new SVGViewImpl(System.out);
          controller = new AnimationController(model, view);
          controller.svgConsoleGo();
        } else {
          try {
            File myFoo = new File(outputFile);
            view = new SVGViewImpl(new FileWriter(myFoo, false));
            controller = new AnimationController(model, view);
            controller.svgFileGo();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        break;
      case "playback":
        view = new GUIViewImpl();
        controller = new AnimationController(model, view);
        controller.guiViewGo();
        break;
   
      default:
        break;
    }
  }
}
