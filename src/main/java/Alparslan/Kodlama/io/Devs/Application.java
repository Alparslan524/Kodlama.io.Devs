package Alparslan.Kodlama.io.Devs;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import Alparslan.Kodlama.io.Devs.core.utilities.exceptions.BusinessException;
import Alparslan.Kodlama.io.Devs.core.utilities.exceptions.ProblemDetails;
import Alparslan.Kodlama.io.Devs.core.utilities.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}// Sadece Business hatalarınnda çalışır

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("VALIDATION.EXCEPTİON");
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());

		for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}

		return validationProblemDetails;
	}// Sadece Validation hatalarınnda çalışır

	// Herhangi bir hataya yakalandığı zaman üstteki kodlar çalışarak hata mesajını
	// bir nevi filtreliyor
	// ve son kullanıcının anlayacağı şekilde yansıtıyor. Üstteki kod
	// BusinnesException hatalarında
	// alttaki kod Validation hatalarında

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
