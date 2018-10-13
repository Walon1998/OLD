import android.view.MotionEvent;
int circleBaseSize = 512; 
void setup() {
  size(displayWidth, displayHeight);
  
}
void infoCircle(float x, float y, float siz, int id) {
  // What is drawn on sceen when touched.
  float diameter = circleBaseSize * siz;
  noFill();
  ellipse(x, y, diameter, diameter);
  fill(0,255,0);
  ellipse(x, y, 8, 8);
  text( ("ID:"+ id + " " + int(x) + ", " + int(y) ), x-128, y-64);
}
public boolean surfaceTouchEvent(MotionEvent me) {
  // Number of places on the screen being touched:
  int numPointers = me.getPointerCount();
  for(int i=0; i < numPointers; i++) {
    int pointerId = me.getPointerId(i);
    float x = me.getX(i);
    float y = me.getY(i);
    float siz = me.getSize(i);
    infoCircle(x, y, siz, pointerId);
  }
  // If you want the variables for motionX/motionY, mouseX/mouseY etc.
  // to work properly, you'll need to call super.surfaceTouchEvent().
  return super.surfaceTouchEvent(me);
}