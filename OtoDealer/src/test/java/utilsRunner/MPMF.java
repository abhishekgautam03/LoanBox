package utilsRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import MPMF.MPMFCalculateLoan;
import Utility.Constants;
import utilsCommonClass.GetConfig;
import utilsCommonClass.GetModelcode;
import utilsCommonClass.GetMrpRuleEngine;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;
import utilsCommonClass.MarketMrpCars;
import utilsCommonClass.SyncMMV;

public class MPMF {
	int versionid=12213;
	String areaid="25";
	
	String version_slug="chrysler-grandcherokee-67009-limited";
	String cityid = "4000088";
	String makeyear="2020";
	String financerId=Constants.MPMF;
	int modelid= 1552;
	
	@Test
	public void testMPMF() throws IOException{
		
		Login login = new Login();
		login.testLogin();
		
		GetConfig config= new GetConfig();
		config.getConfigData();
		
		LoanStockList stock = new LoanStockList();
		stock.getLoanStock();
		
		SyncMMV mmv= new SyncMMV();
		mmv.getSyncMMV(financerId);
		
		GetModelcode code = new GetModelcode();
		code.getModelCode(financerId, modelid, versionid, areaid);
		
		GetMrpRuleEngine getMrp=new GetMrpRuleEngine();
		getMrp.getCarMrp(financerId,versionid,areaid);
		
		MarketMrpCars mrpcar= new MarketMrpCars();
		mrpcar.getCarMrp(financerId,version_slug,cityid,makeyear);
		
		MPMFCalculateLoan loan = new MPMFCalculateLoan();
		loan.getQuote();
		
		//AddLead add = new AddLead();
		//add.addLead();
		
		//SaveDocument doc = new SaveDocument();
		//doc.saveDocData();
		
		//SaveMultipleDocument saveMultiple = new SaveMultipleDocument();
		//saveMultiple.saveAllDoc();
	}

}