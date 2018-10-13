

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

public class Version1 extends PApplet

{
	public static void main(String[] args) {
	
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new Version1());
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook();
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {
				
				switch (event.getVirtualKeyCode()) {

				case 191:
					exit = true;
					break;
				}

				// System.out.println(event);

			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				mode = 1;
				
				ar=true;
				i++;
				// System.out.println(event);

			}
		});

		GlobalMouseHook mouseHook = new GlobalMouseHook();
		mouseHook.addMouseListener(new GlobalMouseAdapter() {
			@Override
			public void mousePressed(GlobalMouseEvent event) {
				// System.out.println(event);
				if ((event.getButtons() & GlobalMouseEvent.BUTTON_LEFT) != GlobalMouseEvent.BUTTON_NO) {
					mode = 2;
					
					ar=true;
					i++;
					// println("links");

				}

				if ((event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
					mode = 3;
				
					ar=true;
					i++;
					// println("rechts");
				}

				if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
					n++;
					// println("middle");
				}

			}

		});

	}

	int ab = (int) random(0,255);
	int ac = (int) random(0,255);
	int ad = (int) random(0,255);

	int ae = (int) random(0,255);
	int af = (int) random(0,255);
	int ag = (int) random(0,255);

	int ah = (int) random(0,255);
	int ai = (int) random(0,255);
	int aj = (int) random(0,255);
	
	int color1 = color(ab, ac, ad);
	int color2 = color(ae, af, ag);
	int color3 = color(ah, ai, aj);
	
	static boolean ar=false;
	static int mode = 1;
	
static int i=0;
int j=1;
	static int n=0;
	

	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "Programm 10 " + ft.format(date) + " .pdf");
		background(255);
		smooth();
		rectMode(CENTER);
		noStroke();
		
		
	
	
	}

	public void draw() {	
		switch (mode){
		case 1 : fill(color1);break;
		case 2 : fill(color2);break;
		case 3 : fill(color3);break;
		}
		translate(width/2,height/2);
		
	
		if (ar==true&&j==i) {
			  rotate((float)(0.1)*i);
			  ellipse(i,0,10,10);
			  ar=false;
			  j++;
		}
		if (i>j){
			i=j;

		}
		
	
		
	
		if (exit == true) {
			fill(0, 30);
			for(int k=0;k<10*n;k++){
				rotate((float)-0.1);
				ellipse(k,0,10,10);
			}
			
		//	ellipse(0, 0, 50 * n, 50 * n);

			

			endRecord();
			saveFrame("Programm 10 " + ft.format(date) + " .tif");
			exit();
		}

	}
}

