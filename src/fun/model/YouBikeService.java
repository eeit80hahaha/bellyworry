package fun.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class YouBikeService {
	private String urlString;

	public String getUrlString() {
		return urlString;
	}

	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}

	public String getJsonData() throws Exception{
		URL url = new URL(urlString);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		InputStream inputStream = conn.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer result = new StringBuffer(); 
		String line = br.readLine();
		while(line!=null){
			result.append(line);
			line = br.readLine();
		}
		conn.disconnect();
		
		
		return result.toString();
	}
	public String getJsonDataFromFile() throws Exception{
		
//		File file = new File("C:/Java/apiAccess.json");
//		FileInputStream inputStream = new FileInputStream(file);
		
		URL url = new URL("http://localhost:8080/bellyworry/map/apiAccess.json");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		InputStream inputStream = conn.getInputStream();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer result = new StringBuffer(); 
		String line = br.readLine();
		while(line!=null){
			result.append(line);
			line = br.readLine();
		}
		return result.toString();
	}
	



	public static void main(String[] args) throws Exception {
		YouBikeService service = new YouBikeService();
//		service.setUrlString("http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=ddb80380-f1b3-4f8e-8016-7ed9cba571d5");
//		
//		System.out.println(service.getJsonData());
		System.out.println(service.getJsonDataFromFile());
		
	}
}
