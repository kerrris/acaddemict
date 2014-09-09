package com.realdolmen.course;


import com.realdolmen.course.domain.Book;
import junit.framework.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class BookPersistenceTest extends PersistenceTest {

    @Test
    public void bookCanBePersisted() throws Exception {
        Book b = new Book("Animal Farm", "George Orwell");
        entityManager().persist(b);
        assertNotNull(b.getId());
    }
}
