package com.example.demo.service.impl;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class BookingServiceImplTest {
    @InjectMocks
    BookingServiceImpl bookingServiceImpl;
    @Mock
    BookingRepository bookingRepository;


    @Test
    public void Given_A_Booking_When_Save_Booking_Is_Cast_And_Both_Conditions_Are_True_Then_Return_True(){

        Booking booking = new Booking(1,1,null,1,null,new java.util.Date());
        Mockito.when(bookingRepository.save(any(Booking.class))).thenReturn(booking);
        Mockito.when(bookingRepository.countByClient(any(Integer.class))).thenReturn(0);
        Mockito.when(bookingRepository.countByDate(any(Date.class))).thenReturn(3);

        Boolean response = bookingServiceImpl.saveBooking(booking);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(true,response);
        Mockito.verify(bookingRepository).save(booking);
        Mockito.verify(bookingRepository).countByClient(1);
        Mockito.verify(bookingRepository).countByDate(any(Date.class));
    }
    @Test
    public void Given_A_Booking_When_Save_Booking_Is_Cast_And_Either_Conditions_Are_False_Then_Return_False(){

        Booking booking = new Booking(1,1,null,1,null,new java.util.Date());
        Mockito.when(bookingRepository.countByClient(any(Integer.class))).thenReturn(21);
        Mockito.when(bookingRepository.countByDate(any(Date.class))).thenReturn(0);

        Boolean response = bookingServiceImpl.saveBooking(booking);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(false,response);
        Mockito.verify(bookingRepository).countByClient(1);
        Mockito.verify(bookingRepository).countByDate(any(Date.class));
    }
    @Test
    public void Given_A_Booking_And_An_Illegal_Exception_When_Save_Booking_Is_Cast_Then_Return_False(){

        Booking booking = new Booking(1,1,null,1,null,new java.util.Date());
        Mockito.when(bookingRepository.save(any(Booking.class))).thenThrow(new IllegalArgumentException());

        Boolean response = bookingServiceImpl.saveBooking(booking);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(false,response);
    }
    @Test
    public void Given_A_Booking_List_When_Find_All_Is_Cast_Then_Return_Booking_List(){

        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking(1,1,null,1,null,new java.util.Date());
        bookingList.add(booking);
        Mockito.when(bookingRepository.findAll()).thenReturn(bookingList);

        List<Booking> response = bookingServiceImpl.findAll();

        Assertions.assertNotNull(response);
        Mockito.verify(bookingRepository).findAll();
    }
    @Test
    public void Given_A_List_And_A_Date_When_Find_By_Date_Is_Cast_Then_Return_Booking_List(){
        java.util.Date  date= new java.util.Date(2024-12-12);
        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking(1,1,null,1,null,date);
        bookingList.add(booking);
        Mockito.when(bookingRepository.findByDate(any(java.sql.Date.class))).thenReturn(bookingList);

        List<Booking> response = bookingServiceImpl.findByDate(date);

        Assertions.assertNotNull(response);
        Mockito.verify(bookingRepository).findByDate(any(java.sql.Date.class));
    }
}
