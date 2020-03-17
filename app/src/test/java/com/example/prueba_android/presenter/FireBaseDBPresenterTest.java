package com.example.prueba_android.presenter;

import com.example.prueba_android.model.Cat;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FireBaseDBPresenterTest {

    private FireBaseDBPresenter fireDB;

    @Before
    public void init(){
        fireDB = Mockito.mock(FireBaseDBPresenter.class);

    }

    @Test
    @DisplayName("Get Favourite Cats Test")
    public void getFavoutiteCatsTest(){
        fireDB.getFavouriteCatsList();
        verify(fireDB).getFavouriteCatsList();
    }

    @Test
    @DisplayName("Upload Cat Test")
    public void uploadCatTest(){
        Cat cat = Mockito.mock(Cat.class);
        String breedName = "bengal";
        fireDB.uploadFavourite(cat, breedName);
        verify(fireDB).uploadFavourite(cat, breedName);
    }
}
