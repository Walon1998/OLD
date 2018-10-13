

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
			public void mouseMoved(GlobalMouseEvent event) {

				if (mousemove < 0) {
					circle = true;

				}
				mousemove = 20;

				// System.out.println(event);
			}

		});

	}

	
	
	double c;
	static float d = 0;
	static int mousemove = 50;
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;
	static boolean circle = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "test " + ft.format(date) + " .pdf");
		background(255);
		smooth();
		noStroke();
		fill(0, 0, 0, 100);

	}

	public void draw() {

		float x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		float y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */
		if (mousemove < 0) {

			d += 0.1;

		}
		if (circle == true) {

			c = (30 * -Math.exp(-0.1 * d) + 30) * Math.pow(d, 0.333);

			float g = (float) c;
			ellipse(x, y, g, g);

			d = 0;
			circle = false;
		}
		mousemove--;

		if (exit == true) {
			saveFrame("test " + ft.format(date) + " .tif");
			endRecord();
			exit();
		}

	}
}
