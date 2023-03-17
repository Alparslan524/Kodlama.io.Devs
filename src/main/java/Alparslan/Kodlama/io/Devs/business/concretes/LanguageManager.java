package Alparslan.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Alparslan.Kodlama.io.Devs.business.abstracts.LanguageService;
import Alparslan.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Alparslan.Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Alparslan.Kodlama.io.Devs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> languagesResponse = new ArrayList<GetAllLanguageResponse>();
		for (Language language : languages) {
			GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			languagesResponse.add(responseItem);
		}
		return languagesResponse;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		languageRepository.save(language);

	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);
		/*
		 * List<Language> languages = languageRepository.findAll(); for (Language
		 * languageItem : languages) { if (languageItem.getName() == language.getName())
		 * { languageRepository.deleteById(language.getId()); } }
		 */
	}

	@Override
	public void update(Language exLanguage, Language newLanguage) {
		// languageRepository.update(exLanguage, newLanguage);

	}

	@Override
	public GetByIdLanguageResponse getById(int id) {
		List<Language> languages = languageRepository.findAll();
		GetByIdLanguageResponse languagesResponse = new GetByIdLanguageResponse();
		for (Language language : languages) {
			if (language.getId() == id) {
				languagesResponse.setId(language.getId());
				languagesResponse.setName(language.getName());
			}
		}
		return languagesResponse;
	}

}
