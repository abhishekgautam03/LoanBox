package MultiQuote;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.ReportBaseClass;
import Utility.Constants;
import io.restassured.response.Response;
import utility.ExcelUtils;
import utilsApi.ApiCall;
import utilsApi.ApiPaths;
import utilsApi.ApiTestUtils;
import utilsApi.JsonVariableReplacement;
import utilsApi.LoadJsonFile;
import utilsCommonClass.Login;

public class CarMarketMrp extends ReportBaseClass{

	static long carMarketMrp;


	@Test
	public void testCarMrketMrp(String version_slug,String cityid) throws IOException {
		
		int testCar=Integer.parseInt(ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",0,1));	
		String bodyData=LoadJsonFile.handleJson(Constants.carMarketMrpJson);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "dealerid",Login.dealerid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "version_slug",version_slug);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "cityid",cityid);
		bodyData = JsonVariableReplacement.replaceJson(bodyData, "makeyear",ExcelUtils.readCellData(Constants.ExcelTestData,"loanStock",testCar,3));
		System.out.println("body data "+bodyData);
		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test Car Market Price");
		Response response=ApiCall.postApiWithBaseUrl(bodyData,ApiPaths.market_mrp_cars);

		System.out.println(response.asString());
		carMarketMrp =ApiTestUtils.getLongIntValueFromAResponse(response, "data.avg_price");
		System.out.println("avg price "+ApiTestUtils.getLongIntValueFromAResponse(response, "data.avg_price"));
		ApiTestUtils.getAllApiResponse(response);
		ApiTestUtils.checkStatusCode(response, 200);
		ReportBaseClass.logger.info("Car Market Price Test executed");
		if(carMarketMrp==0) {
			carMarketMrp =Integer.parseInt(ExcelUtils.readCellData(Constants.ExcelTestData,"multiQuoteData",0,1));		
		}
		//System.out.println(carMarketMrp);

	}

}
