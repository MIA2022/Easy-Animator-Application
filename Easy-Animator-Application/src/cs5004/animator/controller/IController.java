package cs5004.animator.controller;

/**
 * Represents a Controller for Animation. User can handle animation in textual,
 * svg, visual, playback pattern.
 *
 * @author nanchen
 *
 */
public interface IController {
  /**
   * Execute a textual animation and show it in the console.
   */
  void textualConsoleGo();

  /**
   * Execute a textual animation and show it in the file.
   */
  void textualFileGo();

  /**
   * Execute a visual animation. Call view and give the corresponding data to the
   * view. Use JSwing Timer to controller the shapes shown in the JFrame.
   */
  void visualGo();

  /**
   * Execute a GUI animation. Call view and give the corresponding data to the
   * view.
   */
  void guiViewGo();

  /**
   * Execute a SVG animation and show it in the console.
   */
  void svgConsoleGo();

  /**
   * Execute a SVG animation and show it in the file.
   */
  void svgFileGo();

}
