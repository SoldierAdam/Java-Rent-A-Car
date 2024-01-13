package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.services.dtos.color.requests.AddColorRequest;
import com.tobeto.pair9.services.dtos.color.requests.UpdateColorRequest;
import com.tobeto.pair9.services.dtos.color.responses.GetListColorResponse;

import java.util.List;

public interface ColorService {

    List<GetListColorResponse> getAll();

    void add(AddColorRequest request);

    void update(UpdateColorRequest request);

    void delete(int id);

    boolean existsId(int id);
}
