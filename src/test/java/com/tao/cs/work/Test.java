package com.tao.cs.work.controller;

import com.tao.cs.work.entity.User;
import com.tao.cs.work.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginControllerTest {

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private LoginController loginController;

    private MockHttpSession httpSession;
    private Model model;

    @BeforeEach
    void setUp() {
        httpSession = new MockHttpSession();
        model = new ModelMap();
    }

    @Test
    void doLogin_ValidUser_ReturnsHome() {
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setName("test");
        mockUser.setUsername("test");
        mockUser.setPassword("test");

        when(studentService.getByUserName(anyString())).thenReturn(mockUser);

        String result = loginController.doLogin(mockUser.getUsername(), mockUser.getPassword(), httpSession, model);

        assertNotNull(result);
        assertEquals("home", result);
        assertTrue(httpSession.getAttribute("currentuser") instanceof User);
    }

    @Test
    void doLogin_InvalidUser_ReturnsNull() {
        when(studentService.getByUserName(anyString())).thenReturn(null);

        String result = loginController.doLogin("invalidUser", "invalidPass", httpSession, model);

        assertNull(result);
        assertTrue(model.asMap().containsKey("error"));
    }

    @Test
    void doLogin_WrongPassword_ReturnsNull() {
        User mockUser = new User();
        mockUser.setId(1);
        mockUser.setName("test");
        mockUser.setUsername("test");
        mockUser.setPassword("correctPassword");

        when(studentService.getByUserName(anyString())).thenReturn(mockUser);

        String result = loginController.doLogin(mockUser.getUsername(), "wrongPassword", httpSession, model);

        assertNull(result);
        assertTrue(model.asMap().containsKey("error"));
    }
}
