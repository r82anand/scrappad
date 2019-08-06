package com.sivadas.anand.serivce;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sivadas.anand.dto.ChapterDTO;
import com.sivadas.anand.entity.Chapter;
import com.sivadas.anand.entity.repository.ChapterRepository;
import com.sivadas.anand.mapper.ChapterMapper;

@Service
public class ChapterService {

	protected static final Logger LOGGER = LoggerFactory.getLogger(ChapterService.class);

	@Autowired
	private ChapterRepository repository;

	@Autowired
	private ChapterMapper mapper;

	public List<ChapterDTO> getAllChapeters() {

		final List<Chapter> chapters = new ArrayList<>();
		final Iterable<Chapter> results = repository.findAll();
		results.forEach(chapters::add);
		chapters.forEach(element -> {
			LOGGER.info("Chapter = {}", element);
		});

		return mapper.contentsListToContenstDTOList(chapters);
	}

	public ChapterDTO saveContent(final ChapterDTO dto) {

		final Chapter entity = mapper.chaterDTOToChapter(dto);
		final Chapter save = repository.save(entity);
//		perisistRepository.refresh(save);
		final ChapterDTO response = mapper.chapterToChapterDTO(save);

		return response;
	}

	public ChapterDTO getChapterById(final Long id) {

		ChapterDTO response = new ChapterDTO();
		final Optional<Chapter> result = repository.findById(id);
		if (result.isPresent()) {
			final Chapter chapter = result.get();
			response = mapper.chapterToChapterDTO(chapter);
		} else {
			response.setId(id);
		}
		return response;
	}

}
