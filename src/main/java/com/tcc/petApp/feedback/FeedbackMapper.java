package com.tcc.petApp.feedback;

import com.tcc.petApp.feedback.api.FeedbackRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FeedbackMapper {

    public FeedbackRequest feedbacktoFeedbackRequest(Feedback feedback) {
        return FeedbackRequest.builder()
                .score(feedback.getScore())
                .comment(feedback.getComment())
                .careServiceId(feedback.getCareServiceId())
                .build();
    }

    public Feedback feedbackRequestToFeedback(FeedbackRequest feedbackRequest) {
        return Feedback.builder()
                .score(feedbackRequest.getScore())
                .comment(feedbackRequest.getComment())
                .careServiceId(feedbackRequest.getCareServiceId())
                .build();
    }

    public Feedback updateSetterFeedback(Feedback feedback, FeedbackRequest feedbackRequest) {
        feedback.setComment(feedbackRequest.getComment());
        feedback.setScore(feedbackRequest.getScore());
        return feedback;
    }

    public List<FeedbackRequest> feedbackListToFeedbackRequestList(List<Feedback> feedbackList) {
        List<FeedbackRequest> feedbackRequestList = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
feedbackRequestList.add((feedbacktoFeedbackRequest(feedback));
        }
    }
}
