package utilsRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import Maybank.MaybankCalculateLoan;
import Utility.Constants;
import utilsCommonClass.GetConfig;
import utilsCommonClass.GetMrpRuleEngine;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;
import utilsCommonClass.MarketMrpCars;
import utilsCommonClass.SyncMMV;

public class Maybank {

	int versionid=16698;
	String areaid="82";
	
	String version_slug="aston-martin-rapide-other";
	String cityid = "4000082";
	String makeyear="2020";
	String financerid = Constants.Maybank;

	
	@Test
	public void testMaybank() throws IOException{
		Login login = new Login();
		login.testLogin();
		
		GetConfig config= new GetConfig();
		config.getConfigData();
		
		LoanStockList stock = new LoanStockList();
		stock.getLoanStock();
		
		SyncMMV mmv= new SyncMMV();
		mmv.getSyncMMV(financerid);
		
		GetMrpRuleEngine getMrp=new GetMrpRuleEngine();
		getMrp.getCarMrp(financerid,versionid,areaid);
		
		MarketMrpCars mrpcar= new MarketMrpCars();
		mrpcar.getCarMrp(financerid,version_slug,cityid,makeyear);
		
		MaybankCalculateLoan loan = new MaybankCalculateLoan();
		loan.getQuote();
		
		//AddLead add = new AddLead();
		//add.addLead();
		
		//SaveDocument doc = new SaveDocument();
		//doc.saveDocData();
		
		//SaveMultipleDocument saveMultiple = new SaveMultipleDocument();
		//saveMultiple.saveAllDoc();
	}

}