package Input.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class dataReader {

	public List<HashMap<String,String>> getJsonDataTMap(String filePath) throws IOException {
		// convetinf json data to string
	String JsonContent=	FileUtils.readFileToString(new File(filePath),StandardCharsets.UTF_8);
		
	//Converting string to hashmp
	
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(JsonContent, new TypeReference <List<HashMap<String,String>>>(){});
	
	return data;
}
}
