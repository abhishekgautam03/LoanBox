package utilsRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import Base.ReportBaseClass;
import MultiQuote.CarMarketMrp;
import MultiQuote.GetQuote;
import MultiQuote.MultiQuoteFormField;
import utilsCommonClass.LoanStockList;
import utilsCommonClass.Login;

public class TestMultiQuote extends ReportBaseClass  {
	int versionid=9677;
	String areaid="10";
	
	String version_slug="aston-martin-rapide-other";
	String cityid = "4000082";
	String makeyear="2020";
	@Test
	public void testMultiQuote() throws IOException{
		/*Login login = new Login();
		login.testLogin();
		LoanStockList stock = new LoanStockList();
		stock.getLoanStock();*/
		
		ReportBaseClass.logger=ReportBaseClass.report.createTest("Test Multiquote");
		MultiQuoteFormField multifield = new MultiQuoteFormField();
		multifield.getMultiQuoteFormFields();
		CarMarketMrp carMarket = new CarMarketMrp();
		carMarket.testCarMrketMrp(version_slug,cityid);
		GetQuote quote= new GetQuote();
		quote.getQuote();
		
		ReportBaseClass.logger.info("Test Multiquote is executed");
		
	}

}
