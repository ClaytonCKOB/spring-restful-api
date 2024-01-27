package com.example.transaction.service;

import com.example.transaction.domain.user.UserType;
import com.example.transaction.dtos.UserDTO;
import com.example.transaction.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.transaction.domain.user.User;
import java.math.BigDecimal;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception{
        if(sender.userType == UserType.MERCHANT){
            throw new Exception("Usuário do tipo lojista nao esta autorizado a realizar transacao");
        }

        if(sender.balance.compareTo(amount) < 0){
            throw new Exception("Saldo insuficiente.");
        }

    }

    public User findUserById(Long id) throws Exception{
        return this.userRepository.findUserById(id).orElseThrow(() -> new Exception("Usuario nao encontrado"));
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }
}
