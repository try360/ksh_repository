package com.project.myapp.VO;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ImageUploadVO {
	private MultipartFile file;
}
