package com.leapfrog.sangharsha.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Grabber {

	public String get(String link) throws IOException{
		URL url = new URL(link);
		URLConnection conn = url.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line = "";
		StringBuilder content = new StringBuilder();
		while((line = bufferedReader.readLine()) != null){
			content.append(line).append("\n");
		}
		bufferedReader.close();
		return content.toString();
	}
	
}
