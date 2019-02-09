package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EtudiantRepository;
import com.example.demo.entities.Etudiant;

@RestController
public class EtudiantRestService {
@Autowired
private EtudiantRepository etudiantRepository;
@Secured(value= {"ROLE_ADMIN","ROLE_SCOLARITE"})
@RequestMapping(value="/saveEtudiants",method=RequestMethod.GET)
public Etudiant saveEtudiant(Etudiant e ) {
	return etudiantRepository.save(e);
}



@Secured(value= {"ROLE_ADMIN","ROLE_SCOLARITE","ROLE_PROF"})
@RequestMapping(value="/etudiants")
public Page<Etudiant> listEtudiant(int page,int size){
	return etudiantRepository.findAll(new PageRequest(page,size));
}

@RequestMapping(value="/getLogedUser")
public Map<String,Object> getLogedUser(HttpServletRequest request){
	HttpSession httpSession=request.getSession();
	SecurityContext securityContext=(SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
	String username=securityContext.getAuthentication().getName();
	List<String> roles=new ArrayList<String>();
	for( GrantedAuthority ga:securityContext.getAuthentication().getAuthorities()) {
	roles.add(ga.getAuthority())	;
	}
	Map<String,Object> params =new HashMap<>();
	params.put("username", username);
	params.put("roles",roles);
	return params;
}



}


