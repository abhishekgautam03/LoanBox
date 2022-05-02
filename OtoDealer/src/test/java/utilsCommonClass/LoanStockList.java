package utilsCommonClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import Base.ReportBaseClass;
import Utility.Constants;
import Utility.Utils;
import io.restassured.response.Response;
import utility.ExcelUtils;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.ReadExcelFile;

public class LoanStockList extends ReportBaseClass{
	public static String makeId; 
	public static String modelId; 
	public static String versionId; 
	public static String makeYear; 
	public static String carPrice; 
	Map<String, Object[]> loancarlist = new TreeMap<String, Object[]>();
	@SuppressWarnings("unused")
	@Test
	public void getLoanStock() throws IOException {


		Map<String,Object> bodyParams=new HashMap<String,Object>();
		bodyParams.put("dealer_id", Login.dealerid);
		bodyParams.put("search_text","");
		bodyParams.put("category_id","1");
		//bodyParams.put("page_no",1);
		bodyParams.put("car_status","[1]");
		//	bodyParams.put("not_included_car_id",[]);


		String payload=new Gson().toJson(bodyParams);
		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test Loan Stock List");
		Response response=ApiCall.postApiWithHeader(payload,ApiPaths.loan_stock,Login.token);

		ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);
		Utils.logPrint(ApiTestUtils.getValueFromAResponse(response,"data[0].id"));
		Utils.logPrint(ApiTestUtils.getAValueFromList(response,"data.id").toString());
		Utils.logPrint(ApiTestUtils.getListSize(response,"data"));
		ReportBaseClass.logger.info("Loan Stock Test executed");
		makeId=ApiTestUtils.getValueFromAResponse(response,"data[1].make_id");
		modelId=ApiTestUtils.getValueFromAResponse(response,"data[1].model_id");
		versionId=ApiTestUtils.getValueFromAResponse(response,"data[1].version_id");
		makeYear=ApiTestUtils.getValueFromAResponse(response,"data[1].make_year");
		carPrice=ApiTestUtils.getValueFromAResponse(response,"data[1].car_price");
		ReportBaseClass.logger=ReportBaseClass.report.createTest("Loan Stock Added in excelsheet");
		
		JSONObject obj = new JSONObject(response.asString());
		JSONArray arr = obj.getJSONArray("data");
		loancarlist.put(""+ 0, new Object[] {"carTest","2"});
		loancarlist.put(""+ 1, new Object[] {"car_id","dealer_id","make_month","make_year","version_id",
				"reg_no","reg_month","reg_year","km_driven","uc_colour","car_price","fuel_type","transmission",
				"car_body_type","model","model_id","make_id","make","modelVersion","mmv_name","reg_data"});
		for (int i = 0; i < arr.length(); ++i) {

			int id=arr.getJSONObject(i).getInt("id");
			int dealer_id=arr.getJSONObject(i).getInt("dealer_id");
			int make_month=arr.getJSONObject(i).getInt("make_month");
			int make_year=arr.getJSONObject(i).getInt("make_year");
			int version_id=arr.getJSONObject(i).getInt("version_id");
			Object reg_no=arr.getJSONObject(i).get("reg_no");
			Object reg_month=arr.getJSONObject(i).get("reg_month");
			Object reg_year=arr.getJSONObject(i).get("reg_year");
			int km_driven=arr.getJSONObject(i).getInt("km_driven");
			Object uc_colour=arr.getJSONObject(i).get("uc_colour");
			int car_price=arr.getJSONObject(i).getInt("car_price");
			String fuel_type=arr.getJSONObject(i).getString("fuel_type");
			String transmission=arr.getJSONObject(i).getString("transmission");
			String car_body_type=arr.getJSONObject(i).getString("car_body_type");
			String model=arr.getJSONObject(i).getString("model");
			int model_id=arr.getJSONObject(i).getInt("model_id");
			int make_id=arr.getJSONObject(i).getInt("make_id");
			String make=arr.getJSONObject(i).getString("make");
			String modelVersion=arr.getJSONObject(i).getString("modelVersion");
			String mmv_name=make+" "+model+" "+modelVersion;
			Object reg_date = reg_year+"-"+reg_month;


			loancarlist.put(""+2+ i, new Object[] {id,dealer_id,make_month,make_year,version_id,reg_no,
					reg_month,reg_year,km_driven,uc_colour,car_price,fuel_type,transmission,car_body_type,model,
					model_id,make_id,make,modelVersion,mmv_name,reg_year});

		}
		ExcelUtils.writeSheetData(Constants.ExcelTestData,"loanStock", loancarlist);
		ReportBaseClass.logger.info("Loan Stock excelsheet add executed");

	}
}
