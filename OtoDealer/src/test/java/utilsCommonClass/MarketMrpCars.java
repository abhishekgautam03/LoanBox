package utilsCommonClass;

import java.io.IOException;

import org.testng.annotations.Test;

import Utility.Constants;
import io.restassured.response.Response;
import utility.ExcelUtils;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.JsonVariableReplacement;
import utilsApi.LoadJsonFile;

public class MarketMrpCars {
static long carMarketMrp;

	@Test
	public void getCarMrp(String financerId,String version_slug,String cityid,String makeyear) throws IOException {


		String bodyData=LoadJsonFile.handleJson(Constants.carMarketMrpJson);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "dealerid",Login.dealerid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "financier_id",financerId);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "version_slug",version_slug);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "cityid",cityid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "makeyear",makeyear);
		System.out.println("body data "+bodyData);
		Response response=ApiCall.postApiWithBaseUrl(bodyData,ApiPaths.market_mrp_cars);
		System.out.println(response.asString());
	//	carMarketMrp =ApiTestUtils.getLongIntValueFromAResponse(response, "data.avg_price");
	//	System.out.println("avg price "+ApiTestUtils.getLongIntValueFromAResponse(response, "data.avg_price"));
		ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);

		if(carMarketMrp==0) {
			carMarketMrp =Integer.parseInt(ExcelUtils.readCellData(Constants.ExcelTestData,"multiQuoteData",0,1));		
		}
		

	}
}
