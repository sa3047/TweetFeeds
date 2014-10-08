import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
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
		    AccessToken accessToken = loadAccessToken(Integer.parseInt("103492387"), prop);
		    Twitter twitter = factory.getInstance();
		    twitter.setOAuthConsumer(prop.getProperty("customerkey") ,prop.getProperty("customerSecret") );
		    twitter.setOAuthAccessToken(accessToken);
		
		    
		    ResponseList<Status> tweets = twitter.getHomeTimeline();
		    System.out.println("Successfully updated the status to [" + tweets.toString() + "].");
		    System.exit(0);
	}

	private static AccessToken loadAccessToken(int useId,Properties prop){
	    String token = prop.getProperty("token");
	    String tokenSecret = prop.getProperty("toeknSecret");
	    return new AccessToken(token, tokenSecret);
	  }
	
	
}

