package Alparslan.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Alparslan.Kodlama.io.Devs.business.abstracts.FrameWorkService;
import Alparslan.Kodlama.io.Devs.business.requests.CreateFrameWorkRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllFrameWorksResponse;
import Alparslan.Kodlama.io.Devs.entities.concretes.FrameWork;

@RestController
@RequestMapping("api/frameworks")
public class FrameWorksController {
	private FrameWorkService frameWorkService;

	public FrameWorksController(FrameWorkService frameWorkService) {
		this.frameWorkService = frameWorkService;
	}

	@GetMapping("/getall")
	List<GetAllFrameWorksResponse> getAll() {
		return frameWorkService.getAll();
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateFrameWorkRequest createFrameWorkRequest) {
		frameWorkService.add(createFrameWorkRequest);
	}

	@PostMapping("/delete")
	public void delete(int id) {
		frameWorkService.delete(id);
	}

	@PostMapping("/update")
	public void update(@RequestBody FrameWork exFrameWork, FrameWork newFrameWork) {
		frameWorkService.update(exFrameWork, newFrameWork);
	}

	@GetMapping("getbyid")
	public GetAllFrameWorksResponse getById(int id) {
		return frameWorkService.getById(id);
	}

}
