package aula12_1.plugins;

import aula12_1.IPlugin;

public class Plugin1 implements IPlugin {

    @Override
    public void fazQualQuerCoisa() {
        System.out.println("Eu faço qualquer coisa");
    }
    
}