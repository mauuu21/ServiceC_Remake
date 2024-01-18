package org.example.servicec_remake.form.repository;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.servicec_remake.common.repository.AbstractAuditor;
import org.example.servicec_remake.form.model.AbstractQuestion;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Data
@Document(value = "forms")
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
public class FormDocument extends AbstractAuditor {

    @Id
    @EqualsAndHashCode.Include
    private UUID id;

    private String name;

    private String description;

    private boolean active;

    @Builder.Default
    private List<AbstractQuestion> questions = new LinkedList<>();
}
