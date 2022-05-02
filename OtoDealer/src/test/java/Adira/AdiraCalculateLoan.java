package Adira;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class AdiraCalculateLoan {
	
	public void getCalculateLoan(int c) throws IOException {


		int testCar=Integer.parseInt(ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",0,1));	
	
		String bodyData=LoadJsonFile.handleJson(Constants.adiraCalLoan);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "dealerid",Login.dealerid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "makeid",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",1,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "modelid",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",2,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "versionid",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",3,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "makeyear",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",4,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "financer_id",Constants.Adira);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "applicant_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",5,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "customer_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",6,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "plate_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",7,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "vehicle_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",8,c));	
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "insurance_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",9,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",10,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "price_upping_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",11,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "mrp_with_upping",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",12,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "olx_mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",13,c));	
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "tenure",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",14,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "loan_needed",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",15,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "actual_dp_per",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",16,c));
	
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "existing_customer",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",17,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "occupation",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",18,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "usage_type",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",19,c));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "payment_type",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Adira",20,c));

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "user_type",Login.user_type);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "user_id",Login.user_id);


		Response resp=ApiCall.postApiWithHeader(bodyData,ApiPaths.calculate_loan,Login.token);

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
		int length=ExcelUtils.getNumberOfColumn(Constants.OtoFinancerExcelFile,"Adira",1);

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
