package org.example.view;

import org.example.utils.UserInput;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainView implements View {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public int printInfo() {
        printMainMenu();
        int actionNumber = 0;
        actionNumber = UserInput.inputActionNumber(reader);
        return actionNumber;
    }

    private void printMainMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Получить данные о сотруднике");
        System.out.println("2. Добавить нового сотрудника");
        System.out.println("3. Удалить сотрудника");
        System.out.println("4. Выход");
    }
}
