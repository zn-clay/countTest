package com.zhiyou.zn.countText;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Count extends JApplet implements ActionListener{
	private JTextField textField= new JTextField("请输入");
	String operator = "";//操作
	String input = "";//输入的公式
	boolean flag = true;
	
	public void init() {
		Container c = getContentPane();
		JButton b[] = new JButton[16];
		JPanel panel = new JPanel();
		c.add(textField, BorderLayout.NORTH);
		c.add(panel,BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4,4,5,5));
		String name[] = {"7","8","9","+","4","5","6","-","1","2","3","*",
						 "0","c","=","/"};//设置按键
		for(int i= 0;i<16;i++) {
			b[i]= new JButton(name[i]);
			b[i].setBackground(new Color(192, 192, 192));
			b[i].setForeground(Color.BLUE);//数字键设置为黑色
			if(i%4 == 3) {
				b[i].setForeground(Color.RED);
			}
			b[i].setFont(new Font("宋体", Font.PLAIN, 16));
			panel.add(b[i]);
			b[i].addActionListener(this);
			
		}
		b[13].setForeground(Color.RED);
		b[13].setForeground(Color.RED);		
	}
	public void actionPerformed(ActionEvent e) {
		int cnt= 0;
		String actionCommand = e.getActionCommand();
//		System.out.println(actionCommand.toString());
		if(actionCommand.equals("+") || actionCommand.equals("-")||actionCommand.equals("*")||actionCommand.equals("/")) {
			input +=" "+actionCommand+" ";
			System.out.println(input.toString());
		}
		
		else if(actionCommand.equals("c"))
			input = "";
		else if(actionCommand.equals("=")) {
			input += "="+compute(input);
			textField.setText(input);
			input = "";
			cnt = 1;
		}else {
			input +=actionCommand;
		}if(cnt == 0) {
			textField.setText(input);
		}
			
		
	}
	private String compute(String input) {
		String str[];
		str= input.split(" ");
		Stack<Double> s=new Stack<Double>();
		double m =Double.parseDouble(str[0]);
		s.push(m);
		for (int i = 1; i < str.length; i++) {
			if (i%2 == 1) {
				if (str[i].compareTo("+") == 0) {
					double help = Double.parseDouble(str[i+1]);
					s.push(help);
				}
				if (str[i].compareTo("-") == 0) {
					double help = Double.parseDouble(str[i+1]);
					s.push(-help);
				}
				if (str[i].compareTo("*") == 0) {
					double help = Double.parseDouble(str[i+1]);
					double ans = s.peek();
					s.pop();
					ans*=help;
					s.push(ans);
				}
				if (str[i].compareTo("/") == 0) {
					double help = Double.parseDouble(str[i+1]);
					double ans = s.peek();
					s.pop();
					ans/=help;
					s.push(ans);
				}
			}
		}
		double ans =0d;
		while (!s.isEmpty()) {
			ans+=s.peek();
			s.pop();
			
		}
		String result = String.valueOf(ans);
		return result;
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Count");
		Count applet = new Count();
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(350, 400);
		frame.setVisible(true);
	}
}
