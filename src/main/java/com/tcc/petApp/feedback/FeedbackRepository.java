package com.tcc.petApp.feedback;

import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface FeedBackRepository extends Repository {

    public List<Feedback> findAll();

    public Optional<Feedback> findById(Long id);

    public Feedback save(Feedback feedback);

}
