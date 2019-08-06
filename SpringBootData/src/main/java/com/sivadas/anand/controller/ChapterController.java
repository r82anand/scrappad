package com.sivadas.anand.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sivadas.anand.dto.ChapterDTO;
import com.sivadas.anand.serivce.ChapterService;

@RestController
public class ChapterController {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ChapterController.class);

	@Autowired
	private ChapterService service;

	@GetMapping("/chapters")
	public List<ChapterDTO> getAllChapters() {

		final List<ChapterDTO> allChapeters = service.getAllChapeters();
		allChapeters.forEach(element -> {
			LOGGER.info("Chapter DTO = {}", element);
		});

		return allChapeters;
	}

	@GetMapping("/chapter/{id}")
	public ChapterDTO getContent(@PathVariable final Long id) {
		return service.getChapterById(id);
	}

	@PostMapping(path = "/chapter/save", consumes = "application/json", produces = "application/json")
	public ChapterDTO saveContent(@RequestBody final ChapterDTO dto) {
		return service.saveContent(dto);
	}

}
