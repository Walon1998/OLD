float x=0;
float y= 15;  //geschwindigkeit von blöcken 
float erhohb; // erhöhung geschwindidkeit blöcke
float a=0;  
float b=0;
float v=2.5; // geschwindigkeit kugel
float erhohx=0.5; //erhöhung geschwindigkeit kugel x
float ky=3; // variable Grenzwert y kugel
float erhohky=0.1; //erhöhung grenzwert
float k=random(-ky,ky);
float yposr1,xposr1,yposr2,xposr2,ypose,xpose;
float h;
float langer=100;
  float gamemode=0;
  float verk; // verkürzung länge der Blöcke
  String welcome = "Welcome to ma game!";

  String Schwierigkeit1= "1-Easy";
  String Schwierigkeit2= "2-Medium";
  String Schwierigkeit3= "3-Hard";
  String Schwierigkeit4= "4-Insane";
  String Schwierigkeit5= "5-Dont even try it";
  
  String multi=("m-multiplayer");
  String singl=("p-singleplayer");
  String start=("-Press space to start-");
  boolean multip=false;
  boolean single=false;
  int nigga;
  int score;
 
void setup(){
  smooth();
  size(1500,800);
  background(0);
  //ellipse(height/2,width/2,10,10);
  textAlign(CENTER);
  textSize(100);
  //translate(height/2,width/2);
text(welcome,width/2,height/4);
textSize(50);
  textAlign(LEFT);
text(Schwierigkeit1,width/4-150,height/2-50);
text(Schwierigkeit2,width/4-150,height/2+25);
text(Schwierigkeit3,width/4-150,height/2+100);
text(Schwierigkeit4,width/4-150,height/2+175);
text (Schwierigkeit5,width/4-150,height/2+250);
textAlign(CENTER);
text(multi,width/4*3-100,height/2-50);
text(singl,width/4*3-100,height/2+25);
text(start,width/2,height/4*3+150);
}
void draw(){

  if(gamemode>1){
     String scorer=("Score: "+score+"");
      background(0);
      fill(255,255,255,100);
  text(scorer,width/2,height/4);
    if(nigga==300){//multiplayer
      yposr2=height/2-a;
    yposr1=height/2-x;}
    else {//singleplayer
      yposr2=height/2+h;
     // if(mouseY>langer/2&& mouseY<height-(langer/2)){
      yposr1=mouseY;
    }

  
  fill(255);
  rectMode(CENTER);
  //int h=height/2-a;
  rect(50,yposr1,10,langer);
  rect(width-50,yposr2,10,langer);
  //println(x);
  //strokeWeight(50);
  //fill(255);
  ellipse(width/2+b,height/2+h,10,10);
  b=b+v;
  h=h+k;
 println(b);
 
    
     if (h>=height/2||h<=-height/2){
     k=-k;}
  if(b>= width/2-50&& dist(width/2+b,height/2+h,width-50,yposr2)<=langer/2){
    v=v+erhohx;
    v=-v;
    langer=langer-verk;
    ky=ky+erhohky;
      k=random(-ky,ky);
      y=y+erhohb;
      score++;
  }
    if(b<=-width/2+50&& dist(50,yposr1,width/2+b,height/2+h)<=langer/2){
      v=v-erhohx;
      v=-v;
      langer=langer-verk;
     ky=ky+erhohky;
      k=random(-ky,ky);
      y=y+erhohb;
      score++;
    }
    
  if (b==-width/2||b==width/2){
    background(0);
   // delay(5000);
    //exit();
  }}
  if(b>=width/2&& nigga==300){
    stop();
    background(0);
    String scorer=("Score: "+score+"");
    String ver2=("Player 2 hat verloren!");
    textSize(100);
    text(ver2,width/2,height/2);
     fill(255,255,255,100);
     textSize(50);
  text(scorer,width/2,height/4);
  }
if(b<=-width/2&& nigga==300){
    stop();
    background(0);
    String scorer=("Score: "+score+"");
    String ver1=("Player 1 hat verloren!");
      textSize(100);
    text(ver1,width/2,height/2);
     fill(255,255,255,100);
     textSize(50);
  text(scorer,width/2,height/4);
  }
    if(b>=width/2&& nigga==-100){
    stop();
    background(0);
    String scorer=("Score: "+score+"");
    String ver3=("Gratuliere, du hast gewonnen!");
    textSize(100);
    text(ver3,width/2,height/2);
     fill(255,255,255,100);
     textSize(50);
  text(scorer,width/2,height/4);
  }
if(b<=-width/2&& nigga==-100){
    stop();
    background(0);
    String scorer=("Score: "+score+"");
    String ver4=("Du hast verloren!");
      textSize(100);
    text(ver4,width/2,height/2);
     fill(255,255,255,100);
     textSize(50);
  text(scorer,width/2,height/4);
  }
}
void keyPressed(){
  if(key=='w' && x<height/2-langer/2)
  {x=x+y;}
  else if (key=='s' && x>-height/2+langer/2 )
  {x=x-y;}
   else if (key=='9'&& a<height/2-langer/2)
  {a=a+y;}
  else if (key=='6'&& a>-height/2+langer/2)
  {a=a-y;}
 else if(key==' '){
    gamemode= 10;}
  if(key=='1'){
   y=20;
   erhohb=1;
   v=2;
   erhohx=0.3;
   ky=1;
   erhohky=0.1;
   langer=200;
   verk=2;
   
 }
   if(key=='2'){
   y=20;
   erhohb=2;
   v=2;
   erhohx=0.7;
   ky=1;
   erhohky=0.3;
   langer=150;
   verk=3;
   
 }
   if(key=='3'){
   y=20;
   erhohb=4;
   v=2;
   erhohx=1.5;
   ky=1;
   erhohky=0.5;
   langer=100;
   verk=4;
   
 }
   if(key=='4'){
   y=20;
   erhohb=8;
   v=2;
   erhohx=3;
   ky=1;
   erhohky=1;
   langer=50;
   verk=3;
   
 }
   if(key=='5'){
   y=20;
   erhohb=10;
   v=1;
   erhohx=50;
   ky=1;
   erhohky=50;
   langer=20;
   verk=1;
   
 }
    if(key=='m'){
      //multip=true;
      //single=false;
      nigga=300;
    }
   if(key=='p'){
      //multip=false;
      //single=true;
      nigga=-100;
     }
}