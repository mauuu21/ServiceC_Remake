package org.example.servicec_remake.filledform.model;




import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.servicec_remake.form.model.FreeTextQuestion;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class FreeTextAnswer extends AbstractAnswer {

    private FreeTextQuestion freeTextQuestion;

    //TODO moderation implementation first
    private String moderation;
}
