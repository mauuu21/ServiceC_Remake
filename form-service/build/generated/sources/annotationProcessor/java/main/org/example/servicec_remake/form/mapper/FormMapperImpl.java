package org.example.servicec_remake.form.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.servicec_remake.form.model.AbstractQuestion;
import org.example.servicec_remake.form.model.Form;
import org.example.servicec_remake.form.repository.FormDocument;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-06T16:27:33+0100",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 21 (Amazon.com Inc.)"
)
@Component
public class FormMapperImpl implements FormMapper {

    @Override
    public Form convertToForm(FormDocument formDocument) {
        if ( formDocument == null ) {
            return null;
        }

        Form.FormBuilder form = Form.builder();

        form.id( formDocument.getId() );
        form.name( formDocument.getName() );
        form.description( formDocument.getDescription() );
        form.active( formDocument.isActive() );
        List<AbstractQuestion> list = formDocument.getQuestions();
        if ( list != null ) {
            form.questions( new ArrayList<AbstractQuestion>( list ) );
        }

        return form.build();
    }
}
