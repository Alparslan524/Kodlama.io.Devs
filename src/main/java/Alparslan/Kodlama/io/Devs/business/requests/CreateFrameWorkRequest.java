package Alparslan.Kodlama.io.Devs.business.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFrameWorkRequest {
	@NotNull
	@NotBlank
	@Size(min = 1, max = 20)
	private String name;
	@NotNull
	private int languageId;
}
