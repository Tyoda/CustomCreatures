package org.tyoda.wurm.customcreatures;

import javassist.*;
import org.gotti.wurmunlimited.modloader.classhooks.HookException;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.gotti.wurmunlimited.modloader.interfaces.*;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreatures;

import java.util.Properties;
import java.util.logging.Logger;

public class CustomCreatures implements WurmServerMod, Versioned, Configurable, Initable, PreInitable {
    public static final Logger logger = Logger.getLogger(CustomCreatures.class.getName());
    public static final String version = "0.2.2";

    public static final String delimiter = ";";

    private Properties properties = null;

    @Override
    public void configure(Properties p){
        properties = new Properties(p);
    }

    @Override
    public void preInit() {
        try {
            ModCreatures.init();
            ClassPool classPool = HookManager.getInstance().getClassPool();
            CtClass ctCreatureTemplate = classPool.get("com.wurmonline.server.creatures.CreatureTemplate");
            // remove all non-static final modifiers
            logger.info("Removing final modifiers.");
            for (CtField field : ctCreatureTemplate.getFields()) {
                if(Modifier.isFinal(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                    field.setModifiers(Modifier.clear(field.getModifiers(), Modifier.FINAL));
                }
            }
        } catch (NotFoundException e){
            throw new HookException(e);
        }
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

    // TODO: Friya's loottable
    // TODO: color on non-normal mobs
}
