package com.libraryapp.models;

import com.libraryapp.views.ViewFactory;

public class Model {
    private final ViewFactory viewFactory;
    private static Model model;

    private Model() {
        viewFactory = new ViewFactory();
    }

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }

        return model;
    }

    public ViewFactory getViewFactory() {
        return viewFactory;
    }
}
