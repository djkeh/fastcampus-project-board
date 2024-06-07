package com.fastcampus.projectboard.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("[Repository] 해시태그 테스트")
@DataJpaTest
class HashtagRepositoryTest {

    @Autowired private HashtagRepository sut;

    @DisplayName("해시태그가 없으면, 예외를 던진다.")
    @Test
    void givenHashtagId_whenHashTagDoesNotExist_thenThrowsException() {
        // Given
        Long hashtagId = 1L;
        sut.deleteById(hashtagId);

        // When
        Throwable t = catchThrowable(() -> sut.getReferenceById(hashtagId));

        // Then
        assertThat(t)
                .isInstanceOf(JpaObjectRetrievalFailureException.class)
                .hasRootCauseInstanceOf(EntityNotFoundException.class);
    }
}