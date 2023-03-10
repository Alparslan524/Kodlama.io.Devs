package Alparslan.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Alparslan.Kodlama.io.Devs.business.abstracts.LanguageService;
import Alparslan.Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	List<Language> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(Language language) {
		languageService.add(language);
	}

	@PostMapping("/delete")
	public void delete(Language language) {
		languageService.delete(language);
	}

	@PostMapping("/update")
	public void update(Language exLanguage, Language newLanguage) {
		languageService.update(exLanguage, newLanguage);
	}

	@GetMapping("getbyid")
	public Language getById(int id) {
		return languageService.getById(id);
	}
}
