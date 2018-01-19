package com.infoshareacademy.searchengine.repository;

import com.infoshareacademy.searchengine.dao.StatisticsRepositoryDao;
import com.infoshareacademy.searchengine.domain.Gender;
import com.infoshareacademy.searchengine.domain.User;
import org.junit.Test;
import org.mockito.Mock;
import java.util.Arrays;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

public class StatisticsRepositoryTest {

    @Mock
    UsersRepository usersRepository;

    @Mock
    StatisticsRepositoryDao statisticsRepositoryDao;

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
    public void getRepository() {
        //given
        when(usersRepository.getUsersList()).thenReturn(Arrays.asList(JANKOWALSKI, ANNANOWAK));
        //when
        Map<User, Integer> statistics = statisticsRepositoryDao.getAllStatistics();
        //then
        assertThat(statistics).containsOnlyKeys(JANKOWALSKI, ANNANOWAK);
    }*/
}