package OTPSender;

public class Main {

	public static void main(String[] args) {

		OtpSender otp = new OtpSender();
		String s = otp.sendSms();
		System.out.println(s);
		System.out.println("Sms sent");
		
	}

}
