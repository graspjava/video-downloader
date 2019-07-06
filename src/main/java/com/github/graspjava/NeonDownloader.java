package com.github.graspjava;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.graspjava.model.neon.NeonVideo;
import com.github.graspjava.mp4.GetMp4Links;
import com.github.graspjava.neon.NeonVideoUrl;
import com.github.graspjava.writer.DownloadVideo;

/**
 * Hello world!
 *
 */
public class NeonDownloader {
	
	public static void main(String[] args) {
		
		try {
			
			for(String url : urls()) {
				NeonVideo neonVideo = NeonVideoUrl.parseHtml(url);
				
				List<String> urls = GetMp4Links.mp4Links("http://savevideo.me", neonVideo);
				
				System.out.println(neonVideo.getDescription() + ".mp4 -> " + DownloadVideo.download(urls.get(2), "D:\\Neon Tutorials\\" +  neonVideo.getDescription() + ".mp4"));
			}
			
		} catch (IOException e) {
			System.out.println("Exception:"+e );
		}
	}
	
	static List<String> urls() {
		List<String> list = new ArrayList<>();
		
		list.add("https://www.neonclasses.com/video/NzY=/");
		list.add("https://www.neonclasses.com/video/NzQ=/");
		list.add("https://www.neonclasses.com/video/Njc=/");
		list.add("https://www.neonclasses.com/video/NjY=/");
		list.add("https://www.neonclasses.com/video/NjU=/");
		list.add("https://www.neonclasses.com/video/NjA=/");
		list.add("https://www.neonclasses.com/video/NTk=/");
		list.add("https://www.neonclasses.com/video/NTc=/");
		list.add("https://www.neonclasses.com/video/NTY=/");
		list.add("https://www.neonclasses.com/video/NTE=/");
		list.add("https://www.neonclasses.com/video/NTA=/");
		list.add("https://www.neonclasses.com/video/NDk=/");
		list.add("https://www.neonclasses.com/video/NDg=/");
		list.add("https://www.neonclasses.com/video/NDQ=/");
		list.add("https://www.neonclasses.com/video/NDM=/");

		return list;
	}
	
}
