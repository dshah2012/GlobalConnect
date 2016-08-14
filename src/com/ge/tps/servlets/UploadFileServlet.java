package com.ge.tps.servlets;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ge.tps.dao.SaveProfileDao;
import com.ge.tps.service.AddProfileInfoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileUploader")
public class UploadFileServlet extends HttpServlet {

	/**
	 * 
	 */
	AddProfileInfoService addProfileInfoService = null;
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,

	HttpServletResponse response)

	throws ServletException, IOException {

		String filePath = "";
		long tpid = 0;
		try {
			addProfileInfoService = new AddProfileInfoService();
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(request);
//			File uploadDir = new File(uploadPath);
//			System.out.println("\n\n File upload Dir " + uploadDir.getAbsolutePath());
			/*if (!uploadDir.exists()) {
				uploadDir.mkdir();
			}*/
			
			String absoluteDiskPath = "D:\\profilePics";
			File file = new File(absoluteDiskPath);
			if (!file.exists()) {
				file.mkdir();
			}
			
			System.out.println("Absolute path " + file.getAbsolutePath());
			System.out.println("Canonical Path : " + file.getCanonicalPath());
			for (FileItem item : items) {

				if (item.isFormField()) {

					// ajaxUpdateResult += "Field " + item.getFieldName() +

					// " with value: " + item.getString() +
					// " is successfully read\n\r";
					System.out.println(item.getString());
					tpid = Long.parseLong(item.getString());

				} else {

					String fileName = item.getName();
					System.out.println(fileName);
					InputStream content = item.getInputStream();

					response.setContentType("text/plain");

					response.setCharacterEncoding("UTF-8");

					// ajaxUpdateResult += "File " + fileName +
					// " is successfully uploaded\n\r";
					System.out.println("\n\n\n");
					System.out.println("------------------------------------");
					filePath = absoluteDiskPath + File.separator + "Trainer_" + tpid
							+ "_" + fileName;
					// returnableFilePath =relativePath + File.separator +
					// "Trainer_"+tpid+"_"+fileName;
					System.out.println("File Path : " + filePath);
					// System.out.println("returnableFilePath : " +
					// returnableFilePath);
					System.out.println("\n\nStore Path : " + filePath);
					
					
					File storeFile = new File(filePath);
					addProfileInfoService.setProficePicUrl(filePath,
							tpid);
					// saves the file on disk
					try {
						item.write(storeFile);
						System.out.println("Upload has been done successfully!");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}

			}

		} catch (FileUploadException e) {

			throw new ServletException("Parsing file upload failed.", e);

		}

		response.getWriter().print(filePath);

	}
}