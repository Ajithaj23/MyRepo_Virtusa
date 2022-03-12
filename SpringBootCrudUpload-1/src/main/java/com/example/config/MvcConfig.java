package com.example.config;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.example.controller"})
public class MvcConfig  implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
     Path UploadDirec=Paths.get("src/main/webapp/file");
		String uploadpath=UploadDirec.toFile().getAbsolutePath();
		registry.addResourceHandler("src/main/webapp/file/**").addResourceLocations("file:/"+uploadpath+"/");
		//exposeDirectory("src/main/webapp/file",registry);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 /*@Bean
	    public ViewResolver getViewResolver() {
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	        resolver.setViewClass(JstlView.class);  
			System.out.println("Iam Printing in constructor");

	        resolver.setPrefix("/templates/");
	        resolver.setSuffix(".html");
	        return resolver;
	    }*/

	/*@Override
    public void addViewControllers(ViewControllerRegistry registry) {
		 registry.addViewController("/").setViewName("index");
		 registry.addViewController("/new").setViewName("new_fileupload");
		 registry.addViewController("/edit").setViewName("edit_fileupload");
	
    	
	}*/
    /*@Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

	public void exposeDirectory(String dirName,ResourceHandlerRegistry registry) {
		Path UploadDirec=Paths.get(dirName);
		String uploadpath=UploadDirec.toFile().getAbsolutePath();
		if(dirName.startsWith("../")) dirName=dirName.replace("../", "");
		registry.addResourceHandler("/"+dirName+"/**").addResourceLocations("c:/"+uploadpath+"/");
	}*/
}
