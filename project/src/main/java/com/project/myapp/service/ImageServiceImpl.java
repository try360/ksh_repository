package com.project.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.myapp.DAO.ImageDAO;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDAO imageDAO;

	@Override
	public int getWritingPrimaryKey() {
		// TODO Auto-generated method stub
		return imageDAO.getWritingPrimaryKey();
	}

}
