

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

				i++;
				switch (event.getVirtualKeyCode()) {

				case 191:
					exit = true;
					break;
				}

				// System.out.println(event);

			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {

				k++;
				// System.out.println(event);

			}
		});

		GlobalMouseHook mouseHook = new GlobalMouseHook();
		mouseHook.addMouseListener(new GlobalMouseAdapter() {
			@Override
			public void mousePressed(GlobalMouseEvent event) {
				// System.out.println(event);
				if ((event.getButtons() & GlobalMouseEvent.BUTTON_LEFT) != GlobalMouseEvent.BUTTON_NO) {
					o++;
					// println("links");

				}

				if ((event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
					m++;
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
	int color1 = color(ab, ac, ad, 122);
	int color2 = color(ae, af, ag, 122);
	int color3 = color(ah, ai, aj, 122);
	int mode = 1;
	static int y = 15;
	static int x = 15;
	static int abstand=5;
	static int i = -1;
	static int j = 0;
	static int k = -1;
	static int m = -1;
	static int n = 0;
	static int o = -1;
	static int l = 1080 / (y + abstand) - 1;
	int p = 1920 / (x + abstand) - 1;
	// int p = 319;

	static boolean press = false;
	static boolean release = false;

	static float a, b;

	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "Programm 9 " + ft.format(date) + " .pdf");
		background(255);
		smooth();
		
		noStroke();
	}

	public void draw() {

		if (exit == true) {
			for (a = 0; a < i; a++) {//i
				fill(color1);
			
				rect((x + abstand) * b, (y + abstand) * j, x, y);
				if ((x + abstand) * b > 1919) {
					b = -1;
					j++;
				}
				b++;

			}
			b = 0;
			for (a = 0; a < k; a++) {//k
				fill(color2);
	
				rect((x + abstand) * b, (y + abstand) * l, x, y);
				if ((x + abstand) * b > 1919) {
					b = -1;
					l--;
				}
				b++;

			}
			b = 0;
			j = 0;
			for (a = 0; a < o; a++) {//o
				fill(color3);
			
				rect((x + abstand) * j, (y + abstand) * b, x, y);
				if ((y + abstand) * b > 1079) {
					j++;
					b = -1;
				}
				b++;
			}
			b = 0;
			j = 0;

			for (a = 0; a < m; a++) {//m
				fill(color3);
	
				rect((x + abstand) * p, (y + abstand) * j, x, y);
				if ((y + abstand) * j > 1079) {
					j = -1;
					p--;
				}
				j++;

			}
			
			fill(255, 100);
			ellipse(width / 2, height / 2, 50 * n, 50 * n);
			ellipse(width / 10, height / 10*9, 6 * n, 6 * n);
			ellipse(width / 10*9, height / 10*9, 6 * n, 6 * n);
			ellipse(width / 10, height / 10, 6 * n, 6* n);
			ellipse(width / 10*9, height / 10, 6 * n, 6 * n);

			endRecord();
			saveFrame("Programm 9 " + ft.format(date) + " .tif");
			exit();
		}

	}
}
