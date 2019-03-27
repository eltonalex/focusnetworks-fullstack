package br.com.focusnetworks.WebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.focusnetworks.WebApp.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

}
