package MUF;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import Base.ReportBaseClass;
import Utility.Constants;
import io.restassured.response.Response;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.JsonVariableReplacement;
import utilsApi.LoadJsonFile;
import utilsCommonClass.Login;

public class GetModelCode extends ReportBaseClass {
	
	@Test
	public void getModelCode(String financerid,int modelid,int versionid,String areaid) throws FileNotFoundException {
		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test Get Model code");
		String bodyData=LoadJsonFile.handleJson(Constants.getModelcode);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "dealerid",Login.dealerid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "modelid",modelid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "areaid",areaid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "versionid",versionid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "financer_id",financerid);
		Response response=ApiCall.postApiWithHeader(bodyData,ApiPaths.get_model_code,Login.token);
		ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);
		ApiTestUtils.getStatusLineAssertTrue(response, "OK");
		ReportBaseClass.logger.info("Test get model ");
	}

}
