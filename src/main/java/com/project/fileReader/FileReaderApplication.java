package com.project.fileReader;

import com.project.fileReader.dao.UsersDao;
import com.project.fileReader.entities.Users;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class FileReaderApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(FileReaderApplication.class, args);
		UsersDao usersDao= context.getBean(UsersDao.class);
		Users user1= new Users();
		user1.setUserId(1);
		user1.setTitle("sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
		user1.setBody("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");

		/**
		 * Save the user details
		 */
		usersDao.save(user1);
	}

}
