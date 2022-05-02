package utilsApi;

import java.util.regex.Pattern;

public class JsonVariableReplacement {
	
	
	public static String replaceJson(String data,String variableName,String variableValue) {
		data = data.replaceAll(Pattern.quote("{{"+variableName+"}}"), variableValue);
		return data;
	}
	public static String replaceJson(String data,String variableName,long variableValue) {
		String longvalue =String.valueOf(variableValue); 
		data = data.replaceAll(Pattern.quote("{{"+variableName+"}}"), longvalue);
		return data;
	}

}
