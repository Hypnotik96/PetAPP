package com.tcc.petApp.feedback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    FeedbackRepository feedBackRepository;

    public List<Feedback> findAllFeedbacks() {
        return feedBackRepository.findAll();
    }

    public Optional<Feedback> findFeedbackById(Long id) {
        return feedBackRepository.findById(id);
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedBackRepository.save(feedback);
    }

    public Feedback updateFeedback(Feedback feedback) {
        return feedBackRepository.save(feedback);
    }

    public void deleteFeedbackById(Long id) {
        feedBackRepository.deleteById(id);
    }
}
