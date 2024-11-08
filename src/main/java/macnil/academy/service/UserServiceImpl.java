package macnil.academy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import macnil.academy.controller.dto.UserDto;
import macnil.academy.model.User;
import macnil.academy.repository.UserRepository;

//@Component("UserService")
@Service

public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository; 

    @Autowired
    private ModelMapper mapper;


    @Override
    public List<UserDto> readAll() {
        // return userRepository.findAll();
        List<UserDto> dtos = new ArrayList<UserDto>();
        for(User user: userRepository.findAll()){
            dtos.add(mapper.map(user,UserDto.class));
        }
        return dtos;
    }


    @Override
    public UserDto read(Long id) {
     //    Optional<User> optUser = userRepository.findById(id);
    //    if (optUser.isPresent()) {
    //         return optUser.get();
    //    }else{
    //     throw new ResponseStatusException(
    //         HttpStatus.NOT_FOUND,
    //         "User con id: " + id + "non trovato"
    //     );
    //    }
    // }

        Optional<User> optUser = userRepository.findById(id); 
        if (optUser.isPresent()) {
            return mapper.map(optUser.get(), UserDto.class); 
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User id=" + id + " not found");
        }
    }

    @Override
    public List<UserDto> read(String email) {
    //     if(email == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    //    return authorRepository.findByEmail(email);
    // }

        if(email == null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST); 
        List<UserDto> dtos = new ArrayList<UserDto>(); 
        for(User user: userRepository.findByEmail(email)){
            dtos.add(mapper.map(user, UserDto.class));
        }
        return dtos;
    }

    @Override
    public List<UserDto> read(String firstname, String city) {
    // if(firstname == null || lastname== null) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    //     return authorRepository.findByFirstnameAndLastname(firstname, lastname);
    // }

    if (firstname == null || city == null)
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    List<UserDto> dtos = new ArrayList<UserDto>();
    for(User user: userRepository.findByFirstnameAndCity(firstname, city)){
        dtos.add(mapper.map(user, UserDto.class));
    }
    return dtos ;
}

public List<User> readAll1(Integer numero, Long tenantId){
    List <User> user; 

    if (tenantId != null){
        user = userRepository.findByTenantId(tenantId);
    } else {
        user = userRepository.findAll(); 
    }

    if (numero == null || numero < 1)
        return user; 
    else {
        return user.stream().limit(numero).collect(Collectors.toList()); 
    }


}

    
}
