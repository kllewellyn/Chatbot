package comp110;

class DrawingGallery {

  /* Instance Variables */
  Drawings _container;

  /**
   * Constructor - Here we're setting up our _drawings instance variable by
   * adding a new instance of each of our drawing classes to it.
   * 
   * In order to see your work on your own drawings, be sure to add instances of
   * them to the gallery like the stencil code provided below.
   */
  DrawingGallery() {
    _container = new Drawings();

    // Stencil code Drawings.
    // You can comment these out once you start.
    _container.add(new Arrow());
    _container.add(new Target(this.getDarkColor(), this.getLightColor()));
    _container.add(new Bow());
    _container.add(new Archery());
    _container.add(new ShapesPlayground());

    // Uncomment the following lines one-by-one as work on each Drawing...
    //
    // Our support code will automatically select the last Drawing
    // you add to the container when it runs. So if you go back to
    // working on a previous drawing, just add it last so you don't
    // have to select it from the drop down menu each time you run!
    //
     _container.add(new HeadShape());
     _container.add(new Mouth());
    // _container.add(new Nose());
     _container.add(new Eye(this.getDarkColor()));
     _container.add(new Baemoji());

    // Now for the fun part: try adding your own
    // classes and drawing different shapes!
  }

  /* Accessor Methods */
  Drawings getDrawings() {
    return _container;
  }

  Color getLightColor() {
    Color white = new Color();
    white.setRed(1.0);
    white.setGreen(1.0);
    white.setBlue(1.0);
    return white;
  }

  Color getDarkColor() {
    Color red = new Color();
    red.setRed(1.0);
    red.setGreen(0.0);
    red.setBlue(0.0);
    return red;
  }

  Color getPinkColor() {
	    Color pink = new Color();
	    pink.setRed(1.0);
	    pink.setGreen(0.75);
	    pink.setBlue(0.80);
	    return pink;
	  }

}