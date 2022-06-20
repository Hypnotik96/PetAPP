package com.tcc.petApp.appUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository appUserRepository;

    public List<AppUser> findAllAppUsers() {
        return appUserRepository.findAll();
    }

    public Optional<AppUser> findAppUserById(Long id) {
        return appUserRepository.findById(id);
    }

    public AppUser saveAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public AppUser updateAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public void deleteAppUserById(Long id) {
        appUserRepository.deleteById(id);
    }
}
