package utilsCommonClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import Base.ReportBaseClass;
import Utility.Constants;
import io.restassured.response.Response;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.JsonVariableReplacement;
import utilsApi.LoadJsonFile;
import utilsApi.ReadExcelFile;
import utilsCommonClass.Login;

public class SyncMMV extends ReportBaseClass{


	Map<String, Object[]> versiondata = new TreeMap<String, Object[]>();
	@Test
	public void getSyncMMV(String financerid) throws FileNotFoundException {
		
		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test get sync mmv");
		String bodyData=LoadJsonFile.handleJson(Constants.syncMMVJson);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "dealerid",Login.dealerid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "financer_id",financerid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "rpp",1250);
		Response response=ApiCall.getApiMethod(bodyData,ApiPaths.all_mmv,Login.token);

		//	ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);
		ApiTestUtils.getStatusLineAssertTrue(response, "OK");
	//	System.out.println(ApiTestUtils.getListSize(response, "data"));

		JSONObject resObject = new JSONObject(response.asString());
		//	System.out.println(resObject.toString());
	//	JSONArray jsonArrayVersion = resObject.getJSONArray("data");

		ApiTestUtils.checkResponse(response, "Success");

		XSSFWorkbook workbook = new XSSFWorkbook(); 

		//Create a blank sheet

		XSSFSheet sheetVersion = workbook.createSheet("Version");

		versiondata.put(""+ 0, new Object[] {"v_id","mk_id","md_id","mk_n","b_type","category_name",
				"md_n","v_n","v_t_id","f_id","max_age","min_dp","ltv","bd_org", "usage_type_id"});

	/*	for (int i = 0; i < jsonArrayVersion.length(); ++i) {
			int versionid=jsonArrayVersion.getJSONObject(i).getInt("v_id");
			int makeid=jsonArrayVersion.getJSONObject(i).getInt("mk_id");
			int modelid=jsonArrayVersion.getJSONObject(i).getInt("md_id");
			String makeName=jsonArrayVersion.getJSONObject(i).getString("mk_n");
			String b_type=jsonArrayVersion.getJSONObject(i).getString("b_type");
			String category_name=jsonArrayVersion.getJSONObject(i).getString("category_name");
			String modelName=jsonArrayVersion.getJSONObject(i).getString("md_n");
			String versionName=jsonArrayVersion.getJSONObject(i).getString("v_n");
			Object v_t_id=jsonArrayVersion.getJSONObject(i).get("v_t_id");
			Object f_id=jsonArrayVersion.getJSONObject(i).get("f_id");
			Object max_age=jsonArrayVersion.getJSONObject(i).get("max_age");		
			Object min_dp=jsonArrayVersion.getJSONObject(i).get("min_dp");
			Object ltv=jsonArrayVersion.getJSONObject(i).get("ltv");
			Object bd_org=jsonArrayVersion.getJSONObject(i).get("bd_org");
			Object usage_type_id=jsonArrayVersion.getJSONObject(i).get("usage_type_id");

			versiondata.put(""+1+ i, new Object[] {versionid,makeid,modelid,makeName,b_type,category_name,
					modelName,versionName,v_t_id,f_id,max_age,min_dp,ltv,bd_org,usage_type_id});
		}*/
		ReadExcelFile.createData(versiondata,sheetVersion);
		ReportBaseClass.logger.info("Test sync mmv ");

		try{
			//Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(Constants.FinancerMMVExcelFile));
			workbook.write(out);
			out.close();
			System.out.println("Financer MMV written successfully on disk.");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}


	}


}

