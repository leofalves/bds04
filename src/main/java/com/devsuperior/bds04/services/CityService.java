package com.devsuperior.bds04.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;

@Service
public class CityService {
	
	
	@Autowired
	CityRepository repository;
	
	@Transactional(readOnly = true)
	public List<CityDTO> findAll(){
		List<City> result = repository.findAll(Sort.by("name"));
		List<CityDTO> list = result.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
		return list;
	}

}
