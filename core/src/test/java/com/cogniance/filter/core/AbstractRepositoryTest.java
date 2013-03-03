package com.cogniance.filter.core;

import com.cogniance.filter.domain.User;
import com.cogniance.filter.repositories.SimpleFilterRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * User: amaksymenko
 * Date: 3/3/13
 * Time: 8:17 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:infrastructure.xml")
@Transactional
public class AbstractRepositoryTest {

    @Autowired
    protected SimpleFilterRepository repository;

    protected User user;
    protected User user2;

    @Before
    public void setUpDefaultEntities() {
        user = new User();
        user.setUsername("foobar1");
        user.setFirstname("firstname1");
        user.setLastname("lastname1");

        user = repository.save(user);

        User user2 = new User();
        user2.setUsername("foobar2");
        user2.setFirstname("firstname2");
        user2.setLastname("lastname2");

        user2 = repository.save(user2);
    }

    @Test
    public void isDataReady() throws Exception {
        user = repository.findOne(user.getId());
        assertNotNull(user);
    }

}
