package com.zhiyou.zn.countText;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class XXOOGame extends JApplet implements ActionListener{
	
	@Override
	public void init() {
		Container c = getContentPane();
		JPanel panel = new JPanel();
		c.add(panel,BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3,3,5,5));
		JButton button[] = new JButton[9];
		for (int i = 0; i < button.length; i++) {
			button[i] =new JButton("");
			button[i].setBackground(new Color(192, 192, 192));
			panel.add(button[i]);
			button[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("XXOOGame");
		XXOOGame applet = new XXOOGame();
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(350, 400);
		frame.setVisible(true);
	}
}
