package org.tyoda.wurm.customcreatures;

import org.gotti.wurmunlimited.modloader.interfaces.*;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreatures;

import java.util.Properties;
import java.util.logging.Logger;

public class CustomCreatures implements WurmServerMod, Versioned, Configurable, Initable, PreInitable {
    public static final Logger logger = Logger.getLogger(CustomCreatures.class.getName());
    public static final String version = "0.1";

    public static final String delimiter = ";";

    private Properties properties = null;

    @Override
    public void configure(Properties p){
        properties = new Properties(p);
    }

    @Override
    public void preInit() {
        ModCreatures.init();
    }

    @Override
    public void init(){
        if(properties == null) return;

        for(String creaturePrefix : properties.getProperty("customCreatures", "").split(delimiter)) {
            creaturePrefix = creaturePrefix.trim();
            if(creaturePrefix.equals("")) continue;

            ModCreatures.addCreature(new CustomCreature(properties, creaturePrefix));
        }
    }

    @Override
    public String getVersion(){
        return version;
    }
}
