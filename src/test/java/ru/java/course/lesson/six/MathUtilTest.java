package ru.java.course.lesson.six;

import org.junit.*;

public class MathUtilTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Called once before");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("Called once after");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("After");
    }

    @Test
    public void testSum() throws Exception {
        int result = MathUtil.sum(3, 4);

        Assert.assertEquals(7, result);
    }

    @Test
    public void testDivide() throws Exception {
        int result = MathUtil.devide(8, 4);

        Assert.assertEquals(2, result);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() throws Exception {
        MathUtil.devide(8, 0);
    }
}