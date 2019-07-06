package com.github.graspjava.neon;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.github.graspjava.model.neon.NeonVideo;

/**
 * Its take html page and parse the html page & give the download url.
 * 
 * @author Gaurav Jain
 *
 */
public class NeonVideoUrl {

	public static NeonVideo parseHtml(String baseUri) throws IOException {

		Document response = Jsoup.connect(baseUri).get();
		

		String name= response.getElementsByTag("h1").html();

		String url = response.getElementsByTag("iframe").get(0).attr("src");

		return new NeonVideo(name, url);

	}
}
