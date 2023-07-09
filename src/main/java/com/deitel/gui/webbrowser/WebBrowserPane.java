package com.deitel.gui.webbrowser;


import java.util.*;
import java.net.*;
import java.io.*;

import javax.swing.*;

public class WebBrowserPane extends JEditorPane{

	private List history=new ArrayList();
	private int historyIndex;


	public WebBrowserPane(){
		setEditable(false);
	}

	public void goToURL(URL url){
		displayPage(url);
		history.add(url);
		historyIndex=history.size()-1;
	}

	public URL forward(){
		historyIndex++;

		if(historyIndex>=history.size()){
			historyIndex=history.size()-1;
		}

		URL url=(URL) history.get(historyIndex);
		displayPage(url);

		return url;
	}

	public URL back(){
		historyIndex--;

		if(historyIndex<0)
			historyIndex=0;

		URL url=(URL) history.get(historyIndex);
		displayPage(url);
		return url;
	}

	private void displayPage(URL pageURL){
		try{
			setPage(pageURL);
		}catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
}
