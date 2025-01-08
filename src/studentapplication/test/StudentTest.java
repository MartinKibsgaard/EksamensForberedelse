package studentapplication.test;

import org.junit.jupiter.api.Test;
import studentapplication.model.Student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentTest {

    @Test
    public void testCreateStudent() {
        // act
        Student student = new Student("Jane", 23, true);
        // assert
        assertEquals("Jane", student.getName());
        assertEquals(23, student.getAge());
        assertTrue(student.isActive());
    }

    @Test
    public void testIncreaseAge() {
        // arrange
        Student student = new Student("Jane", 23, true);
        // act
        student.increaseAge();
        // assert
        assertEquals(24, student.getAge());
    }
}
