package com.tcc.petApp.feedback.api;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class FeedbackRequest {

    @NotNull
    private byte score;

    @Size(min = 1, max = 255, message = "Comment must be between 1 and 255 characters")
    private String comment;

    @NotNull
    private Long careServiceId;
}
