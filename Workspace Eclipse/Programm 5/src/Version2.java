

import processing.core.PApplet;

import java.awt.Frame;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.mouse.GlobalMouseHook;
import lc.kra.system.mouse.event.GlobalMouseAdapter;
import lc.kra.system.mouse.event.GlobalMouseEvent;
import processing.pdf.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.MouseInfo;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.TS_DOWN;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_CONTROL;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_LCONTROL;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_LMENU;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_LSHIFT;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_MENU;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_RCONTROL;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_RMENU;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_RSHIFT;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_RWIN;
import static lc.kra.system.keyboard.event.GlobalKeyEvent.VK_SHIFT;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

import lc.kra.system.LibraryLoader;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import lc.kra.system.keyboard.event.GlobalKeyListener;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import javax.swing.*;
import javax.swing.JFrame;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
import javax.swing.JPanel;
import processing.core.*;
import processing.core.PApplet;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyListener;
import processing.pdf.*;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Version2 extends PApplet

{
	public static void main(String[] args) {
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new Version2());
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook();
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {

				switch (event.getVirtualKeyCode()) {

				case 191:
					exit = true; break;
				
				

				}

			
			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				// System.out.println(event);
				switch (event.getVirtualKeyCode()) {
			case 27: taste=27; break;
			case 112:taste=112; break;
			case 113:taste=113; break;
			case 114:taste=114; break;
			case 115:taste=115; break;
			case 116:taste=116; break;
			case 117:taste=117; break;
			case 118:taste=118; break;
			case 119:taste=119; break;
			case 120:taste=120; break;
			case 121:taste=121; break;
			case 122:taste=122; break;
			case 123:taste=123; break;
			case 44:taste=44; break;
			case 111:taste=111; break;
			case 106:taste=106; break;
			case 109:taste=109; break;
			case 19: taste=19; break;
			case 144:taste=144;break;
			case 145:taste=145;break;
			case 49 : taste=49 ;break;
			case 50: taste= 50;break;
			case 51: taste= 51;break;
			case 52: taste= 52;break;
			case 53: taste= 53;break;
			case 54: taste= 54;break;
			case 55: taste= 55;break;
			case 56: taste= 56;break;
			case 57: taste= 57;break;
			case 48: taste= 48;break;
			case 219: taste= 219;break;
			case 221: taste= 221;break;
			case 8: taste= 8;break;
			case 45: taste=45 ;break;
			case 36: taste= 36;break;
			case 33: taste= 33;break;
			case 9: taste= 9;break;	
			case 81: taste= 81;break;	
			case 87: taste= 87;break;	
			case 69: taste= 69;break;
			case 82: taste= 82;break;	
			case 84: taste= 84;break;	
			case 90: taste= 90;break;	
			case 85: taste= 85;break;	
			case 73: taste= 73;break;	
			case 79: taste= 79;break;		
			case 80: taste= 80;break;	
			case 186: taste= 186;break;	
			case 192: taste= 192;break;	
			case 13: taste= 13;break;	
			case 46: taste= 46;break;	
			case 35: taste= 35;break;	
			case 34: taste= 34;break;	
			case 103: taste= 103;break;	
			case 104: taste= 104;break;	
			case 105: taste= 105;break;	
			case 107: taste= 107;break;	
			case 20: taste=20 ;break;	
			case 65: taste=65 ;break;
			case 83: taste= 83;break;
			case 68: taste= 68;break;
			case 70: taste= 70;break;
			case 71: taste= 71;break;
			case 72: taste= 72;break;
			case 74: taste= 74;break;
			case 75: taste= 75;break;
			case 76: taste= 76;break;
			case 222: taste= 222;break;
			case 220: taste= 220;break;
			case 223: taste= 223;break;
			case 100: taste= 100;break;
			case 101: taste= 101;break;			
			case 102: taste= 102;break;
			case 160: taste=160 ;break;
			case 226: taste= 226;break;
			case 89: taste= 89;break;
			case 88: taste= 88;break;
			case 67: taste= 67;break;
			case 86: taste= 86;break;
			case 66: taste= 66;break;
			case 78: taste= 78;break;
			case 77: taste= 77;break;
			case 188: taste=188 ;break;
			case 190: taste= 190;break;
			case 189: taste= 189;break;
			case 161: taste= 161;break;
			case 38: taste= 38;break;
			case 97: taste= 97;break;
			
			case 98 : taste=98 ;break;
			case 99: taste= 99;break;
			case 162: taste=162 ;break;
			case 91: taste= 91;break;
			case 164: taste= 164;break;
			case 32: taste= 32;break;
			case 165: taste= 165;break;
			
			case 93: taste= 93;break;
			case 163: taste= 163;break;
			case 37: taste= 37;break;
			case 40: taste= 40;break;
			case 39: taste= 39;break;
			case 96: taste= 96;break;
			case 110: taste= 110;break;
		
			
			
			
				}
			}
		});

		
		

	}


	
