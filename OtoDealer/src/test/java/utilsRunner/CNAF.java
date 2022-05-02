package utilsRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import CNAF.CNAFCalculateLoan;
import utilsCommonClass.SyncMMV;
import Utility.Constants;
import utilsCommonClass.GetConfig;
import utilsCommonClass.GetMrpRuleEngine;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;
import utilsCommonClass.MarketMrpCars;

public class CNAF {
	int versionid=9677;
	String areaid="10";
	
	String version_slug="aston-martin-rapide-other";
	String cityid = "4000082";
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
		mmv.getSyncMMV(Constants.CNAF);
		
		GetMrpRuleEngine getMrp=new GetMrpRuleEngine();
		getMrp.getCarMrp(Constants.CNAF,versionid,areaid);
		
		MarketMrpCars mrpcar= new MarketMrpCars();
		mrpcar.getCarMrp(Constants.CNAF,version_slug,cityid,makeyear);
		
		CNAFCalculateLoan loan = new CNAFCalculateLoan();
		loan.getQuote();
		
		//AddLead add = new AddLead();
		//add.addLead();
		
		//SaveDocument doc = new SaveDocument();
		//doc.saveDocData();
		
		//SaveMultipleDocument saveMultiple = new SaveMultipleDocument();
		//saveMultiple.saveAllDoc();
	}
}
