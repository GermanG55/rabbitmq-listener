package com.example.demo.service.impl;

import com.example.demo.model.Pet;
import com.example.demo.model.User;
import com.example.demo.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PetServiceImplTest {
    @InjectMocks
    private PetServiceImpl petServiceImpl;
    @Mock
    private PetRepository petRepository;
    private Pet pet;

    @Test
    public void Given_A_Pet_When_Save_Pet_Is_Cast_Then_Return_True(){

        Pet pet = new Pet(1,"Michi",1,null,new java.util.Date());
        Mockito.when(petRepository.save(any(Pet.class))).thenReturn(pet);
        Mockito.when(petRepository.countByClient(any(Integer.class))).thenReturn(1);

        Boolean response = petServiceImpl.savePet(pet);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(true,response);
        Mockito.verify(petRepository).save(pet);
    }
    @Test
    public void Given_A_Pet_When_Save_Pet_Is_Cast_And_The_Condition_Is_False_Then_Return_False(){

        Pet pet = new Pet(1,"Michi",1,null,new java.util.Date());
        Mockito.when(petRepository.countByClient(any(Integer.class))).thenReturn(3);

        Boolean response = petServiceImpl.savePet(pet);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(false,response);
        Mockito.verify(petRepository).countByClient(any(Integer.class));
    }
    @Test
    public void Given_A_Pet_And_An_Illegal_Exception_When_Save_Pet_Is_Cast_Then_Return_False(){

        Pet pet = new Pet(1,"Michi",1,null,new java.util.Date());
        Mockito.when(petRepository.save(any(Pet.class))).thenThrow(new IllegalArgumentException());

        Boolean response = petServiceImpl.savePet(pet);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(false,response);
    }
    @Test
    public void Given_A_Pet_List_When_Find_All_Is_Cast_Then_Return_Pet_List() {

        List<Pet> petList = new ArrayList<>();
        Pet pet = new Pet(1, "Michi", 1, null, new java.util.Date());
        petList.add(pet);
        Mockito.when(petRepository.findAll()).thenReturn(petList);

        List<Pet> response = petServiceImpl.findAll();

        Assertions.assertNotNull(response);
        Mockito.verify(petRepository).findAll();
    }
    @Test
    public void Given_A_List_And_An_Owner_Document_When_Find_By_Owner_Is_Cast_Then_Return_Pet_List(){

        List<Pet> petList = new ArrayList<>();
        Pet pet = new Pet(1,"German",1,new User(),new java.util.Date());
        petList.add(pet);
        Mockito.when(petRepository.findByOwnerDocument(1)).thenReturn(petList);

        List<Pet> response = petServiceImpl.findByOwnerDocument(1);

        Assertions.assertNotNull(response);
        Mockito.verify(petRepository).findByOwnerDocument(1);
    }
}
