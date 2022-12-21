In this project, I have five packages.
In the package cs5004.animator, I take the command-line arguments. Taken input file and speed to construct model. Construct different view according to different view names, and then pass the model and view to controller. According to the different view, controller will call different function to ask view to show animations in different ways.

In the package cs5004.animator.model, in the IModel interface, I use addCanvas(), addShape(), addMotion() methods to build model, and store the canvas data, shape data and motion data. They are stored using LinkedHashMap and LinkedList data structure. It includes nameType, nameTickShape, nameAppearState, nameDisappearTime, nameAppearTime, orderedMotionShapes(shapes are sorted according to tick time), animationAppearTime, animationDisappearTime, speed, canvas. I use move(int tick) method to calculate the shapes in the animation canvas at the given tick. It will be used for visual view and GUI view. And this interface includes some getters for controller to pass the data in the model to the view.

In the package cs5004.animator.util, it includes the helper functions for building animation. It also includes Canvas class, (Shape interface, AnimationShape abstract class, Oval class, Rectangle class )(They are for constructing shapes), and Motion class(It includes some static methods to check the motion state from the initial shapes to final shapes and it can change ticks to time given speed). All these classes contains getters as well as methods to produce strings for SVGView and TextualView.

In the package cs5004.animator. view, it contains an empty IView interface. There are four interfaces GUIView, SVGView, TextualView and VisualView extends this IView interface (following the SOLID principles). Four these four interfaces, each has an implement class. There is a AnimationPanel class for both GUIView and VisualView.
For the SVGView, there are 3 JCheckBox and five button.
When the looping box is selected, the animation will loop. If not, it will show only once.
When increase speed box is selected, the animation will increase speed. If not, it will use the original speed. 
When decrease speed box is selected, the animation will decrease speed. If not, it will use the original speed.
At the beginning of the view, we can choose start button and exit button. 
When the animation start, only pause, restart button can be chosen.
When the animation pause, only resume and restart can be chosen.
If there is no loop, when animation done, only restart button can be chosen.

In the package cs5004.animator.controller，it contains IController interface and its implement class. For the interface, there are textualConsoleGo(), textualFileGo(), visualGo(), GUIViewGo(),SVGConsoleGo(), SVGFileGo() methods to call each kinds of view to show the animation. The AnimationController class also implements ActionListener, ItemListener. In the GUIViewGo(), I use the thread to control abilities of the GUIView.
