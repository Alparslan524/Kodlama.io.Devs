package Alparslan.Kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Alparslan.Kodlama.io.Devs.entities.concretes.Language;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

	List<Language> languages;

	public InMemoryLanguageRepository() {
		languages = new ArrayList<Language>();
		languages.add(new Language(0, "C#"));
		languages.add(new Language(1, "Java"));
		languages.add(new Language(2, "Python"));
	}

	@Override
	public List<Language> getAll() {
		return languages;
	}

	@Override
	public void add(Language language) {
		for (Language tempLanguage : languages) {
			if (tempLanguage.getName() == language.getName()) {
				System.out.println("Language name already exist");
			}
		}
		languages.add(language);
	}

	@Override
	public void delete(Language language) {
		languages.remove(language);
	}

	@Override
	public void update(Language exLanguage, Language newLanguage) {
		languages.set(exLanguage.getId(), newLanguage);
	}

	@Override
	public Language getById(int id) {
		return languages.get(id);
	}

}
