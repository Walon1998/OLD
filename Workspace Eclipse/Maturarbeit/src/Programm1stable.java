
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

public class Programm1stable extends PApplet

{
	public static void main(String[] args) {
		try {
			Thread.sleep(52000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new Programm1stable());

		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook();
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {

				switch (event.getVirtualKeyCode()) {

				case 191:
					exit = true;

				}

			}

		});

	}

	int mode = 2;

	int ab = 74;
	int ac = 21;
	int ad = 175;

	int ae = 29;
	int af = 224;
	int ag = 213;

	int ah = 238;
	int ai = 255;
	int aj = 13;

	int ak = ae;
	int al = af;
	int am = ag;

	/*
	 * int color1 = color(ab,ac,ad); int color2 = color(ae,af,ag); int color3 =
	 * color(ah,ai,aj); int colorfinal = color(ak,al,am);
	 */

	static int x, y;
	static float a, b;
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");
	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {
		beginRecord(PDF, "Programm1 Gabriela Spiel  " + ft.format(date) + " .pdf");
		background(255);
		smooth();
		stroke(255);
		strokeWeight(10);

	}

	public void draw() {
		float x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		float y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */
		float speed = abs(x - a) + abs(y - b);
		float strokeweight = 10 - (speed / 10);/* dist(x,y,a,b) */
		if (strokeweight < 1) {
			strokeWeight(1);
		} else {
			strokeWeight((strokeweight));
		}

		if (exit == true) {
			endRecord();
			saveFrame("Programm1 Gabriela Spiel " + ft.format(date) + " .tif");
			exit();
		}

		line(x, y, a, b);

		if (mode == 1) {
			if (ak < ab && ak != ab) {
				ak++;
			} else if (ak != 0) {
				ak--;
			}

			if (al < ac && al != ac) {
				al++;
			} else if (al != 0) {
				al--;
			}
			if (am < ad && am != ad) {
				am++;
			} else if (am != 0) {
				am--;
			}
			if ((ak == ab || ak == ab + 1 || ak == ab - 1) && (al == ac || al == ac - 1 || al == ac + 1)
					&& (am == ad || am == ad + 1 || am == ad - 1)) {
				mode = 2;
			}
		}
		if (mode == 2) {
			if (ak < ae) {
				ak++;
			} else if (ak != 0) {
				ak--;
			}

			if (al < af) {
				al++;
			} else if (al != 0) {
				al--;
			}
			if (am < ag) {
				am++;
			} else if (am != 0) {
				am--;
			}
			if ((ak == ae || ak == ae + 1 || ak == ae - 1) && (al == af || al == af - 1 || al == af + 1)
					&& (am == ag || am == ag + 1 || am == ag - 1)) {
				mode = 3;
			}

		}
		if (mode == 3) {
			if (ak < ah) {
				ak++;
			} else if (ak != 0) {
				ak--;
			}

			if (al < ai) {
				al++;
			} else if (al != 0) {
				al--;
			}
			if (am < aj) {
				am++;
			} else if (am != 0) {
				am--;
			}
			if ((ak == ah || ak == ah + 1 || ak == ah - 1) && (al == ai || al == ai - 1 || al == ai + 1)
					&& (am == aj || am == aj + 1 || am == aj - 1)) {
				mode = 1;
			}
		}
		stroke(ak, al, am);

		a = x; /* always last */
		b = y; /* always last */

	}
}
