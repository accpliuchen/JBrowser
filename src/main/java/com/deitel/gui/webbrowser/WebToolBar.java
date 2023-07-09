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
        urlTextField.addActionListener( new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent event) {
				try{
					URL url=new URL(urlTextField.getText());
					webBrowserPane.goToURL(url);

				}catch(MalformedURLException urlException){
					urlException.printStackTrace();
				}
			}
		});


        backButton = new JButton( new ImageIcon(getClass().getResource( "./images/back.gif" ) ) );
        backButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event){
        		URL url=webBrowserPane.back();

        		urlTextField.setText(url.toString());
        	}
        });


		
		forwardButton = new JButton( new ImageIcon(getClass().getResource( "./images/forward.gif" ) ) );

		forwardButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent event){
        		URL url=webBrowserPane.forward();

        		urlTextField.setText(url.toString());
        	}
        });

        add(backButton);
        add(forwardButton);
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
