import processing.core.PApplet;
//import processing.event.KeyEvent;
//import processing.event.MouseEvent;
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

public class stable2 extends PApplet

{
	public static void main(String[] args) {
		String[] a = { "MAIN" };
		PApplet.runSketch(a, new stable2());

		GlobalKeyboardHook keyboardHook = new GlobalKeyboardHook();
		keyboardHook.addKeyListener(new GlobalKeyAdapter() {
			@Override
			public void keyPressed(GlobalKeyEvent event) {
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
					// println("rechts");

				}

				if ((event.getButtons() & GlobalMouseEvent.BUTTON_RIGHT) != GlobalMouseEvent.BUTTON_NO) {

					// println("links");
				}

				if (event.getButton() == GlobalMouseEvent.BUTTON_MIDDLE) {

				}

			}

			@Override
			public void mouseReleased(GlobalMouseEvent event) {
				// System.out.println(event);
			}

			@Override
			public void mouseMoved(GlobalMouseEvent event) {
				// System.out.println(event);
			}

			@Override
			public void mouseWheel(GlobalMouseEvent event) {
				// System.out.println(event);
			}
		});

	}

	
	int x, y;
	float a, b, i;

	public void settings() {
		// size(500,500);
		// size(displayWidth,displayHeight);
		fullScreen();

	}

	public void setup() {
		beginRecord(PDF, "MouseClicked.pdf");
		background(0);
		smooth();
		stroke(0);
		strokeWeight(1);

	}

	public void draw() {

		strokeWeight(1);
		float x = MouseInfo.getPointerInfo().getLocation().x;
		float y = MouseInfo.getPointerInfo().getLocation().y;
		line(x, y, a, b);
		noFill();
		// frameRate(1);
		 //ellipse(x, y, random(-2000, 2000), random(-2000, 2000));
		// rect(displayWidth/2,displayHeight/2,random(-1000,1000),random(-1000,1000));
		if (i > 0) {
			stroke(255);
		}
		i++;
		a = x;
		b = y;
	}

	public void keyPressed() {
		if (key == 'q') {
			endRecord();
			exit();
			
		}

	}

}
