package Maybank;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import utility.FileUtils;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsCommonClass.Login;

import org.json.JSONObject;
import org.testng.annotations.Test;

import Utility.Constants;
import io.restassured.response.Response;
import utility.ExcelUtils;

public class MaybankCalculateLoan {

	public void getCalculateLoan(int c) throws IOException {

		int testCar=Integer.parseInt(ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",0,1));	

    	JSONObject bodyData = new JSONObject();
		bodyData.put("dealerid",Login.dealerid);
		bodyData.put( "makeid",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",1,c));
		bodyData.put( "modelid",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",2,c));
		bodyData.put("versionid",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",3,c));
		bodyData.put( "makeyear",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",4,c));
		bodyData.put( "financer_id",Constants.Maybank);
		bodyData.put( "applicant_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",5,c));
		bodyData.put( "customer_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",6,c));
		bodyData.put( "plate_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",7,c));
		bodyData.put( "vehicle_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",8,c));	
		bodyData.put( "insurance_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",9,c));
		bodyData.put( "mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",10,c));
		bodyData.put( "price_upping_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",11,c));
		bodyData.put( "mrp_with_upping",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",12,c));
		bodyData.put( "olx_mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",13,c));	
		bodyData.put( "tenure",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",14,c));
		bodyData.put( "loan_needed",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",15,c));
		bodyData.put( "actual_dp_per",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Maybank",16,c));

		bodyData.put( "user_type",Login.user_type);
		bodyData.put( "user_id",Login.user_id);

		Response resp=ApiCall.postApiWithHeader(bodyData.toString(),ApiPaths.calculate_loan,Login.token);

		ApiTestUtils.getAllApiResponse(resp);
		ApiTestUtils.checkStatusCode(resp, 200);
		//Utils.logPrint(ApiTestUtils.getValueFromAResponse(resp,"data[0].financier_id"));
		//Utils.logPrint(ApiTestUtils.getAValueFromList(resp,"data.financier_id").toString());
		//Utils.logPrint(ApiTestUtils.getAValueFromList(resp,"data.financier_name").toString());
		//Utils.logPrint(ApiTestUtils.getListSize(resp,"data"));
		
		System.out.println("class name "+this.getClass().getName());
		FileUtils.createJsonFile(this.getClass().getName(),resp);
	}
	@Test
	public void getQuote() throws IOException {
		int length=ExcelUtils.getNumberOfColumn(Constants.OtoFinancerExcelFile,"Maybank",1);

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
