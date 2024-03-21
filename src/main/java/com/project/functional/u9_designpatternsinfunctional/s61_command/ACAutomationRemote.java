package com.project.functional.u9_designpatternsinfunctional.s61_command;

import lombok.Setter;

@Setter
public class ACAutomationRemote {

    Command command;

    public void buttonPressed() {
        command.execute();
    }

}
