package ua.yandex.collections;

public class NotEnoughIndexException extends RuntimeException {

    NotEnoughIndexException() {
    }

    NotEnoughIndexException(String args) {
        super(args);
    }
}
