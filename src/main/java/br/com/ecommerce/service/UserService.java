package br.com.ecommerce.service;

import br.com.ecommerce.repository.UserRepository;
import br.com.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;
    //public List<User> listAll(){
//        return repo.findAll();
//    }
//
//    public void save(User user){
//        repo.save(user);
//    }
//
//    public User get(Integer id){
//        return repo.findById(id).get();
//    }
//
//    public void delete(Integer id){
//        repo.deleteById(id);
//    }

    public void addNewUser(String name, String email, String password){
        User newUser = new User();
        newUser.setUser_name(name);
        newUser.setUser_email(email);
        newUser.setUser_password(password);
        repo.save(newUser);
    }

    //Finds user by email and checks password
    public User findUserByEmail(String email, String password) {

        //Gets data from repository
        List<User> userList = repo.findUserByEmail(email);

        if(userList.isEmpty()){
            return null;
        }else{
            if(password.equals(userList.get(0).getUser_password())){
                return userList.get(0);
            }else{
                return null;
            }
        }
    }
}
