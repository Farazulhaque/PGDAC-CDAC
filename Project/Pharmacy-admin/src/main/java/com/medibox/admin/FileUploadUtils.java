package com.medibox.admin;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {
	public  static void saveFile(String dirString , String filename , MultipartFile multipartFile) throws IOException {
		Path uploadPath = Paths.get(dirString);
		if(!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
	try(InputStream imInputStream = multipartFile.getInputStream()) {
		// converting string  to path 
		Path filePath = uploadPath.resolve(filename);
		Files.copy(imInputStream,filePath,StandardCopyOption.REPLACE_EXISTING);
		
	} catch (Exception e) {
		throw new IOException("could not save image file");
	}
		
	}

}