import processing.pdf.*;
void setup() {
  beginRecord(PDF, "Heart.pdf");
 background(255);
  size(1000,1000);
  smooth();
  strokeWeight(5);
  stroke(255,0,0);
}

float a,b,x,y;
void draw() {
  if (mousePressed==true){
    strokeWeight(50);
     line(mouseX,mouseY,pmouseX,pmouseY);
  }
  
  translate(width/2,3*height/4);
  //background(255);
  for (float i=0; i<60; i=i+0.1) {
    float x = 0.25 * (-pow(i,2) + 40*i + 1200)*sin((PI*i)/180);
    float y = -0.25 * (-pow(i,2) + 40*i + 1200)*cos((PI*i)/180);
    point(x,y); // use these to place your little hearts
    point(-x,y); // use these to place your little hearts
    
    line(x,y,a,b);
    line(-x,y,-a,b);
    a=x;
    b=y;
  }
   
}

public void keyPressed() {
    if (key == 'p') {
      endRecord();
      exit();
    }

  }