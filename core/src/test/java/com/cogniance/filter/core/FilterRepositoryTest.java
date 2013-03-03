package com.cogniance.filter.core;

import com.cogniance.filter.domain.User;
import com.cogniance.filter.repositories.SimpleFilterRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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

        List<User> users = repository.findAll(spec);
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

        List<User> users = repository.findAll(spec);
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

        List<User> users = repository.findAll(spec);
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

        List<User> users = repository.findAll(spec);
        assertNotNull(users);
        assertEquals(2, users.size());
    }
}
