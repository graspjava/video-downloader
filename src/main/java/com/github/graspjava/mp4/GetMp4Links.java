/**
 * 
 */
package com.github.graspjava.mp4;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.github.graspjava.model.neon.NeonVideo;

/**
 * <p>
 * This class will digest the video URL and 
 * provide multiple .mp4 links to download the video with different quality.
 * 
 * @author Rahul.Vishvakarma
 *
 */
public class GetMp4Links {

	/**
	 * 
	 * 
	 * @param helperUrl video url e.g.; YouTube, Udemy, Vimeo
	 * @return
	 */
	public static List<String> mp4Links(String helperUrl, NeonVideo neonVideo) throws IOException {
		
		Document resp = Jsoup.connect("http://savevideo.me/get/")
							.method(Method.POST)
							.headers(headers())
							.data(data(neonVideo.getUrl()))
							.post();
		
		return resp.getElementsByTag("div").get(0).getElementsByTag("p")
											.stream()
											.map(p -> p.getElementsByTag("a").get(0))
											.map(a -> a.attr("href"))
											.collect(Collectors.toList());
	}
	
	private static Map<String, String> data(String videoUrl) {
		Map<String, String> data = new HashMap<>();
		data.put("url", videoUrl);
		return data;
	}
	
	private static Map<String, String> headers() {
		Map<String, String> headers = new HashMap<>();
		
		headers.put("Accept", "*/*");
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Accept-Language", "en-US,en;q=0.9");
		headers.put("Connection", "keep-alive");
		headers.put("Content-Length", "54");
		headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		headers.put("Host", "savevideo.me");
		headers.put("Origin", "http://savevideo.me");
		headers.put("Referer", "http://savevideo.me/");
		headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36");
		headers.put("X-Requested-With", "XMLHttpRequest");
		
		return headers;
	}
}