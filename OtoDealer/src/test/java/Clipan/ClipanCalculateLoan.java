package Clipan;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.testng.annotations.Test;

import Utility.Constants;
import io.restassured.response.Response;
import utility.ExcelUtils;
import utility.FileUtils;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.JsonVariableReplacement;
import utilsApi.LoadJsonFile;
import utilsCommonClass.Login;

public class ClipanCalculateLoan {
	
	public void getCalculateLoan(int c) throws IOException {

	int testCar=Integer.parseInt(ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",0,1));	

	//String bodyData=LoadJsonFile.handleJson(Constants.buanaCalLoan);
	JSONObject bodyData = new JSONObject();
	bodyData.put("dealerid",Login.dealerid);
	bodyData.put( "makeid",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",1,c));
	bodyData.put( "modelid",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",2,c));
	bodyData.put("versionid",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",3,c));
	bodyData.put( "makeyear",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",4,c));
	bodyData.put( "financer_id",Constants.Clipan);
	bodyData.put( "applicant_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",5,c));
	bodyData.put( "customer_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",6,c));
	bodyData.put( "plate_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",7,c));
	bodyData.put( "vehicle_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",8,c));	
	bodyData.put( "insurance_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",9,c));
	bodyData.put( "mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",10,c));
	bodyData.put( "price_upping_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",11,c));
	bodyData.put( "mrp_with_upping",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",12,c));
	bodyData.put( "olx_mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",13,c));	
	bodyData.put( "tenure",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",14,c));
	bodyData.put( "loan_needed",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",15,c));
	bodyData.put( "actual_dp_per",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Buana",16,c));
	
	bodyData.put( "user_type",Login.user_type);
	bodyData.put( "user_id",Login.user_id);


	Response resp=ApiCall.postApiWithHeader(bodyData.toString(),ApiPaths.calculate_loan,Login.token);

	ApiTestUtils.getAllApiResponse(resp);
	ApiTestUtils.checkStatusCode(resp, 200);
	//Utils.logPrint(ApiTestUtils.getValueFromAResponse(resp,"data[0].financier_id"));
	//Utils.logPrint(ApiTestUtils.getAValueFromList(resp,"data.financier_id").toString());
	//Utils.logPrint(ApiTestUtils.getAValueFromList(resp,"data.financier_name").toString());
	//Utils.logPrint(ApiTestUtils.getListSize(resp,"data"));
	FileUtils.createJsonFile("CNAFCalLoan",resp);


}
@Test
public void getQuote() throws IOException {
	int length=ExcelUtils.getNumberOfColumn(Constants.OtoFinancerExcelFile,"Buana",1);

	try {
		System.out.println("col length "+length);
		for(int col =1;col<length;col++) {
			getCalculateLoan(col);

		}

		TimeUnit.SECONDS.sleep(10);
	} catch (InterruptedException ie) {
		Thread.currentThread().interrupt();
	}

}
}