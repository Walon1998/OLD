

import processing.core.PApplet;
//import processing.event.KeyEvent;
//import processing.event.MouseEvent;
import java.awt.Frame;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;
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

public class Stable extends PApplet

{

	public static void main(String[] args) {
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new Stable());
		
		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook();
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {
				//System.out.println(event);
				
			}
			@Override
			public void keyReleased(GlobalKeyEvent event) {
				//System.out.println(event);
				
			}
		});

		try {
			while (run)
				Thread.sleep(128);
		} catch (InterruptedException e) {
		} finally {
			keyboardHook.shutdownHook();
		}
	}

	private static boolean run = true;
	int x, y;
	float a, b, i;
	
	

	public void settings() {
		// size(500,500);
		// size(displayWidth,displayHeight);
		fullScreen();

	}

	public void setup() {
		beginRecord(PDF, "Rects.pdf");
		background(0);
		smooth();
		stroke(0);
		strokeWeight(1);

	}

	public void draw() {
		
			
		
		strokeWeight(1);
		float x = MouseInfo.getPointerInfo().getLocation().x;
		float y = MouseInfo.getPointerInfo().getLocation().y;
		line(x, y, a, b);
		noFill();
		// frameRate(1);
		// ellipse(x, y, random(-2000, 2000), random(-2000, 2000));
		//rect(displayWidth/2,displayHeight/2,random(-1000,1000),random(-1000,1000));
		if (i > 0) {
			stroke(255);
		}
		i++;
		a = x;
		b = y;
	}

	public void keyPressed() {
		if (key == 'q') {
			endRecord();
			exit();
		}

	}

}
