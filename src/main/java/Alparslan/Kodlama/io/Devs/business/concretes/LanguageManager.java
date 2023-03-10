package Alparslan.Kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import Alparslan.Kodlama.io.Devs.business.abstracts.LanguageService;
import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Alparslan.Kodlama.io.Devs.entities.concretes.Language;
@Service
public class LanguageManager implements LanguageService, LanguageRepository {

	private LanguageRepository languageRepository;

	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public List<Language> getAll() {
		return languageRepository.getAll();
	}

}
