
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

public class Programm2stable extends PApplet

{
	public static void main(String[] args) {
		try {
			Thread.sleep(50000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new Programm2stable());

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

	int color1 = color(74,21,175, 1);
	int color11 = color(74,21,175, 2);
	int color111 = color(74,21,175);

	int color2 = color(29,224,213, 1);
	int color22 = color(29,224,213, 2);
	int color222 = color(29,224,213);

	int color3 = color(238,255,13, 1);
	int color33 = color(238,255,13, 2);
	int color333 = color(238,255,13);

	static int click = 0;
	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "Programm2 Gabriela Spiel  " + ft.format(date) + " .pdf");
		background(255);
		smooth();
		noStroke();
	}

	public void draw() {

		float x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		float y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */

		if (exit == true) {
			endRecord();
			saveFrame("Programm2 Gabriela Spiel  " + ft.format(date) + " .tif");
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
