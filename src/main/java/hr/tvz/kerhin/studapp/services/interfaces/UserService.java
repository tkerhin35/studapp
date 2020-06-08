package hr.tvz.kerhin.studapp.services.interfaces;

import hr.tvz.kerhin.studapp.models.DTO.UserDTO;

import java.util.Optional;

public interface UserService {

    Optional<UserDTO> getCurrentUser();
}
