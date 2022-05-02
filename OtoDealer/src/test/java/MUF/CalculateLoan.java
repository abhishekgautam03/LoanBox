package MUF;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;
import org.testng.annotations.Test;

import Base.ReportBaseClass;
import Utility.Constants;
import Utility.Utils;
import io.restassured.response.Response;

import utility.ExcelUtils;
import utility.FileUtils;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.JsonVariableReplacement;
import utilsApi.LoadJsonFile;
import utilsCommonClass.Login;

public class CalculateLoan extends ReportBaseClass{



	public Response getCalculateLoan(int c) throws IOException {

		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test MUF Quote "
				+ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",0,c));
		int testCar=Integer.parseInt(ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",0,1));	
		// int c=1;
		
		JSONObject bodyData = new JSONObject();


		bodyData.put("dealer_id",Login.dealerid);
		bodyData.put( "make_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",4,c));
		bodyData.put( "model_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",5,c));
		bodyData.put( "version_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",6,c));
		bodyData.put( "make_year",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",8,c));
		bodyData.put( "financier_id",Integer.parseInt(Constants.MUF));
		bodyData.put( "occupation",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",2,c));
		bodyData.put( "applicant_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",14,c));
		bodyData.put( "customer_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",15,c));
		bodyData.put( "plate_area_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",3,c));
		bodyData.put( "vehicle_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",7,c));
		bodyData.put( "insurance_type_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",9,c));
		bodyData.put( "mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",11,c));
		bodyData.put( "olx_mrp",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",16,c));	
		bodyData.put( "price_upping_id",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",12,c));
		bodyData.put( "mrp_with_upping",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",13,c));
		bodyData.put( "tenure",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",10,c));
		bodyData.put( "loan_needed",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",17,c));
		bodyData.put( "actual_dp_per",ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",18,c));
		bodyData.put( "user_type",Login.user_type);
		bodyData.put( "user_id",Login.user_id);



		Response resp=ApiCall.postApiWithHeader(bodyData.toString(),ApiPaths.calculate_loan,Login.token);


		//Utils.logPrint(ApiTestUtils.getAValueFromList(resp,"data.financier_id").toString());
		//Utils.logPrint(ApiTestUtils.getAValueFromList(resp,"data.financier_name").toString());
		//Utils.logPrint(ApiTestUtils.getListSize(resp,"data"));
		//FileUtils.createJsonFile("mufCalLoan",resp);
		return resp;

	}
	@Test
	public void getQuote() throws IOException {
		int length=ExcelUtils.getNumberOfColumn(Constants.OtoFinancerExcelFile,"Mufquote",1);

		try {
			System.out.println("col length "+length);
			for(int col =1;col<length;col++) {
				Response resp=getCalculateLoan(col);

				ApiTestUtils.getAllApiResponse(resp);
				ApiTestUtils.checkStatusCode(resp, 200);
				Utils.logPrint("dp amount",ApiTestUtils.getValueFromAResponse(resp,"data.dp_amount"));
				Utils.logPrint("ltv per",ApiTestUtils.getValueFromAResponse(resp,"data.ltv_per"));
				ApiTestUtils.testAssertEquals(ApiTestUtils.getValueFromAResponse(resp,"data.ltv_per"),
						ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",24,col));
				ApiTestUtils.testAssertEquals(ApiTestUtils.getValueFromAResponse(resp,"data.tenure"),
						ExcelUtils.readCellData(Constants.OtoFinancerExcelFile,"Mufquote",22,col));
				Utils.logPrint("installment",ApiTestUtils.getValueFromAResponse(resp,"data.installment"));
				Utils.logPrint("total_payment_to_dealer"+ApiTestUtils.getValueFromAResponse(resp,"data.total_payment_to_dealer"));
				Utils.logPrint("total_dp"+ApiTestUtils.getValueFromAResponse(resp,"data.total_dp"));
				Utils.logPrint("disbursement",ApiTestUtils.getValueFromAResponse(resp,"data.disbursement"));
				Utils.logPrint("tenure"+ApiTestUtils.getValueFromAResponse(resp,"data.tenure"));
				Utils.logPrint("dp_per"+ApiTestUtils.getValueFromAResponse(resp,"data.dp_per"));
				Utils.logPrint("total_income"+ApiTestUtils.getValueFromAResponse(resp,"data.total_income"));
				Utils.logPrint("total_loan_amount"+ApiTestUtils.getValueFromAResponse(resp,"data.total_loan_amount"));
				//ReportBaseClass.logger.info("failed due to ");
			}

			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException ie) {
			Thread.currentThread().interrupt();
		}

	}
}
