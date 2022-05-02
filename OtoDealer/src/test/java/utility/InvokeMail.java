package utility;

public class InvokeMail {

	public static String server="smtp.gmail.com";

	public static String from = "abhishektest09@gmail.com";
	public static String password = "testing09";
	public static String[] to ={"abhishek.gautam1@girnarsoft.co.in",/*"rohit.gaurav@girnarsoft.co.in",*/
			/*"Aditya.arya@girnarsoft.co.in"*/};
	public static String subject = "Api Test Report";
	public static String port="25";
	//public static String username="abhishektest09@gmail.com";
	public static String subjectattachment = "Api report";
	//public static String messageBody="Hi";

	public static String messageBody
	="Please find the Api report attached."
			+
			" <br><br><b></b>"+"<br><br>"+
			"<b>Thanks,</b><br>QA Team";


	//public static StringBuffer testCaseLink=new StringBuffer();
	public static String attachmentPath="/home/abhishekgautam/Desktop/Api FrameWork/OtoDealer/resource/logger.txt";
	public static String attachmentName="logger.txt";
}