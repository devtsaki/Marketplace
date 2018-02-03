package com.tsaki.marketplace.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "C:\\Users\\tsaki\\eclipse-workspace\\marketplace\\src\\main\\webapp\\WEB-INF\\resources\\images\\";
	private static String REAL_PATH = "";
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {

		REAL_PATH = request.getSession().getServletContext().getRealPath("/WEB-INF/resources/images/");
		logger.info(REAL_PATH);
		
		if (!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}
		if (!new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			//Server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			//Project dir upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		}
		catch (IOException ex) {
			
		}
	}
	
}
