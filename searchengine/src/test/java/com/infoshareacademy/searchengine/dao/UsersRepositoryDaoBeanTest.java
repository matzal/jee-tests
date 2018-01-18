package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UsersRepositoryDaoBeanTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    UsersRepositoryDao usersRepositoryDao = new UsersRepositoryDaoBean();

    private User JANKOWALSKI = newUser("Jan", "Kowalski", "janko", 40, Gender.MAN);

    private User newUser(String name, String surname, String login, int age, Gender gender) {
        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setLogin(login);
        user.setAge(age);
        user.setGender(gender);
        return user;
    }

/*    @Test
    public void addOneUser() {
        //given
        User user = JANKOWALSKI;
        //when
        usersRepositoryDao.addUser(user);
        //then
        assertThat(usersRepository.getUserByLogin("janko")).isEqualTo(JANKOWALSKI);
    }*/

    @Test
    public void getUserById() {
    }

    @Test
    public void getUserByLogin() {
    }

    @Test
    public void getUsersList() {
    }

    @Test
    public void getUsersNames() {
    }
}