package com.musesite;

import com.musesite.dao.BandRepository;
import com.musesite.model.Album;
import com.musesite.model.Band;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class MusesiteBackEndApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusesiteBackEndApplication.class, args);
	}
}
