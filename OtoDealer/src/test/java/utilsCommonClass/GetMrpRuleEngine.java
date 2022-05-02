package utilsCommonClass;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.ReportBaseClass;
import Utility.Constants;
import io.restassured.response.Response;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.JsonVariableReplacement;
import utilsApi.LoadJsonFile;

public class GetMrpRuleEngine extends ReportBaseClass {
	

	@Test
	public void getCarMrp(String financerId,int versionid,String areaid) throws IOException {

		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test Get Mrp rule Engine");
		String bodyData=LoadJsonFile.handleJson(Constants.getMrp);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "dealerid",Login.dealerid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "financier_id",financerId);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "versionid",versionid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "areaid",areaid);
		System.out.println("body data "+bodyData);
		Response response=ApiCall.postApiWithHeader(bodyData,ApiPaths.getmrp_cars,Login.token);

		System.out.println(response.asString());
	
		ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);

		ReportBaseClass.logger.info("Test get mrp ");
	

	}
}
