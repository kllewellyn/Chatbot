package comp110;

/*
 * In this class, you'll be constructing all of your emoji face's
 * constituent shapes (face/skin shape, mouth, nose, eyes, etc) to
 * form a complex drawing made up of simpler drawings.
 */
public class Baemoji extends Drawing {

  HeadShape _faceShape;
  Nose _nose;
  Mouth _mouth;
  Eye _leftEye;
  Eye _rightEye;

  public Baemoji() {
	  _faceShape = new HeadShape();
    _leftEye = new Eye(getDarkColor());
    _rightEye = new Eye(getDarkColor());
  }

  public Shapes getShapes() {
    Shapes container = new Shapes();

    container.add(_faceShape);

    // Translate, Scale, and/or Rotate the Mouth
  //  container.add(_mouth);

    // Translate, Scale, and/or Rotate the Nose
 //   container.add(_nose);

   _leftEye.setTranslateX(21);
   _leftEye.setTranslateY(21);
    container.add(_leftEye);

    // Translate, Scale, and/or Rotate the Right Eye
    _rightEye.setTranslateX(65);
    _rightEye.setTranslateY(21);
    container.add(_rightEye);
    
    return container;
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