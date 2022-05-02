package utilsCommonClass;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import Base.ReportBaseClass;
import Utility.Constants;
import Utility.Utils;
import io.restassured.response.Response;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.JsonVariableReplacement;
import utilsApi.LoadJsonFile;



public class GetConfig extends ReportBaseClass{
	String[] config_data = {"agent_list","status_list", "financier_list","lead_source", "region_list",  "document_list",
			"language_list","loan_tenure","declaration","insurance_type", "loan_type",  "jakarta_plate_no", 
			"price_upping", "installment_type"};
	@Test       
	public void getConfigData() throws FileNotFoundException {
	
	
		Map<String,Object> bodyParams=new HashMap<String,Object>();
		bodyParams.put("config_data",config_data);
		bodyParams.put("dealer_id",Login.dealerid);
		bodyParams.put("source",ApiPaths.source_gcloud);
		System.out.println(bodyParams);
		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test get config");
		Response response=ApiCall.postApiWithHeader(bodyParams,ApiPaths.get_config,Login.token);

		ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);
		Utils.logPrint(ApiTestUtils.getValueFromAResponse(response,"data.agent_list[0].name"));
		Utils.logPrint(ApiTestUtils.getAValueFromList(response,"data.financier_list.id").toString());
		Utils.logPrint(ApiTestUtils.getAValueFromList(response,"data.financier_list.name").toString());
		Utils.logPrint(ApiTestUtils.getListSize(response,"data.agent_list"));
		ReportBaseClass.logger.info("Test get config ");
	}

}
