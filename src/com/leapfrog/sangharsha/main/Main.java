package com.leapfrog.sangharsha.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leapfrog.sangharsha.utils.Grabber;

public class Main {
	
	public static void main(String[] args){
		String link = "http://merojob.com";
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Menu");
		System.out.println("---------");
		System.out.println("1. Show all jobs");
		System.out.println("2. Search jobs by keyword");
		int choice = scanner.nextInt();
		scanner.close();
		switch(choice){
		case 1: 
			showAllJobs(link);
			break;
		case 2: 
			showJobsByKeyWord();
		}
	}

	private static void showAllJobs(String link) {
		try{
			Grabber grabber = new Grabber();
			String content = grabber.get(link); 
			String regex = com.leapfrog.sangharsha.regexes.Pattern.meroJobPattern;
			Pattern jobPattern = Pattern.compile(regex);
			Matcher jobMatcher = jobPattern.matcher(content);
			while(jobMatcher.find()){
				System.out.println("COMPANY: " + jobMatcher.group(10).trim().toUpperCase());
				Pattern jobListPattern = Pattern.compile(com.leapfrog.sangharsha.regexes.Pattern.meroJobListPattern);
				Matcher jobListMatcher = jobListPattern.matcher(jobMatcher.group());

				System.out.println("");
				int count = 1;
				while(jobListMatcher.find()){
					System.out.println(count+")");
					System.out.println("Title: " + jobListMatcher.group(3).trim());
					System.out.println("Link: " + jobListMatcher.group(1).trim());
					System.out.println("");
					count++;
				}
				System.out.println("================================================================================================");
			}
		}catch(Exception e){
			
		}
	}	
	
	private static void showJobsByKeyWord(){
		System.out.println("UnderContruction");
	}
}