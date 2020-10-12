package TwitterActions;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class SendTweet {
	
	public static void tweetLines() {
        String line;
        try {
            try (
                    InputStream fis = new FileInputStream("C:\\Users\\rebec\\Desktop\\eclipse-work-bench\\NewTwitterBot\\src\\main\\resources\\tweets.txt");
                    InputStreamReader isr = new InputStreamReader(fis, Charset.forName("Cp1252"));
                    BufferedReader br = new BufferedReader(isr);
            ) {
                while ((line = br.readLine()) != null) {
                    sendTweet(line);
                    System.out.println("Tweeting: " + line + "...");

                    try {
                        System.out.println("Sleeping for 10 minutes...");
                        Thread.sleep(600000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

	 private static void sendTweet(String line) {
	        Twitter twitter = TwitterFactory.getSingleton();
	        Status status;
	        try {
	            status = twitter.updateStatus(line);
	            System.out.println(status);
	        } catch (TwitterException e) {;
	            e.printStackTrace();
	        }
	    }
}
