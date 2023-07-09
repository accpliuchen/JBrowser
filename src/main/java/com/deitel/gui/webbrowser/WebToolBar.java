package com.deitel.gui.webbrowser;

import java.awt.*;
import java.awt.event.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;

public class WebToolBar extends JToolBar implements HyperlinkListener{

	private WebBrowserPane webBrowserPane;
	private JButton backButton;
	private JButton forwardButton;
	private JTextField urlTextField;

	public WebToolBar(WebBrowserPane browser){
		super("Web Navigation");

        webBrowserPane=browser;
        webBrowserPane.addHyperlinkListener(this);

        urlTextField=new JTextField(25);
        
        add(urlTextField);
	}

	public void hyperlinkUpdate(HyperlinkEvent event){
		if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED){
			URL url=event.getURL();
            webBrowserPane.goToURL(url);
			urlTextField.setText(url.toString());
		}
	}
}
