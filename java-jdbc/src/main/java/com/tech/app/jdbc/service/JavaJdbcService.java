package com.tech.app.jdbc.service;

import java.sql.SQLException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.app.exception.NotFoundException;
import com.tech.app.jdbc.dao.PersonDAO;
import com.tech.app.jdbc.dto.PersonDTO;
import com.tech.app.jdbc.repository.JDBCTransactionExample;
import com.tech.app.jdbc.repository.JavajdbcCURDRepositoryImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * Service object to person related task
 * 
 * @author Bhushan Bafna
 */
@Service
@Slf4j
public class JavaJdbcService {
	
	@Autowired
	private JavajdbcCURDRepositoryImpl javajdbcDaoImpl;
	
	@Autowired
	private JDBCTransactionExample jdbcTransactionExample;
	
	/**
	 * Method to get connect to repository and fetch person details
	 * 
	 * @param id
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
	public PersonDTO getDataUsingJavaJDBC(String id) throws SQLException  {
		PersonDAO personDao = javajdbcDaoImpl.getData(id);
		PersonDTO personDto = new PersonDTO();
		BeanUtils.copyProperties(personDao, personDto);
		log.info("personDto - {}", personDto.toString());
		if (personDto.getInstanz() == null)
			throw new NotFoundException("NOTFOUND", "Person Details not found");
		return personDto;
	}

	/**
	 * This method
	 *
	 * @param id
	 * @return 
	 * PersonDTO
	 * @throws SQLException 
	 */
	public PersonDTO executeCRUDOperation(String id) throws SQLException {
		PersonDAO personDao = javajdbcDaoImpl.executeCRUDOperation(id);
		PersonDTO personDto = new PersonDTO();
		BeanUtils.copyProperties(personDao, personDto);
		log.info("personDto - {}", personDto.toString());
		if (personDto.getInstanz() == null)
			throw new NotFoundException("NOTFOUND", "Person Details not found");
		return personDto;
	}

	/**
	 * This method
	 *
	 * @return 
	 * PersonDTO
	 * @throws SQLException 
	 */
	public String executeTxExample() throws SQLException {
		return jdbcTransactionExample.executeTxExample();
	}
	
}
