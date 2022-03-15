package aula12_1.plugins;

import aula12_1.IPlugin;

public class Plugin2 implements IPlugin {

    @Override
    public void fazQualQuerCoisa() {
        System.out.println("Eu faço mais qualquer coisa");
    }
}