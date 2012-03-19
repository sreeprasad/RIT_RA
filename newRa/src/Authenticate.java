
/* CODE written by Sreeprasad */
	
	/* import statements  */
	import java.io.*;	 
	import java.util.ArrayList;
	import java.util.List;
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

	/* class begins */	
public class Authenticate {
	/* main method */	
    public static void main(String[] args){
 	try { 
		/* initialize client */	
 		DefaultHttpClient client = new DefaultHttpClient();
		/* initialize URL to navigate for authencation for client */	
		HttpPost post = new HttpPost("REPLACE_WITH_AUTHENTICATION_URL");
			try {
				List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
		/* replace with authentication username and id */	
				nameValuePairs.add(new BasicNameValuePair("REPLACE_WITH_ID_KEY",
				                    "REPLACE_WITH_ID_VALUE"));
		/* replace with authentication password  */	
				nameValuePairs.add(new BasicNameValuePair("REPLACE_WITH_PASSWORD_KEY",
				                    "REPLACE_WITH_PASSWORD_VALUE"));
				post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				
				System.out.println("response is :");
				/* redirection to navigate after redirection */
				client.setRedirectStrategy( new DefaultRedirectStrategy(){
 					public boolean isRedirected(HttpRequest req, HttpResponse res, HttpContext con){
 						if(res.getStatusLine().getStatusCode()==302) return true;
 						return false;
 					}
 				});
				/* get reponse from server */
				HttpResponse response = client.execute(post); 
				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				String line = "";
				/* this is not required. Just added to provide layer of debugging. */
				while ((line = rd.readLine()) != null) {
					//System.out.println(line);
				}
				/* navigate to the url to scrap data */				
				HttpPost new_post = new HttpPost("REPLACE_WITH_NAVIGATION_URL");
				/* get response from url to scrap data */
				HttpResponse new_response = client.execute(new_post); 
				
				BufferedReader new_rd = new BufferedReader(new InputStreamReader(
						new_response.getEntity().getContent()));
				String new_line = "";
				while ((new_line = new_rd.readLine()) != null) {
					/* render reponse before scrapping data */
					System.out.println(new_line);
				}
				
			       /* catch Exceptions */
				} catch (IOException e) {
						e.printStackTrace();
				}
		} 
		catch(Exception e) 
		{ 
			System.out.println( "Exception caught while navigating." ); 
			System.out.println( e.toString() ); 
			e.printStackTrace(); 
		} 
	}
}
	
	

