package com.pfa.Careersync.Services;

import com.pfa.Careersync.Model.User;
import com.pfa.Careersync.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;
    public List<User> findAll(){return userRepository.findAll();}
    public void save (User user){
        var us = User.builder().id_user(user.getId_user()).nom_user(user.getNom_user()).prenom_user(user.getPrenom_user()).adresse(user.getAdresse())
                .email(user.getEmail()).bio(user.getBio()).date_naissance(user.getDate_naissance()).cv_file(user.getCv_file()).password(user.getPassword())
                .skills(user.getSkills()).recamended_jobs(user.getRecamended_jobs()).build();
        userRepository.save(us);
    }
    public void remove (Integer id  )throws Exception{
        User user_remove = userRepository.findById(id).orElseThrow(()->new Exception("utilisateur n'existe pas"));
        if(user_remove !=null){
            userRepository.delete(user_remove);
        }
    }
    public ResponseEntity<User> update (User user , Integer id) throws Exception{
        User us = userRepository.findById(id).orElseThrow(()->new Exception("utilisateur n'existe pas"));
        if (us != null){
            us.setId_user(user.getId_user());
            us.setNom_user(user.getNom_user());
            us.setPrenom_user(user.getPrenom_user());
            us.setAdresse(user.getAdresse());
            us.setEmail(user.getEmail());
            us.setPassword(user.getPassword());
            us.setBio(user.getBio());
            us.setSkills(user.getSkills());
            us.setRecamended_jobs(user.getRecamended_jobs());
            us.setDate_naissance(user.getDate_naissance());
            User newUser=userRepository.save(us);
            return ResponseEntity.ok(newUser);
        }
        return null;
    }
}
