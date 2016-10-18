package comp110;

/*
 * Bow is an example Drawing given to you as support code. You do not need to
 * do anything to this class, but feel encouraged to read through it for
 * understanding and tinker with anything that does not make sense.
 */

class Bow extends Drawing {

  /* Constructor */
  Bow() {
  }

  /* Methods */
  Shapes getShapes() {
    Shapes container = new Shapes(); // Initialize our _shapes instance
                                     // variable!

    // We'll "draw" our bow by breaking it down into smaller methods
    container.add(this.makeBowString());
    container.add(this.makeBowHandle());
    return container;
  }

  Path makeBowString() {
    Path stringPath = new Path();

    StartingPoint top = new StartingPoint();
    top.setX(21.0);
    top.setY(10.0);
    stringPath.add(top);

    LineTo bottom = new LineTo();
    bottom.setX(21.0);
    bottom.setY(90.0);
    stringPath.add(bottom);

    return stringPath;
  }

  Path makeBowHandle() {
    Path handlePath = new Path();

    Color brown = new Color(0.67, 0.33, 0.01);
    handlePath.setFill(brown);

    StartingPoint top = new StartingPoint();
    top.setX(20.0);
    top.setY(10.0);
    handlePath.add(top);

    CubicCurveTo insideCurve = new CubicCurveTo();
    insideCurve.setX(20.0);
    insideCurve.setY(90.0);
    // We'll "pull" the top half of the curve toward (80, 10)
    insideCurve.setControlX1(75.0);
    insideCurve.setControlY1(10.0);
    // We'll "pull" the bottom half of the curve toward (80, 90)
    insideCurve.setControlX2(75.0);
    insideCurve.setControlY2(90.0);
    handlePath.add(insideCurve);

    CubicCurveTo outsideCurve = new CubicCurveTo();
    outsideCurve.setX(20.0);
    outsideCurve.setY(10.0);
    outsideCurve.setControlX1(80.0);
    outsideCurve.setControlY1(90.0);
    outsideCurve.setControlX2(80.0);
    outsideCurve.setControlY2(10.0);
    handlePath.add(outsideCurve);

    return handlePath;
  }

}
