package org.tyoda.wurm.customcreatures;

import com.wurmonline.mesh.Tiles;
import com.wurmonline.server.creatures.*;
import com.wurmonline.shared.constants.CreatureTypes;
import org.gotti.wurmunlimited.modloader.ReflectionUtil;
import org.gotti.wurmunlimited.modsupport.CreatureTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.EncounterBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreature;
import org.gotti.wurmunlimited.modsupport.creatures.TraitsSetter;
import org.gotti.wurmunlimited.modsupport.vehicles.ModVehicleBehaviour;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomCreature implements ModCreature {
    private static final Logger logger = CustomCreatures.logger;
    private final Properties p;
    private final String prefix;
    private int templateId = -10;
    public CustomCreature(Properties properties, String prefix){
        this.p = properties;
        this.prefix = prefix;
    }

    @Override
    public CreatureTemplateBuilder createCreateTemplateBuilder() {
        logger.info("Creating creature template builder for: "+prefix);

        int[] types = {
                CreatureTypes.C_TYPE_CARNIVORE,
                CreatureTypes.C_TYPE_MOVE_GLOBAL,
                CreatureTypes.C_TYPE_VEHICLE,
                CreatureTypes.C_TYPE_REGENERATING,
                CreatureTypes.C_TYPE_AGG_HUMAN,
                CreatureTypes.C_TYPE_SWIMMING,
                CreatureTypes.C_TYPE_HUNTING,
                CreatureTypes.C_TYPE_DOMINATABLE,
                CreatureTypes.C_TYPE_MONSTER,
                CreatureTypes.C_TYPE_NON_NEWBIE,
                CreatureTypes.C_TYPE_ANIMAL,
                CreatureTypes.C_TYPE_MISSION_OK,
                CreatureTypes.C_TYPE_MISSION_TRAITOR_OK
        };
        CreatureTemplateBuilder builder = new CreatureTemplateBuilder("mod.tyoda.customcreatures."+prefix, getStringProperty("name"), "A creature.", "model.creature.humanoid.rooster.brown", types, (byte) 3, (short) 5, (byte) 0, (short) 60, (short) 30, (short) 90, "sound.death.lion",
                "sound.death.lion", "sound.combat.hit.lion", "sound.combat.hit.lion", 0.95f, 3.0f, 0.0f, 5.0f, 0.0f, 0.0f, 1.0f, 1200, new int[] { 92, 305, 313 }, 10, 40, (byte) 75);

        templateId = builder.getTemplateId();
        builder.defaultSkills();

        // basic stuff
        try{ builder.modelName(getStringProperty("modelName")); logger.info("Added modelName"); } catch (MissingPropertyException ignored){}
        try{ builder.acidVulnerability(getFloatProperty("acidVulnerability")); logger.info("Added acidVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.acidResistance(getFloatProperty("acidResistance")); logger.info("Added acidResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.aggressive(getIntProperty("aggressive")); logger.info("Added aggressive"); } catch (MissingPropertyException ignored){}
        try{ builder.alignment(getFloatProperty("alignment")); logger.info("Added alignment"); } catch (MissingPropertyException ignored){}
        try{ builder.armourType(getIntProperty("armourType")); logger.info("Added armourType"); } catch (MissingPropertyException ignored){}
        try{ builder.baseCombatRating(getFloatProperty("baseCombatRating")); logger.info("Added baseCombatRating"); } catch (MissingPropertyException ignored){}
        try{ builder.biteResistance(getFloatProperty("biteResistance")); logger.info("Added biteResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.biteVulnerability(getFloatProperty("biteVulnerability")); logger.info("Added biteVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.bodyType(getByteProperty("bodyType")); logger.info("Added bodyType"); } catch (MissingPropertyException ignored){}
        try{ builder.bonusCombatRating(getIntProperty("bonusCombatRating")); logger.info("Added bonusCombatRating"); } catch (MissingPropertyException ignored){}
        try{ builder.childTemplate(getIntProperty("childTemplate")); logger.info("Added childTemplate"); } catch (MissingPropertyException ignored){}
        try{ builder.coldResistance(getFloatProperty("coldResistance")); logger.info("Added coldResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.coldVulnerability(getFloatProperty("coldVulnerability")); logger.info("Added coldVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.combatDamageType(getByteProperty("combatDamageType")); logger.info("Added combatDamageType"); } catch (MissingPropertyException ignored){}
        try{ builder.crushResistance(getFloatProperty("crushResistance")); logger.info("Added crushResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.crushVulnerability(getFloatProperty("crushVulnerability")); logger.info("Added crushVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.daysOfPregnancy(getByteProperty("daysOfPregnancy")); logger.info("Added daysOfPregnancy"); } catch (MissingPropertyException ignored){}
        try{ builder.denMaterial(getByteProperty("denMaterial")); logger.info("Added denMaterial"); } catch (MissingPropertyException ignored){}
        try{ builder.denName(getStringProperty("denName")); logger.info("Added denName"); } catch (MissingPropertyException ignored){}
        try{ builder.description(getStringProperty("description")); logger.info("Added description"); } catch (MissingPropertyException ignored){}
        try{ builder.diseaseResistance(getFloatProperty("diseaseResistance")); logger.info("Added diseaseResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.diseaseVulnerability(getFloatProperty("diseaseVulnerability")); logger.info("Added diseaseVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.eggLayer(getIntProperty("eggLayer")); logger.info("Added eggLayer"); } catch (MissingPropertyException ignored){}
        try{ builder.fireResistance(getFloatProperty("fireResistance")); logger.info("Added fireResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.fireVulnerability(getFloatProperty("fireVulnerability")); logger.info("Added fireVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.glowing(getBooleanProperty("glowing")); logger.info("Added glowing"); } catch (MissingPropertyException ignored){}
        try{ builder.handDamString(getStringProperty("handDamString")); logger.info("Added handDamString"); } catch (MissingPropertyException ignored){}
        try{ builder.hasHands(getBooleanProperty("hasHands")); logger.info("Added hasHands"); } catch (MissingPropertyException ignored){}
        try{ builder.headbuttDamString(getStringProperty("headbuttDamString")); logger.info("Added headbuttDamString"); } catch (MissingPropertyException ignored){}
        try{ builder.internalResistance(getFloatProperty("internalResistance")); logger.info("Added internalResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.internalVulnerability(getFloatProperty("internalVulnerability")); logger.info("Added internalVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.isHorse(getBooleanProperty("isHorse")); logger.info("Added isHorse"); } catch (MissingPropertyException ignored){}
        try{ builder.itemsButchered(getIntArrayProperty("itemsButchered")); logger.info("Added itemsButchered"); } catch (MissingPropertyException ignored){}
        try{ builder.keepSex(getBooleanProperty("keepSex")); logger.info("Added keepSex"); } catch (MissingPropertyException ignored){}
        try{ builder.kickDamString(getStringProperty("kickDamString")); logger.info("Added kickDamString"); } catch (MissingPropertyException ignored){}
        try{ builder.leaderTemplateId(getIntProperty("leaderTemplateId")); logger.info("Added leaderTemplateId"); } catch (MissingPropertyException ignored){}
        try{ builder.maxAge(getIntProperty("maxAge")); logger.info("Added maxAge"); } catch (MissingPropertyException ignored){}
        try{ builder.maxGroupAttackSize(getIntProperty("maxGroupAttackSize")); logger.info("Added maxGroupAttackSize"); } catch (MissingPropertyException ignored){}
        try{ builder.maxHuntDist(getIntProperty("maxHuntDist")); logger.info("Added maxHuntDist"); } catch (MissingPropertyException ignored){}
        try{ builder.maxPercentOfCreatures(getFloatProperty("maxPercentOfCreatures")); logger.info("Added maxPercentOfCreatures"); } catch (MissingPropertyException ignored){}
        try{ builder.maxPopulationOfCreatures(getIntProperty("maxPopulationOfCreatures")); logger.info("Added maxPopulationOfCreatures"); } catch (MissingPropertyException ignored){}
        try{ builder.meatMaterial(getByteProperty("meatMaterial")); logger.info("Added meatMaterial"); } catch (MissingPropertyException ignored){}
        try{ builder.moveRate(getIntProperty("moveRate")); logger.info("Added moveRate"); } catch (MissingPropertyException ignored){}
        try{ builder.naturalArmour(getFloatProperty("naturalArmour")); logger.info("Added naturalArmour"); } catch (MissingPropertyException ignored){}
        try{ builder.offZ(getFloatProperty("offZ")); logger.info("Added offZ"); } catch (MissingPropertyException ignored){}
        try{ builder.paintMode(getIntProperty("paintMode")); logger.info("Added paintMode"); } catch (MissingPropertyException ignored){}
        try{ builder.physicalResistance(getFloatProperty("physicalResistance")); logger.info("Added physicalResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.physicalVulnerability(getFloatProperty("physicalVulnerability")); logger.info("Added physicalVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.pierceResistance(getFloatProperty("pierceResistance")); logger.info("Added pierceResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.pierceVulnerability(getFloatProperty("pierceVulnerability")); logger.info("Added pierceVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.plural(getStringProperty("plural")); logger.info("Added plural"); } catch (MissingPropertyException ignored){}
        try{ builder.poisonResistance(getFloatProperty("poisonResistance")); logger.info("Added poisonResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.poisonVulnerability(getFloatProperty("poisonVulnerability")); logger.info("Added poisonVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.reputation(getIntProperty("reputation")); logger.info("Added reputation"); } catch (MissingPropertyException ignored){}
        try{ builder.setCombatMoves(getIntArrayProperty("setCombatMoves")); logger.info("Added setCombatMoves"); } catch (MissingPropertyException ignored){}
        try{ builder.sex(getByteProperty("sex")); logger.info("Added sex"); } catch (MissingPropertyException ignored){}
        try{ builder.slashResistance(getFloatProperty("slashResistance")); logger.info("Added slashResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.slashVulnerability(getFloatProperty("slashVulnerability")); logger.info("Added slashVulnerability"); } catch (MissingPropertyException ignored){}
        try{ builder.speed(getFloatProperty("speed")); logger.info("Added speed"); } catch (MissingPropertyException ignored){}
        try{ builder.types(getIntArrayProperty("types")); logger.info("Added types"); } catch (MissingPropertyException ignored){}
        try{ builder.usesNewAttacks(getBooleanProperty("usesNewAttacks")); logger.info("Added usesNewAttacks"); } catch (MissingPropertyException ignored){}
        try{ builder.vision(getShortProperty("vision")); logger.info("Added vision"); } catch (MissingPropertyException ignored){}
        try{ builder.waterResistance(getFloatProperty("waterResistance")); logger.info("Added waterResistance"); } catch (MissingPropertyException ignored){}
        try{ builder.waterVulnerability(getFloatProperty("waterVulnerability")); logger.info("Added waterVulnerability"); } catch (MissingPropertyException ignored){}

        try{
            int[] values = getIntArrayProperty("sizeModifier", 3);
            builder.sizeModifier(values[0], values[1], values[2]);
            logger.info("Added sizeModifier");
        } catch (MissingPropertyException ignored){}
        try{
            String[] values = getStringArrayProperty("onFire", 2);
            builder.onFire(Boolean.parseBoolean(values[0]), Byte.parseByte(values[1]));
            logger.info("Added onFire");
        } catch (MissingPropertyException ignored){}
        try{
            String[] values = getStringArrayProperty("hitSounds", 2);
            builder.hitSounds(values[0], values[1]);
            logger.info("Added hitSounds");
        } catch (MissingPropertyException ignored){}
        try{
            String[] values = getStringArrayProperty("dimension", 3);
            builder.dimension(Short.parseShort(values[0]), Short.parseShort(values[1]), Short.parseShort(values[2]));
            logger.info("Added dimension");
        } catch (MissingPropertyException ignored){}
        try{
            String[] values = getStringArrayProperty("deathSounds", 2);
            builder.deathSounds(values[0], values[1]);
            logger.info("Added deathSounds");
        } catch (MissingPropertyException ignored){}
        try{
            float[] values = getFloatArrayProperty("damages", 5);
            builder.damages(values[0], values[1], values[2], values[3], values[4]);
            logger.info("Added damages");
        } catch (MissingPropertyException ignored){}
        try{
            int[] values = getIntArrayProperty("color", 3);
            builder.color(values[0], values[1], values[2]);
            logger.info("Added color");
        } catch (MissingPropertyException ignored){}
        try{
            float[] values = getFloatArrayProperty("boundsValues", 4);
            builder.boundsValues(values[0], values[1], values[2], values[3]);
            logger.info("Added boundsValues");
        } catch (MissingPropertyException ignored){}
        try{
            for(int i = 1;;++i) {
                String[] values = getStringArrayProperty("addPrimaryAttack"+i, 11);
                builder.addPrimaryAttack(createAttackAction(values));
                logger.info("Added addPrimaryAttack"+i);
            }
        } catch (MissingPropertyException ignored){}
        try{
            for(int i = 1;;++i) {
                String[] values = getStringArrayProperty("addSecondaryAttack"+i, 11);
                builder.addSecondaryAttack(createAttackAction(values));
                logger.info("Added addSecondaryAttack"+i);
            }
        } catch (MissingPropertyException ignored){}
        try{
            for(int i = 1;;++i) {
                String[] values = getStringArrayProperty("skill"+i, 2);
                builder.skill(Integer.parseInt(values[0]), Float.parseFloat(values[1]));
                logger.info("Added skill"+i);
            }
        } catch (MissingPropertyException ignored){}


        // extras


        return builder;
    }

    private AttackAction createAttackAction(String[] values){
        String name = values[0];
        AttackIdentifier attackIdentifier = AttackIdentifier.valueOf(values[1]);

        float baseDamage = Float.parseFloat(values[2]);
        float criticalChance = Float.parseFloat(values[3]);
        float baseSpeed = Float.parseFloat(values[4]);
        int attackReach = Integer.parseInt(values[5]);
        int weightGroup = Integer.parseInt(values[6]);
        byte damageType = Byte.parseByte(values[7]);
        boolean usesWeapon = Boolean.parseBoolean(values[8]);
        int rounds = Integer.parseInt(values[9]);
        float waitUntilNextAttack = Float.parseFloat(values[10]);
        AttackValues attackValues = new AttackValues(baseDamage, criticalChance, baseSpeed, attackReach, weightGroup, damageType, usesWeapon, rounds, waitUntilNextAttack);
        return new AttackAction(name, attackIdentifier, attackValues);
    }

    private String getStringProperty(String propName){
        String value = p.getProperty(prefix+'.'+propName);
        if(value == null)
            throw new MissingPropertyException("Property "+propName+" not found for "+prefix);
        return value.trim();
    }

    private String[] getStringArrayProperty(String propName){
        return getStringArrayProperty(propName, -1);
    }

    private String[] getStringArrayProperty(String propName, int length){
        String value = p.getProperty(prefix+'.'+propName);
        if(value == null)
            throw new MissingPropertyException("Property "+propName+" not found for "+prefix);
        String[] items = value.split(CustomCreatures.delimiter);
        if(length > -1 && items.length != length) throw new RuntimeException("Property "+propName+" must have exactly "+length+" items");
        for(int i = 0; i < items.length; ++i){
            items[i] = items[i].trim();
        }
        return items;
    }

    private int[] getIntArrayProperty(String propName){
        return getIntArrayProperty(propName, -1);
    }

    private int[] getIntArrayProperty(String propName, int length){
        String value = p.getProperty(prefix+'.'+propName);
        if(value == null)
            throw new MissingPropertyException("Property "+propName+" not found for "+prefix);
        String[] items = value.split(CustomCreatures.delimiter);
        if(length > -1 && items.length != length) throw new RuntimeException("Property "+propName+" must have exactly "+length+" items");
        int[] toReturn = new int[items.length];
        for(int i = 0; i < items.length; ++i){
            toReturn[i] = Integer.parseInt(items[i].trim());
        }
        return toReturn;
    }

    private float[] getFloatArrayProperty(String propName){
        return getFloatArrayProperty(propName, -1);
    }

    private float[] getFloatArrayProperty(String propName, int length){
        String value = p.getProperty(prefix+'.'+propName);
        if(value == null)
            throw new MissingPropertyException("Property "+propName+" not found for "+prefix);
        String[] items = value.split(CustomCreatures.delimiter);
        if(length > -1 && items.length != length) throw new RuntimeException("Property "+propName+" must have exactly "+length+" items");
        float[] toReturn = new float[items.length];
        for(int i = 0; i < items.length; ++i){
            toReturn[i] = Float.parseFloat(items[i].trim());
        }
        return toReturn;
    }

    private int getIntProperty(String propName){
        String value = p.getProperty(prefix+'.'+propName);
        if(value == null)
            throw new MissingPropertyException("Property "+propName+" not found for "+prefix);
        return Integer.parseInt(value.trim());
    }

    private float getFloatProperty(String propName){
        String value = p.getProperty(prefix+'.'+propName);
        if(value == null)
            throw new MissingPropertyException("Property "+propName+" not found for "+prefix);
        return Float.parseFloat(value.trim());
    }

    private byte getByteProperty(String propName){
        String value = p.getProperty(prefix+'.'+propName);
        if(value == null)
            throw new MissingPropertyException("Property "+propName+" not found for "+prefix);
        return Byte.parseByte(value.trim());
    }

    private short getShortProperty(String propName){
        String value = p.getProperty(prefix+'.'+propName);
        if(value == null)
            throw new MissingPropertyException("Property "+propName+" not found for "+prefix);
        return Short.parseShort(value.trim());
    }

    private boolean getBooleanProperty(String propName){
        String value = p.getProperty(prefix+'.'+propName);
        if(value == null)
            throw new MissingPropertyException("Property "+propName+" not found for "+prefix);
        return Boolean.parseBoolean(value.trim());
    }

    @Override
    public ModVehicleBehaviour getVehicleBehaviour() {
        // This is called right after the template is built, so we're going to put some inappropriate stuff here. Sue me.
        try{
            CreatureTemplate template = CreatureTemplateFactory.getInstance().getTemplate(templateId);
            try{ ReflectionUtil.setPrivateField(template, ReflectionUtil.getField(CreatureTemplate.class, "corpsename"), getStringProperty("corpseName")); logger.info("Added corpseName"); } catch (MissingPropertyException ignored){}
            try{ ReflectionUtil.setPrivateField(template, ReflectionUtil.getField(CreatureTemplate.class, "ghost"), getBooleanProperty("ghost")); logger.info("Added ghost"); } catch (MissingPropertyException ignored){}
            try{ template.setSubterranean(getBooleanProperty("subTerranean")); logger.info("Added subTerranean"); } catch (MissingPropertyException ignored){}
        } catch (NoSuchCreatureTemplateException e){
            logger.log(Level.SEVERE, "Creature template not found for custom creature "+prefix);
        } catch (NoSuchFieldException | IllegalAccessException e){
            logger.log(Level.SEVERE, "ReflectionUtil failed.", e);
        }

        // And now the actual stuff this method should do:
        return null;
    }

    @Override
    public void addEncounters() {
        if (templateId == -10)
            return;

        try{
            for(int i = 1;;++i) {
                String[] values = getStringArrayProperty("encounter"+i, 3);
                Tiles.Tile tile = Tiles.Tile.valueOf(values[0]);
                int count = Integer.parseInt(values[1]);
                int chance = Integer.parseInt(values[2]);
                new EncounterBuilder(tile.id)
                        .addCreatures(templateId, count)
                        .build(chance);
                logger.info("Added encounter"+i);
            }
        } catch (MissingPropertyException ignored){}
    }

    @Override
    public String getTraitName(int trait) {
        return null;
    }

    @Override
    public String getColourName(int trait) {
        return null;
    }

    @Override
    public void assignTraits(TraitsSetter traitsSetter) {

    }

    @Override
    public boolean hasTraits() {
        return false;
    }

    @Override
    public long calcNewTraits(double breederSkill, boolean inbred, long motherTraits, long fatherTraits) {
        return Traits.calcNewTraits(breederSkill, inbred, motherTraits, fatherTraits);
    }
}
