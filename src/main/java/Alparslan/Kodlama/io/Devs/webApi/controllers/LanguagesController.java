package Alparslan.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Alparslan.Kodlama.io.Devs.business.abstracts.LanguageService;
import Alparslan.Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {
	LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	List<Language> getAll() {
		return languageService.getAll();
	}
}
