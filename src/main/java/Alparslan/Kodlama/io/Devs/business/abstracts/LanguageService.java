package Alparslan.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Alparslan.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Alparslan.Kodlama.io.Devs.entities.concretes.Language;

public interface LanguageService {

	public List<GetAllLanguageResponse> getAll();

	public void add(CreateLanguageRequest createLanguageRequest);

	public void delete(int id);

	public void update(Language exLanguage, Language newLanguage);

	public GetAllLanguageResponse getById(int id);
}