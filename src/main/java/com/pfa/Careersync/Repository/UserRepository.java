package com.pfa.Careersync.Repository;

import com.pfa.Careersync.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
