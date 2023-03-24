package Alparslan.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Alparslan.Kodlama.io.Devs.business.abstracts.FrameWorkService;
import Alparslan.Kodlama.io.Devs.business.requests.CreateFrameWorkRequest;
import Alparslan.Kodlama.io.Devs.business.requests.UpdateFrameWorkRequest;
import Alparslan.Kodlama.io.Devs.business.responses.GetAllFrameWorksResponse;
import Alparslan.Kodlama.io.Devs.business.responses.GetByIdFrameWorksResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/frameworks")
public class FrameWorksController {
	private FrameWorkService frameWorkService;

	public FrameWorksController(FrameWorkService frameWorkService) {
		this.frameWorkService = frameWorkService;
	}

	@GetMapping
	List<GetAllFrameWorksResponse> getAll() {
		return frameWorkService.getAll();
	}

	@PostMapping
	public void add(@RequestBody @Valid CreateFrameWorkRequest createFrameWorkRequest) {
		frameWorkService.add(createFrameWorkRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@RequestBody @PathVariable int id) {
		frameWorkService.delete(id);
	}

	@PutMapping()
	public void update(@RequestBody @Valid UpdateFrameWorkRequest updateFrameWorkRequest) {
		frameWorkService.update(updateFrameWorkRequest);
	}

	@GetMapping("/{id}")
	public GetByIdFrameWorksResponse getById(@PathVariable int id) {
		return frameWorkService.getById(id);
	}

}
