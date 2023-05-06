package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Pet;
import com.example.demo.model.User;
import com.example.demo.service.BookingService;
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

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {

    private List<Booking> bookingList() {
        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking();
        booking.setBookingId(123);
        booking.setClientId(173);
        booking.setDate(new Date(23-23-22));
        booking.setPetId(340);
        bookingList.add(booking);
        return bookingList;
    }

    @Mock
    BookingService bookingService;
    @InjectMocks
    BookingController bookingController ;

    @Test
    public void Given_Find_All_Values_When_Values_Arent_Empty_Then_Return_Existing_List_As_Not_Empty (){
        Mockito.when(bookingService.findAll()).thenReturn(bookingList());
        List<Booking> result = bookingController.findAll();
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(bookingService).findAll();
    }

    @Test
    public void Given_All_Values_Request_When_Values_Arent_Null_Then_Return_Size_Existent (){
        Mockito.when(bookingService.findAll()).thenReturn(bookingList());
        List<Booking> result = bookingController.findAll();
        assertNotNull(result.size());
        Assertions.assertThat(result);
        Mockito.verify(bookingService).findAll();
    }

    @Test
    public void Given_Saved_Booking_When_New_Booking_Registered_Then_Return_Boolean_True (){
        Booking booking = new Booking(422,323,new User(),433,new Pet(),new Date());
        Mockito.when(bookingService.saveBooking(new Booking())).thenReturn(true);
        boolean result = bookingController.saveBooking(new Booking());
        assertEquals(true, result);
        Mockito.verify(bookingService).saveBooking(new Booking());
    }

    @Test
    public void Given_Search_By_Date_When_New_Search_Done_Then_Return_List_Size_As_One (){
        Mockito.when(bookingService.findByDate(new Date(23-23-22))).thenReturn(bookingList());
        List<Booking> result = bookingController.findByDate(new Date(23-23-22));
        assertEquals(1, result.size());
        Assertions.assertThat(result);
        Mockito.verify(bookingService).findByDate(new Date(23-23-22));
    }

    @Test
    public void Given_Search_Values_Request_By_Date_When_Values_Arent_Null_Then_Return_Size_Existent (){
        Mockito.when(bookingService.findByDate(new Date(23-23-22))).thenReturn(bookingList());
        List<Booking> result = bookingController.findByDate(new Date(23-23-22));
        assertNotNull(result.size());
        Assertions.assertThat(result);
        Mockito.verify(bookingService).findByDate(new Date(23-23-22));
    }

}
