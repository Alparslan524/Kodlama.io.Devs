package Alparslan.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Alparslan.Kodlama.io.Devs.business.abstracts.LanguageService;
import Alparslan.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Alparslan.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Alparslan.Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import Alparslan.Kodlama.io.Devs.business.rules.LanguageBusinessRules;
import Alparslan.Kodlama.io.Devs.core.utilities.mappers.abstracts.ModelMapperService;
import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Alparslan.Kodlama.io.Devs.entities.concretes.Language;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;
	private ModelMapperService modelMapperService;
	private LanguageBusinessRules languageBusinessRules;

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languagesResponse = languages.stream()
				.map(language -> modelMapperService.forResponse().map(language, GetAllLanguageResponse.class))
				.collect(Collectors.toList());
		return languagesResponse;
	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		Language language = languageRepository.findById(id).orElseThrow();
		GetByIdLanguageResponse getByIdLanguageResponse = modelMapperService.forResponse().map(language,
				GetByIdLanguageResponse.class);
		return getByIdLanguageResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		languageBusinessRules.checkIfLanguageNameExists(createLanguageRequest.getName());
		Language language = modelMapperService.forRequest().map(createLanguageRequest, Language.class);
		languageRepository.save(language);
	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);
	}

	@Override
	public void update(UpdateLanguageRequest updateLanguageRequest) {
		languageBusinessRules.checkIfLanguageNameExists(updateLanguageRequest.getName());
		Language language = modelMapperService.forRequest().map(updateLanguageRequest, Language.class);
		languageRepository.save(language);
	}
}
