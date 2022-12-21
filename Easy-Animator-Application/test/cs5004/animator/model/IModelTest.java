package cs5004.animator.model;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Map.Entry;

import org.junit.Test;

import cs5004.animator.util.AnimationBuilderImp;
import cs5004.animator.util.AnimationReader;
import cs5004.animator.util.Shape;

/**
 * A test for model.
 * 
 * @author nanchen
 *
 */
public class IModelTest {

  /**
   * Test Canvas().
   */
  @Test
  public void testCanvas() {
    try {
      IModel model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));

      String expectedCanvas = "Top-left corner (200,70), dimensions 360x360";
      assertEquals(expectedCanvas, model.getCanvas().toString());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      IModel model = AnimationReader.parseFile(new FileReader("buildings.txt"),
          new AnimationBuilderImp(5));

      String expectedCanvas = "Top-left corner (0,0), dimensions 800x800";
      assertEquals(expectedCanvas, model.getCanvas().toString());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test getAnimationAppearTime(), getAnimationDisappearTime(), getSpeed().
   */
  @Test
  public void testGetAnimationTime() {
    try {
      IModel model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));
      assertEquals(1, model.getAnimationAppearTime());
      assertEquals(100, model.getAnimationDisappearTime());
      assertEquals(1, model.getSpeed());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      IModel model = AnimationReader.parseFile(new FileReader("toh-3.txt"),
          new AnimationBuilderImp(5));
      assertEquals(1, model.getAnimationAppearTime());
      assertEquals(302, model.getAnimationDisappearTime());
      assertEquals(5, model.getSpeed());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  /**
   * Test getNameTickShapeMap().
   */
  @Test
  public void testGetNameTickShapeMap() {
    try {
      IModel model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));
      String expectedNameTickShapeMap = "R Name: R Type: Rectangle t=1 "
          + "Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=10 Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=10 Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=50 Min corner: (300, 300) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=50 Min corner: (300, 300) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=51 Min corner: (300, 300) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=51 Min corner: (300, 300) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=70 Min corner: (300, 300) Width: 25, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=70 Min corner: (300, 300) Width: 25, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=100 Min corner: (200, 200) "
          + "Width: 25, Height: 100 (255, 0, 0)"
          + "C Name: C Type: Ellipse t=6 Center: (440, 70) X radius: 120, Y radius: 60 (0, 0, 255)"
          + "Name: C Type: Ellipse t=20 Center: (440, 70) X radius: 120, Y radius: 60 (0, 0, 255)"
          + "Name: C Type: Ellipse t=20 Center: (440, 70) X radius: 120, Y radius: 60 (0, 0, 255)"
          + "Name: C Type: Ellipse t=50 Center: (440, 250) X radius: 120, Y radius: 60 (0, 0, 255)"
          + "Name: C Type: Ellipse t=50 Center: (440, 250) X radius: 120, Y radius: 60 (0, 0, 255)"
          + "Name: C Type: Ellipse t=70 Center: (440, 370) X radius: 120, Y radius: 60 (0, 170, 85)"
          + "Name: C Type: Ellipse t=70 Center: (440, 370) X radius: 120, Y radius: 60 (0, 170, 85)"
          + "Name: C Type: Ellipse t=80 Center: (440, 370) X radius: 120, Y radius: 60 (0, 255, 0)"
          + "Name: C Type: Ellipse t=80 Center: (440, 370) X radius: 120, Y radius: 60 (0, 255, 0)"
          + "Name: C Type: Ellipse t=100 Center: (440, 370) "
          + "X radius: 120, Y radius: 60 (0, 255, 0)";
      String actualNameTickShapeMap = "";
      for (Entry<String, LinkedList<Shape>> entry : model.getNameTickShapeMap().entrySet()) {
        actualNameTickShapeMap += entry.getKey() + " ";
        LinkedList<Shape> list = entry.getValue();
        for (int i = 0; i < list.size(); i++) {
          actualNameTickShapeMap += list.get(i).toString();
        }
      }
      assertEquals(expectedNameTickShapeMap, actualNameTickShapeMap);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  /**
   * Test GetNameAppearTime().
   */
  @Test
  public void testGetNameAppearTime() {
    try {
      IModel model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));
      String expectedNameAppearTime = "R 1 C 6 ";
      String actualNameAppearTime = "";
      for (String name : model.getNameAppearTime().keySet()) {
        actualNameAppearTime += name + " ";
        actualNameAppearTime += model.getNameAppearTime().get(name) + " ";
      }
      assertEquals(expectedNameAppearTime, actualNameAppearTime);

