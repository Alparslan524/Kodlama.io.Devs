package Alparslan.Kodlama.io.Devs.core.utilities.mappers.abstracts;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forResponse();

	ModelMapper forRequest();
}
