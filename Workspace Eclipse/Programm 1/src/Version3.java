

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

public class Version3 extends PApplet

{
	public static void main(String[] args) {
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new Version3());

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
			
				// System.out.println(event);
			}

			@Override
			public void mouseWheel(GlobalMouseEvent event) {
			 //System.out.println(event);
				
			
			}
		});

	}

	
	int mode=2;
	int ab=178;
	int ac=16;
	int ad=75;
	int ae=16;
	int af=124;
	int ag=178;
	int ah=129;
	int ai=178;
	int aj=16;
	int ak=ae;
	int al=af;
	int am=ag;

	int color1  = color(ab,ac,ad);
	  int color2  = color(ae,af,ag);
	int color3  = color(ah,ai,aj);
	int colorfinal = color(ak,al,am);


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
	//	frameRate(240);
		
		
        
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
			if (ak<ab&&ak!=ab){
				ak++;}
				else if (ak!=0) {
					ak--;
				}

			if (al<ac&&al!=ac){
				al++;
			}
			else if (al!=0){al--;}
			if (am<ad&&am!=ad){
				am++;
			}
			else if (am!=0){am--;}
			if ((ak==ab||ak == ab+1||ak==ab-1)&&(al==ac||al==ac-1||al==ac+1)&&(am==ad||am==ad+1||am==ad-1))
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
				if ((ak==ae||ak == ae+1||ak==ae-1)&&(al==af||al==af-1||al==af+1)&&(am==ag||am==ag+1||am==ag-1))					{
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
				if ((ak==ah||ak == ah+1||ak==ah-1)&&(al==ai||al==ai-1||al==ai+1)&&(am==aj||am==aj+1||am==aj-1))					{
					mode=1;}
					}
	stroke (ak,al,am);

		a = x; /*always last*/
		b = y; /*always last*/
	

	}}


