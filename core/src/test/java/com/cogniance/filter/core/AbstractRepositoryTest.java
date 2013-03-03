package com.cogniance.filter.core;

import com.cogniance.filter.domain.Role;
import com.cogniance.filter.domain.RoleUserPersonalInfo;
import com.cogniance.filter.domain.User;
import com.cogniance.filter.repositories.RoleRepository;
import com.cogniance.filter.repositories.UserRepository;
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
    protected UserRepository userRepository;

    @Autowired
    protected RoleRepository roleRepository;

    protected Role role1;
    protected Role role2;

    protected User user1;
    protected User user2;

    @Before
    public void setUpDefaultEntities() {
        role1 = new Role();
        role1.setRolename("read");
        role1 = roleRepository.save(role1);

        role2 = new Role();
        role2.setRolename("write");
        role2 = roleRepository.save(role2);

        user1 = new User();
        user1.setUsername("foobar1");
        user1.setFirstname("firstname1");
        user1.setLastname("lastname1");
        user1.getRoles().add(role1);
        user1.setPersonalInfo(new RoleUserPersonalInfo("123"));
        user1 = userRepository.save(user1);

        user2 = new User();
        user2.setUsername("foobar2");
        user2.setFirstname("firstname2");
        user2.setLastname("lastname2");
        user2.getRoles().add(role1);
        user2.getRoles().add(role2);
        user2.setPersonalInfo(new RoleUserPersonalInfo("456"));
        user2 = userRepository.save(user2);
    }

    @Test
    public void isDataReady() throws Exception {
        user1 = userRepository.findOne(user1.getId());
        assertNotNull(user1);
    }

}
