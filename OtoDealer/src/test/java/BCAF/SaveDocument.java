package BCAF;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsCommonClass.Login;

public class SaveDocument {
	String leadId = AddLead.lead_id;
	@Test       
	public void saveDocData() throws IOException {

		JSONObject arrayparams= new JSONObject();
		arrayparams.put("finance_lead_id",leadId);
		arrayparams.put("doc_id","7");
		arrayparams.put("parent_id","0");
		arrayparams.put("doc_path","finance/"+leadId+"/1645099775496.JPEG");
		arrayparams.put("doc_aws_path","https://otobackendbeta.storage.googleapis.com/finance/"+leadId+"/1645099775496.JPEG");

		JSONArray array =new JSONArray();
		array.put(0, arrayparams);
		
		JSONObject bodyParams= new JSONObject();
		
		bodyParams.put("lead_docs",array);
		bodyParams.put("finance_lead_id",leadId);
		bodyParams.put("user_id",Login.user_id);
		bodyParams.put("dealer_id",Login.dealerid);
		bodyParams.put("dealer_id_hash",Login.dealer_id_hash);
		bodyParams.put("is_calculator_image","1");
		bodyParams.put("source",ApiPaths.source_gcloud);
		bodyParams.put("user_type",Login.user_type);
		
		System.out.println(bodyParams.toString());

		Response response=ApiCall.postApiWithHeader(bodyParams.toString(),ApiPaths.savedoc,Login.token);

		ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);

	}


}
