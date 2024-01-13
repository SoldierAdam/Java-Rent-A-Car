package com.tobeto.pair9.services.concretes;

import com.tobeto.pair9.core.utilities.mappers.ModelMapperService;
import com.tobeto.pair9.entities.concretes.User;
import com.tobeto.pair9.repositories.UserRepository;
import com.tobeto.pair9.services.abstracts.UserService;
import com.tobeto.pair9.services.dtos.user.requests.AddUserRequest;
import com.tobeto.pair9.services.dtos.user.requests.UpdateUserRequest;
import com.tobeto.pair9.services.dtos.user.responses.GetListUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<GetListUserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> this.modelMapperService.forResponse()
                        .map(user, GetListUserResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void add(AddUserRequest request) {
        entryCheck(request.getEmail());
        User user = this.modelMapperService.forRequest().map(request,User.class);
        this.userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest request) {
        entryCheck(request.getEmail());
        User user = this.modelMapperService.forRequest()
                .map(request,User.class);
        this.userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        this.userRepository.deleteById(id);

    }

    @Override
    public boolean existsId(int id) {
        return userRepository.existsById(id);
    }

    @Override
    public void entryCheck(String email) {
        if(userRepository.existsUserByEmail(email)){
            throw new RuntimeException("There cannot be two person with the same email address");
        }
    }
}
