package com.pfa.Careersync.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user ;
    private String nom_user;
    private  String prenom_user;
    private String adres;
    private String email;
    private String password;
    private  String bio;
    private String skills;
    private String cv_file;
    private ArrayList<String> recamended_jobs;
    //TODO: ENUM niveaux etude
    private Date date_naissance;


}
