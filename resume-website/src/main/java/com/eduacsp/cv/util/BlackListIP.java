package com.eduacsp.cv.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ResourceUtils;

public class BlackListIP {

	private static File file;
	private static List<String> list = new ArrayList<>();

	public boolean isIPBlocked(String ip){
		boolean isBlocked = false;

		if(list.size()==0){
			try {
				if(file==null){
					file = ResourceUtils.getFile("classpath:ip/russia.txt");
					System.out.println("file:"+file);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try (BufferedReader br = Files.newBufferedReader(file.toPath())) {
				list = br.lines().collect(Collectors.toList());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if(list.contains(ip)){
			isBlocked = true;
		}
		
		return isBlocked;
	}


/*	public static void main(String[] args) {
		BlackListIP black = new BlackListIP();
		System.out.println("BlackListIP:"+black.isIPBlocked("5.16.0.0/14"));
	}
*/

}
