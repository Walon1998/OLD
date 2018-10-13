
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

		});
		GlobalMouseHook mouseHook = new GlobalMouseHook();
		mouseHook.addMouseListener(new GlobalMouseAdapter() {

			@Override
			public void mouseWheel(GlobalMouseEvent event) {
				// System.out.println(event);
				// size=size+1;
				wheel=true;
				
			}
		});

	}

	static double size = 2;
	int zahler;
	static boolean wheel = false;
	int mode = 2;
	int ab = (int) random(0,255);
	int ac = (int) random(0,255);
	int ad = (int) random(0,255);

	int ae = (int) random(0,255);
	int af = (int) random(0,255);
	int ag = (int) random(0,255);

	int ah = (int) random(0,255);
	int ai = (int) random(0,255);
	int aj = (int) random(0,255);

	
	int ak = ae;
	int al = af;
	int am = ag;
	float start1 = 1;
	float start2;
	float xPos;
	float yPos = height / 2;
	double u = -0.001;
	
	float rad = 75;
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "Programm 7 " + ft.format(date) + " .pdf");
		background(255);
		smooth();

fill(0);
//		noFill();
//strokeWeight(100);
	}

	public void draw() {
		if(wheel==false&&size>2){
			zahler++;
		}
		if (wheel==true){
			size += 1;
			wheel=false;
			zahler=0;
		}
		if(zahler>20&&size>2){
			size-=0.1;
		}

		// fill(0,20);
		// rect(0,0,width,height);

		// float x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		// float y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */

		if (xPos > width) {
			xPos = 0;
		}
		// xPos=(int) (noise(start1+=u)*height+1);
		xPos = xPos + 1;
		yPos = (int) (noise(start2 += u) * height);
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
		stroke(ak, al, am);//testen
		float size2 = (float) size;
		double c = (50 * -Math.exp(-0.1 * size) + 50) * Math.pow(size, 0.333);

		float g = (float) c;
		ellipse(xPos, yPos, g, g);
		
		// ellipse(xPos, yPos, size2, size2);

		if (exit == true) {
			endRecord();
			saveFrame("Programm 7 " + ft.format(date) + " .tif");
			exit();
		}

	}
}
