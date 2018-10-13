
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
				// System.out.println(event);

			}
		});

	}

	static int x, y;

	int i;
	int a = (int) random(0,255);
	int b = (int) random(0,255);
	int c = (int) random(0,255);

	int f = (int) random(0,255);
	int g = (int) random(0,255);
	int h = (int) random(0,255);

	int l = (int) random(0,255);
	int m = (int) random(0,255);
	int o = (int) random(0,255);

	int j = 100;
	int color1 = color(f, g, h, j);
	int color2 = color(a, b, c, j);
	int color3 = color(l, m, o, j);
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "Programm 6 " + ft.format(date) + " .pdf");
		background(255);
		smooth();
		strokeCap(PROJECT);
		strokeWeight(3);
	}

	public void draw() {
		float x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		float y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */

		if (x == 1919 || x == 0) {/* Ränder */
			if (i > 0) {
				noStroke();
				fill(color1);
				ellipse(x, y, 100, 100);
			
				stroke(color1);

				line(x, y, 1919 / 2, 1079 / 2);

				i = -10;
			}
		}
		if (y == 1079) {
			if (i > 0) {
				noStroke();
				fill(color2);
				ellipse(x, y, 100, 100);
				
				stroke(color2);

				line(x, y, 1919 / 2, 1079 / 2);

				i = -10;
			}
		}
		if (y == 0) {
			if (i > 0) {
				noStroke();
				fill(color3);
				ellipse(x, y, 100, 100);
			
				stroke(color3);

				line(x, y, 1919 / 2, 1079 / 2);

				i = -10;
			}
		}

		if (exit == true) {
			endRecord();
			saveFrame("Programm 6 " + ft.format(date) + " .tif");
			exit();
		}

		i++;
	}
}
