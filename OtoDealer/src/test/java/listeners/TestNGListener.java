package listeners;

import org.testng.IExecutionListener;

import Base.ReportBaseClass;
import Utility.Email;

public class TestNGListener implements IExecutionListener {
	
	@Override
	public void onExecutionStart() {

	}

	@Override
	public void onExecutionFinish() {

		String outputdir=System.getProperty("user.dir")+"/test-output";
		String reportdir = System.getProperty("user.dir")+"/reports/";
		System.out.println(outputdir);
	//	String outputdir= "../OtoDealer/test-output";
		
	   Email.sendEmail(outputdir,ReportBaseClass.TimeStamp,reportdir);
        
	    System.out.println("Email is sent");
	}


	
}
	
	

	


