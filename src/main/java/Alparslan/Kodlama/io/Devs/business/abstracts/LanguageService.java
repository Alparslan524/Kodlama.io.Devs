package Alparslan.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Alparslan.Kodlama.io.Devs.business.requests.CreateLanguageRequest;
import Alparslan.Kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllLanguageResponse;
import Alparslan.Kodlama.io.Devs.business.responses.GetByIdLanguageResponse;

public interface LanguageService {

	public List<GetAllLanguageResponse> getAll();

	public void add(CreateLanguageRequest createLanguageRequest);

	public void delete(int id);

	public void update(UpdateLanguageRequest updateLanguageRequest);

	public GetByIdLanguageResponse getById(int id);
}