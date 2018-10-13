

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

public class mousecompilation extends PApplet

{
	public static void main(String[] args) {
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new mousecompilation());
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
					click2 = 1;
					button = 1;

					i8++;
					k8 = 0;
					float x = MouseInfo.getPointerInfo()
							.getLocation().x; /* always 1 */
					float y = MouseInfo.getPointerInfo()
							.getLocation().y; /* always 1 */

					e8 = x;
					d8 = y;
					mode11 = 1;
					f11++;
					mouse12 = true;
					// println("links");

				}

				if ((event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {
					click2 = 2;
					button = 2;

					i8++;
					k8 = 0;
					float x = MouseInfo.getPointerInfo()
							.getLocation().x; /* always 1 */
					float y = MouseInfo.getPointerInfo()
							.getLocation().y; /* always 1 */

					e8 = x;
					d8 = y;
					mode11 = 2;
					f11++;
					mouse12 = true;
					// println("rechts");
				}

				if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {
					click2 = 3;
					button = 3;

					i8++;
					k8 = 0;
					float x = MouseInfo.getPointerInfo()
							.getLocation().x; /* always 1 */
					float y = MouseInfo.getPointerInfo()
							.getLocation().y; /* always 1 */

					e8 = x;
					d8 = y;
					mode11 = 3;
					f11++;
					mouse12 = true;
					// println("middle");
				}

			}

			@Override
			public void mouseReleased(GlobalMouseEvent event) {
				// System.out.println(event);
				j8++;
				b8 = MouseInfo.getPointerInfo()
						.getLocation().x; /* always last */
				c8 = MouseInfo.getPointerInfo()
						.getLocation().y; /* always last */
				g11++;
			}

			@Override
			public void mouseMoved(GlobalMouseEvent event) {
				if (mousemove < 0) {
					circle = true;

				}
				mousemove = 20;
				// System.out.println(event);
			}

			@Override
			public void mouseWheel(GlobalMouseEvent event) {
				// System.out.println(event);

			}
		});

	}

	int mode1 = 2;
	int i2;
	int ab = (int) random(0, 255);
	int ac = (int) random(0, 255);
	int ad = (int) random(0, 255);

	int ae = (int) random(0, 255);
	int af = (int) random(0, 255);
	int ag = (int) random(0, 255);

	int ah = (int) random(0, 255);
	int ai = (int) random(0, 255);
	int aj = (int) random(0, 255);

	int ak = ae;
	int al = af;
	int am = ag;
	int color1 = color(ab, ac, ad, 1);
	int color11 = color(ab, ac, ad, 2);
	int color111 = color(ab, ac, ad);

	int color2 = color(ae, af, ag, 1);
	int color22 = color(ae, af, ag, 2);
	int color222 = color(ae, af, ag);

	int color3 = color(ah, ai, aj, 1);
	int color33 = color(ah, ai, aj, 2);
	int color333 = color(ah, ai, aj);
	static int click2 = 0;
	static int x, y;
	static float a, b;
	int color14 = color(0, 0, 0, 1);
	int color114 = color(0, 0, 0, 2);
	int color1114 = color(0, 0, 0);
	double c;
	static float d = 0;
	static int mousemove = 50;
	static boolean circle = false;
	int i6;
	int j6 = 100;
	int color16 = color(ab, ac, ad, j6);
	int color26 = color(ae, af, ag, j6);
	int color36 = color(ah, ai, aj, j6);
	static int button;
	static boolean makeline8 = false;
	static float e8, d8, q8, w8, r8, t8, z8;
	static boolean mousemove8 = false;
	static int mouseclick8 = 0;
	static boolean mouserelease8 = false;
	static int i8, j8, k8;

	static int b8, c8;
	int color18 = color(ab, ac, ad, 150);
	int color28 = color(ae, af, ag, 150);
	int color38 = color(ah, ai, aj, 150);

	int color1111 = color(ab, ac, ad, 10);
	int color211 = color(ae, af, ag, 10);
	int color311 = color(ah, ai, aj, 10);

	int[] q11 = new int[1000000];
	int[] w11 = new int[1000000];
	int[] e11 = new int[1000000];
	int[] r11 = new int[1000000];
	int i11 = 0;
	int a11, b11;
	static int f11, g11;
	static int mode11;
	
	int mode12 =0;
	float q12 = 0;
	float rad12 = 75;
	
	static float b12,c12,d12,e12,k12;
	static boolean mouse12 = false;

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
		stroke(255);
		strokeWeight(10);

	}

	public void draw() {

		float x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		float y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */
		if (x == 1919 || x == 0 || y == 0 || y == 1079) { /* Ränder */

		}
		float speed = abs(x - a) + abs(y - b);
		float strokeweight = 10 - (speed / 10);/* dist(x,y,a,b) */
		if (strokeweight < 1) {
			strokeWeight(1);
		} else {
			strokeWeight((strokeweight));
		}

		if (exit == true) {
			endRecord();
			saveFrame("test " + ft.format(date) + " .tif");
			exit();
		}
		strokeCap(ROUND);
		line(x, y, a, b);

		if (mode1 == 1) {
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
				mode1 = 2;
			}
		}
		if (mode1 == 2) {
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
				mode1 = 3;
			}

		}
		if (mode1 == 3) {
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
				mode1 = 1;
			}
		}

		noStroke();
		switch (click2) {
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
			click2 = 0;
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
			click2 = 0;
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
			click2 = 0;
			break;
		}
		noStroke();

		if (mousemove < 0) {

			d += 0.1;

		}
		if (circle == true) {

			c = (30 * -Math.exp(-0.1 * d) + 30) * Math.pow(d, 0.333);

			float g = (float) c;
			fill(color14);
			for (int i = 0; i < g; i++) {

				ellipse(x, y, i, i);
				if (i > 10 && i < 50) {
					fill(color114);
					ellipse(x, y, i, i);
				}
			}
			if (g > 50) {
				fill(color1114);
				ellipse(x, y, g / 25, g / 25);
			}

			// ellipse(x, y, g, g);

			d = 0;
			circle = false;
		}
		mousemove--;

		if (x == 1919 || x == 0) {/* Ränder */
			strokeCap(PROJECT);
			strokeWeight(3);
			if (i6 > 0) {
				noStroke();
				fill(color16);
				ellipse(x, y, 100, 100);

				stroke(color16);

				line(x, y, 1919 / 2, 1079 / 2);

				i6 = -10;
			}
			strokeCap(ROUND);
		}
		if (y == 1079) {
			strokeCap(PROJECT);
			strokeWeight(3);
			if (i6 > 0) {
				noStroke();
				fill(color26);
				ellipse(x, y, 100, 100);

				stroke(color26);

				line(x, y, 1919 / 2, 1079 / 2);

				i6 = -10;
			}
			strokeCap(ROUND);
		}
		if (y == 0) {
			strokeCap(PROJECT);
			strokeWeight(3);
			if (i6 > 0) {
				noStroke();
				fill(color36);
				ellipse(x, y, 100, 100);

				stroke(color36);

				line(x, y, 1919 / 2, 1079 / 2);

				i6 = -10;
			}
			strokeCap(ROUND);
		}
		i6++;

		switch (button) {
		case 1:
			strokeWeight(30);
			strokeCap(SQUARE);
			stroke(color18);
			float ff = dist(e8, d8, b8, c8);
			if (ff > 5 && i8 == j8 && k8 == 0) {

				line(e8, d8, b8, c8);
				k8 = 1;
				strokeCap(ROUND);
			}
			break;
		case 2:
			strokeWeight(30);
			strokeCap(SQUARE);
			stroke(color28);
			ff = dist(e8, d8, b8, c8);
			if (ff > 5 && i8 == j8 && k8 == 0) {

				line(e8, d8, b8, c8);
				k8 = 1;
				strokeCap(ROUND);
			}
			break;
		case 3:
			strokeWeight(30);
			strokeCap(SQUARE);
			stroke(color38);
			ff = dist(e8, d8, b8, c8);
			if (ff > 5 && i8 == j8 && k8 == 0) {

				line(e8, d8, b8, c8);
				k8 = 1;
				strokeCap(ROUND);
			}
			break;
		}
		strokeCap(ROUND);
		switch (mode11) {
		case 1:
			stroke(color1111);
			break;

		case 2:
			stroke(color211);
			break;
		case 3:
			stroke(color311);
			break;
		}
		if (f11 > g11) {

			int x11 = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
			int y11 = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */
			if (a11 != x || b11 != y) {
				for (int g11 = 0; g11 < i11; g11++) {
					if (dist(x, y, e11[g11], r11[g11]) < 100) {
strokeWeight(1);
						line(x, y, e11[g11], r11[g11]);
					}
				}
			}

			e11[i11] = x11;
			r11[i11] = y11;
			i11++;
			a11 = x11;
			b11 = y11;

		}
		
		 
		float xcenter = x;
		float ycenter = y;
	
		if (mouse12 == true) {
			if (x==b12&&y==c12){
			for (float i12 = 0; i12 < 360; i12 += 1) {
				 stroke(0,200);
					strokeWeight(1);
				rad12 = random (0,100);
				float q12 = xcenter + cos(i12) * rad12;
				float w12 = ycenter + sin(i12) * rad12;
				rad12 = random (5,50);
				x = xcenter + cos(i12) *rad12 ;
				 y = ycenter + sin(i12) * rad12;
			
				line(x, y, q12, w12);
			}}
			mouse12 = false;
		b12=x;
		c12=y;
		}
		
		stroke(ak, al, am);
		a = x; /* always last */
		b = y; /* always last */
	}
}
