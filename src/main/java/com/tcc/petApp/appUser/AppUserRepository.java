package com.tcc.petApp.appUser;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends Repository<AppUser, Long> {

    public List<AppUser> findAll();

    public Optional<AppUser> findById(Long id);

    public AppUser save(AppUser appUser);

    public void deleteById(Long id);
}
