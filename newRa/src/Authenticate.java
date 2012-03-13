/* CODE: SREEPRASAD */

/* This code is used to authenticate to website using java */

/* import functions */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class Authenticate {
	
	public static void main(String[] args) {
		 
		try {
			/* get client */ 
			HttpClient client = new DefaultHttpClient();
			/* url to logg in */
			HttpPost post = new HttpPost("https://albert.rit.edu/patroninfo");
			try {
				/* get the user name and password to store in list */
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
				/* adding username */
				nameValuePairs
						.add(new BasicNameValuePair("username", "REPLACE_WITH_USERNAME"));
				/* adding password */
				nameValuePairs.add(new BasicNameValuePair("password",
						"REPLACE_WITH_PASSWORD"));
				post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				/* execute */
				HttpResponse response = client.execute(post);
				/* get content */
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				/* String to store the output */
				String line = "";
				/* Output until end of line */
				while ((line = rd.readLine()) != null)
					System.out.println(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			System.out.println("Could not logg in..");
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
