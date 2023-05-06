package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    private List<User> userList(){
        List<User> userList= new ArrayList<>();
        User user = new User();
        user.setDocument(621);
        user.setName("Daniel");
        user.setAddress("Chilacos 34-100");
        user.setDateCreated(new Date());;
        userList.add(user);
        return userList;
    }

    @Mock
    UserService userService;
    @InjectMocks
    UserController userController ;

    @Test
    public void Given_All_Values_Request_When_Values_Arent_Empty_Then_Return_Existing_List_As_Not_Empty (){
        Mockito.when(userService.findAll()).thenReturn(userList());
        List<User> result = userController.findAll();
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(userService).findAll();
    }

    @Test
    public void Given_All_Values_Request_When_Values_Arent_Null_Then_Return_Size_Existent (){
        Mockito.when(userService.findAll()).thenReturn(userList());
        List<User> result = userController.findAll();
        assertNotNull(result.size());
        Assertions.assertThat(result);
        Mockito.verify(userService).findAll();
    }

    @Test
    public void Given_Saved_User_When_New_User_Registered_Then_Return_Boolean_True (){
        User user = new User(531,"Daniel","Rio Frio",new Date());
        Mockito.when(userService.saveUser(new User())).thenReturn(true);
        boolean result = userController.saveUser(new User());
        assertEquals(true, result);
        Mockito.verify(userService).saveUser(new User());
    }

    @Test
    public void Given_Search_Booking_By_Document_When_New_Search_Done_Then_Return_List_Size_As_One (){
        Mockito.when(userService.findBookingByDocument(621)).thenReturn(userList());
        List<User> result = userController.findBookingByDocument(621);
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(userService).findBookingByDocument(621);
    }

    @Test
    public void Given_Pets_Search_By_Document_When_New_Search_Done_Then_Return_List_Size_As_One (){
        Mockito.when(userService.findPetsByDocument(621)).thenReturn(userList());
        List<User> result = userController.findPetsByDocument(621);
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(userService).findPetsByDocument(621);
    }

    @Test
    public void Given_Booking_Search_By_Document_Request_When_Values_Arent_Null_Then_Return_Size_Existent (){
        Mockito.when(userService.findBookingByDocument(621)).thenReturn(userList());
        List<User> result = userController.findBookingByDocument(621);
        assertNotNull(result.size());
        Assertions.assertThat(result);
        Mockito.verify(userService).findBookingByDocument(621);
    }

    @Test
    public void Given_Pet_Search_By_Document_Request_When_Values_Arent_Null_Then_Return_Size_Existent (){
        Mockito.when(userService.findPetsByDocument(621)).thenReturn(userList());
        List<User> result = userController.findPetsByDocument(621);
        assertNotNull(result.size());
        Assertions.assertThat(result);
        Mockito.verify(userService).findPetsByDocument(621);
    }

}