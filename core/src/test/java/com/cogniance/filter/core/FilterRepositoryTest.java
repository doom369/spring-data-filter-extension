package com.cogniance.filter.core;

import com.cogniance.filter.domain.User;
import org.junit.Test;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

import static com.cogniance.filter.core.SpecificationBuilder.and;
import static com.cogniance.filter.core.SpecificationBuilder.filter;
import static com.cogniance.filter.core.SpecificationBuilder.or;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 */
public class FilterRepositoryTest extends AbstractRepositoryTest {

	@Test
	public void hasUsernameEqual() throws Exception {
        Specification<User> spec = filter("username", "foobar1");

        List<User> users = userRepository.findAll(spec);
        assertNotNull(users);
        assertEquals(1, users.size());
	}

    @Test
   	public void hasUsernameFirstnameLastnameEqual() throws Exception {
        AbstractSpecification<User> spec1 = filter("username", "foobar1");
        AbstractSpecification<User> spec2 = filter("firstname", "firstname1");
        AbstractSpecification<User> spec3 = filter("lastname", "lastname1");

        Specification<User> spec =
                and(
                        spec1, spec2, spec3
                );

        List<User> users = userRepository.findAll(spec);
        assertNotNull(users);
        assertEquals(1, users.size());
   	}

    @Test
    public void hasFirstnameAndLastnameEqual() throws Exception {
        Specification<User> spec =
                and(
                        SpecificationBuilder.<User>filter("firstname", "firstname1"),
                        SpecificationBuilder.<User>filter("lastname", "lastname2")
                );

        List<User> users = userRepository.findAll(spec);
        assertNotNull(users);
        assertEquals(0, users.size());
    }

    @Test
    public void hasFirstnameOrLastnameEqual() throws Exception {
        Specification<User> spec =
                or(
                        SpecificationBuilder.<User>filter("firstname", "firstname1"),
                        SpecificationBuilder.<User>filter("lastname", "lastname2")
                );

        List<User> users = userRepository.findAll(spec);
        assertNotNull(users);
        assertEquals(2, users.size());
    }
}
