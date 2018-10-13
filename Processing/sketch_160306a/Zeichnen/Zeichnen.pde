import de.fhpotsdam.simpletouch.*;
import de.fhpotsdam.simpletouch.examples.*;
import de.fhpotsdam.simpletouch.examples.dynamic.*;
import de.fhpotsdam.simpletouch.examples.inner.*;
import de.fhpotsdam.simpletouch.examples.threading.*;

import ketai.ui.*;
void setup()
{size(displayWidth, displayHeight, SMT.RENDERER);
SMT.init( this, TouchSource.AUTOMATIC);
background(255);
stroke(0);
strokeWeight(10);

}
void drawMyZone(Zone zone){
  rect(0, 0, displayWidth, displayHeight);
}
void touchMyZone(Zone zone){
  line(mouseX,mouseY ,pmouseX, pmouseY);}

void draw()
{
  

line(mouseX,mouseY ,pmouseX, pmouseY);

}
void mouseReleased(){
  background(255);
}