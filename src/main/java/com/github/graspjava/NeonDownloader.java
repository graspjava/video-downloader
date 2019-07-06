package com.github.graspjava;

import java.io.IOException;

import com.github.graspjava.neon.NeonVideoUrl;

/**
 * Hello world!
 *
 */
public class NeonDownloader {
	public static void main(String[] args) {
		NeonVideoUrl neonvideourl = new NeonVideoUrl();
		try {
			System.out.println(neonvideourl.parseHtml("https://www.neonclasses.com/video/NDI0/"));
			
		} catch (IOException e) {
			System.out.println("Exception:"+e );
		}
	}
}
