import java.io.*;
import java.net.*;
import java.util.Scanner;
import org.json.*;

public class Currency_Conventer {
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String USD_URL = "http://api.nbp.pl/api/exchangerates/rates/a/USD/?format=json";
	
	private static void USD() throws Exception {
		URL obj = new URL(USD_URL);
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
			
			System.out.println("Kurs uzyskany z NBP");
            System.out.println("Aby wyjść wpisz '0'");
			final JSONObject obj2 = new JSONObject(response.toString());
			final JSONArray rates = obj2.getJSONArray("rates");
		    final JSONObject rates2 = rates.getJSONObject(0);
		    System.out.println("1 " + obj2.getString("code") + " = " + rates2.getDouble("mid") + " zł");
		    double amount = 1.0;
			while (amount != 0.0) {
		    	Scanner input = new Scanner(System.in);
			    System.out.print("Podaj ilość " + obj2.getString("code") + " : ");
				amount = input.nextDouble();
				if(amount == 0.0) {
					break;
				} else {
				System.out.println(amount+ " " + obj2.getString("code") + " = " + rates2.getDouble("mid")*amount + " zł");
				}
		    }
		} else {
			System.out.println("GET request not worked");
		}

	}
	public static void main(String[] argv) throws Exception {
		USD();
	}

}