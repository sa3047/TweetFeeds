import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ReadLiveTweets {

	/**
	 * @param args
	 * @throws TwitterException 
	 */
	/**
	 * @param args
	 * @throws TwitterException
	 */
	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub
		
		    TwitterFactory factory = new TwitterFactory();
		    //get the properties for twitter account
		    Properties prop = AccessProperties.getTwiiterProperties();
		    
		    //Get the access token for particular ID
		    AccessToken accessToken = loadAccessToken(Integer.parseInt("103492387"), prop);
		    Twitter twitter = factory.getInstance();
		    twitter.setOAuthConsumer(prop.getProperty("customerkey") ,prop.getProperty("customerSecret") );
		    twitter.setOAuthAccessToken(accessToken);
		
		    
		    ResponseList<Status> tweets = twitter.getHomeTimeline();
		    //System.out.println("Successfully updated the status to [" + tweets.toString() + "].");
		    
		    for (Status s : tweets )
		    {
		    	//System.out.println(s.getText());
		    	saveTweets(s.getText());
		    }
		    
		    
		    System.exit(0);
	}

	private static AccessToken loadAccessToken(int useId,Properties prop){
	    String token = prop.getProperty("token");
	    String tokenSecret = prop.getProperty("toeknSecret");
	    return new AccessToken(token, tokenSecret);
	  }
	
	public static void saveTweets(String tweets)
    {
       
        try{
             
            File file =new File("Tweets.txt");
 
            //if file doesnt exists, then create it
            if(!file.exists()){
                file.createNewFile();
            }
 
            //true = append file
            FileWriter fileWritter = new FileWriter(file.getName(),true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            bufferWritter.write(tweets);
            bufferWritter.write("\n");
            bufferWritter.close();
 
 
        }catch(IOException e){
            e.printStackTrace();
        }
      
    }
	
}

