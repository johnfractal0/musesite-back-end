package com.example.musesitebackend;

import com.musesite.MusesiteBackEndApplication;
import com.musesite.dao.AlbumRepository;
import com.musesite.dao.BandRepository;
import com.musesite.model.Album;
import com.musesite.model.Band;
import com.musesite.restful.Association;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MusesiteBackEndApplication.class, webEnvironment = RANDOM_PORT)
public class MusesiteBackEndApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Autowired
	AlbumRepository albumRepository;

	@Autowired
	BandRepository bandRepository;

	@Test
	public void shouldCreateAssociation() {
		//given
		Album muzykaPowazna = new Album();
		muzykaPowazna.setTitle("title");
		muzykaPowazna = albumRepository.save(muzykaPowazna);

		Band pezet = new Band();
		pezet.setName("Pezet");
		pezet = bandRepository.save(pezet);

		//when
		restTemplate.postForEntity("/album/{albumId}/band/{bandId}", null, Association.class,
				muzykaPowazna.getId(), pezet.getId());

		//then
		Album albumWithBands = albumRepository.findAlbumById(muzykaPowazna.getId());

		assertThat(albumWithBands.getBands())
				.hasOnlyOneElementSatisfying(
						band -> assertThat(band).extracting(Band::getName).isEqualTo("Pezet"));
	}

}

