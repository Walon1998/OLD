// Eric Pavey - AkEric.com - 2010-12-29
// Example showing simple multi-touch detection in 'Processing - Android'.
// My Samsung Captivate (Galaxy S) can track 5 touch-points.
// Updated to work with Processing's surfaceTouchEvent instead of
// Android's dispatchTouchEvent.

// Should point out that API Level 9 has MotionEvent.PointerCoords class that
// expose some cool functionality, but I'm only on Level 7.
import android.view.MotionEvent;

String[] fontList;
PFont androidFont;
int circleBaseSize = 512; // change this to make the touche circles bigger\smaller.
float x,y,a,b,c,d;
//float a=(displayWidth/2);
 //float b=(displayHeight/2);
void setup() {
  
  size(displayWidth, displayHeight);
  // Fix the orientation so the sketch won't reset when rotated.
  orientation(PORTRAIT);
  stroke(255);
  smooth();
  // Setup Fonts:
  fontList = PFont.list();
  androidFont = createFont(fontList[0], 16, true);
  textFont(androidFont);
  textAlign(LEFT);
}

void draw() {
  //background(0);
}
//void drawline(float x,float y, float x2, float y2){
  
//  line (

//}
void lineMach(float x, float y,float a, float b) {
// float a=(displayWidth/2);
//float b=(displayHeight/2);
//  void mouseDragged(){
  // What is drawn on sceen when touched.
  //float diameter = circleBaseSize * siz;
  //Fill();
  //ellipse(x, y, diameter, diameter);
 // fill(0,255,0);
  //ellipse(x, y, 8, 8);
  //text( ("ID:"+ id + " " + int(x) + ", " + int(y) ), x-128, y-64);
 // fill(0);
 // stroke (0);
 // strokeWeight(10);
 // point(x,y);
  
 // float a=c;
  //float b=d;
 // line(x,y,a,b); 
  
 
 // print("a="+a+"");
   // print("b="+b+"");
   // print("x="+x+"");
   // print("y="+y+"");
  
}

//-----------------------------------------------------------------------------------------
// Override Processing's surfaceTouchEvent, which will intercept all
// screen touch events.  This code only runs when the screen is touched.

public boolean surfaceTouchEvent(MotionEvent me) {
  // Number of places on the screen being touched:
  int numPointers = me.getPointerCount();
  for(int i=0; i < numPointers; i++) {
    int pointerId = me.getPointerId(i);
  //  float c,d;
   // float a=x;
//float b=d;
    float x = me.getX(i);
    float y = me.getY(i);
   // println("shit");
    print("a="+a+"");
    print("b="+b+"");
   // float siz = me.getSize(i);
   //float a=0;
  // float c=g;
 
  // float a=c;
   //float b=d;
    fill(0);
 stroke (0);
  strokeWeight(10);
   //lineMach(x,y,a,b);
    line(x,y,a,b); 
    a=x;
     b=y;
   //float a=x;
    //b=y;
 //c=x;
//d=y;
 //lineMach(x, y,a,b);
  }
  // If you want the variables for motionX/motionY, mouseX/mouseY etc.
  // to work properly, you'll need to call super.surfaceTouchEvent().
  return super.surfaceTouchEvent(me);
}