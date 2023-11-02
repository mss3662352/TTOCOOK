package com.ttocook.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class FileController {
	@GetMapping("/upload")
	public void form() {}
	
public String upload2(MultipartHttpServletRequest files) {
		

		//서버에서 저장 할 경로
		String uploadFolder = "C:\\test\\upload";
		List<MultipartFile> list = files.getFiles("files");
		for(int i = 0; i<list.size(); i++) {
			String fileRealName = list.get(i).getOriginalFilename();
			long size = list.get(i).getSize();
			
			System.out.println("파일명 :" + fileRealName);
			System.out.println("사이즈" + size);
			
			File saveFile = new File(uploadFolder + "\\" + fileRealName);
			try {
				list.get(i).transferTo(saveFile);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		return "/upload_ok";
	}
}
