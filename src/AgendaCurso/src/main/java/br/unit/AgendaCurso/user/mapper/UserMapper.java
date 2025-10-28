package br.unit.AgendaCurso.user.mapper;

import br.unit.AgendaCurso.user.DTO.UserResponse;
import br.unit.AgendaCurso.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toUserReponse(User user){
        if (user == null) {
            return null;
        }

        UserResponse dto = new UserResponse();
        dto.setEmail(user.getEmail());
        dto.setName(user.getName());

        return dto;
    }
}
