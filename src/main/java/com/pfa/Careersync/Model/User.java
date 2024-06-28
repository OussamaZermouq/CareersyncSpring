package com.pfa.Careersync.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user ;
    private String nom_user;
    private String prenom_user;
    private String adresse;
    private String email;
    private String password;
    private Date date_naissance;
    @Enumerated(EnumType.STRING)
    private NiveauEtude NiveauEtude;

    //Contains the URL, or the ID of the file that has been uploaded to the cloud service.
    private String CvFile;
    private String bio;
    private String skills;

}
