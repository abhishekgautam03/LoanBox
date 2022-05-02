package utilsRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import BCAF.AddLead;
import BCAF.SaveDocument;
import BCAF.SaveMultipleDocument;
import utilsCommonClass.GetConfig;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;

public class BCAF {
	
	@Test
	public void testBCAF() throws IOException{
		Login login = new Login();
		login.testLogin();
		GetConfig config= new GetConfig();
		config.getConfigData();
		LoanStockList stock = new LoanStockList();
		stock.getLoanStock();
		AddLead add = new AddLead();
		add.addLead();
		SaveDocument doc = new SaveDocument();
		doc.saveDocData();
		SaveMultipleDocument saveMultiple = new SaveMultipleDocument();
		saveMultiple.saveAllDoc();
	}
}