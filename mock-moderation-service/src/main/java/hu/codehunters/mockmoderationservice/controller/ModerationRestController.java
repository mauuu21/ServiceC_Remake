package hu.codehunters.mockmoderationservice.controller;

import hu.codehunters.mockmoderationservice.controller.dto.ModerationRequest;
import hu.codehunters.mockmoderationservice.controller.dto.ModerationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModerationRestController {

    @PostMapping(path = "moderation/ok")
    ResponseEntity<ModerationResponse> runModeration(ModerationRequest moderationRequest) {
        return ResponseEntity.ok(ModerationResponse
                .builder()
                .text(moderationRequest.getText())
                .build()
        );
    }

    @PostMapping(path = "moderation/serverfailed")
    ResponseEntity<ModerationResponse> failOnModeration(ModerationRequest moderationRequest) {
        return ResponseEntity.internalServerError().build();
    }

}
