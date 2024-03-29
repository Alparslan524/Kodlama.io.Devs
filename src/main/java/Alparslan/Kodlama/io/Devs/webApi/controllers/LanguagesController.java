package Alparslan.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Alparslan.Kodlama.io.Devs.business.abstracts.LanguageService;
import Alparslan.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Alparslan.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Alparslan.Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/languages")
@AllArgsConstructor
public class LanguagesController {
	private LanguageService languageService;

	@GetMapping()
	List<GetAllLanguageResponse> getAll() {
		return languageService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdLanguageResponse getById(@PathVariable int id) {
		return languageService.getById(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateLanguageRequest createLanguageRequest) {
		languageService.add(createLanguageRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		languageService.delete(id);
	}

	@PutMapping
	public void update(@RequestBody @Valid UpdateLanguageRequest updateLanguageRequest) {
		languageService.update(updateLanguageRequest);
	}

}
