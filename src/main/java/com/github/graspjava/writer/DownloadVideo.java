/**
 * 
 */
package com.github.graspjava.writer;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author Rahul.Vishvakarma1
 *
 */
public class DownloadVideo {

	public static boolean download(String url, String fileName) {
		
		try {
			downloadUsingStream(url, fileName);
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	private static void downloadUsingStream(String urlStr, String file) throws IOException {
		
        URL url = new URL(urlStr);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count=0;
        while((count = bis.read(buffer,0,1024)) != -1)
        {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
    }
}
