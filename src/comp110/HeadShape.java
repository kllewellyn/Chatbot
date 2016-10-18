package comp110;

class HeadShape extends Drawing {

  /* Constructor(s) */
  HeadShape() {
  }

  Color getPinkColor() {
	    Color pink = new Color();
	    pink.setRed(1.0);
	    pink.setGreen(0.75);
	    pink.setBlue(0.80);
	    return pink;
	  }
  /* Methods */
  Shapes getShapes() {
    Shapes container = new Shapes();

    /**
     * Construct your shape for a background here.
     */
    
    Circle head = new Circle();
    head.setCenterX(50);
    head.setCenterY(50);
    head.setScaleX(100);
    head.setScaleY(100);
    head.setStroke(getPinkColor());
    container.add(head);
    return container;
  }
  
  

}