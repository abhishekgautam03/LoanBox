package utility;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import utilsApi.ApiTestUtils;

public class FilterRequestData implements Filter{
	
	// private static final Log log = LogFactory.getLog(FilterRequestData.class);
	private static final Logger log = LoggerFactory.getLogger(FilterRequestData.class);
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		Response response = ctx.next(requestSpec, responseSpec);
		/* if (response.statusCode() == 200) {
	            log.error(requestSpec.getMethod() + " " + requestSpec.getURI() + " => " +
	                    response.getStatusCode() + " " + response.getStatusLine());
	            System.out.println("filter if "+log.toString());
	        }else {
	        	 log.info(requestSpec.getMethod() + " " + requestSpec.getURI() + " \n Request Body =>" + requestSpec.getBody() + "\n Response Status => " +
	 	                response.getStatusCode() + " " + response.getStatusLine() + " \n Response Body => " + response.getBody().prettyPrint());
	 	        System.out.println("filter else "+log.toString());
	        }*/
		StringBuilder requestBuilder = new StringBuilder();
		requestBuilder.append("*******Request Data****** \n");
		requestBuilder.append("\nApi Method-----  "+requestSpec.getMethod()+"\n");
    	requestBuilder.append("\nUrl-----  "+requestSpec.getURI()+"\n");
		requestBuilder.append("\n*******Header******** \n");
		requestBuilder.append("\n"+requestSpec.getHeaders()+"\n");
		requestBuilder.append("\n*******RequestBody******** \n\n");
		requestBuilder.append(requestSpec.getBody()+"\n");
	
		requestBuilder.append("\n********Response Data*******\n");

		log.info(requestBuilder.toString());  //Log your request where you need it
		StringBuilder responseBuilder = new StringBuilder();
		responseBuilder.append("\nStatus line------  "+response.getStatusLine()+"\n");
		responseBuilder.append("Status Code------  "+response.getStatusCode()+"\n");
		responseBuilder.append("Api Response Status Code------- "+ApiTestUtils.getValueFromResponse(response, "status")+"\n\n");
		responseBuilder.append(response.asString());
		log.info(responseBuilder.toString()); //Log your response where you need it
		StringBuilder all =new StringBuilder();
		all.append(requestBuilder);
		all.append(responseBuilder);
		System.out.println(all.toString());
	
		if (response.statusCode() !=200 || ApiTestUtils.getValueFromResponse(response, "status")!="200") {

			/*try(PrintWriter writer = new PrintWriter(new FileWriter("/ApiFramework/logging.txt"))) {
		    	    writer.append(requestBuilder);
		    	    writer.append(responseBuilder);
		    	} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} */
			try{    
				FileWriter fw=new FileWriter("../OtoDealer/resource/logger.txt");    
				fw.write(all.toString());    
				fw.close();    
			}catch(Exception e){
				System.out.println(e);
				System.out.println("write to file ");
			}
			try {
				SendMail.send(InvokeMail.server,InvokeMail.from, InvokeMail.to, InvokeMail.subject, 
						InvokeMail.messageBody, InvokeMail.attachmentPath, InvokeMail.attachmentName);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}    


		return response;

	}

}

		  