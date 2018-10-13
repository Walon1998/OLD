

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
					button = 1;

					i++;
					k = 0;
					float x = MouseInfo.getPointerInfo()
							.getLocation().x; /* always 1 */
					float y = MouseInfo.getPointerInfo()
							.getLocation().y; /* always 1 */

					e = x;
					d = y;

				}

				if ((event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
					button = 2;

					i++;
					k = 0;
					float x = MouseInfo.getPointerInfo()
							.getLocation().x; /* always 1 */
					float y = MouseInfo.getPointerInfo()
							.getLocation().y; /* always 1 */

					e = x;
					d = y;
					// println("rechts");
				}

				if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
					button = 3;

					i++;
					k = 0;
					float x = MouseInfo.getPointerInfo()
							.getLocation().x; /* always 1 */
					float y = MouseInfo.getPointerInfo()
							.getLocation().y; /* always 1 */

					e = x;
					d = y;
					// println("middle");
				}

			}

			@Override
			public void mouseReleased(GlobalMouseEvent event) {

			//	 System.out.println(event);

				j++;
				b = MouseInfo.getPointerInfo()
						.getLocation().x; /* always last */
				c = MouseInfo.getPointerInfo()
						.getLocation().y; /* always last */

			}

		});

	}

	static int button;
	static boolean makeline = false;
	static float e, d,q,w,r,t,z;
	static boolean mousemove = false;
	static int mouseclick = 0;
	static boolean mouserelease = false;
	static int i, j, k;
	static int x, y;
	static int b, c;
	static int ab = 255;
	static int ac = 0;
	static int ad = 0;
	static int ae = 0;
	static int af = 255;
	static int ag = 0;
	static int ah = 0;
	static int ai = 0;
	static int aj = 255;
	int color1 = color(ab, ac, ad, 100);
	int color2 = color(ae, af, ag, 100);
	int color3 = color(ah, ai, aj, 100);

	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "test " + ft.format(date) + " .pdf");
		background(255);
		smooth();
		stroke(0, 100);
		strokeWeight(30);

		strokeCap(SQUARE);
	}

	public void draw() {
		switch (button) {
		case 1:
			stroke(color1);
			float ff = dist(e, d, b, c);
			if (ff > 0 && i == j && k == 0) {

				line(e, d, b, c);
				k = 1;
			}
			break;
		case 2:
			stroke(color2);
			 ff = dist(e, d, b, c);
			if (ff > 0 && i == j && k == 0) {

				line(e, d, b, c);
				k = 1;
			}
			break;
		case 3:
			stroke(color3);
		 ff = dist(e, d, b, c);
			if (ff > 0 && i == j && k == 0) {

				line(e, d, b, c);
				k = 1;
			}
			break;
		}
		
		if (exit == true) {
			endRecord();
			saveFrame("test " + ft.format(date) + " .tif");
			exit();
		}

	}

}

