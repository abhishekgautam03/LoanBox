package BCAF;

import java.io.IOException;
import Utility.Constants;
import io.restassured.response.Response;
import utility.ExcelUtils;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.JsonVariableReplacement;
import utilsApi.LoadJsonFile;
import utilsCommonClass.Login;

public class AddLead {

	static String lead_id;
	static String dealer_id;
	static String customer_id;
	static String car_id;

	public void addLead() throws IOException {


		int testCar=Integer.parseInt(ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",0,1));	
		String bodyData=LoadJsonFile.handleJson(Constants.addLead);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "name",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",1,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "phone",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",2,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "application_type",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",3,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "lead_source_id",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",4,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "financerid",Constants.BCAF);

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "branch_id",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",5,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "already_po",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",6,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "notes",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",7,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "car_id",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,0));

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "make_id",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,16));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "model_id",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,15));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "version_id",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,4));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "mmv_name",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,19));

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "reg_number",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,5));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "region_id",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",8,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "reg_date",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,20));

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "make_year",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,3));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "transmission",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,12));

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "loan_type",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",9,1));

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "make",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,17));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "model",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,14));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "modelVersion",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,18));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "uc_colour",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,9));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "is_multiquote",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",10,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "user_id",Login.user_id);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "user_type",Login.user_type);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "agent_id",Login.user_type_id);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "car_body_type",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,13));

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "installment_type",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",11,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "amount_needed",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",12,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "car_price",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,10));

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "first_tdp",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",14,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "emi",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",15,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "tenure",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",16,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "refund_to_oto",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",17,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "booster_amount",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",18,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "payout_to_dealer",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",19,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "has_rule_engine",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",20,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "is_active_calculator",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",21,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "is_mrp",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",22,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "approved_amount",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",23,1));
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "real_tdp",ExcelUtils.readCellData(Constants.AddLeadExcelFile,"addLead",24,1));

		bodyData = JsonVariableReplacement.replaceJson(bodyData, "dealer_id",Login.dealerid);

		Response response=ApiCall.postApiWithHeader(bodyData,ApiPaths.addlead,Login.token);
		lead_id =ApiTestUtils.getValueFromAResponse(response,"data.lead_id");
		dealer_id =ApiTestUtils.getValueFromAResponse(response,"data.dealer_id");
		customer_id =ApiTestUtils.getValueFromAResponse(response,"data.customer_id");
		car_id =ApiTestUtils.getValueFromAResponse(response,"data.car_id");


		ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);

	}

}
