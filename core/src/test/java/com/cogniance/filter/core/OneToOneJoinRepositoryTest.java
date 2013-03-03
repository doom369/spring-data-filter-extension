package com.cogniance.filter.core;

import com.cogniance.filter.domain.User;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static com.cogniance.filter.core.SpecificationBuilder.filter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class OneToOneJoinRepositoryTest extends AbstractRepositoryTest {

	@Test
	public void checkOneToOneJoin() throws Exception {
        Specification<User> spec = filter("personalInfo.passportId", "456");

        List<User> users = userRepository.findAll(spec);
        assertNotNull(users);
        assertEquals(1, users.size());
        assertEquals(user2.getUsername(), users.get(0).getUsername());
    }
}
