package com.tcc.petApp.feedback;

import com.tcc.petApp.appUser.petOwner.PetOwner;
import com.tcc.petApp.appUser.petOwner.PetOwnerService;
import com.tcc.petApp.careService.CareService;
import com.tcc.petApp.careService.CareServiceService;
import com.tcc.petApp.feedback.api.FeedbackRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/feedback")
public class FeedbackController {

    @Autowired
    FeedbackService feedbackService;

    @Autowired
    FeedbackMapper feedbackMapper;

    @Autowired
    CareServiceService careServiceService;

    @Autowired
    PetOwnerService petOwnerService;

    //FEEDBACK LIST
    @GetMapping
    public ResponseEntity<List<Feedback>> findAllFeedbacks() {
        return new ResponseEntity<List<Feedback>>(feedbackService.findAllFeedbacks(), HttpStatus.OK);
    }

    //FEEDBACK REQUEST LIST
    /*
    @GetMapping
    public ResponseEntity<List<FeedbackRequest>> findAllFeedbacks() {
        List<Feedback> feedbackList = feedbackService.findAllFeedbacks();
        return new ResponseEntity<List<FeedbackRequest>>(feedbackMapper.feedbackListToFeedbackRequestList(feedbackList), HttpStatus.OK);
    }
     */

    @GetMapping("/{id}")
    public ResponseEntity<FeedbackRequest> findFeedbackById(@PathVariable("id") Long id) {

        Optional<Feedback> feedback = feedbackService.findFeedbackById(id);

        return feedback.map(value -> new ResponseEntity<FeedbackRequest>(feedbackMapper.feedbacktoFeedbackRequest(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<FeedbackRequest> saveFeedback(@RequestBody FeedbackRequest feedbackRequest) {
        Feedback feedback = feedbackMapper.feedbackRequestToFeedback(feedbackRequest);
        feedbackService.saveFeedback(feedback);
        CareService careService = careServiceService.findCareServiceById(feedbackRequest.getCareServiceId()).get();
        PetOwner petOwner = petOwnerService.findPetOwnerById(feedbackRequest.getPetOwnerId()).get();
        List<Long> serviceFeedbackIds = careService.getFeedbackIds();
        List<Long> ownerFeedbackIds = petOwner.getFeedbackIds();
        serviceFeedbackIds.add(feedback.getId());
        ownerFeedbackIds.add(feedback.getId());
        petOwner.setFeedbackIds(ownerFeedbackIds);
        careService.setFeedbackIds(serviceFeedbackIds);
        petOwnerService.updatePetOwner(petOwner);
        careServiceService.updateCareService(careService);
        return new ResponseEntity<FeedbackRequest>(feedbackRequest, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FeedbackRequest> updateFeedback(@PathVariable("id") Long id, @RequestBody FeedbackRequest feedbackRequest) {
        Optional<Feedback> feedbackToUpdate = feedbackService.findFeedbackById(id);

        return feedbackToUpdate.map(feedback -> new ResponseEntity<FeedbackRequest>
                        (feedbackMapper.feedbacktoFeedbackRequest(feedbackService.saveFeedback
                                (feedbackMapper.updateSetterFeedback(
                                        feedback, feedbackRequest))), HttpStatus.ACCEPTED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedbackById(@PathVariable Long id) {
        Optional<Feedback> feedback = feedbackService.findFeedbackById(id);

        if (feedback.isPresent()) {
            feedbackService.deleteFeedbackById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

