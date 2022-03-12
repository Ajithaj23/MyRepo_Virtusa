package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.beans.FileUploadBean;
import com.example.repository.FileUploadRepository;
@Service
@Transactional
public class FileUploadService {
	@Autowired
	private  FileUploadRepository repo;
	
	public List<FileUploadBean> listAll() {
		return repo.findAll();
	}
	
	public FileUploadBean save(FileUploadBean fileuploadbean) {
		return repo.save(fileuploadbean);
	}
	
	public FileUploadBean get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {
		repo.deleteById(id);
	}

}
