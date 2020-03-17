package com.example.prueba_android.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AmazingCatPresenterTest {

    private AmazingCatPresenter presenter;

    @Before
    public void init(){
        presenter = Mockito.mock(AmazingCatPresenter.class);
    }

    @Test
    @DisplayName("Breed Request Test")
    public void breedRequestTest(){
        presenter.breedsRequest();
        verify(presenter).breedsRequest();
    }

    @Test
    @DisplayName("Cat Request Test")
    public void catRequestTest(){
        String id = "aab";
        int limit = 10;
        presenter.catRequest(id, limit);
        verify(presenter).catRequest(id, limit);
    }
}
