package com.craft.beer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.craft.beer.expcetions.ResourceNotFoundException;
import com.craft.beer.model.commons.StyleTypeDTO;
import com.craft.beer.model.entity.StyleType;
import com.craft.beer.model.request.StyleTypeRequest;
import com.craft.beer.repository.StyleTypeRepository;

@Service
public class StyleTypeService {
	private String ID_NOT_FOUND = "Style id[XXX] not found in our databse";

	private StyleTypeRepository styleTypeRepository;

	@Autowired
	public StyleTypeService(StyleTypeRepository styleTypeRepository) {
		super();
		this.styleTypeRepository = styleTypeRepository;
	}

	public StyleTypeRequest save(StyleTypeRequest styleTypeRequest) {
		StyleType st = styleTypeRepository.save(StyleTypeDTO.convertToEntity(styleTypeRequest));
		return StyleTypeDTO.convertToRequest(st);
	}

	public List<StyleTypeRequest> getAllFinds() {
		List<StyleType> list = styleTypeRepository.findAll();
		List<StyleTypeRequest> requests = new ArrayList<StyleTypeRequest>();
		for (StyleType styleType : list) {
			requests.add(StyleTypeDTO.convertToRequest(styleType));
		}
		return requests;
	}

	public StyleTypeRequest getFindById(String id) {
		StyleType st = styleTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND.replace("XXX", id)));
		return StyleTypeDTO.convertToRequest(st);
	}
	
	public StyleTypeRequest update(String id, StyleTypeRequest styleTypeRequest) {
		 Optional<StyleType> st = Optional.of(styleTypeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(ID_NOT_FOUND.replace("XXX", id))));
		
		if (st.isPresent()) {
			StyleType stDTO = StyleTypeDTO.convertToEntity(styleTypeRequest);
			stDTO.setId(st.get().getId());
			return StyleTypeDTO.convertToRequest(styleTypeRepository.save(stDTO));
		}
		return null;
	}

}
