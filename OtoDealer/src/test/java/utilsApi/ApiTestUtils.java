package utilsApi;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import Base.ReportBaseClass;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ApiTestUtils extends ReportBaseClass{

	public static void getAllApiResponse(Response response) {
		response.then().log().all();
	}

	public static void checkStatusCode(Response response,int checkData) {
		Assert.assertEquals(response.getStatusCode(),checkData);
	}
	public static void getStatusLineAssertTrue(Response response,String containsData) {
		Assert.assertTrue(response.getStatusLine().contains(containsData));
	}
	public static void checkResponse(Response response,String checkInResponse) {
		Assert.assertTrue(response.getBody().asString().contains(checkInResponse));
	}
	//get a value from response
	public static String getValueFromResponse(Response response,String jsonPath) {
		String apiPath =""+ response.jsonPath().get(jsonPath);
		return apiPath;
	}

	//Returns JsonPath object
	public static JsonPath getJsonPath(Response res) {
		String json = res.asString();
		return new JsonPath(json);
	}
	// get all data in a list
	public static List<Map<String, Object>> getAllListdata(Response response,String jsonpath) {
		List<Map<String,Object>> all = ApiTestUtils.getJsonPath(response).getList(jsonpath);
		for(Map<String,Object> alldata : all)
		{
			System.out.println(alldata);
		}
		return all;

	}
	// get a value from response value
	public static String getValueFromAResponse(Response response,String jsonpath) {
		String path = ""+getJsonPath(response).get(jsonpath);
		return path;	
	}
	// get a value from response value
	public static boolean getBooleanResponse(Response response,String jsonpath) {
		boolean path = ""+getJsonPath(response).get(jsonpath) != null;
		return path;	
	}
	// get a long int value from response value
	public static long getLongIntValueFromAResponse(Response response,String jsonpath) {
		String path = ""+getJsonPath(response).get(jsonpath);
		return Integer.parseInt(path);	
	}

	// We can get a value from all elements of array
	public static List<String> getAValueFromList(Response response,String jsonpath) {
		List<String> list = ApiTestUtils.getJsonPath(response).getList(jsonpath);
		return list;
	}
	// We can get list size
	public static String getListSize(Response response,String jsonpath) {
		List<String> all = ApiTestUtils.getJsonPath(response).getList(jsonpath);
		String listsize =""+all.size(); 
		return listsize;
	}
	public static void assertEquals(String actual,String expected) {
		Assert.assertEquals(actual,expected);
	}

	public static void testAssertEquals(String actual,String expected) {

		try {
			Assert.assertEquals(actual,expected);
			ReportBaseClass.logger.info("pass ");
			ReportBaseClass.logger.log(Status.PASS,MarkupHelper.createLabel( "Test PASSED ", ExtentColor.GREEN));
		} catch (AssertionError e) {
			ReportBaseClass.logger.info("pass ");
			ReportBaseClass.logger.log(Status.FAIL, MarkupHelper.createLabel(" Test FAILED", ExtentColor.RED));
			//logger.fail(result.getThrowable());					
			ReportBaseClass.logger.info("failed due to "+e.getMessage().toString());

		}

	}
	public static void testAssertWithMessage(String message,String actual,String expected) {

		try {
			Assert.assertEquals(actual,expected);
			ReportBaseClass.logger.log(Status.PASS,MarkupHelper.createLabel( message+" Test PASSED ", ExtentColor.GREEN));
		} catch (AssertionError e) {
			ReportBaseClass.logger.log(Status.FAIL, MarkupHelper.createLabel(message+" Test FAILED", ExtentColor.RED));
			//logger.fail(result.getThrowable());					
			ReportBaseClass.logger.info("failed due to "+e.getMessage().toString());

		}

	}

}
