package comp110;

/*
 * Target is an example Drawing given to you as support code. You do not need to
 * do anything to this class, but feel encouraged to read through it for
 * understanding and tinker with anything that does not make sense.
 */

class Target extends Drawing {

  /* Instance Variables */
  Color _darkColor;
  Color _lightColor;

  /* Constructor */
  // Notice we're adding parameters to our constructor so that it's
  // easy for another drawing (like Archery) to change the colors
  // of the target by simply providing them as arguments to the constructor.
  Target(Color darkColor, Color lightColor) {
    _darkColor = darkColor;
    _lightColor = lightColor;
  }

  /* Methods */
  Shapes getShapes() {
    Shapes container = new Shapes(); // Initialize our _shapes instance
                                     // variable!

    // We'll setup a local variable for the outer radius of the target.
    double outerRadius = 45.0;

    // We'll "draw" our target by repeatedly calling a "helper" method we wrote
    // below that uses some parameters to construct a new circle, return it,
    // assign the returned circle
    Circle outermostCircle = this.makeCircle(outerRadius, _darkColor);
    container.add(outermostCircle);

    // We can also add the returned circles directly to our container without
    // using a local variable. The following lines are equivalent to above.
    container.add(this.makeCircle(outerRadius - 10.0, _lightColor));
    container.add(this.makeCircle(outerRadius - 20.0, _darkColor));
    container.add(this.makeCircle(outerRadius - 30.0, _lightColor));
    container.add(this.makeCircle(outerRadius - 40.0, _darkColor));

    return container;
  }

  // The purpose of this makeCircle job is to save us some typing!
  // Feel encouraged to try inventing your own methods to could save you
  // some repetitive code in a similar way!
  Circle makeCircle(double radius, Color color) {
    Circle circle = new Circle();
    circle.setCenterX(50.0);
    circle.setCenterY(50.0);
    circle.setRadius(radius);
    circle.setFill(color);
    return circle;
  }

}
