package Alparslan.Kodlama.io.Devs.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import Alparslan.Kodlama.io.Devs.business.abstracts.FrameWorkService;
import Alparslan.Kodlama.io.Devs.business.requests.CreateFrameWorkRequest;
import Alparslan.Kodlama.io.Devs.business.requests.UpdateFrameWorkRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllFrameWorksResponse;
import Alparslan.Kodlama.io.Devs.business.responses.GetByIdFrameWorksResponse;
import Alparslan.Kodlama.io.Devs.business.rules.FrameWorkBusinessRules;
import Alparslan.Kodlama.io.Devs.core.utilities.mappers.abstracts.ModelMapperService;
import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.FrameWorkRepository;
import Alparslan.Kodlama.io.Devs.entities.concretes.FrameWork;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FrameWorkManager implements FrameWorkService {

	private FrameWorkRepository frameWorkRepository;
	private ModelMapperService mapperService;
	private FrameWorkBusinessRules frameWorkBusinessRules;
	
	@Override
	public List<GetAllFrameWorksResponse> getAll() {
		List<FrameWork> frameWorks = frameWorkRepository.findAll();
		List<GetAllFrameWorksResponse> frameWorksResponse = frameWorks.stream()
				.map(frameWork -> mapperService.forResponse().map(frameWork, GetAllFrameWorksResponse.class))
				.collect(Collectors.toList());
		return frameWorksResponse;
	}

	@Override
	public void add(CreateFrameWorkRequest createFrameWorkRequest) {
		frameWorkBusinessRules.checkIfFrameWorkNameExists(createFrameWorkRequest.getName());
		FrameWork frameWork = mapperService.forRequest().map(createFrameWorkRequest, FrameWork.class);
		frameWorkRepository.save(frameWork);
	}

	@Override
	public void delete(int id) {
		frameWorkRepository.deleteById(id);

	}

	@Override
	public void update(UpdateFrameWorkRequest updateFrameWorkRequest) {
		frameWorkBusinessRules.checkIfFrameWorkNameExists(updateFrameWorkRequest.getName());
		FrameWork frameWork = mapperService.forRequest().map(updateFrameWorkRequest, FrameWork.class);
		frameWorkRepository.save(frameWork);
	}

	@Override
	public GetByIdFrameWorksResponse getById(int id) {
		FrameWork frameWork = frameWorkRepository.findById(id).orElseThrow();
		GetByIdFrameWorksResponse getByIdFrameWorksResponse = mapperService.forResponse().map(frameWork,
				GetByIdFrameWorksResponse.class);
		return getByIdFrameWorksResponse;
	}

}
