package Alparslan.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Alparslan.Kodlama.io.Devs.business.abstracts.FrameWorkService;
import Alparslan.Kodlama.io.Devs.business.requests.CreateFrameWorkRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllFrameWorksResponse;
import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.FrameWorkRepository;
import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import Alparslan.Kodlama.io.Devs.entities.concretes.FrameWork;
import Alparslan.Kodlama.io.Devs.entities.concretes.Language;

@Service
public class FrameWorkManager implements FrameWorkService {

	private FrameWorkRepository frameWorkRepository;
	private LanguageRepository languageRepository;

	public FrameWorkManager(FrameWorkRepository frameWorkRepository, LanguageRepository languageRepository) {
		this.frameWorkRepository = frameWorkRepository;
		this.languageRepository = languageRepository;
	}

	@Override
	public List<GetAllFrameWorksResponse> getAll() {
		List<FrameWork> frameWorks = frameWorkRepository.findAll();
		List<GetAllFrameWorksResponse> frameWorksResponse = new ArrayList<GetAllFrameWorksResponse>();
		for (FrameWork frameWork : frameWorks) {
			GetAllFrameWorksResponse responseItem = new GetAllFrameWorksResponse();
			responseItem.setId(frameWork.getId());
			responseItem.setName(frameWork.getName());
			responseItem.setLanguageId(frameWork.getLanguage().getId());
			frameWorksResponse.add(responseItem);
		}
		return frameWorksResponse;
	}

	@Override
	public void add(CreateFrameWorkRequest createFrameWorkRequest) {
		FrameWork frameWork = new FrameWork();
		frameWork.setName(createFrameWorkRequest.getName());
		for (Language language : languageRepository.findAll()) {
			if (createFrameWorkRequest.getLanguageId() == language.getId()) {
				frameWork.setLanguage(language);
			}
		}
		frameWorkRepository.save(frameWork);
	}

	@Override
	public void delete(int id) {
		frameWorkRepository.deleteById(id);

	}

	@Override
	public void update(FrameWork exFrameWorks, FrameWork newFrameWorks) {
		// TODO Auto-generated method stub

	}

	@Override
	public GetAllFrameWorksResponse getById(int id) {
		List<FrameWork> frameWorks = frameWorkRepository.findAll();
		GetAllFrameWorksResponse frameWorksResponse = new GetAllFrameWorksResponse();
		for (FrameWork frameWork : frameWorks) {
			if (frameWork.getId() == id) {
				frameWorksResponse.setId(frameWork.getId());
				frameWorksResponse.setName(frameWork.getName());
			}
		}
		return frameWorksResponse;
	}

}
