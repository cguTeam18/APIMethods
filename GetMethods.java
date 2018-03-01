/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*TO DO: Separate the tenantId/authCode into its own method
         Create an interface for all methods to make more generic
         Parse the response into an object
         Integrate methods with the mvc (important!)
*/
package RequestMethods;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
/**
 *
 * @author jidev
 */
public class GetMethods {
    
    private final String tenantId = "Team18";
    private final String authToken = "ddd8af7c-3e22-4d31-aefa-3e834071c954";
    
    public static void main(String[] args) throws Exception {

		GetMethods http = new GetMethods();

		System.out.println("Testing 1 - Recieve all timelines");
		http.sendGetAllTimelines();
                System.out.println("Testing 2 - Recieve specified timeline with the id '123456'");
                http.sendGetTimeline("TimelineId", "123456");
	}
    
    public void sendGetAllTimelines() throws Exception {
        
        String url = "https://gcu.ideagen-development.com/Timeline/GetTimelines";
        
        URL query = new URL(url);
        HttpURLConnection con = (HttpURLConnection) query.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("tenantId", tenantId);
        con.setRequestProperty("AuthToken", authToken);
        int responseCode = con.getResponseCode();
        System.out.println("Sending GET request to: " + url);
        System.out.println("Response code: " + responseCode);
        
        BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                System.out.println(response.toString());
        
    }
    
    public void sendGetTimeline(String timelineIdKey, String timelineIdVal) throws Exception {
        
        String url = "https://gcu.ideagen-development.com/Timeline/GetTimeline";
        
        URL query = new URL(url);
        HttpURLConnection con = (HttpURLConnection) query.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("tenantId", tenantId);
        con.setRequestProperty("AuthToken", authToken);
        con.setRequestProperty(timelineIdKey, timelineIdVal);
        int responseCode = con.getResponseCode();
        System.out.println("Sending GET request to: " + url);
        System.out.println("Response code: " + responseCode);
        
        BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
                System.out.println(response.toString());
    }
}
