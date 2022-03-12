package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.beans.FileUploadBean;

public interface FileUploadRepository extends JpaRepository<FileUploadBean, Long> {

}
