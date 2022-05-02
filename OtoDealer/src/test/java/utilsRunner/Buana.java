package utilsRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import Buana.BuanaCalculateLoan;
import utilsCommonClass.SyncMMV;
import Utility.Constants;
import utilsCommonClass.GetConfig;
import utilsCommonClass.GetMrpRuleEngine;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;
import utilsCommonClass.MarketMrpCars;

public class Buana {
	int versionid=9677;
	String areaid="10";
	
	String version_slug="a5-2.0-tfsi-x-line-bensin";
	String cityid = "4000084";
	String makeyear="2020";
	
	@Test
	public void testCNAF() throws IOException{
		Login login = new Login();
		login.testLogin();
		
		GetConfig config= new GetConfig();
		config.getConfigData();
		
		LoanStockList stock = new LoanStockList();
		stock.getLoanStock();
		
		SyncMMV mmv= new SyncMMV();
		mmv.getSyncMMV(Constants.Buana);
		
	//	GetMrpRuleEngine getMrp=new GetMrpRuleEngine();
	//	getMrp.getCarMrp(Constants.Buana,versionid,areaid);
		
		MarketMrpCars mrpcar= new MarketMrpCars();
		mrpcar.getCarMrp(Constants.Buana,version_slug,cityid,makeyear);
		
		BuanaCalculateLoan loan = new BuanaCalculateLoan();
		loan.getQuote();
		
		//AddLead add = new AddLead();
		//add.addLead();
		
		//SaveDocument doc = new SaveDocument();
		//doc.saveDocData();
		
		//SaveMultipleDocument saveMultiple = new SaveMultipleDocument();
		//saveMultiple.saveAllDoc();
	}
}
