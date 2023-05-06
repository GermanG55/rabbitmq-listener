package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
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
public class
UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userServiceImpl;
    @Mock
    private UserRepository userRepository;
    @Test
    public void Given_A_User_When_Save_User_Is_Cast_Then_Return_True(){

        User user = new User(1,"German","Negro Arroyo",new java.util.Date());
        Mockito.when(userRepository.save(any(User.class))).thenReturn(user);

        Boolean response = userServiceImpl.saveUser(user);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(true,response);
        Mockito.verify(userRepository).save(any(User.class));
    }
    @Test
    public void Given_A_User_And_An_Illegal_Exception_When_Save_User_Is_Cast_Then_Return_False(){

        User user = new User(1,"German","Negro Arroyo",new java.util.Date());
        Mockito.when(userRepository.save(any(User.class))).thenThrow(new IllegalArgumentException());
        Boolean response = userServiceImpl.saveUser(user);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(false,response);
    }
    @Test
    public void Given_A_User_List_When_Find_All_Is_Cast_Then_Return_User_List(){

        List<User> userList = new ArrayList<>();
        User user = new User(1,"German","Negro Arroyo",new java.util.Date());
        userList.add(user);
        Mockito.when(userRepository.findAll()).thenReturn(userList);

        List<User> response = userServiceImpl.findAll();

        Assertions.assertNotNull(response);
        Mockito.verify(userRepository).findAll();
    }
    @Test
    public void Given_A_User_List_When_Find_Booking_By_Document_Is_Cast_Then_Return_Booking_List(){

        List<User> userList = new ArrayList<>();
        User user = new User(1,"German","Negro Arroyo",new java.util.Date());
        userList.add(user);
        Mockito.when(userRepository.findBookingByDocument(any(Integer.class))).thenReturn(userList);

        List<User> response = userServiceImpl.findBookingByDocument(1);

        Assertions.assertNotNull(response);
        Mockito.verify(userRepository).findBookingByDocument(1);
    }
    @Test
    public void Given_A_User_List_When_Find_Pets_By_Document_Is_Cast_Then_Return_Pet_List(){

        List<User> userList = new ArrayList<>();
        User user = new User(1,"German","Negro Arroyo",new java.util.Date());
        userList.add(user);
        Mockito.when(userRepository.findPetsByDocument(any(Integer.class))).thenReturn(userList);

        List<User> response = userServiceImpl.findPetsByDocument(1);

        Assertions.assertNotNull(response);
        Mockito.verify(userRepository).findPetsByDocument(1);
    }
}
