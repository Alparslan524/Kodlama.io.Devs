package Alparslan.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Alparslan.Kodlama.io.Devs.business.abstracts.FrameWorkService;
import Alparslan.Kodlama.io.Devs.business.requests.CreateFrameWorkRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllFrameWorksResponse;
import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.FrameWorkRepository;
import Alparslan.Kodlama.io.Devs.entities.concretes.FrameWork;

@Service
public class FrameWorkManager implements FrameWorkService {

	private FrameWorkRepository frameWorkRepository;

	public FrameWorkManager(FrameWorkRepository frameWorkRepository) {
		this.frameWorkRepository = frameWorkRepository;
	}

	@Override
	public List<GetAllFrameWorksResponse> getAll() {
		List<FrameWork> frameWorks = frameWorkRepository.findAll();
		List<GetAllFrameWorksResponse> frameWorksResponse = new ArrayList<GetAllFrameWorksResponse>();
		for (FrameWork frameWork : frameWorks) {
			GetAllFrameWorksResponse responseItem = new GetAllFrameWorksResponse();
			responseItem.setId(frameWork.getId());
			responseItem.setName(frameWork.getName());
			frameWorksResponse.add(responseItem);
		}
		return frameWorksResponse;
	}

	@Override
	public void add(CreateFrameWorkRequest createFrameWorkRequest) {
		FrameWork frameWork = new FrameWork();
		frameWork.setName(createFrameWorkRequest.getName());
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
