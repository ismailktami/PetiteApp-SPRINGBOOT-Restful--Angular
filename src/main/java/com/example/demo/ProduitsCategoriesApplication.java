package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Role;
import com.example.demo.entities.User;

@SpringBootApplication
public class ProduitsCategoriesApplication {

	public static void main(String[] args) throws ParseException {
	ApplicationContext ctx=	SpringApplication.run(ProduitsCategoriesApplication.class, args);
	UserRepository ur=ctx.getBean(UserRepository.class);
	User u=new User();
	u=ur.getOne("ismail2");
	System.out.println(u.getUsername());
//	List<Role> roles=(List<Role>) u.getRoles();
	//roles.forEach(e->System.out.println(e.getRole()));
	//DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
/*	er.save(new Etudiant("safoine","safoine",df.parse("2010-11-1")));
	er.save(new Etudiant("safoine1","safoine1",df.parse("2010-11-2")));
	er.save(new Etudiant("safoine2","safoine2",df.parse("2010-11-3")));
	er.save(new Etudiant("safoine3","safoine3",df.parse("2010-11-4")));
	*/
	//List<Etudiant> etudiants=er.findAll();
//	etudiants.forEach(e->System.out.println(e.getNom()));
	
	
	
	}

}

