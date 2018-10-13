
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
				case 49:
					color = 1;

					break;
				case 50:
					color = 2;

					break;

				case 51:
					color = 3;

					break;

				}

				// System.out.println(event);
				
				
			}

			@Override
			public void keyReleased(GlobalKeyEvent event) {
				// System.out.println(event);
				key = true;
			}
		});

	}
           
	static int color;

	static boolean key = false;
	Date date = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E dd.MM.yyyy 'at' HH-mm-ss  ");

	static boolean exit = false;

	public void settings() {

		fullScreen(P3D);

	}

	public void setup() {

		beginRaw(DXF, "test " + ft.format(date) + " .dxf");
		// beginRaw(PDF, "test " + ft.format(date) + " .pdf");

		background(255);
		smooth();

		strokeWeight(5);

	}

	public void draw() {
	
                           
		if (exit == true) {
			endRaw();

			saveFrame("test " + ft.format(date) + " .tif");
			exit();
		}
		if (key == true) {
		
			 
		
			switch (color) {
			case 1:
				fill(255, 0, 0, 100);
				break;
			case 2:
				fill(0, 0, 255, 100);
				break;
			case 3:
				fill(0, 255, 0, 100);

			}

			translate(random(0, 1919), random(0, 1079), random(-1000, 1000));
			box(100);
			key = false;
			 
		}
	}

}
