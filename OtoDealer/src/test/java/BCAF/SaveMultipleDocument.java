package BCAF;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsCommonClass.Login;

public class SaveMultipleDocument {
	String leadId = AddLead.lead_id;
	@Test       
	public void saveAllDoc() throws IOException {

		JSONObject array= new JSONObject();
		array.put("finance_lead_id",leadId);
		array.put("doc_id","22");
		array.put("parent_id","1");
		array.put("doc_path","finance/"+leadId+"/1645271594724.JPEG");
		array.put("doc_aws_path","https://otobackendbeta.storage.googleapis.com/finance/"+leadId+"/1645271594724.JPEG");
		
		JSONObject array1= new JSONObject();
		array1.put("finance_lead_id",leadId);
		array1.put("doc_id","26");
		array1.put("parent_id","8");
		array1.put("doc_path","finance/"+leadId+"/1645271596246.JPEG");
		array1.put("doc_aws_path","https://otobackendbeta.storage.googleapis.com/finance/"+leadId+"/1645271596246.JPEG");
		
		JSONObject array2= new JSONObject();
		array2.put("finance_lead_id",leadId);
		array2.put("doc_id","27");
		array2.put("parent_id","8");
		array2.put("doc_path","finance/"+leadId+"/1645271597662.JPEG");
		array2.put("doc_aws_path","https://otobackendbeta.storage.googleapis.com/finance/"+leadId+"/1645271597662.JPEG");
		
		JSONObject array3= new JSONObject();
		array3.put("finance_lead_id",leadId);
		array3.put("doc_id","31");
		array3.put("parent_id","48");
		array3.put("doc_path","finance/"+leadId+"/1645271599231.JPEG");
		array3.put("doc_aws_path","https://otobackendbeta.storage.googleapis.com/finance/"+leadId+"/1645271599231.JPEG");

		JSONArray arrayData =new JSONArray();
		arrayData.put(0, array);
		arrayData.put(1, array1);
		arrayData.put(2, array2);
		arrayData.put(3, array3);
		
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
