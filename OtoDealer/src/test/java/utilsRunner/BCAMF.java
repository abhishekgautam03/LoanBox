package utilsRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import BCAMF.BCAMFCalculateLoan;
import Utility.Constants;
import utilsCommonClass.GetConfig;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;
import utilsCommonClass.MarketMrpCars;
import utilsCommonClass.SyncMMV;

public class BCAMF {

	int versionid=12213;
	String areaid="25";

	String version_slug="honda-jazz-66877-a";
	String cityid = "4000307";
	String makeyear="2020";
	String financerId=Constants.BCAMF;
	int modelid= 1552;

	@Test
	public void testBCAMF() throws IOException{

		Login login = new Login();
		login.testLogin();

		GetConfig config= new GetConfig();
		config.getConfigData();

		LoanStockList stock = new LoanStockList();
		stock.getLoanStock();

		SyncMMV mmv= new SyncMMV();
		mmv.getSyncMMV(financerId);

		//	GetModelcode code = new GetModelcode();
		//	code.getModelCode(financerId, modelid, versionid, areaid);

		//	GetMrpRuleEngine getMrp=new GetMrpRuleEngine();
		//	getMrp.getCarMrp(financerId,versionid,areaid);

		MarketMrpCars mrpcar= new MarketMrpCars();
		mrpcar.getCarMrp(financerId,version_slug,cityid,makeyear);

		BCAMFCalculateLoan loan = new BCAMFCalculateLoan();
		loan.getQuote();

		//AddLead add = new AddLead();
		//add.addLead();

		//SaveDocument doc = new SaveDocument();
		//doc.saveDocData();

		//SaveMultipleDocument saveMultiple = new SaveMultipleDocument();
		//saveMultiple.saveAllDoc();
	}

}