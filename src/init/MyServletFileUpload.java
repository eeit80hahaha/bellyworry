package init;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

public class MyServletFileUpload {

	
	//private String uploadPath = "E:\\upFile\\";
	//private File tempPath = new File("E:\\upFile\\temp"); //伺服器上，檔案暫存的位置

	/**
	 * 初始化Servlet，确保需要使用的目录都被建立<br>
	 * 
	 * @throws javax.servlet.ServletException
	 */

//	@Override
//	public void init() throws ServletException {
//		if (!new File(uploadPath).isDirectory())
//			new File(uploadPath).mkdir();
//		if (!tempPath.isDirectory())
//			tempPath.mkdir();
//	}

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public static Map<String, FileItem> fileUpload(HttpServletRequest request, HttpServletResponse response) throws IOException, FileUploadException{

		// 创建一个上传项目工厂，并设置其缓存数据大小和临时文件保存位置
//		request.setCharacterEncoding("UTF-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		//factory.setRepository(tempPath);

		// 使用项目工厂创建一个ServletFileUpload对象，用于解析文件上传请求
		// 并设置可以上传的文件的最大字节数，超过会抛出异常
		ServletFileUpload upload = new ServletFileUpload(factory);
		//upload.setSizeMax(1000000);
		upload.setHeaderEncoding("utf-8");

		List fileItems = null;
		Map<String, FileItem> fileItemMap = new HashMap<String, FileItem>();
		//ByteArrayOutputStream buffer = new ByteArrayOutputStream();	// 开始读取上传信息,fileItems為FORM內所有INPUT內容
			fileItems = upload.parseRequest(new ServletRequestContext(request));
			// 依次处理每一个上传的文件
			Iterator itor = fileItems.iterator();
			
			// 過濾上傳檔案类型，僅能上傳"jpg", "png", "jpeg", "gif" 
			String[] correctType = { "jpg", "png", "jpeg", "gif" };
			
			while (itor.hasNext()) {
				FileItem item = (FileItem) itor.next();

				// 忽略其他不是上傳檔案的所有其他表单信息；isFormField()為除檔案外所有FORM的INPUT
				if (!item.isFormField()) {
					//getName()為取item名稱的方法(即上傳檔案名稱)
					String name = item.getName();
					//getSize()為取item大小的方法(即上傳檔案大小)
					long size = item.getSize();					
					boolean result = false;
					
					if ((name == null || name.equals("")) && size == 0)
						continue;
					
					for (int temp = 0; temp < correctType.length; temp++) {
						//比對檔案名稱後的副檔名
						if(name.matches(".+\\." + correctType[temp])){
							result = true;
							break;
						}
					}
					
					if(result){
						//item.getFieldName()[某INPUT的name]
						fileItemMap.put(item.getFieldName(), item);
					}
					else{
						//讓SERVLET可以接到IOException
						throw new IOException(name + ":wrong type");
					}
					
					
//					Matcher m = p.matcher(name);
//					boolean result = m.find();
//					// 如果是允许上传的文件类型就执行上传操作
//					System.out.println("FieldName == "+item.getFieldName());
//					System.out.println("result  == "+result);
//					if (result) {
//						for (int temp = 0; temp < errorType.length; temp++) {
//							if (m.group(1).endsWith(errorType[temp])) {
//								throw new IOException(name + ":wrong type");
//							}
//						}
//						System.out.println("Map  "+item.getFieldName()+"=="+item.getOutputStream());
//						fileItemMap.put(item.getFieldName(), item);
//					}
				}
				else{
					fileItemMap.put(item.getFieldName(), item);
				}
			}
		
		return fileItemMap;

	}
												//FileItem==>Form的INPUT
	public static ByteArrayOutputStream getFileOutputStream(FileItem item){
		//ByteArrayOutputStream==>byte[]的OutputStream(因為要資料庫要寫入byte[])
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();
		try {
						
			InputStream fis = null;
			
			int read;
			byte[] data = new byte[1024];
			try {
				fis = item.getInputStream();
				//每次讀[1024]放入buffer,最後一次不滿[1024]讀多少放多少
				while ((read = fis.read(data, 0, data.length)) != -1) {
					buffer.write(data, 0, read);
				}
				//回衝buffer
				buffer.flush();
				System.out.println("Buffer  "+item.getFieldName()+"=="+buffer);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		 }catch (Exception e) {
			 e.printStackTrace();
		 }
		
		return buffer;
	}

}
