package com.tech.app.jdbc.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tech.app.jdbc.dao.PersonDAO;
import com.tech.app.jdbc.dto.PersonDTO;
import com.tech.app.jdbc.service.impl.JavajdbcDaoImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Bhushan Bafna
 *
 */
@Service
@Slf4j
public class JavaJdbcService {

	@Autowired
	private JavajdbcDaoImpl javajdbcDaoImpl;

	public PersonDTO getDataUsingJavaJDBC(String id) throws Exception {
		PersonDAO personDao = javajdbcDaoImpl.getData(id);
		PersonDTO personDto = new PersonDTO();
		BeanUtils.copyProperties(personDao, personDto);
		log.info("personDto - {}", personDto.toString());
		return personDto;
	}

}
