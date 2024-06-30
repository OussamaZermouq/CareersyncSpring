package com.pfa.Careersync.auth;

import com.pfa.Careersync.Model.NiveauEtude;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String nom_user;
    private String prenom_user;
    private String adresse;
    private String email;
    private String password;
    private Date date_naissance;
    @Enumerated(EnumType.STRING)
    private NiveauEtude NiveauEtude;

}
