package org.example.app.controllers.positions;

import org.example.app.services.positions.PositionReadService;
import org.example.app.utils.AppStarter;
import org.example.app.views.positions.PositionReadView;

public class PositionReadController {

    PositionReadService service;
    PositionReadView view;

    public PositionReadController(PositionReadService service, PositionReadView view) {
        this.service = service;
        this.view = view;
    }

    public void readPositions() {
        String str = service.readPositions();
        view.getOutput(str);
        AppStarter.startApp();
    }
}
