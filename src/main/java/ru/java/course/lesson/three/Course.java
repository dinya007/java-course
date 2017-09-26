package ru.java.course.lesson.three;

/**
 * @author dinyat
 * 26/09/2017
 */
public enum Course {

    MATH {
        @Override
        void printName() {

        }
    },
    PHYSICS(456) {
        @Override
        void printName() {

        }
    },
    BIOLOGY(3) {
        @Override
        void printName() {

        }
    };

    abstract void printName();

    private final int semestr;

    Course() {
        this.semestr = 4;
    }

    Course(int semestr) {
        this.semestr = semestr;
    }

    public int getSemestr() {
        return semestr;
    }
}
