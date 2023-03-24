package Alparslan.Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import Alparslan.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.FrameWorkRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FrameWorkBusinessRules {

	private FrameWorkRepository frameWorkRepository;

	public void checkIfFrameWorkNameExists(String name) {
		if (frameWorkRepository.existsByName(name)) {
			throw new BusinessException("FrameWorks Name (" + name + ") Already Exists");
		}
	}
}
