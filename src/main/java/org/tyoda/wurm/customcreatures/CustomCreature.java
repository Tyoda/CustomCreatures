package org.tyoda.wurm.customcreatures;

import com.wurmonline.mesh.Tiles;
import com.wurmonline.server.combat.ArmourTemplate;
import com.wurmonline.server.creatures.*;
import com.wurmonline.server.deities.Deities;
import com.wurmonline.server.skills.Skill;
import com.wurmonline.server.skills.Skills;
import com.wurmonline.server.skills.SkillsFactory;
import org.gotti.wurmunlimited.modloader.ReflectionUtil;
import org.gotti.wurmunlimited.modloader.classhooks.HookException;
import org.gotti.wurmunlimited.modsupport.CreatureTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.EncounterBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreature;
import org.gotti.wurmunlimited.modsupport.creatures.TraitsSetter;
import org.gotti.wurmunlimited.modsupport.vehicles.ModVehicleBehaviour;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class CustomCreature implements ModCreature {
    private static final Logger logger = CustomCreatures.logger;
    private final Properties p;
    private final String prePrefix = "mod.tyoda.customcreatures.";
    private final String prefix;
    private int templateId = -10;
    public CustomCreature(Properties properties, String prefix){
        this.p = properties;
        if(prefix.endsWith(".")){
            this.prefix = prefix;
        }else{
            this.prefix = prefix + ".";
        }
    }

    @Override
    public CreatureTemplateBuilder createCreateTemplateBuilder() {
        return new CreatureTemplateBuilder(prePrefix+prefix) {
            @Override
            public CreatureTemplate build() {

                CreatureTemplate temp = new CreatureTemplateBuilder(prePrefix+prefix, getStringProperty("name"), "A creature.", "model.creature.humanoid.rooster.brown", new int[0], (byte) 3, (short) 5, (byte) 0, (short) 60, (short) 30, (short) 90, "sound.death.lion",
                        "sound.death.lion", "sound.combat.hit.lion", "sound.combat.hit.lion", 0.95f, 3.0f, 0.0f, 5.0f, 0.0f, 0.0f, 1.0f, 1200, new int[] { 92, 305, 313 }, 10, 40, (byte) 75).build();
                templateId = temp.getTemplateId();
                return buildOnTemplate(temp);
            }
        };
    }

    private CreatureTemplate buildOnTemplate(CreatureTemplate temp){
        logger.info("Creating creature template for: "+prefix);
        ArrayList<String> properties = new ArrayList<>();

        for(String property : p.stringPropertyNames()){
            if(property.startsWith(prefix)){
                properties.add(property.substring(prefix.length()));
            }
        }

        for(String property : properties){
            switch(property){
                case "name":
                    setPrivateField(temp, "name", getStringProperty("name"));
                    break;
                case "plural":
                    setPrivateField(temp, "plural", getStringProperty("plural"));
                    break;
                case "bodyType":
                    setPrivateField(temp, "bodyType", getByteProperty("bodyType"));
                    break;
                case "sex":
                    setPrivateField(temp, "sex", getByteProperty("sex"));
                    break;
                case "vision":
                    temp.setVision(getShortProperty("vision"));
                    break;
                case "description":
                    setPrivateField(temp, "longDesc", getStringProperty("description"));
                    break;
                case "modelName":
                    setPrivateField(temp, "modelName", getStringProperty("modelName"));
                    break;
                case "corpseName":
                    String corpseName = getStringProperty("corpseName");
                    if(!corpseName.endsWith(".")){
                        corpseName += '.';
                    }
                    temp.setCorpseName(corpseName);
                    break;
                case "ghost":
                    setPrivateField(temp, "ghost", getBooleanProperty("ghost"));
                    break;
                case "subterranean":
                    temp.setSubterranean(getBooleanProperty("subTerranean"));
                    break;
                case "handDamage":
                    setPrivateField(temp, "handDamage",  getFloatProperty("handDamage"));
                    break;
                case "kickDamage":
                    setPrivateField(temp, "kickDamage", getFloatProperty("kickDamage"));
                    break;
                case "biteDamage":
                    setPrivateField(temp, "biteDamage", getFloatProperty("biteDamage"));
                    break;
                case "headButtDamage":
                    setPrivateField(temp, "headButtDamage", getFloatProperty("headButtDamage"));
                    break;
                case "breathDamage":
                    setPrivateField(temp, "breathDamage", getFloatProperty("breathDamage"));
                    break;
                case "reputation":
                    setPrivateField(temp, "reputation", getIntProperty("reputation"));
                    break;
                case "meatMaterial":
                    setPrivateField(temp, "meatMaterial", getByteProperty("meatMaterial"));
                    break;
                case "denName":
                    temp.setDenName(getStringProperty("denName"));
                    break;
                case "denMaterial":
                    temp.setDenMaterial(getByteProperty("denMaterial"));
                    break;
                case "handDamString":
                    temp.setHandDamString(getStringProperty("handDamString"));
                    break;
                case "biteDamString":
                    temp.setBiteDamString(getStringProperty("biteDamString"));
                    break;
                case "kickDamString":
                    temp.setKickDamString(getStringProperty("kickDamString"));
                    break;
                case "headbuttDamString":
                    temp.setHeadbuttDamString(getStringProperty("headbuttDamString"));
                    break;
                case "breathDamString":
                    temp.setBreathDamString(getStringProperty("breathDamString"));
                    break;
                case "aggressivity":
                    setPrivateField(temp, "aggressivity", getIntProperty("aggressivity"));
                    break;
                case "alignment":
                    temp.setAlignment(getFloatProperty("alignment"));
                    break;
                case "deity":
                    setPrivateField(temp, "deity", Deities.getDeity(getIntProperty("deity")));
                    break;
                case "faith":
                    setPrivateField(temp, "faith", getFloatProperty("faith"));
                    break;
                case "naturalArmour":
                    setPrivateField(temp, "naturalArmour", getFloatProperty("naturalArmour"));
                    break;
                case "armourType":
                    temp.setArmourType(intToArmourType(getIntProperty("armourType")));
                    break;
                case "eggLayer":
                    temp.setEggLayer(getBooleanProperty("eggLayer"));
                    break;
                case "eggTemplateId":
                    temp.setEggTemplateId(getIntProperty("eggTemplateId"));
                    break;
                case "childTemplateId":
                    temp.setChildTemplateId(getIntProperty("childTemplateId"));
                    break;
                case "combatMoves":
                    temp.setCombatMoves(getIntArrayProperty("combatMoves"));
                    break;
                case "noSkillgain":
                    temp.setNoSkillgain(getBooleanProperty("noSkillgain"));
                    break;
                case "royalAspiration":
                    setPrivateField(temp, "royalAspiration", getBooleanProperty("royalAspiration"));
                    break;
                case "offZ":
                    setPrivateField(temp, "offZ", getFloatProperty("offZ"));
                    break;
                /*case "colourNameOverrides":
                    break;*/ // TODO
                case "keepSex":
                    temp.setKeepSex(getBooleanProperty("keepSex"));
                    break;
                case "tutorial":
                    temp.setTutorial(getBooleanProperty("tutorial"));
                    break;
                case "glowing":
                    temp.setGlowing(getBooleanProperty("glowing"));
                    break;
                case "hasHands":
                    setPrivateField(temp, "hasHands", getBooleanProperty("hasHands"));
                    break;
                case "noCorpse":
                    setPrivateField(temp, "noCorpse", getBooleanProperty("noCorpse"));
                    break;
                case "maxPopulationOfCreatures":
                    temp.setMaxPopulationOfCreatures(getIntProperty("maxPopulationOfCreatures"));
                    setPrivateField(temp, "usesMaxPopulation", true);
                    break;
                case "useNewAttacks":
                    temp.setUsesNewAttacks(getBooleanProperty("useNewAttacks"));
                    break;
                case "noServerSounds":
                    temp.setNoServerSounds(getBooleanProperty("noServerSounds"));
                    break;
                case "speed":
                    setPrivateField(temp, "speed", getFloatProperty("speed"));
                    break;
                case "baseCombatRating":
                    temp.setBaseCombatRating(getFloatProperty("baseCombatRating"));
                    break;
                case "bonusCombatRating":
                    temp.setBonusCombatRating(getFloatProperty("bonusCombatRating"));
                    break;
                case "fireResistance":
                    temp.fireResistance = getFloatProperty("fireResistance");
                    break;
                case "coldResistance":
                    temp.coldResistance = getFloatProperty("coldResistance");
                    break;
                case "diseaseResistance":
                    temp.diseaseResistance = getFloatProperty("diseaseResistance");
                    break;
                case "physicalResistance":
                    temp.physicalResistance = getFloatProperty("physicalResistance");
                    break;
                case "pierceResistance":
                    temp.pierceResistance = getFloatProperty("pierceResistance");
                    break;
                case "slashResistance":
                    temp.slashResistance = getFloatProperty("slashResistance");
                    break;
                case "crushResistance":
                    temp.crushResistance = getFloatProperty("crushResistance");
                    break;
                case "biteResistance":
                    temp.biteResistance = getFloatProperty("biteResistance");
                    break;
                case "poisonResistance":
                    temp.poisonResistance = getFloatProperty("poisonResistance");
                    break;
                case "waterResistance":
                    temp.waterResistance = getFloatProperty("waterResistance");
                    break;
                case "acidResistance":
                    temp.acidResistance = getFloatProperty("acidResistance");
                    break;
                case "internalResistance":
                    temp.internalResistance = getFloatProperty("internalResistance");
                    break;
                case "fireVulnerability":
                    temp.fireVulnerability = getFloatProperty("fireVulnerability");
                    break;
                case "coldVulnerability":
                    temp.coldVulnerability = getFloatProperty("coldVulnerability");
                    break;
                case "diseaseVulnerability":
                    temp.diseaseVulnerability = getFloatProperty("diseaseVulnerability");
                    break;
                case "physicalVulnerability":
                    temp.physicalVulnerability = getFloatProperty("physicalVulnerability");
                    break;
                case "pierceVulnerability":
                    temp.pierceVulnerability = getFloatProperty("pierceVulnerability");
                    break;
                case "slashVulnerability":
                    temp.slashVulnerability = getFloatProperty("slashVulnerability");
                    break;
                case "crushVulnerability":
                    temp.crushVulnerability = getFloatProperty("crushVulnerability");
                    break;
                case "biteVulnerability":
                    temp.biteVulnerability = getFloatProperty("biteVulnerability");
                    break;
                case "poisonVulnerability":
                    temp.poisonVulnerability = getFloatProperty("poisonVulnerability");
                    break;
                case "waterVulnerability":
                    temp.waterVulnerability = getFloatProperty("waterVulnerability");
                    break;
                case "acidVulnerability":
                    temp.acidVulnerability = getFloatProperty("acidVulnerability");
                    break;
                case "internalVulnerability":
                    temp.internalVulnerability = getFloatProperty("internalVulnerability");
                    break;
                case "maxPercentOfCreatures":
                    temp.setMaxPercentOfCreatures(getFloatProperty("maxPercentOfCreatures"));
                    break;
                case "mateTemplateId":
                    temp.setMateTemplateId(getIntProperty("mateTemplateId"));
                    break;
                case "moveRate":
                    setPrivateField(temp, "moveRate", getIntProperty("moveRate"));
                    break;
                case "butcheredItems":
                    setPrivateField(temp, "butcheredItems", getIntArrayProperty("butcheredItems"));
                    break;
                case "maxHuntDistance":
                    setPrivateField(temp, "maxHuntDistance", getIntProperty("maxHuntDistance"));
                    break;
                case "leaderTemplateId":
                    temp.setLeaderTemplateId(getIntProperty("leaderTemplateId"));
                    break;
                case "adultFemaleTemplateId":
                    temp.setAdultFemaleTemplateId(getIntProperty("adultFemaleTemplateId"));
                    break;
                case "adultMaleTemplateId":
                    temp.setAdultMaleTemplateId(getIntProperty("adultMaleTemplateId"));
                    break;
                case "maxGroupAttackSize":
                    temp.setMaxGroupAttackSize(getIntProperty("maxGroupAttackSize"));
                    break;
                case "maxAge":
                    temp.setMaxAge(getIntProperty("maxAge"));
                    break;
                /*case "maxColourCount":
                    temp.maxColourCount = getIntProperty("maxColourCount");
                    break;*/
                case "paintMode":
                    temp.setPaintMode(getIntProperty("paintMode"));
                    break;
                case "combatDamageType":
                    temp.setCombatDamageType(getByteProperty("combatDamageType"));
                    break;
                case "daysOfPregnancy":
                    temp.setDaysOfPregnancy(getByteProperty("daysOfPregnancy"));
                    break;
                /*case "lootTable":
                    break;*/ // TODO
                case "color":
                    int[] color = getIntArrayProperty("color", 3);
                    temp.setColorRed(color[0]);
                    temp.setColorGreen(color[1]);
                    temp.setColorBlue(color[2]);
                    setPrivateField(temp, "isColoured", true);
                    break;
                case "boundsValues":
                    float[] boundsValues = getFloatArrayProperty("boundsValues", 4);
                    temp.setBoundsValues(boundsValues[0], boundsValues[1], boundsValues[2], boundsValues[3]);
                    break;
                case "sizeModifier":
                    int[] sizeModifiers = getIntArrayProperty("sizeModifier", 3);
                    temp.setSizeModX(sizeModifiers[0]);
                    temp.setSizeModY(sizeModifiers[1]);
                    temp.setSizeModZ(sizeModifiers[2]);
                    break;
                case "onFire":
                    String[] onFire = getStringArrayProperty("onFire", 2);
                    temp.setOnFire(Boolean.parseBoolean(onFire[0]));
                    temp.setFireRadius(Byte.parseByte(onFire[1]));
                    break;
                case "dimension":
                    String[] values = getStringArrayProperty("dimension", 3);
                    setPrivateField(temp, "centimetersHigh", Short.parseShort(values[0]));
                    setPrivateField(temp, "centimetersLong", Short.parseShort(values[1]));
                    setPrivateField(temp, "centimetersWide", Short.parseShort(values[2]));
                    break;
                case "hitSounds":
                    String[] hitSounds = getStringArrayProperty("hitSounds", 2);
                    setPrivateField(temp, "hitSoundMale",   hitSounds[0]);
                    setPrivateField(temp, "hitSoundFemale", hitSounds[1]);
                    break;
                case "deathSounds":
                    String[] deathSounds = getStringArrayProperty("deathSounds", 2);
                    setPrivateField(temp, "deathSoundMale",   deathSounds[0]);
                    setPrivateField(temp, "deathSoundFemale", deathSounds[1]);
                    break;
                case "types":
                    try {
                        ReflectionUtil.callPrivateMethod(temp, ReflectionUtil.getMethod(temp.getClass(), "assignTypes"), (Object) getIntArrayProperty("types"));
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
                        throw new HookException(e);
                    }
                    break;
                case "copy":
                case "override":
                    continue;
                default:
                    if(!property.startsWith("skill")
                            && !property.startsWith("addSecondaryAttack")
                            && !property.startsWith("addPrimaryAttack")
                            && !property.startsWith("encounter"))
                        throw new HookException("No such property \""+property+"\" in "+prefix);
            }
            logger.info("Added "+property);
        }

        List<AttackAction> primaryAttacks = new ArrayList<>(temp.getPrimaryAttacks());
        List<AttackAction> secondaryAttacks = new ArrayList<>(temp.getSecondaryAttacks());
        setPrivateField(temp, "primaryAttacks", primaryAttacks);
        setPrivateField(temp, "secondaryAttacks", secondaryAttacks);
        try{
            for(int i = 1;;++i) {
                String[] values = getStringArrayProperty("addPrimaryAttack"+i, 11);
                if(i == 1) temp.getPrimaryAttacks().clear();
                temp.addPrimaryAttack(createAttackAction(values));
                logger.info("Added addPrimaryAttack"+i);
            }
        } catch (MissingPropertyException ignored){}
        try{
            for(int i = 1;;++i) {
                String[] values = getStringArrayProperty("addSecondaryAttack"+i, 11);
                if(i == 1) temp.getSecondaryAttacks().clear();
                temp.addSecondaryAttack(createAttackAction(values));
                logger.info("Added addSecondaryAttack"+i);
            }
        } catch (MissingPropertyException ignored){}

        Skills skills = SkillsFactory.createSkills(temp.getName());
        skills.learnTemp(100, 20.0F);
        skills.learnTemp(101, 20.0F);
        skills.learnTemp(102, 20.0F);
        skills.learnTemp(104, 20.0F);
        skills.learnTemp(103, 20.0F);
        skills.learnTemp(105, 20.0F);
        skills.learnTemp(106, 20.0F);
        try{
            for(Skill skill : temp.getSkills().getSkills()) {
                skills.learnTemp(skill.getNumber(), (float)skill.getKnowledge());
            }
        } catch (Exception ignored){}
        try{
            for(int i = 1;;++i) {
                String[] values = getStringArrayProperty("skill"+i, 2);
                skills.learnTemp(Integer.parseInt(values[0]), Float.parseFloat(values[1]));
                logger.info("Added skill"+i);
            }
        } catch (MissingPropertyException ignored){}
        setPrivateField(temp, "skills", skills);

        return temp;
    }

    private void setPrivateField(CreatureTemplate temp, String fieldname, Object value){
        try {
            ReflectionUtil.setPrivateField(temp, ReflectionUtil.getField(CreatureTemplate.class, fieldname), value);
        }catch (NoSuchFieldException | IllegalAccessException e){
            throw new HookException(e);
        }
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

    private String getStringProperty(String propName) throws MissingPropertyException {
        String value = p.getProperty(prefix+propName);
        if(value == null)
            throw new MissingPropertyException("Property \""+propName+"\" not found for "+prefix);
        return value.trim();
    }

    private String[] getStringArrayProperty(String propName) throws MissingPropertyException {
        return getStringArrayProperty(propName, -1);
    }

    private String[] getStringArrayProperty(String propName, int length) throws MissingPropertyException {
        String value = p.getProperty(prefix+propName);
        if(value == null)
            throw new MissingPropertyException("Property \""+propName+"\" not found for "+prefix);
        String[] items = value.split(CustomCreatures.delimiter);
        if(length > -1 && items.length != length) throw new RuntimeException("Property "+propName+" must have exactly "+length+" items");
        for(int i = 0; i < items.length; ++i){
            items[i] = items[i].trim();
        }
        return items;
    }

    private int[] getIntArrayProperty(String propName) throws MissingPropertyException {
        return getIntArrayProperty(propName, -1);
    }

    private int[] getIntArrayProperty(String propName, int length) throws MissingPropertyException {
        String value = p.getProperty(prefix+propName);
        if(value == null)
            throw new MissingPropertyException("Property \""+propName+"\" not found for "+prefix);
        String[] items = value.split(CustomCreatures.delimiter);
        if(length > -1 && items.length != length) throw new RuntimeException("Property "+propName+" must have exactly "+length+" items");
        int[] toReturn = new int[items.length];
        for(int i = 0; i < items.length; ++i){
            toReturn[i] = Integer.parseInt(items[i].trim());
        }
        return toReturn;
    }

    private float[] getFloatArrayProperty(String propName) throws MissingPropertyException {
        return getFloatArrayProperty(propName, -1);
    }

    private float[] getFloatArrayProperty(String propName, int length) throws MissingPropertyException {
        String value = p.getProperty(prefix+propName);
        if(value == null)
            throw new MissingPropertyException("Property \""+propName+"\" not found for "+prefix);
        String[] items = value.split(CustomCreatures.delimiter);
        if(length > -1 && items.length != length) throw new RuntimeException("Property "+propName+" must have exactly "+length+" items");
        float[] toReturn = new float[items.length];
        for(int i = 0; i < items.length; ++i){
            toReturn[i] = Float.parseFloat(items[i].trim());
        }
        return toReturn;
    }

    private int getIntProperty(String propName) throws MissingPropertyException {
        String value = p.getProperty(prefix+propName);
        if(value == null)
            throw new MissingPropertyException("Property \""+propName+"\" not found for "+prefix);
        return Integer.parseInt(value.trim());
    }

    private float getFloatProperty(String propName) throws MissingPropertyException {
        String value = p.getProperty(prefix+propName);
        if(value == null)
            throw new MissingPropertyException("Property \""+propName+"\" not found for "+prefix);
        return Float.parseFloat(value.trim());
    }

    private byte getByteProperty(String propName) throws MissingPropertyException {
        String value = p.getProperty(prefix+propName);
        if(value == null)
            throw new MissingPropertyException("Property \""+propName+"\" not found for "+prefix);
        return Byte.parseByte(value.trim());
    }

    private short getShortProperty(String propName) throws MissingPropertyException {
        String value = p.getProperty(prefix+propName);
        if(value == null)
            throw new MissingPropertyException("Property \""+propName+"\" not found for "+prefix);
        return Short.parseShort(value.trim());
    }

    private boolean getBooleanProperty(String propName) throws MissingPropertyException {
        String value = p.getProperty(prefix+propName);
        if(value == null)
            throw new MissingPropertyException("Property \""+propName+"\" not found for "+prefix);
        return Boolean.parseBoolean(value.trim());
    }

    public static ArmourTemplate.ArmourType intToArmourType(int armourType){
        switch (armourType) {
            case 1:
                return ArmourTemplate.ARMOUR_TYPE_LEATHER;
            case 2:
                return ArmourTemplate.ARMOUR_TYPE_STUDDED;
            case 3:
                return ArmourTemplate.ARMOUR_TYPE_CHAIN;
            case 4:
                return ArmourTemplate.ARMOUR_TYPE_PLATE;
            case 5:
                return ArmourTemplate.ARMOUR_TYPE_RING;
            case 6:
                return ArmourTemplate.ARMOUR_TYPE_CLOTH;
            case 7:
                return ArmourTemplate.ARMOUR_TYPE_SCALE;
            case 8:
                return ArmourTemplate.ARMOUR_TYPE_SPLINT;
            case 9:
                return ArmourTemplate.ARMOUR_TYPE_LEATHER_DRAGON;
            case 10:
                return ArmourTemplate.ARMOUR_TYPE_SCALE_DRAGON;
            default:
                throw new HookException("Wrong armour type: "+armourType);
        }
    }

    @Override
    public ModVehicleBehaviour getVehicleBehaviour() {
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