int grosse=65;
int abstandx=70;
int a= abstandx/2;
float c= (3*abstandx)/4;
float d= abstandx/4;

int abstandy=70;
int e=(1079/6+1079/5)/2;
int b= abstandy/2;
int durchsichtig=25;
int color1 = color(255,0, 0, 100);
int color2 = color(0,255, 0, 100);
int color3 = color(0,0, 255, 100);
int color4 = color(0,0, 0, 100);
static int taste;
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "test " + ft.format(date) + " .pdf");
		background(255);
		smooth();
		noStroke();
		
		

	}

	public void draw() {
		
				switch (taste) {
			case 27: fill(color1);rect(abstandx,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
//			case : rect(abstandx,7*abstandy,grosse,grosse,durchsichtig);taste=0; break;
			case 112:fill(color1);rect(3*abstandx,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 113:fill(color1);rect(4*abstandx,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 114:fill(color1);rect(5*abstandx,abstandy+e,grosse,grosse,durchsichtig); taste=0;break;
			case 115:fill(color1);rect(6*abstandx,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 116:fill(color1);rect(8*abstandx-a,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 117:fill(color1);rect(9*abstandx-a,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 118:fill(color1);rect(10*abstandx-a,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 119:fill(color1);rect(11*abstandx-a,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 120:fill(color1);rect(12*abstandx,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 121:fill(color1);rect(13*abstandx,abstandy+e,grosse,grosse,durchsichtig); taste=0;break;
			case 122:fill(color1);rect(14*abstandx,abstandy+e,grosse,grosse,durchsichtig); taste=0;break;
			case 123:fill(color1);rect(15*abstandx,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 44:fill(color1);rect(17*abstandx,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 145:fill(color1);rect(18*abstandx,abstandy+e,grosse,grosse,durchsichtig); taste=0;break;
			case 19:fill(color1);rect(19*abstandx,abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 144: fill(color2);rect(22*abstandx+a,3*abstandy+e,grosse,grosse,durchsichtig); taste=0;break;
			case 111: fill(color2);rect(23*abstandx+a,3*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 106:fill(color2); rect(24*abstandx+a,3*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 109: fill(color2);rect(25*abstandx+a,3*abstandy+e,grosse,grosse,durchsichtig); taste=0;break;
			case 49 :fill(color3);rect(2*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste=0 ;break;
			case 50: fill(color3);rect(3*abstandx,3*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;
			case 51:fill(color3); rect(4*abstandx,3*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;
			case 52:fill(color3); rect(5*abstandx,3*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;
			case 53: fill(color3);rect(6*abstandx,3*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;
			case 54:fill(color3);rect(7*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;
			case 55:fill(color3);rect(8*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;
			case 56:fill(color3);rect(9*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;
			case 57:fill(color3);rect(10*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;
			case 48:fill(color3);rect(11*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;
			case 219:fill(color3);rect(12*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;
			case 221:fill(color3);rect(13*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;
			case 8:fill(color3);rect(14*abstandx,3*abstandy+e,2*grosse,grosse,durchsichtig); taste= 0;break;
			case 45:fill(color1);rect(17*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste=0 ;break;
			case 36: fill(color1);rect(18*abstandx,3*abstandy+e,grosse,grosse,durchsichtig);taste= 0; break;
			case 33:fill(color1);rect(19*abstandx,3*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;	
			case 9:fill(color3);rect(abstandx,4*abstandy+e,grosse+a,grosse,durchsichtig); taste= 0;break;	
			case 81:fill(color3);rect(2*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;	
			case 87:fill(color3);rect(3*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;	
			case 69:fill(color3); rect(4*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;	
			case 82:fill(color3); rect(5*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;	
			case 84:fill(color3);rect(6*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;	
			case 90:fill(color3);rect(7*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;	
			case 85:fill(color3); rect(8*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;	
			case 73: fill(color3);rect(9*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;	
			case 79:fill(color3);rect(10*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig); taste= 0;break;		
			case 80: fill(color3);rect(11*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;	
			case 186:fill(color3); rect(12*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;	
			case 192:fill(color3); rect(13*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste= 0;break;	
			case 13:
				fill(color3);beginShape();
			vertex(14*abstandx+a,4*abstandy+e);
			vertex(14*abstandx+a+90,4*abstandy+e);
			vertex(14*abstandx+a+90,6*abstandy-5+e);
			vertex(14*abstandx+a+20,6*abstandy-5+e);
			vertex(14*abstandx+a+20,5*abstandy+e);
			vertex(14*abstandx+a,5*abstandy+e);							
			endShape();
			 taste= 0;break;
			case 46: fill(color1); rect(17*abstandx,4*abstandy+e,grosse,grosse,durchsichtig);taste=0;;break;	
			case 35: fill(color1); rect(18*abstandx,4*abstandy+e,grosse,grosse,durchsichtig);taste=0;;break;	
			case 34: fill(color1); rect(19*abstandx,4*abstandy+e,grosse,grosse,durchsichtig);taste=0;;break;	
			case 103: fill(color2); rect(22*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste=0;;break;	
			case 104:fill(color2);  rect(23*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste=0;break;	
			case 105: fill(color2); rect(24*abstandx+a,4*abstandy+e,grosse,grosse,durchsichtig);taste=0;break;	
			case 107: fill(color2); rect(25*abstandx+a,4*abstandy+e,grosse,2*grosse,durchsichtig);taste=0;break;	
			case 65:fill(color3); rect(2*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 83:fill(color3); rect(3*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 68:fill(color3); rect(4*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 70:fill(color3); rect(5*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 71: fill(color3);rect(6*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 72: fill(color3);rect(7*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 74: fill(color3);rect(8*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 75: fill(color3);rect(9*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 76: fill(color3);rect(10*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 222: fill(color3);rect(11*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 220: fill(color3);rect(12*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 223: fill(color3);rect(13*abstandx+c,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 100:fill(color2); rect(22*abstandx+a,5*abstandy+e,grosse,grosse,durchsichtig);;taste=0; break;
			case 101:fill(color2); rect(23*abstandx+a,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 102:fill(color2); rect(24*abstandx+a,5*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 160:fill(color3); rect(abstandx,6*abstandy+e,grosse+d,grosse,durchsichtig);taste=0; break;
			case 226:fill(color3); rect(2*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 89:fill(color3); rect(3*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 88:fill(color3); rect(4*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 67:fill(color3); rect(5*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 86:fill(color3); rect(6*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 66:fill(color3); rect(7*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 78:fill(color3); rect(8*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 77: fill(color3);rect(9*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 188:fill(color3); rect(10*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 190:fill(color3); rect(11*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 189:fill(color3); rect(12*abstandx+d,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 161:fill(color3); rect(13*abstandx+d,6*abstandy+e,3*grosse-10,grosse,durchsichtig);taste=0; break;
			case 38: fill(color1);rect(18*abstandx,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 97:fill(color2); rect(22*abstandx+a,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 98: fill(color2);rect(23*abstandx+a,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 99: fill(color2);rect(24*abstandx+a,6*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 162: fill(color3);rect(abstandx,7*abstandy+e,grosse+a,grosse,durchsichtig);taste=0; break;
			case 91:fill(color3); rect(2*abstandx+a,7*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 164: fill(color3);rect(3*abstandx+a,7*abstandy+e,grosse+d,grosse,durchsichtig);taste=0; break;
			case 32: fill(color3);rect(4*abstandx+c,7*abstandy+e,6*grosse+c+7,grosse,durchsichtig);taste=0; break;
			case 165:fill(color3); rect(11*abstandx+d,7*abstandy+e,grosse+d,grosse,durchsichtig);taste=0; break;
			case 93:fill(color3); rect(13*abstandx+a,7*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 163: fill(color3);rect(14*abstandx+a,7*abstandy+e,grosse+a,grosse,durchsichtig);taste=0; break;
			case 37:fill(color1); rect(17*abstandx,7*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 40:fill(color1); rect(18*abstandx,7*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 39:fill(color1); rect(19*abstandx,7*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 96: fill(color2);rect(22*abstandx+a,7*abstandy+e,2*grosse+5,grosse,durchsichtig);taste=0; break;
			case 110:fill(color2); rect(24*abstandx+a,7*abstandy+e,grosse,grosse,durchsichtig);taste=0; break;
			case 20: fill(color3);rect(abstandx,5*abstandy+e,grosse+c,grosse,durchsichtig);taste=0; break;
			
	
			
			 
			
				}
		


		
		if (exit == true) {
			endRecord();
			saveFrame("test " + ft.format(date) + " .tif");
			exit();
		}

	
	}
}
