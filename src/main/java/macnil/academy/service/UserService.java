package macnil.academy.service;

import java.util.List;

import macnil.academy.controller.dto.UserDto;
import macnil.academy.model.User;

public interface UserService {
    /*recupera tutti gli user */
    List<UserDto> readAll(); 

    /*leggere un singolo user */
    UserDto read(Long id); 

    /*lista dell'email degli user */
    List<UserDto> read(String email); 

    /*lista degli user con firstname e city */
    List<UserDto> read(String firstname, String city); 

    
}
