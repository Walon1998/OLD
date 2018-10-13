


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
int[] q =new int[1000000];
int[] w =new int[1000000];
int[] e =new int[1000000];
int[] r =new int[1000000];
	int i=0;
	int a, b;

	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen();

	}

	public void setup() {

		beginRecord(PDF, "test " + ft.format(date) + " .pdf");
		background(0);
		smooth();
		stroke(255,10);
//frameRate(240);
	}

	public void draw() {

		int x = MouseInfo.getPointerInfo().getLocation().x; /* always 1 */
		int y = MouseInfo.getPointerInfo().getLocation().y; /* always 1 */
if (a!=x || b!=y){
for (int g=0;g<i;g++){
	if(dist(x,y,e[g],r[g])<100){

		line(x,y,e[g],r[g]);
	}
}
}
	
		if (exit == true) {
			endRecord();
			saveFrame("test " + ft.format(date) + " .tif");
			exit();
		}
		
		
		e[i]=x;
		r[i]=y;
		i++;
		a=x;
		b=y;
	}
}
