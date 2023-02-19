# CustomCreatures
## About
The properties below can be applied to any custom creature.
For an example property `exampleProperty` the next line is how it's applied
to the custom creature `cret`:<br>
cret.exampleProperty = value
<br>The value can be whatever is defined as the type. The types and their possible values are (unless otherwise specified):
<br>`string   : any string`
<br>`float    : 1.0 | 1.5 | 1 | -5 | [...]`
<br>`int      : 1 | -5 | [...]`
<br>`short    : 1 | -5 | [-32768-32767]`
<br>`byte     : 0 | 160 | [-128-127]`
<br>`intArray : 0; 1; 2; 3; 4; 5 | 7 | [...]`

Note that whenever an input needs several values it **must be** separated by a `;`.
Even if I make a mistake and use `,` in an example. 


## Properties

### Basic properties
name ***string*** : The name of the creature.
<br>Example: cret.name = thunder rat

plural ***string*** : The plural name.
<br>Example: cret.plural = thunder rats

modelName ***string*** : The model's name. See the mappings.txt from your graphics.jar or
[here on GitHub](https://github.com/Tyoda/CustomCreatures/blob/master/include/mappings.txt).
Modded models also work.
<br>Example: cret.modelName = model.creature.humanoid.rooster.brown

acidVulnerability ***float***

acidResistance ***float***

aggressivity ***int*** : The range at which it aggros.
<br>Example: cret.aggressivity = 45

alignment ***float***

armourType ***int*** : For the armour type ID see ArmourTypes.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/ArmourTypes.txt)
<br>Example: cret.armourType = 2

baseCombatRating ***float***

bonusCombatRating ***int***

biteResistance ***float***

biteVulnerability ***float***

bodyType ***byte*** : For the body type ID see BodyTypes.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/BodyTypes.txt)
<br>Example: cret.bodyType = 5

childTemplateId ***int***

coldResistance ***float***

coldVulnerability ***float***

combatDamageType ***byte*** : Type of damage it does
<br>Example: cret.combatDamageType = 4

crushResistance ***float***

crushVulnerability ***float***

daysOfPregnancy ***byte***

denName ***string***

denMaterial ***byte*** : See Materials.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/Materials.txt)
<br>Example: cret.denMaterial = 89

description ***string***

diseaseResistance ***float***

diseaseVulnerability ***float***

eggLayer ***boolean***

eggTemplateId ***int***

mateTemplateId ***int***

adultFemaleTemplateId ***int***

adultMaleTemplateId ***int***

fireResistance ***float***

fireVulnerability ***float***

glowing ***bool***

hasHands ***bool*** : whether it is a human/monster with hands like goblin/troll
<br>Example: cret.hasHands = true

internalResistance ***float***

internalVulnerability ***float***

isHorse ***bool***

butcheredItems  ***intArray*** : Item ids of what it should drop upon butchering. 
See [this list](https://github.com/ago1024/WurmServerModLauncher/wiki/Item-and-creature-ids) or itemIds.txt for the IDs or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/itemIDs.txt)

keepSex ***bool***

leaderTemplateId ***int***

maxAge ***int*** : How old it can get. (Venerable is around 40)
<br>Example: cret.maxAge = 80

maxGroupAttackSize ***int*** : How many people can attack it.
<br>Example: cret.maxGroupAttackSize = 8

maxHuntDistance ***int*** : How far it chases the player.
<br>Example: cret.maxHuntDistance = 12

maxPercentOfCreatures ***float***

maxPopulationOfCreatures ***int***

meatMaterial ***byte*** : The material type for the meat. For the ids see MeatMaterials.txt or
[on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/MeatMaterials.txt)
<br>Example: cret.meatMaterial = 80

moveRate ***int***

naturalArmour ***float*** : Percentage of damage blocked automatically (0.0-1.0).
Uniques have 0.04 (4%) or 0.02f (2%)
<br>Example: cret.naturalArmour = 0.04

offZ ***float*** : ~~The height offset of the creture while on water.~~ It doesn't seem to work idk 

paintMode ***int***

physicalResistance ***float***

physicalVulnerability ***float***

pierceResistance ***float***

pierceVulnerability ***float***

poisonResistance ***float***

poisonVulnerability ***float***

reputation ***int***

combatMoves ***intArray*** : Can use combat moves.
<br>Example: cret.combatMoves = 1; 2; 5; 7; 8

sex ***byte***

slashResistance ***float***

slashVulnerability ***float***

speed ***float***

types ***intArray*** : A list of the type numbers. See CreatureTypes.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/CreatureTypes.txt)
Types like aggressive towards human/carnivore/animal/monster/ect
<br>Example: cret.types = 16; 35; 33

useNewAttacks ***bool***

vision ***short***

waterResistance ***float***

waterVulnerability ***float***

corpseName ***string*** : the corpse's model name will be "model.corpse.[WHATEVER_YOU_WROTE].", so look for
those kinds of model strings in mappings.txt
<br>Example: cret.corpseName = forestgiant

ghost ***bool***

