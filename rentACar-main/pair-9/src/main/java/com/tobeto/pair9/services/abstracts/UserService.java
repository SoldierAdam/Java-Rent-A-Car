package com.tobeto.pair9.services.abstracts;

import com.tobeto.pair9.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair9.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair9.services.dtos.user.responses.GetListUserResponse;

import java.util.List;

public interface UserService {

    List<GetListUserResponse> getAll();

    void add(AddUserRequest request);

    void update(UpdateUserRequest request);

    void delete(int id);

    boolean existsId(int id);

    void entryCheck(String email);

}
