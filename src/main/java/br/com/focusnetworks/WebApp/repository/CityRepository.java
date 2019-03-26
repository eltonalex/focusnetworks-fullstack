package br.com.focusnetworks.WebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.focusnetworks.WebApp.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
