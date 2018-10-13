
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

import com.jogamp.common.util.InterruptSource.Thread;

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
//	try {
//		Thread.sleep(60000);
//	} catch (InterruptedException e) {
//		
//		e.printStackTrace();
//	}
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
					mode = 1;
					f++;
					// println("links");

				}

				if ((event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
					mode = 2;
					f++;
					// println("rechts");
				}

				if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
					mode=3;
					f++;
					// println("middle");
				}

			}

			@Override
			public void mouseReleased(GlobalMouseEvent event) {
				g++;
				// System.out.println(event);
			
			}

		});

	}

	static int mode;
	
	int ab =  (int) random(0,255);
	int ac = (int) random(0,255);
	int ad = (int) random(0,255);

	int ae = (int) random(0,255);
	int af = (int) random(0,255);
	int ag = (int) random(0,255);

	int ah =(int) random(0,255) ;
	int ai = (int) random(0,255);
	int aj = (int) random(0,255);
/*	int ab = 121;
	int ac = 6;
	int ad = 35;

	int ae = 33;
	int af = 112;
	int ag = 142;

	int ah = 234;
	int ai = 229;
	int aj = 206;*/
	int color1 = color(ab, ac, ad,10);
	int color2 = color(ae, af, ag,10);
	int color3 = color(ah, ai, aj,10);

	int[] q = new int[1000000];
	int[] w = new int[1000000];
	int[] e = new int[1000000];
	int[] r = new int[1000000];
	int i = 0;
	int a, b;
	static int f, g;
	
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "Programm 11 " + ft.format(date) + " .pdf");
		background(255);
		smooth();
//		stroke(0, 10);
		// frameRate(240);
	}

	public void draw() {
		switch (mode) {
		case 1:
			stroke(color1);break;
			
		case 2:
			stroke(color2);break;
		case 3:
			stroke(color3);break;
		}
		if (f > g) {

			int x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
			int y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */
			if (a != x || b != y) {
				for (int g = 0; g < i; g++) {
					if (dist(x, y, e[g], r[g]) < 100) {

						line(x, y, e[g], r[g]);
					}
				}
			}

			e[i] = x;
			r[i] = y;
			i++;
			a = x;
			b = y;

		}
		if (exit == true) {
			endRecord();
			saveFrame("Programm 11 " + ft.format(date) + " .tif");
			exit();
		}
	}
}
