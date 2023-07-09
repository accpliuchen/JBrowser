package com.deitel.gui.webbrowser;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;

public class WebBrowser extends JFrame {

	private WebToolBar toolBar;
	private WebBrowserPane browserPane;

	public WebBrowser(){
		super("Web Browser");

		browserPane=new WebBrowserPane();
		toolBar=new WebToolBar(browserPane);

		Container contentPane=getContentPane();
		contentPane.add(toolBar,BorderLayout.NORTH);
		contentPane.add(new JScrollPane(browserPane),BorderLayout.CENTER);
	}

	public static void main(String args[]){
		WebBrowser browser=new WebBrowser();
		browser.setDefaultCloseOperation(EXIT_ON_CLOSE);
		browser.setSize(640,480);
		browser.setVisible(true);
	}
}
