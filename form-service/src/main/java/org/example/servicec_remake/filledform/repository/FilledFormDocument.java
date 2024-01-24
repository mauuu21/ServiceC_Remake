package org.example.servicec_remake.filledform.repository;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.servicec_remake.common.repository.AbstractAuditor;
import org.example.servicec_remake.filledform.model.AbstractAnswer;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
@Document(value = "filled-forms")
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class FilledFormDocument extends AbstractAuditor {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    private UUID formId;

    @Builder.Default
    List<AbstractAnswer> answers = new LinkedList<>();

}
