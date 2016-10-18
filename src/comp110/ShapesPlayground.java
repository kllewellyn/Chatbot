package comp110;

class ShapesPlayground extends Drawing {

  Shapes getShapes() {
    // This is the "container" we'll be adding our shapes to.
    Shapes container = new Shapes();

    // Let's Setup Some Colors
    Color red = new Color();
    red.setRed(1.0);
    red.setGreen(0.0);
    red.setBlue(0.0);

    Color green = new Color();
    green.setRed(0.0);
    green.setGreen(1.0);
    green.setBlue(0.0);

    Color blue = new Color();
    blue.setRed(0.0);
    blue.setGreen(0.0);
    blue.setBlue(1.0);

    Color black = new Color();
    black.setBlue(0.0);
    black.setGreen(0.0);
    black.setRed(0.0);

    Color gray = new Color();
    gray.setRed(0.5);
    gray.setGreen(0.5);
    gray.setBlue(0.5);

    Color white = new Color();
    white.setRed(1.0);
    white.setGreen(1.0);
    white.setBlue(1.0);

    // Now Let's Draw Some Shapes By Hand

    // Circle
    Circle exampleCircle = new Circle();
    exampleCircle.setCenterX(20.0);
    exampleCircle.setCenterY(20.0);
    exampleCircle.setRadius(10.0);
    exampleCircle.setFill(red);
    exampleCircle.setStroke(black);
    exampleCircle.setStrokeWidth(1.0);
    container.add(exampleCircle);

    // Rectangle
    Rectangle exampleRectangle = new Rectangle();
    exampleRectangle.setX(50.0);
    exampleRectangle.setY(10.0);
    exampleRectangle.setWidth(20.0);
    exampleRectangle.setHeight(20.0);
    exampleRectangle.setFill(green);
    exampleRectangle.setStroke(gray);
    exampleRectangle.setStrokeWidth(2.0);
    container.add(exampleRectangle);

    // Path
    Path examplePath = new Path();
    StartingPoint startOfPath = new StartingPoint();
    startOfPath.setX(90.0);
    startOfPath.setY(30.0);
    examplePath.add(startOfPath);
    LineTo leftSide = new LineTo();
    leftSide.setX(100.0);
    leftSide.setY(10.0);
    examplePath.add(leftSide);
    LineTo rightSide = new LineTo();
    rightSide.setX(110.0);
    rightSide.setY(30.0);
    examplePath.add(rightSide);
    LineTo bottom = new LineTo();
    bottom.setX(90.0);
    bottom.setY(30.0);
    examplePath.add(bottom);
    examplePath.setFill(white);
    examplePath.setStroke(blue);
    examplePath.setStrokeWidth(3.0);
    container.add(examplePath);

    // Now that we've added all of our shapes to the container, we
    // return or "give" them back to support code so that it can
    // draw the shapes on the grid.
    return container;
  }

}
