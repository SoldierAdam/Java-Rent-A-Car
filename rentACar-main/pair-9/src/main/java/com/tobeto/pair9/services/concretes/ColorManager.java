package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair9.entities.concretes.Color;
import com.tobeto.pair9.repositories.ColorRepository;
import com.tobeto.pair9.services.abstracts.ColorService;
import com.tobeto.pair9.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair9.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair9.services.dtos.color.responses.GetListColorResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ColorManager implements ColorService {
    private ColorRepository colorRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetListColorResponse> getAll() {
        List<Color> colors = colorRepository.findAll();
        return colors.stream().map(color -> this.modelMapperService.forResponse().map(color,GetListColorResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void add(AddColorRequest request) {
        if(colorRepository.existsByName(request.getName())){
            throw new RuntimeException("There cannot be same color");
        }
        Color color = this.modelMapperService.forRequest().map(request,Color.class);
        this.colorRepository.save(color);
    }

    @Override
    public void update(UpdateColorRequest request) {
        if(colorRepository.existsByName(request.getName())){
            throw new RuntimeException("There cannot be same color");
        }
        Color color = this.modelMapperService.forRequest().map(request,Color.class);
        this.colorRepository.save(color);

    }

    @Override
    public void delete(int id) {
        this.colorRepository.deleteById(id);
    }

    @Override
    public boolean existsId(int id) {
        return colorRepository.existsById(id);
    }
}
