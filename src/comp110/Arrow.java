package comp110;

/*
 * Arrow is an example Drawing given to you as support code. You do not need to
 * do anything to class, but feel encouraged to read through it for
 * understanding and tinker with anything that does not make sense.
 */

class Arrow extends Drawing {

  /* Instance Variables */

  /* Constructor */
  Arrow() {
  }

  /* Methods */
  Shapes getShapes() {
    Shapes container = new Shapes();
    container.add(this.makeArrowHeadPath());
    container.add(this.makeShaftPath());
    container.add(this.makeFletchingLines(70.0));
    container.add(this.makeFletchingLines(80.0));
    container.add(this.makeFletchingLines(90.0));
    return container;
  }

  /*
   * Helper Methods
   * 
   * The following methods break down the task of drawing an arrow into smaller
   * units of work.
   */
  Path makeArrowHeadPath() {
    Path arrowHeadPath = new Path();

    StartingPoint moveTo = new StartingPoint();
    moveTo.setX(40.0);
    moveTo.setY(20.0);
    arrowHeadPath.add(moveTo);

    LineTo leftLine = new LineTo();
    leftLine.setX(50.0);
    leftLine.setY(0.0);
    arrowHeadPath.add(leftLine);

    LineTo rightLine = new LineTo();
    rightLine.setX(60.0);
    rightLine.setY(20.0);
    arrowHeadPath.add(rightLine);

    return arrowHeadPath;
  }

  Path makeShaftPath() {
    Path shaftPath = new Path();

    StartingPoint startingPoint = new StartingPoint();
    startingPoint.setX(50);
    startingPoint.setY(0);
    shaftPath.add(startingPoint);

    LineTo shaftLine = new LineTo();
    shaftLine.setX(50);
    shaftLine.setY(90);
    shaftPath.add(shaftLine);

    return shaftPath;
  }

  Path makeFletchingLines(double top) {
    double bottom = top + 10.0;

    Path fletchingLinePath = new Path();

    StartingPoint startingPoint = new StartingPoint();
    startingPoint.setX(40.0);
    startingPoint.setY(bottom);
    fletchingLinePath.add(startingPoint);

    LineTo leftLine = new LineTo();
    leftLine.setX(50.0);
    leftLine.setY(top);
    fletchingLinePath.add(leftLine);

    LineTo rightLine = new LineTo();
    rightLine.setX(60.0);
    rightLine.setY(bottom);
    fletchingLinePath.add(rightLine);

    return fletchingLinePath;
  }

}