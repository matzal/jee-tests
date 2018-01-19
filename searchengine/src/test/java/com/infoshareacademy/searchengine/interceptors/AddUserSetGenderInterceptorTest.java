package com.infoshareacademy.searchengine.interceptors;

import com.infoshareacademy.searchengine.dao.UsersRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;
import org.junit.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;

import static org.mockito.Mockito.when;

public class AddUserSetGenderInterceptorTest {

    @Mock
    private UsersRepositoryDao usersRepositoryDao;

    private User JANKOWALSKI = newUser("Jan", "Kowalski", "janko", 40);
    private User ANNANOWAK = newUser("Anna", "Nowak", "annno", 30);

    private User newUser(String name, String surname, String login, int age) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setAge(age);
        return user;
    }

/*    @Test
    public void intercept() {
        //given
        when(usersRepositoryDao.addUser(any(User.class))).thenReturn(JANKOWALSKI);
        //when
        usersRepositoryDao.addUser(JANKOWALSKI);
        //then
        assertThat(JANKOWALSKI.getGender()).isEqualTo(Gender.MAN);
    }*/
}