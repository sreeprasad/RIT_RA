
	/* CODE: SREEPRASAD */

	/* This code is used to authenticate to website using java */

	/* import functions */
	import java.io.*;
	import java.util.ArrayList;
	import java.util.List;

	import org.apache.http.Header;
	import org.apache.http.HttpRequest;
	import org.apache.http.HttpResponse;
	import org.apache.http.NameValuePair;
	import org.apache.http.client.HttpClient;
	import org.apache.http.client.entity.UrlEncodedFormEntity;
	import org.apache.http.client.methods.HttpPost;
	import org.apache.http.impl.client.DefaultHttpClient; 
	import org.apache.http.impl.client.DefaultRedirectStrategy;
	import org.apache.http.message.BasicNameValuePair;
	import org.apache.http.protocol.HttpContext;
	import org.apache.http.protocol.BasicHttpContext;



	public class Authenticate {

		public static void main(String[] args) {

			try {
				/* get client */ 
				DefaultHttpClient client = new DefaultHttpClient();

				/* url to logg in */
				HttpPost post = new HttpPost("https://albert.rit.edu/patroninfo~S3/1147900/top");
				try {
					/* get the user name and password to store in list */
					List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
					/* adding username */
					nameValuePairs
							.add(new BasicNameValuePair("name", "REPLACE_WITH_NAME"));
					/* adding password */
					nameValuePairs.add(new BasicNameValuePair("code",
							"REPLACE_WITH_CODE"));
					nameValuePairs.add(new BasicNameValuePair("pin",
							"REPLACE_WITH_PIN"));
					post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					/* execute */


	 				HttpResponse response = client.execute(post);

					/* added code to handle redirection */
					
					
	 				client.setRedirectStrategy( new DefaultRedirectStrategy(){
	 				/* The parameter of the function :HttpContext con  throws NoSuchMethod Runtime exception.
						Currently code is has yet to handle this. I have put up request in stackoverflow
						http://stackoverflow.com/questions/9706781/basichttpcontext-error-message-on-redirection
						Till now no one has answered this question. Looking for other options */
						public boolean isRedirected(HttpRequest req, HttpResponse res, HttpContext con){
	 						if(res.getStatusLine().getStatusCode()==302) return true;
	 						return false;
	 					}
	 				});

					System.out.println("response is :");
					System.out.println(response.toString());





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
