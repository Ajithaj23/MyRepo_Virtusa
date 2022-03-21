package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


public class Message {
	
	  
        private String name;

        private String content;

        private String photo;
		/**
		 * @param name
		 * @param content
		 * @param photo
		 */
		public Message(String name, String content, String photo) {
			super();
			this.name = name;
			this.content = content;
			this.photo = photo;
		
		}
		public Message() {
			// TODO Auto-generated constructor stub
			System.out.println("Iam printing Constructor");
		}
		
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		
		
        
}
