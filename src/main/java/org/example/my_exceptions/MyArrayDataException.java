package org.example.my_exceptions;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int row, int col) {
        super("Ошибка преобразования данных в ячейке [" + row + "][" + col + "]");
    }
}
