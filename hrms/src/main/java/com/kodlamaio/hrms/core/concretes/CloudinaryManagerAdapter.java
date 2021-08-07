package com.kodlamaio.hrms.core.concretes;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kodlamaio.hrms.cloudinaryService.CloudinaryManager;
import com.kodlamaio.hrms.core.abstracts.CloudinaryImageService;


@Service
public class CloudinaryManagerAdapter implements CloudinaryImageService{
	
	private CloudinaryManager cloudinaryManager;
	
	@Autowired
	public CloudinaryManagerAdapter(CloudinaryManager cloudinaryManager) {
		super();
		this.cloudinaryManager = cloudinaryManager;
	}

	@Override
	public Map photoUpload(MultipartFile multipartFile) throws IOException {
		return this.cloudinaryManager.upload(multipartFile);
	}

	@Override
	public Map photoDelete(String id) throws IOException {
		return this.cloudinaryManager.delete(id);
	}

	@Override
	public File convert(MultipartFile multipartFile) throws IOException {
		return this.cloudinaryManager.convert(multipartFile);
	}

}
