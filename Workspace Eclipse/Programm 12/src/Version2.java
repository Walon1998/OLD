



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
					exit = true;
					break;
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
					mouse = true;
					
					// println("links");

				}

				if ((event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
					mouse = true;
					
					// println("rechts");
				}

				if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
					mouse = true;
					
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
				// System.out.println(event);

			}
		});

	}
int mode =0;
	float q = 0;
	float rad = 75;
	static int x, y;
	static float b,c,d,e,k;
	static boolean mouse = false;
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "Programm 12 " + ft.format(date) + " .pdf");
		background(255);
		smooth();
		stroke(0,200);
	}

	public void draw() {
		

		float x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		float y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */
		float xcenter = x;
		float ycenter = y;
		float angle;
		
		if (mouse == true) {
			if (x==b&&y==c){
			for (float i = 0; i < 360; i += 1) {
				rad = random (0,100);
				float q = xcenter + cos(i) * rad;
				float w = ycenter + sin(i) * rad;
				rad = random (5,50);
				x = xcenter + cos(i) *rad ;
				 y = ycenter + sin(i) * rad;

				line(x, y, q, w);
			}}
			mouse = false;
		b=x;
		c=y;
		}
	
		

		if (exit == true) {
			endRecord();
			saveFrame("Programm 12 " + ft.format(date) + " .tif");
			exit();
		}
		
	}
}
