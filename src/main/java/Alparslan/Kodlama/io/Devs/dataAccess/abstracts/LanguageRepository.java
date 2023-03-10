package Alparslan.Kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import Alparslan.Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageRepository {

	List<Language> getAll();
}
