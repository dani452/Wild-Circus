package com.wildCircus.demo.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUpload {

	private String UPLOADED_FOLDER = System.getProperty("user.dir") + "/src/main/resources/static";

	public void writeFile(MultipartFile file, String fileName) {
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + fileName);
			Files.write(path, bytes);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void deleteFile(String fileName) {
		try {
			Path fileToDelete = Paths.get(UPLOADED_FOLDER + fileName);
			Files.delete(fileToDelete);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
