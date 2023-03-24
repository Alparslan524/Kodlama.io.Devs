package Alparslan.Kodlama.io.Devs.business.rules;

import org.springframework.stereotype.Service;

import Alparslan.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import Alparslan.Kodlama.io.Devs.dataAccess.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LanguageBusinessRules {

	private LanguageRepository languageRepository;

	public void checkIfLanguageNameExists(String name) {
		if (languageRepository.existsByName(name)) {
			throw new BusinessException("Language Name (" + name + ") Already Exists");
		}
	}
}
