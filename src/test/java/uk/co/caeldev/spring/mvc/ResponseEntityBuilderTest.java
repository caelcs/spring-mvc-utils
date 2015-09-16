package uk.co.caeldev.spring.mvc;

import org.junit.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.org.fyodor.generators.RDG.list;
import static uk.org.fyodor.generators.RDG.string;

public class ResponseEntityBuilderTest {

    @Test
    public void shouldBuildEntity() throws Exception {
        //Given
        final String resource = string().next();

        //When
        final ResponseEntity<String> response = ResponseEntityBuilder.<String>responseEntityBuilder().entity(resource).build();

        //Then
        assertThat(response.getBody()).isEqualTo(resource);
    }

    @Test
    public void shouldBuildListOfEntities() throws Exception {
        //Given
        final List<String> resource = list(string()).next();

        //When
        final ResponseEntity<List<String>> response = ResponseEntityBuilder.<List<String>>responseEntityBuilder().entity(resource).build();

        //Then
        assertThat(response.getBody()).isEqualTo(resource);
    }

}