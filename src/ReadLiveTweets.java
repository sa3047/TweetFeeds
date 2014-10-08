import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;


public class ReadLiveTweets {

	/**
	 * @param args
	 * @throws TwitterException 
	 */
	public static void main(String[] args) throws TwitterException {
		// TODO Auto-generated method stub
		 TwitterFactory factory = new TwitterFactory();
		    AccessToken accessToken = loadAccessToken(Integer.parseInt("103492387"));
		    Twitter twitter = factory.getInstance();
		    twitter.setOAuthConsumer("vVDm69CbrMwUhLr7QqvM0luQd", "xVI19LHWFrPgKPkrefNyYbt1KzyN7QDP9g2Ks5RKh79slZfYla");
		    twitter.setOAuthAccessToken(accessToken);
		   // Status status = twitter.updateStatus(args[1]);
		   // ResponseList<String> tweets = new ResponseList<String>();
		    
		    ResponseList<Status> tweets = twitter.getHomeTimeline();
		    System.out.println("Successfully updated the status to [" + tweets.toString() + "].");
		    System.exit(0);
	}

	private static AccessToken loadAccessToken(int useId){
	    String token = "103492387-m0184ZGIqphZnQSBUvqVPv4EGIOnHT2946NQXmHn";
	    String tokenSecret = "TNvfrIuXYXv2MsnocKQfOigYHCuwcsiwJQwBidbpOvB9i";
	    return new AccessToken(token, tokenSecret);
	  }
}
