package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Utility.Constants;
import io.restassured.response.Response;

public class FileUtils {
	
	public static void createJsonFile(String fileName,Response response) throws IOException {
		String basepath=Constants.jsonFilePath+fileName+".json";
		File fileObj = new File(basepath);

		if(fileObj.createNewFile()) {
			FileWriter myWriter = new FileWriter(basepath);
			myWriter.write(response.toString());
			myWriter.close();
		//	System.out.println("pass   case   ");
		}else {
			FileWriter myWriter = new FileWriter(basepath);
			myWriter.write(response.toString());
			myWriter.close();
			//System.out.println("Failed   case   ");
		}
	}

}
