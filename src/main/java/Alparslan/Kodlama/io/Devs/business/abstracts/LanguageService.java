package Alparslan.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Alparslan.Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {

	public List<Language> getAll();

	public void add(Language language);

	public void delete(Language language);

	public void update(Language exLanguage, Language newLanguage);

	public Language getById(int id);
}
