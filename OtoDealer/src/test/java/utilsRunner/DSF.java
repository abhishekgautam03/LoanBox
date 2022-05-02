package utilsRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import DSF.DSFCalculateLoan;
import Utility.Constants;
import utilsCommonClass.GetConfig;
import utilsCommonClass.GetMrpRuleEngine;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;
import utilsCommonClass.MarketMrpCars;

public class DSF {
	
	int versionid=23004;
	String areaid="1";
	
	String version_slug="aston-martin-rapide-other";
	String cityid = "4000081";
	String makeyear="2019";
	
	@Test
	public void testDSF() throws IOException{
		Login login = new Login();
		login.testLogin();
		
		GetConfig config= new GetConfig();
		config.getConfigData();
		
		LoanStockList stock = new LoanStockList();
		stock.getLoanStock();
		
		GetMrpRuleEngine getMrp=new GetMrpRuleEngine();
		getMrp.getCarMrp(Constants.DSF,versionid,areaid);
		
		MarketMrpCars mrpcar= new MarketMrpCars();
		mrpcar.getCarMrp(Constants.DSF, version_slug, cityid,makeyear);
		
		DSFCalculateLoan calculateLoan = new DSFCalculateLoan();
		calculateLoan.getQuote();
		
		//AddLead add = new AddLead();
		//add.addLead();
		
		//SaveDocument doc = new SaveDocument();
		//doc.saveDocData();
		
		//SaveMultipleDocument saveMultiple = new SaveMultipleDocument();
		//saveMultiple.saveAllDoc();
	}

}
