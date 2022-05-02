package utilsCommonClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import Base.ReportBaseClass;
import Utility.Constants;
import io.restassured.response.Response;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.LoadJsonFile;
import utilsApi.ReadExcelFile;



public class Login extends ReportBaseClass {
	public static String token;
	public static String dealerid;
	public static String user_id;
	public static String user_type;
	public static String user_type_id;
	public static String source_id;
	public static String dealer_id_hash;
	@Test
	public void testLogin() throws IOException {
		
		ReadExcelFile d=new ReadExcelFile();
		ArrayList<String> data=d.getData("login","islogin","y");
		Map<String,Object> bodyParams=new HashMap<String,Object>();
		bodyParams.put("email", data.get(1));
		bodyParams.put("password",data.get(2));

	//	String payload=new Gson().toJson(bodyParams);
	//	System.out.println("****{POST}*****");
	//	String bodyData=LoadJsonFile.handleJson(Constants.LoginJson);
		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test Login");
		Response response=ApiCall.postApiMethod(bodyParams,ApiPaths.email_login);

		ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);
		ApiTestUtils.getStatusLineAssertTrue(response, "OK");

		ApiTestUtils.checkResponse(response, "Success");
		token =ApiTestUtils.getValueFromResponse(response, "data.token");
		dealerid=ApiTestUtils.getValueFromResponse(response, "data.dealer_data[0].dealer_id");
		user_id=ApiTestUtils.getValueFromResponse(response, "data.user_data.user_id");
		user_type=ApiTestUtils.getValueFromResponse(response, "data.user_data.user_type");
	
		user_type =(ApiTestUtils.getValueFromResponse(response, "data.user_data.user_type").equals("D")) ? "dealer":"sfa";
		user_type_id=ApiTestUtils.getValueFromResponse(response, "data.user_data.user_type_id");
		source_id=ApiTestUtils.getValueFromResponse(response, "data.user_data.source_id");
		dealer_id_hash=ApiTestUtils.getValueFromResponse(response, "data.dealer_data[0].dealer_id_hash");
		ReportBaseClass.logger.info("Login Test executed");
	}
}