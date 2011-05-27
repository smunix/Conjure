module conjure.main;

import conjure.core.model;
import conjure.core.view;
import conjure.core.controller;

void main ()
{
    initialize();
}

void initialize()
{
    Model model = Model.getInstance();
    View view = View.getInstance();
    Controller controller = Controller.getInstance(view);
}
