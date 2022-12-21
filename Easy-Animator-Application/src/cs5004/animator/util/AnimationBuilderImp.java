package cs5004.animator.util;

import cs5004.animator.model.AnimationModel;
import cs5004.animator.model.IModel;

/**
 * Implement the AnimationBuilder.
 * 
 * @author nanchen
 *
 */
public class AnimationBuilderImp implements AnimationBuilder<IModel> {

  private IModel model;

  /**
   * Build the model according to the data given in the inputfile.
   * 
   * @param speed the speed shown the animation
   */
  public AnimationBuilderImp(int speed) {
    this.model = new AnimationModel(speed);
  }

  @Override
  public IModel build() {
    return this.model;
  }

  @Override
  public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
    this.model.addCanvas(x, y, width, height);
    return this;
  }

  @Override
  public AnimationBuilder<IModel> declareShape(String name, String type) {
    this.model.addShape(name, type);
    return this;
  }

  @Override
  public AnimationBuilder<IModel> addMotion(String name, int t1, int x1, int y1, int w1, int h1,
      int r1, int g1, int b1, int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    this.model.addMotion(name, t1, x1, y1, w1, h1, r1, g1, b1, t2, x2, y2, w2, h2, r2, g2, b2);
    return this;
  }
}