      String expectedNameDisappearTime = "R 100 C 100 ";
      String actualNameDisappearTime = "";
      for (String name : model.getNameAppearTime().keySet()) {
        actualNameDisappearTime += name + " ";
        actualNameDisappearTime += model.getNameDisappearTime().get(name) + " ";
      }
      assertEquals(expectedNameDisappearTime, actualNameDisappearTime);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      IModel model = AnimationReader.parseFile(new FileReader("toh-3.txt"),
          new AnimationBuilderImp(5));
      String expectedNameAppearTime = "disk1 1 disk2 1 disk3 1 ";
      String actualNameAppearTime = "";
      for (String name : model.getNameAppearTime().keySet()) {
        actualNameAppearTime += name + " ";
        actualNameAppearTime += model.getNameAppearTime().get(name) + " ";
      }
      assertEquals(expectedNameAppearTime, actualNameAppearTime);

      String expectedNameDisappearTime = "disk1 302 disk2 302 disk3 302 ";
      String actualNameDisappearTime = "";
      for (String name : model.getNameAppearTime().keySet()) {
        actualNameDisappearTime += name + " ";
        actualNameDisappearTime += model.getNameDisappearTime().get(name) + " ";
      }
      assertEquals(expectedNameDisappearTime, actualNameDisappearTime);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  /**
   * Test GetNameAppearState().
   */
  @Test
  public void testGetNameAppearState() {
    try {
      IModel model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));
      String expectedNameAppearState = "R Name: R Type: Rectangle t=1 "
          + "Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0) "
          + "C Name: C Type: Ellipse t=6 Center: (500, 100) "
          + "X radius: 60, Y radius: 30 (0, 0, 255) ";
      String actualNameAppearState = "";
      for (String name : model.getNameAppearState().keySet()) {
        actualNameAppearState += name + " ";
        actualNameAppearState += model.getNameAppearState().get(name).toString() + " ";
      }
      assertEquals(expectedNameAppearState, actualNameAppearState);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      IModel model = AnimationReader.parseFile(new FileReader("toh-3.txt"),
          new AnimationBuilderImp(5));
      String expectedNameAppearState = "disk1 Name: disk1 Type: Rectangle t=1 "
          + "Min corner: (190, 180) Width: 20, Height: 30 (0, 49, 90) "
          + "disk2 Name: disk2 Type: Rectangle t=1 "
          + "Min corner: (167, 210) Width: 65, Height: 30 (6, 247, 41) "
          + "disk3 Name: disk3 Type: Rectangle t=1 "
          + "Min corner: (145, 240) Width: 110, Height: 30 (11, 45, 175) ";
      String actualNameAppearState = "";
      for (String name : model.getNameAppearState().keySet()) {
        actualNameAppearState += name + " ";
        actualNameAppearState += model.getNameAppearState().get(name).toString() + " ";
      }
      assertEquals(expectedNameAppearState, actualNameAppearState);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  /**
   * Test GetOrderedMotionShapes().
   */
  @Test
  public void testGetOrderedMotionShapes() {
    try {
      IModel model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));
      String expectedOrderedMotionShapes = "Name: R Type: Rectangle t=1 "
          + "Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=10 Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: C Type: Ellipse t=6 Center: (500, 100) X radius: 60, Y radius: 30 (0, 0, 255)"
          + "Name: C Type: Ellipse t=20 Center: (500, 100) X radius: 60, Y radius: 30 (0, 0, 255)"
          + "Name: R Type: Rectangle t=10 Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=50 Min corner: (300, 300) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: C Type: Ellipse t=20 Center: (500, 100) X radius: 60, Y radius: 30 (0, 0, 255)"
          + "Name: C Type: Ellipse t=50 Center: (500, 280) X radius: 60, Y radius: 30 (0, 0, 255)"
          + "Name: R Type: Rectangle t=50 Min corner: (300, 300) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=51 Min corner: (300, 300) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: C Type: Ellipse t=50 Center: (500, 280) X radius: 60, Y radius: 30 (0, 0, 255)"
          + "Name: C Type: Ellipse t=70 Center: (500, 400) X radius: 60, Y radius: 30 (0, 170, 85)"
          + "Name: R Type: Rectangle t=51 Min corner: (300, 300) Width: 50, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=70 Min corner: (300, 300) Width: 25, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=70 Min corner: (300, 300) Width: 25, Height: 100 (255, 0, 0)"
          + "Name: R Type: Rectangle t=100 Min corner: (200, 200) "
          + "Width: 25, Height: 100 (255, 0, 0)"
          + "Name: C Type: Ellipse t=70 Center: (500, 400) X radius: 60, Y radius: 30 (0, 170, 85)"
          + "Name: C Type: Ellipse t=80 Center: (500, 400) X radius: 60, Y radius: 30 (0, 255, 0)"
          + "Name: C Type: Ellipse t=80 Center: (500, 400) X radius: 60, Y radius: 30 (0, 255, 0)"
          + "Name: C Type: Ellipse t=100 Center: (500, 400) X radius: 60, Y radius: 30 (0, 255, 0)";
      String actualOrderedMotionShapes = "";
      for (int i = 0; i < model.getOrderedMotionShapes().size(); i++) {
        actualOrderedMotionShapes += model.getOrderedMotionShapes().get(i).toString();
      }
      assertEquals(expectedOrderedMotionShapes, actualOrderedMotionShapes);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  /**
   * Test move().
   */
  @Test
  public void testMove() {
    try {
      IModel model = AnimationReader.parseFile(new FileReader("smalldemo.txt"),
          new AnimationBuilderImp(1));
      String expectedMotionShapeMap = "R Name: R Type: Rectangle t=3 "
          + "Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0)";
      String actualMotionShapeMap = "";
      for (String name : model.move(3).keySet()) {
        if (model.move(3).get(name) != null) {
          actualMotionShapeMap += name + " ";
          actualMotionShapeMap += model.move(3).get(name).toString();
        }
      }
      assertEquals(expectedMotionShapeMap, actualMotionShapeMap);

      expectedMotionShapeMap = "R Name: R Type: Rectangle t=6 "
          + "Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0)"
          + "C Name: C Type: Ellipse t=6 Center: (440, 70) X radius: 120, Y radius: 60 (0, 0, 255)";
      actualMotionShapeMap = "";
      for (String name : model.move(6).keySet()) {
        if (model.move(6).get(name) != null) {
          actualMotionShapeMap += name + " ";
          actualMotionShapeMap += model.move(6).get(name).toString();
        }
      }
      assertEquals(expectedMotionShapeMap, actualMotionShapeMap);

      expectedMotionShapeMap = "R Name: R Type: Rectangle t=10 "
          + "Min corner: (200, 200) Width: 50, Height: 100 (255, 0, 0)"
          + "C Name: C Type: Ellipse t=10 Center: (440, 70) "
          + "X radius: 120, Y radius: 60 (0, 0, 255)";
      actualMotionShapeMap = "";
      for (String name : model.move(10).keySet()) {
        if (model.move(10).get(name) != null) {
          actualMotionShapeMap += name + " ";
          actualMotionShapeMap += model.move(10).get(name).toString();
        }
      }
      assertEquals(expectedMotionShapeMap, actualMotionShapeMap);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    try {
      IModel model = AnimationReader.parseFile(new FileReader("toh-3.txt"),
          new AnimationBuilderImp(5));
      String expectedMotionShapeMap = "disk1 Name: disk1 Type: Rectangle "
          + "t=1 Min corner: (190, 180) Width: 20, Height: 30 (0, 49, 90)"
          + "disk2 Name: disk2 Type: Rectangle t=1 Min corner: (167, 210) "
          + "Width: 65, Height: 30 (6, 247, 41)"
          + "disk3 Name: disk3 Type: Rectangle t=1 Min corner: (145, 240) "
          + "Width: 110, Height: 30 (11, 45, 175)";
      String actualMotionShapeMap = "";
      for (String name : model.move(1).keySet()) {
        if (model.move(1).get(name) != null) {
          actualMotionShapeMap += name + " ";
          actualMotionShapeMap += model.move(1).get(name).toString();
        }
      }
      assertEquals(expectedMotionShapeMap, actualMotionShapeMap);

      expectedMotionShapeMap = "disk1 Name: disk1 Type: Rectangle "
          + "t=100 Min corner: (490, 50) Width: 20, Height: 30 (0, 49, 90)"
          + "disk2 Name: disk2 Type: Rectangle t=100 Min corner: (317, 240) "
          + "Width: 65, Height: 30 (6, 247, 41)"
          + "disk3 Name: disk3 Type: Rectangle t=100 Min corner: (145, 240) "
          + "Width: 110, Height: 30 (11, 45, 175)";
      actualMotionShapeMap = "";
      for (String name : model.move(100).keySet()) {
        if (model.move(100).get(name) != null) {
          actualMotionShapeMap += name + " ";
          actualMotionShapeMap += model.move(100).get(name).toString();
        }
      }
      assertEquals(expectedMotionShapeMap, actualMotionShapeMap);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

}
