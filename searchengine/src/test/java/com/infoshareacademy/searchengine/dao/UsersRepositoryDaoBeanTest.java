package com.infoshareacademy.searchengine.dao;

import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;
import com.infoshareacademy.searchengine.repository.UsersRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class UsersRepositoryDaoBeanTest {

    @Mock
    private UsersRepository usersRepository;

    @Mock
    private UsersRepositoryDaoRemote usersRepositoryDaoRemote;

    @InjectMocks
    UsersRepositoryDao usersRepositoryDao = new UsersRepositoryDaoBean();

    private User JANKOWALSKI = newUser("Jan", "Kowalski", "janko", 40, Gender.MAN);
    private User ANNANOWAK = newUser("Anna", "Nowak", "annno", 30, Gender.WOMAN);

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
        //given
        when(usersRepository.getUserById(anyInt())).thenReturn(JANKOWALSKI);
        //when
        User user = usersRepositoryDao.getUserById(1);
        //then
        assertThat(user).isEqualTo(JANKOWALSKI);
    }

    @Test
    public void getUserByLogin() {
        //given
        when(usersRepository.getUserByLogin("janko")).thenReturn(JANKOWALSKI);
        //when
        User user = usersRepositoryDao.getUserByLogin("janko");
        //then
        assertThat(user).isEqualTo(JANKOWALSKI);
    }

    @Test
    public void getUsersList() {
        //given
        when(usersRepository.getUsersList()).thenReturn(Arrays.asList(JANKOWALSKI, ANNANOWAK));
        //when
        List<User> userList = usersRepositoryDao.getUsersList();
        //then
        assertThat(userList).isEqualTo(Arrays.asList(JANKOWALSKI, ANNANOWAK));
    }

    @Test
    public void getUsersNames() {
        //given
        when(usersRepositoryDaoRemote.getUsersNames()).thenReturn(Arrays.asList(JANKOWALSKI.getName(), ANNANOWAK.getName()));
        //when
        List<String> usersNames = usersRepositoryDaoRemote.getUsersNames();
        //then
        assertThat(usersNames).isEqualTo(Arrays.asList(JANKOWALSKI.getName(), ANNANOWAK.getName()));
    }
}