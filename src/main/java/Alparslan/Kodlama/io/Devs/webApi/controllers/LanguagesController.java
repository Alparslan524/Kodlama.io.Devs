package Alparslan.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Alparslan.Kodlama.io.Devs.business.abstracts.LanguageService;
import Alparslan.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Alparslan.Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import Alparslan.Kodlama.io.Devs.entities.concretes.Language;

@RestController
@RequestMapping("api/languages")
public class LanguagesController {
	private LanguageService languageService;

	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@GetMapping("/getall")
	List<GetAllLanguageResponse> getAll() {
		return languageService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateLanguageRequest createLanguageRequest) {
		languageService.add(createLanguageRequest);
	}

	@PostMapping("/delete")
	public void delete(int id) {
		languageService.delete(id);
	}

	@PostMapping("/update")
	public void update(@RequestBody Language exLanguage, Language newLanguage) {
		languageService.update(exLanguage, newLanguage);
	}

	@GetMapping("getbyid")
	public GetByIdLanguageResponse getById(int id) {
		return languageService.getById(id);
	}
}
