package com.tech.app.jdbc.service;

import java.sql.SQLException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.app.exception.NotFoundException;
import com.tech.app.jdbc.dao.ActorDAO;
import com.tech.app.jdbc.dto.ActorDTO;
import com.tech.app.jdbc.repository.JDBCTransactionExample;
import com.tech.app.jdbc.repository.JavajdbcCURDRepositoryImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * Service object to Actor related task
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
	 * Method to get connect to repository and fetch Actor details
	 * 
	 * @param id
	 * @return
	 * @throws SQLException 
	 * @throws Exception
	 */
	public ActorDTO getDataUsingJavaJDBC(int id) throws SQLException  {
		ActorDAO actorDao = javajdbcDaoImpl.getDataByID(id);
		ActorDTO actorDto = new ActorDTO();
		BeanUtils.copyProperties(actorDao, actorDto);
		log.info("actorDto - {}", actorDto.toString());
		if (actorDto.getId() == 0)
			throw new NotFoundException("NOTFOUND", "Actor Details not found");
		return actorDto;
	}

	/**
	 * This method
	 *
	 * @param id
	 * @return 
	 * ActorDTO
	 * @throws SQLException 
	 */
	public ActorDTO executeCRUDOperation(String id) throws SQLException {
		ActorDAO actorDao = javajdbcDaoImpl.executeCRUDOperation(id);
		ActorDTO actorDto = new ActorDTO();
		BeanUtils.copyProperties(actorDao, actorDto);
		log.info("actorDto - {}", actorDto.toString());
		if (actorDto.getId() == 0)
			throw new NotFoundException("NOTFOUND", "Data not found");
		return actorDto;
	}

	/**
	 * This method
	 *
	 * @return 
	 * ActorDTO
	 * @throws SQLException 
	 */
	public String executeTxExample() throws SQLException {
		return jdbcTransactionExample.executeTxExample();
	}
	
}
