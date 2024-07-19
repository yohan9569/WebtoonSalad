package com.webtoonsalad.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.webtoonsalad.mapper.JJimMapper;

@RunWith(MockitoJUnitRunner.class)
public class JJimServiceTest {

    @Mock
    private JJimMapper jjimMapper;

    @InjectMocks
    private JJimServiceImpl jjimService;

    @Test
    public void testDeleteJJim() {
        // Given
        String userId = "test1";
        String webtoonId = "naver_768536";

        // When
        jjimService.deleteJJim(userId, webtoonId);

        // Then
        verify(jjimMapper, times(1)).deleteJJim(userId, webtoonId);
    }
}
