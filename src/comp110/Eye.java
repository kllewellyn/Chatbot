package comp110;

class Eye extends Drawing {

  /* Instance Variables (Properties) */
  Color _color; // The Color of

  /* Constructor */
  Eye(Color color) {
    _color = color;
  }

  /* Methods */

  // The getShapes method returns a Shapes collection.
  Shapes getShapes() {
    Shapes container = new Shapes();

    /*
     * Construct your shapes for an eye here. Call methods on the shapes to
     * change their properties. Don't forget to add them to the Shapes container
     * when you're done!
     * 
     * Be sure at least one of your shapes' fill properties is set to the _color
     * instance variable.
     */

    Circle circle = new Circle();
    circle.setStroke(_color);
    circle.setScaleX(7);
    circle.setScaleY(7);
    container.add(circle);
    
    return container;
  }

  // Accessor and Mutator Methods for an Eye's color property
  void setColor(Color color) {
    _color = color;
  }

  Color getColor() {
    return _color;
  }

}
