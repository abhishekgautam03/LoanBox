package utilsRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.ReportBaseClass;
import MUF.CalculateLoan;
import MUF.GetModelCode;
import Utility.Constants;
import utilsCommonClass.GetConfig;
import utilsCommonClass.GetMrpRuleEngine;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;
import utilsCommonClass.SyncMMV;



public class MUFQuote extends ReportBaseClass{
	
	int versionid=21941;
	String areaid="12";
	int modelid=282;
	@Test
	public void testMUFQuote() throws IOException{
		/*Login login = new Login();
		login.testLogin();
		
		LoanStockList stock = new LoanStockList();
		stock.getLoanStock();*/
		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test MUF Quate");
		GetConfig config= new GetConfig();
		config.getConfigData();
		
		SyncMMV mmv= new SyncMMV();
		mmv.getSyncMMV(Constants.MUF);
		
		GetModelCode modelcode=new GetModelCode();
		modelcode.getModelCode(Constants.MUF,modelid,versionid,areaid);
				
		GetMrpRuleEngine carMarket = new GetMrpRuleEngine();
		carMarket.getCarMrp(Constants.MUF, versionid, areaid);;
		
		CalculateLoan calculateLoan = new CalculateLoan();
		calculateLoan.getQuote();
		
		
		ReportBaseClass.logger.info("Test muf runner ");
		
		
	}

}
