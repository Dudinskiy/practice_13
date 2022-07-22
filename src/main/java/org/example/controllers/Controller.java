package org.example.controllers;

import org.example.view.View;

public abstract class Controller {
    public static final int MAIN_MENU_ACTION = 0;
    public static final int GET_EMPLOYEE_ACTION = 1;
    public static final int ADD_EMPLOYEE_ACTION = 2;
    public static final int REMOVE_EMPLOYEE_ACTION = 3;
    public static final int EXIT_ACTION = 4;

    protected View view;
    protected int actionToPerform = 0;

    public Controller(View view, int actionToPerform) {
        this.view = view;
        this.actionToPerform = actionToPerform;
    }

    public boolean canProcess(int action) {
        return action == actionToPerform;
    }

    public int process(){
        return view.printInfo();
    }
}
