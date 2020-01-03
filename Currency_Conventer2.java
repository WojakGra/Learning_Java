import java.io.*;
import java.net.*;
import org.json.*;

public class Currency_Conventer2 {
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String USD_URL = "http://api.nbp.pl/api/exchangerates/rates/a/USD/?format=json";
	private static final String EUR_URL = "http://api.nbp.pl/api/exchangerates/rates/a/EUR/?format=json";
	private static final String GBP_URL = "http://api.nbp.pl/api/exchangerates/rates/a/GBP/?format=json";
	
	private static void Convert(String LINK) throws Exception {
		URL obj = new URL(LINK);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			final JSONObject obj2 = new JSONObject(response.toString());
			final JSONArray rates = obj2.getJSONArray("rates");
			final JSONObject rates2 = rates.getJSONObject(0);
			System.out.print("1 " + obj2.getString("code") + " = " + rates2.getDouble("mid") + " zł");
			System.out.println(" (Kurs uzyskany z NBP)");
		} else {
			System.out.println("GET request not worked");
		}
	}
	public static void main(String[] argv) throws Exception {
		Convert(USD_URL);
		Convert(EUR_URL);
		Convert(GBP_URL);
	}

}