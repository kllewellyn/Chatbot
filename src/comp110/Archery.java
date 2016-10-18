package comp110;

/*
 * Archery is an example composite Drawing given to you as support code. It uses
 * the Target, Arrow, and Bow classes to draw a scene made up of other Drawings.
 */

class Archery extends Drawing {

  /* Instance Variables */
  Target _target;
  Arrow _bullseyeArrow;
  Arrow _nextArrow;
  Bow _bow;

  /* Constructor */
  Archery() {
    // Initialize our "component" instance variables
    _target = new Target(this.getPink(), this.getCarolinaBlue());
    _bullseyeArrow = new Arrow();
    _nextArrow = new Arrow();
    _bow = new Bow();
  }

  /* Methods */
  Shapes getShapes() {
    Shapes container = new Shapes();

    // Place and size the target
    _target.setTranslateX(190.0);
    _target.setTranslateY(20.0);
    _target.setScale(0.5);
    _target.setScale(0.5);
    container.add(_target);

    // Place, resize, and rotate arrow hitting the target
    _bullseyeArrow.setRotation(135.0);
    _bullseyeArrow.setScaleX(0.5);
    _bullseyeArrow.setScaleY(0.5);
    _bullseyeArrow.setTranslateX(173.0);
    _bullseyeArrow.setTranslateY(2.0);
    container.add(_bullseyeArrow);

    // Move and rotate the in the bow
    _nextArrow.setRotation(75.0);
    _nextArrow.setTranslateX(10.0);
    _nextArrow.setTranslateY(-8.0);
    container.add(_nextArrow);

    // Rotate the bow a bit
    _bow.setRotation(345.0);
    container.add(_bow);

    return container;
  }

  Color getCarolinaBlue() {
    Color carolinaBlue = new Color();
    carolinaBlue.setRed(0.48);
    carolinaBlue.setGreen(0.69);
    carolinaBlue.setBlue(0.83);
    return carolinaBlue;
  }

  Color getPink() {
    Color pink = new Color();
    pink.setRed(1.0);
    pink.setGreen(0.75);
    pink.setBlue(0.80);
    return pink;
  }

}