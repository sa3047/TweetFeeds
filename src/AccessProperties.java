import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class AccessProperties {
	
	public static Properties getTwiiterProperties ()
	{
		Properties prop = new Properties();				
		InputStream input = null;
		 
		try {
	 
			input = new FileInputStream("twitter4j.properties");
	 
			// load a properties file
			prop.load(input);
			
			//check properties
			// get the property value and print it out
			System.out.println(prop.getProperty("token"));
			System.out.println(prop.getProperty("toeknSecret"));
			System.out.println(prop.getProperty("customerSecret"));
			System.out.println(prop.getProperty("customerkey"));
	 
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
