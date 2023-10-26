import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIAccess {

    public String accessUrl(String apiUrl) {
        String returnValue;
        try {
            // Step 1: Create a URL object with the API endpoint
            URL url = new URL(apiUrl);

            // Step 2: Open an HTTP connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Step 3: Set the request method (GET, POST, etc.) and request properties
            connection.setRequestMethod("GET");

            // Step 4: Read the response from the API
            int responseCode = connection.getResponseCode();

            // if response OK
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                // Read the response data line by line
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Handle the API response (stored in the 'response' variable)
                returnValue = "API Response: " + response.toString();
            } else {
                // Handle HTTP error responses (Not 200-OK)
                returnValue = "Request failed with response code: " + responseCode;
            }
            // Step 5: Close the connection
            connection.disconnect();
        } catch (Exception e) {
            // Step 6: Handle exceptions
            returnValue = e.getMessage();
        }
        return returnValue;
    }
}
