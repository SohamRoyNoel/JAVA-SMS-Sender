package OTPSender;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/*
 * Generate your api key from -- https://www.textlocal.in/
 * */
public class OtpSender {

	public String sendSms() {
		try {
			// Construct data
			String apiKey = "apikey=" + "iGM6/dtsWK0-srWGbhJTTe8jddobG3mTfpIu3gnroA";
			String message = "&message=" + "Soham created an OTP to get Suchismita : " + RandomizerClass.getRandomvalue();
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "9038897580";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			 
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	
}
