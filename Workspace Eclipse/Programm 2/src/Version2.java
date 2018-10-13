
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

				}

				// System.out.println(event);

			}

		});

		GlobalMouseHook mouseHook = new GlobalMouseHook();
		mouseHook.addMouseListener(new GlobalMouseAdapter() {
			@Override
			public void mousePressed(GlobalMouseEvent event) {
				// System.out.println(event);
				if ((event.getButtons() & GlobalMouseEvent.BUTTON_LEFT) != GlobalMouseEvent.BUTTON_NO) {
					click = 1;
					// println("links");

				}

				if ((event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
					click = 2;
					// println("rechts");
				}

				if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
					click = 3;
					// println("middle");
				}

			}

		});

	}

	static int x, y;
	static float a, b;
	int i;
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");
/*	int ab = (int) random(0,255);
	int ac = (int) random(0,255);
	int ad = (int) random(0,255);

	int ae = (int) random(0,255);
	int af = (int) random(0,255);
	int ag = (int) random(0,255);

	int ah = (int) random(0,255);
	int ai = (int) random(0,255);
	int aj = (int) random(0,255);*/
	int ab = 255;
	int ac = 0;
	int ad = 0;

	int ae = 0;
	int af = 255;
	int ag = 0;

	int ah = 0;
	int ai = 0;
	int aj = 255;
	
	int color1 = color(ab,ac,ad, 1);
	int color11 = color(ab,ac,ad, 2);
	int color111 = color(ab,ac,ad);
	
	int color2 = color(ae,af,ag, 1);
	int color22 = color(ae,af,ag, 2);
	int color222 = color(ae,af,ag);
	
	int color3 = color(ah,ai,aj, 1);
	int color33 = color(ah,ai,aj, 2);
	int color333 = color(ah,ai,aj);
	static int click = 0;
	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "Programm 2" + ft.format(date) + " .pdf");
		background(255);
		smooth();
		noStroke();
	}

	public void draw() {

		float x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		float y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */

		if (exit == true) {
			endRecord();
			saveFrame("Programm 2 " + ft.format(date) + " .tif");
			exit();
		}
		switch (click) {
		case 1:
			fill(color1);
			for (int i = 0; i < 150; i++) {

				ellipse(x, y, i, i);
				if (i > 10 && i < 50) {
					fill(color11);
					ellipse(x, y, i, i);
				}
			}
			fill(color111);
			ellipse(x, y, 10, 10);
			click = 0;
			break;
		case 2:
			fill(color2);
			for (int i = 0; i < 150; i++) {

				ellipse(x, y, i, i);
				if (i > 10 && i < 50) {
					fill(color22);
					ellipse(x, y, i, i);
				}
			}
			fill(color222);
			ellipse(x, y, 10, 10);
			click = 0;
			break;
		case 3:
			fill(color3);
			for (int i = 0; i < 150; i++) {

				ellipse(x, y, i, i);
				if (i > 10 && i < 50) {
					fill(color33);
					ellipse(x, y, i, i);
				}
			}
			fill(color333);
			ellipse(x, y, 10, 10);
			click = 0;
			break;
		}

	}
}
