package hu.codehunters.mockmoderationservice.controller.dto;

import lombok.*;

@Value
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Builder
public class ModerationRequest {

    String text;

}
