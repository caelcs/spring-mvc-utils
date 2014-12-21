package uk.co.caeldev.spring.mvc;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.caeldev.spring.mvc.commons.SpringMongoCommonsRDG.string;

public class ETagBuilderTest {

    @Test
    public void shouldGenerateAlwaysTheSameETagForIdenticalHashCode() throws Exception {
        // Given
        final String hashcode = string().next();

        // When
        final String firstETag = ETagBuilder.eTagBuilder().value(hashcode).build();
        // And
        final String secondETag = ETagBuilder.eTagBuilder().value(hashcode).build();

        // Then
        assertThat(firstETag).isEqualTo(secondETag);
    }

    @Test
    public void shouldGenerateDifferentETagForDifferentHashCode() throws Exception {
        // Given
        final String firstHashcode = string().next();
        final String secondHashcode = string().next();

        // When
        final String firstETag = ETagBuilder.eTagBuilder().value(firstHashcode).build();
        // And
        final String secondETag = ETagBuilder.eTagBuilder().value(secondHashcode).build();

        // Then
        assertThat(firstETag).isNotEqualTo(secondETag);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointExceptionWhenValueHashCodeIsNull() throws Exception {
        // When
        ETagBuilder.eTagBuilder().value(null).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenValueIsEmpty() throws Exception {
        // When
        ETagBuilder.eTagBuilder().value("").build();
    }

}