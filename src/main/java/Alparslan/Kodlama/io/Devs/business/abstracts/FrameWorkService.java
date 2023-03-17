package Alparslan.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import Alparslan.Kodlama.io.Devs.business.requests.CreateFrameWorkRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllFrameWorksResponse;
import Alparslan.Kodlama.io.Devs.entities.concretes.FrameWork;

public interface FrameWorkService {

	public List<GetAllFrameWorksResponse> getAll();

	public void add(CreateFrameWorkRequest createFrameWorkRequest);

	public void delete(int id);

	public void update(FrameWork exFrameWorks, FrameWork newFrameWorks);

	public GetAllFrameWorksResponse getById(int id);
}