subTerranean ***bool***

handDamage ***float*** : Hand damage
<br>Example: cret.handDamage = 0.5

kickDamage ***float*** : Kick damage
<br>Example: cret.kickDamage = 0.5

biteDamage ***float*** : Bite damage
<br>Example: cret.biteDamage = 0.5

headButtDamage ***float*** : Headbutt damage
<br>Example: cret.headButtDamage = 0.5

breathDamage ***float*** : Breath damage
<br>Example: cret.breathDamage = 0.5

handDamString ***string*** : How the hand damage is called in the combat log
<br>Example: cret.handDamString = rawr xd

biteDamString ***string***
<br>Example: cret.biteDamString = rawr xd

kickDamString ***string***
<br>Example: cret.kickDamString = rawr xd

headbuttDamString ***string***
<br>Example: cret.headbuttDamString = rawr xd

breathDamString ***string***
<br>Example: cret.breathDamString = rawr xd

deity ***int*** : For ids see Deities.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/Deities.txt)
I have no idea if setting this does anything. For all vanilla creatures this is set to null.
<br>Example: cret.deity = 1 

faith ***float***

tutorial ***bool***

noSkillgain ***bool***

royalAspiration ***bool***

noCorpse ***bool***

noServerSounds ***bool***



### Complex properties

sizeModifier ***(int, int, int)*** : Modifier to the size of the creature's model. X, Y, Z
(64, 64, 64) is default.
<br>Example: cret.sizeModifier = 256; 256; 256

onFire ***(bool, byte)*** : onFire, fireRadius

hitSounds ***(string, string)*** : Sound it makes when hit. Male and female. See sounds.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/sounds.txt)
<br>Example: cret.hitSounds = sound.combat.hit.cat; sound.combat.hit.cat

dimension ***(short, short, short)*** : The effective size of the creature
in centimeters. Height, length, and width.
Height determines how far the creature is visible from
(401 makes it visible as far as possible). 
<br>Example: cret.dimension = 40; 500; 100

deathSounds ***(string, string)*** : Sound it makes when it dies. Male and female. See sounds.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/sounds.txt)
<br>Example: cret.deathSounds = sound.death.dragon; sound.death.dragon

color ***(int, int, int)*** : RGB color
<br>Example: cret.color = 128; 64; 196

boundsValues ***(float, float, float, float)*** : minX, minY, maxX, maxY
<br>Example: cret.boundsValues = 1.5; 3; 5.2; 36.6

### Complicated properties

***You can define several instances for these properties.
The first one must end with `1`, the second with `2` and so on.*** 

**NOTE THAT ADDPRIMARYATTACK AND ADDSECONDARYATTACK BOTH SEEM TO DO NOTHING IN WU AT THE MOMENT**
addPrimaryAttack ***(string, AttackIdentifier[STRIKE, BITE, MAUL, CLAW, HEADBUTT, KICK]
float, float, float, int, int, byte, bool, int, float)*** :
name, attackIdentifier, baseDamage, criticalChance, baseSpeed, attackReach,
weightGroup, damageType, usesWeapon, rounds, waitUntilNextAttack
**Note that adding in one or more primary attack clears out the other ones if you copied a template**
<br>Example: cret.addPrimaryAttack1 = maul; MAUL; 7.0; 0.04; 6.0; 3; 2; 0; true; 3; 1.4
<br>Example: cret.addPrimaryAttack2 = bite rawrxd; BITE; 7.0; 0.04; 6.0; 3; 2; 0; true; 3; 1.4
<br>Example: cret.addPrimaryAttack3 = strike; STRIKE; 7.0; 0.04; 6.0; 3; 2; 0; true; 3; 1.4

addSecondaryAttack ***same as addPrimaryAttack***
**Note that adding in one or more primary attack clears out the other ones if you copied a template**
<br>Example: cret.addSecondaryAttack1 = "maul"; MAUL; 7.0; 0.04; 6.0; 3; 2; 0; true; 3; 1.4
<br>Example: cret.addSecondaryAttack2 = "bite"; BITE; 7.0; 0.04; 6.0; 3; 2; 0; true; 3; 1.4
<br>Example: cret.addSecondaryAttack3 = "strike"; STRIKE; 7.0; 0.04; 6.0; 3; 2; 0; true; 3; 1.4

skill ***(int, float)*** : Skill id and level. See IDs SkillList.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/SkillList.txt)
<br>Example: cret.skill1 = 10013; 25.0
<br>Example: cret.skill2 = 10025; 10.0
<br>Example: cret.skill3 = 10036; 47.2
<br>Example: cret.skill3 = 10042; 45.3

#### Encounters

encounter ***(byte, int, int)*** : tile type, creature count, chance. See tile types in TileTypes.txt [or on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/TileTypes.txt)
The encounter1 here means "it can spawn on sand with a group of 2 monsters and has 3% chance per tile poll"
<br>Example: cret.encounter1 = TILE_SAND; 2; 3
<br>Example: cret.encounter2 = TILE_TAR; 5; 10