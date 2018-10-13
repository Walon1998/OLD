

import processing.core.PApplet;
//import processing.event.KeyEvent;
//import processing.event.MouseEvent;
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
				
				switch (event.getVirtualKeyCode()){
			
				case 81: exit = true;
				
				
					
				}
				
				// System.out.println(event);
				

			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				// System.out.println(event);
				

			}
		});

		GlobalMouseHook mouseHook = new GlobalMouseHook();
		mouseHook.addMouseListener(new GlobalMouseAdapter() {
			@Override
			public void mousePressed(GlobalMouseEvent event) {
				// System.out.println(event);
				if ((event.getButtons() & GlobalMouseEvent.BUTTON_LEFT) != GlobalMouseEvent.BUTTON_NO) {
					
					// println("links");
					
				}

				if ((event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
				
					// println("rechts");
				}

				if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
				
					// println("middle");
				}

			}

			@Override
			public void mouseReleased(GlobalMouseEvent event) {
				// System.out.println(event);
			}

			@Override
			public void mouseMoved(GlobalMouseEvent event) {
				line = true;
				// circle = false;
				// System.out.println(event);
			}

			@Override
			public void mouseWheel(GlobalMouseEvent event) {
			 //System.out.println(event);
				
			
			}
		});

	}

	static boolean line = false;
	int mode=2;
	int ab=255;
	int ac=0;
	int ad=0;
	int ae=0;
	int af=255;
	int ag=0;
	int ah=0;
	int ai=0;
	int aj=255;
	int ak=ae;
	int al=af;
	int am=ag;

	int color1  = color(ab,ac,ad);
	  int color2  = color(ae,af,ag);
	int color3  = color(ah,ai,aj);


	static int x, y;
	static float a, b;


	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {
		beginRecord(PDF, "test.pdf");
		background(255);
		smooth();
		stroke(255);
		strokeWeight(15);
		
		
		
        
	}

	public void draw() {
		
		float x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		float y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */
		float speed = abs(x-a) + abs(y-b);
		
		float strokeweight=15-(speed/10);
		//println(""+strokeweight+"");
		if (strokeweight<1){
		strokeWeight(1);
		}
		else {
		strokeWeight((strokeweight));
		}
		
		if (x == 1919 || x == 0 || y == 0 || y == 1079) { /* Ränder */

		}
		
		if (exit == true) {
			endRecord();
			exit();
		}
		
			line(x, y, a, b);
			
			if (keyPressed) {
			    if (key == 'q' || key == 'Q') {
			    	exit = true;
			    }}
			if(mode==1){
			if (ak<ab){
				ak++;}
				else if (ak!=0) {
					ak--;
				}

			if (al<ac){
				al++;
			}
			else if (al!=0){al--;}
			if (am<ad){
				am++;
			}
			else if (am!=0){am--;}
			if (ak==ab&&al==ac&&am==ad)
				{
				mode=2;}
				}
			if(mode==2){
				if (ak<ae){
					ak++;}
					else if (ak!=0){
						ak--;
					}

				if (al<af){
					al++;
				}
				else if (al!=0){al--;}
				if (am<ag){
					am++;
				}
				else if (am!=0){am--;}
				if (ak==ae&&al==af&&am==ag)
					{
					mode=3;}
				
					}
			if(mode==3){
				if (ak<ah){
					ak++;}
					else if (ak!=0){
						ak--;
					}

				if (al<ai){
					al++;
				}
				else if (al!=0){al--;}
				if (am<aj){
					am++;
				}
				else if (am!=0){am--;}
				if (ak==ah&&al==ai&&am==aj)
					{
					mode=1;}
					}
	stroke (ak,am,al);
println(mode);
		a = x; /*always last*/
		b = y; /*always last*/
	

	}}


