package SMSF;

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
import utilsCommonClass.Login;

public class SMSFCalculateLoan {

	public void getCalculateLoan(int c) throws IOException {

		int testCar=Integer.parseInt(ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",0,1));	

		//String bodyData=LoadJsonFile.handleJson(Constants.buanaCalLoan);
		JSONObject bodyData = new JSONObject();
		bodyData.put("dealer_id",Login.dealerid);
		bodyData.put( "make_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",1,c));
		bodyData.put( "model_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",2,c));
		bodyData.put("version_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",3,c));
		bodyData.put( "make_year",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",4,c));
		bodyData.put( "financer_id",Constants.SMSF);
		bodyData.put( "applicant_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",5,c));
		bodyData.put( "customer_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",6,c));
		bodyData.put( "plate_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",7,c));
		bodyData.put( "vehicle_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",8,c));	
		bodyData.put( "insurance_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",9,c));
		bodyData.put( "mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",10,c));
		bodyData.put( "price_upping_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",11,c));
		bodyData.put( "mrp_with_upping",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",12,c));
		bodyData.put( "olx_mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",13,c));	
		bodyData.put( "tenure",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",14,c));
		bodyData.put( "loan_needed",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",15,c));
		bodyData.put( "actual_dp_per",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",16,c));
		bodyData.put( "usage_type",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",17,c));
		bodyData.put( "payment_type",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"SMSF",18,c));

		
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
		int length=ExcelUtils.getNumberOfColumn(Constants.OtoFinancerExcelFile,"SMSF",1);

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
