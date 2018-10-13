
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

public class Version3 extends PApplet

{
	public static void main(String[] args) {
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new Version3());

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
				long endTime=System.currentTimeMillis();
				
				float estimatedTime = abs(startTime-endTime);
				 startTime = System.currentTimeMillis();
				zeit=estimatedTime;
			}
		});

	}
	static long startTime = 0;
	float	a=204;
	float	b=0;
	float	c=0;
	float d=255;
	float e=0;
	float f=0;
	float g=0;
	float h=0;
	float i=255;
	float ae = 100;
	static float  zeit;
	
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
		

		float ab = 0;
		float ac = 0;
		float ad = 0;
		
		ab=ab+zeit;
		ac=ac+zeit;
		ad=ad+zeit;
		if (ab>a){
			ab=a;
		}
		if (ac>b){
			ac=b;
		}
		if (ad>c){
			ad=c;
		}
	int	color1 = color(ab, ac, ad, ae);
fill(color1);

		

		if (exit == true) {
			endRaw();

			saveFrame("test " + ft.format(date) + " .tif");
			exit();
		}
		
		if (key == true) {
			
			
if(zeit==0){
	fill(a,b,c,ae);
}
			translate(random(-50, 1919+50), random(-50, 1079+50), random(-1000, 500));
			box(100);

			key = false;
		}
		
		
	}

}
//