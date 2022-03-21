package com.example.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.beans.FileUploadBean;
import com.example.service.FileUploadService;

@Controller
public class FileUploadController {
	@Autowired
	private FileUploadService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		System.out.println("Iam printing in Controller");
		List<FileUploadBean> listFileUploads = service.listAll();
		for(FileUploadBean fileuploadbean:listFileUploads) {
		System.out.println(fileuploadbean.getDetailsImage());
		}
		
		model.addAttribute("listFileUploads", listFileUploads);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewFileUploadPage(Model model) {
		FileUploadBean fileuploadbean = new FileUploadBean();
		model.addAttribute("fileuploadbean", fileuploadbean);
		return "new_fileupload";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveFileUpload(@ModelAttribute("fileuploadbean") FileUploadBean fileuploadbean, 
			@RequestParam("fileImg")MultipartFile mfile,@RequestParam("fileVid")MultipartFile vfile,
			@RequestParam("fileDoc")MultipartFile dfile)throws IOException {
		
		
		String filename=StringUtils.cleanPath(mfile.getOriginalFilename());//java.png
		String filenamev=StringUtils.cleanPath(vfile.getOriginalFilename());//java.mp4
		String filenamed=StringUtils.cleanPath(dfile.getOriginalFilename());//java.pdf,doc
		fileuploadbean.setPhoto(filename);
		fileuploadbean.setVideo(filenamev);
		fileuploadbean.setDocument(filenamed);
		FileUploadBean saveFileUpload=service.save(fileuploadbean);
		 String UploadDirec="/src/main/webapp/file/"+saveFileUpload.getId();//src/main/webapp/file/id
		 
				Path uploadpath=Paths.get(UploadDirec);
				
				if(!Files.exists(uploadpath)) {
					Files.createDirectories(uploadpath);
				}
		try (InputStream inputStream=mfile.getInputStream()){
			Path filePath=uploadpath.resolve(filename);
			Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
			System.out.println(filePath);
		}catch (IOException e) {
			throw new IOException (e+"should not load file"+filename);
		}
			
		try(InputStream inputStreamv=vfile.getInputStream()){
				Path filePathv=uploadpath.resolve(filenamev);
				System.out.println(filePathv);
				Files.copy(inputStreamv, filePathv,StandardCopyOption.REPLACE_EXISTING);
		}catch (IOException e) {
			throw new IOException (e+"should not load file"+filenamev);
	    }
		try(InputStream inputStreamd=dfile.getInputStream()){	
		Path filePathd=uploadpath.resolve(filenamed);
		Files.copy(inputStreamd, filePathd,StandardCopyOption.REPLACE_EXISTING);
		System.out.println(filePathd);
			} catch (IOException e) {
			throw new IOException (e+"should not load file"+filenamed);
			}
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_fileupload");
		FileUploadBean fileuploadbean = service.get(id);
		mav.addObject("fileuploadbean", fileuploadbean);
		System.out.println(fileuploadbean.getPhoto());
		System.out.println(fileuploadbean.getVideo());
		System.out.println(fileuploadbean.getDocument());
		return mav;
	}
	
	@RequestMapping(value="/fileedit",method=RequestMethod.POST)
	public String fileuploadbeaneditsave(@ModelAttribute("fileuploadbean") FileUploadBean fileuploadbean, 
			@RequestParam("fileImg") MultipartFile mfile,@RequestParam("fileVid")MultipartFile vfile,
			@RequestParam("fileDoc")MultipartFile dfile)throws IOException {
		
	
		System.out.println(fileuploadbean.getId());
		FileUploadBean uploadbean = service.get(fileuploadbean.getId());
		
		String filename=StringUtils.cleanPath(mfile.getOriginalFilename());//java.png
		String filenamev=StringUtils.cleanPath(vfile.getOriginalFilename());//java.mp4
		String filenamed=StringUtils.cleanPath(dfile.getOriginalFilename());//java.pdf,doc
	

		System.out.println(fileuploadbean.getId()+"\n 1"+ fileuploadbean.getName()+"\n 2"+
			fileuploadbean.getPhoto()+filename+"\n 3"+	fileuploadbean.getVideo()+filenamev+"\n 4"+fileuploadbean.getDocument()+"\n 5"+filenamed);
	if(filename.isEmpty()) {
		fileuploadbean.setPhoto(uploadbean.getPhoto());
		fileuploadbean.setVideo(uploadbean.getVideo());
		fileuploadbean.setDocument(uploadbean.getDocument());
		System.out.println("It is Null");
		service.save(fileuploadbean);
		return "redirect:/";
	}else {
		System.out.println("It is not Null");
		fileuploadbean.setPhoto(filename);
		fileuploadbean.setVideo(filenamev);
		fileuploadbean.setDocument(filenamed);
		
		FileUploadBean saveFileUpload=service.save(fileuploadbean);
		 String UploadDirec="src/main/webapp/file"+saveFileUpload.getId();//src/main/webapp/file/id
		 
			Path uploadpath=Paths.get(UploadDirec);
			
			if(!Files.exists(uploadpath)) {
				Files.createDirectories(uploadpath);
			}
			//InputStream inputStream=multipartFile.getInputStream()
	try (InputStream inputStream=mfile.getInputStream()){
	Path filePath=uploadpath.resolve(filename);
	Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
	System.out.println(filePath);
	} catch (IOException e) {
		throw new IOException (e+"should not load file"+filename);
	}
	try(InputStream inputStreamv=vfile.getInputStream()){
		Path filePathv=uploadpath.resolve(filenamev);
		System.out.println(filePathv);
		Files.copy(inputStreamv, filePathv,StandardCopyOption.REPLACE_EXISTING);
    }catch (IOException e) {
	throw new IOException (e+"should not load file"+filenamev);
    }
   try(InputStream inputStreamd=dfile.getInputStream()){	
   Path filePathd=uploadpath.resolve(filenamed);
   Files.copy(inputStreamd, filePathd,StandardCopyOption.REPLACE_EXISTING);
   System.out.println(filePathd);
	} catch (IOException e) {
	throw new IOException (e+"should not load file"+filenamed);
	}

	
	return "redirect:/";
	}
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteFileUpload(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
