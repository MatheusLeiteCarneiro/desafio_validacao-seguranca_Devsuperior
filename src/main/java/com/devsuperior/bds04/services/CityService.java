package com.devsuperior.bds04.services;

import com.devsuperior.bds04.dto.CityDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    private final CityRepository repository;

    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CityDTO> findAll(){
        return repository.findAll(Sort.by("name")).stream().map(CityDTO::new).toList();
    }

    @Transactional
    public CityDTO insert(CityDTO insertDto){
        City city = new City(null, insertDto.getName());
        return new CityDTO(repository.save(city));
    }
}
