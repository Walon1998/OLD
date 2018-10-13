
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
import processing.opengl.*;
import javax.swing.*;
import processing.opengl.*;
import processing.dxf.*;
import java.util.*;

public class Programm3stable extends PApplet

{
	public static void main(String[] args) {
		try {
			Thread.sleep(48000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		String[] a = { "MAIN" };
		PApplet.runSketch(a, new Programm3stable());

		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook();
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {

				switch (event.getVirtualKeyCode()) {

				case 191:
					exit = true;
					break;

				}

				key = true;
			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				// System.out.println(event);
				long endTime = System.currentTimeMillis();

				float estimatedTime = abs(startTime - endTime);
				startTime = System.currentTimeMillis();
				zeit = estimatedTime;
			}
		});

	}

	int mode = 1;
	static long startTime = 0;

	float a = 74;
	float b = 21;
	float c = 175;

	float d = 29;
	float e = 224;
	float f = 213;

	float g = 238;
	float h = 255;
	float i = 13;

	float ae = 100;
	static float zeit;

	static boolean key = false;
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen(P3D);

	}

	public void setup() {

		beginRaw(DXF, "Programm3 Gabriela Spiel  " + ft.format(date) + " .dxf");
		// beginRaw(PDF, "test " + ft.format(date) + " .pdf");

		background(255);
		smooth();

		// strokeWeight(5);
		noStroke();

	}

	public void draw() {

		if (exit == true) {
			endRaw();

			saveFrame("Programm3 Gabriela Spiel " + ft.format(date) + " .tif");
			exit();
		}

		if (key == true) {
			switch (mode) {
			case 1:
				float ab = 0;
				float ac = 0;
				float ad = 0;

				ab = (ab + zeit) / (a / 255);
				ac = (ac + zeit) / (b / 255);
				ad = (ad + zeit) / (c / 255);
				if (ab > a) {
					ab = a;
				}
				if (ac > b) {
					ac = b;
				}
				if (ad > c) {
					ad = c;
				}
				int color1 = color(ab, ac, ad, ae);
				fill(color1);
				mode = 2;
				break;
			case 2:
				ab = 0;
				ac = 0;
				ad = 0;

				ab = (ab + zeit) / (d / 255);
				ac = (ac + zeit) / (e / 255);
				ad = (ad + zeit) / (f / 255);
				if (ab > d) {
					ab = d;
				}
				if (ac > e) {
					ac = e;
				}
				if (ad > f) {
					ad = f;
				}
				int color2 = color(ab, ac, ad, ae);
				fill(color2);
				mode = 3;
				break;
			case 3:
				ab = 0;
				ac = 0;
				ad = 0;

				ab = (ab + zeit) / (g / 255);
				ac = (ac + zeit) / (h / 255);
				ad = (ad + zeit) / (i / 255);
				if (ab > g) {
					ab = g;
				}
				if (ac > h) {
					ac = h;
				}
				if (ad > i) {
					ad = i;
				}
				int color3 = color(ab, ac, ad, ae);
				fill(color3);
				mode = 1;
				break;
			}

			if (zeit == 0) {
				switch (mode) {
				case 1:
					fill(a, b, c, ae);
					break;
				case 2:
					fill(d, e, f, ae);
					break;
				case 3:
					fill(g, h, i, ae);
					break;
				}

			}
			translate(random(-50, 1919 + 50), random(-50, 1079 + 50), random(-1000, 500));
			box(100);

			key = false;
		}

	}

}
//