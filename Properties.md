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
<br>`byte     : 0 | 160 | [-128-127]`
<br>`intArray : 0; 1; 2; 3; 4; 5 | 7 | [...]`

Note that whenever an input needs several values it **must be** separated by a `;`.
Even if I make a mistake and use `,` in an example. 


## Properties

### Basic properties
modelName ***string*** : The model's name. See the mappings.txt from your graphics.jar or
[here on GitHub](https://github.com/Tyoda/CustomCreatures/blob/master/include/mappings.txt).
Modded models also work.
<br>Example: cret.modelName = model.creature.humanoid.rooster.brown

acidVulnerability ***float***

acidResistance ***float***

aggressive ***int***

alignment ***float***

armourType ***int***

baseCombatRating ***float***

biteResistance ***float***

biteVulnerability ***float***

bodyType ***byte***

bonusCombatRating ***int***

childTemplate ***int***

coldResistance ***float***

coldVulnerability ***float***

combatDamageType ***byte***

crushResistance ***float***

crushVulnerability ***float***

daysOfPregnancy ***byte***

denMaterial ***byte***

denName ***string***

description ***string***

diseaseResistance ***float***

diseaseVulnerability ***float***

eggLayer ***int***

fireResistance ***float***

fireVulnerability ***float***

glowing ***bool***

handDamString ***string***

hasHands ***bool***

headbuttDamString ***string***

internalResistance ***float***

internalVulnerability ***float***

isHorse ***bool***

itemsButchered ***intArray*** : Item ids of what it should drop upon butchering. 
See [this list](https://github.com/ago1024/WurmServerModLauncher/wiki/Item-and-creature-ids) or itemIds.txt for the IDs or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/itemIDs.txt)

keepSex ***bool***

kickDamString ***string***

leaderTemplateId ***int***

maxAge ***int***

maxGroupAttackSize ***int***

maxHuntDist ***int***

maxPercentOfCreatures ***float***

maxPopulationOfCreatures ***int***

meatMaterial ***byte***

moveRate ***int***

naturalArmour ***float***

offZ ***float*** : ~~The height offset of the creture while on water.~~ It doesn't seem to work idk 

paintMode ***int***

physicalResistance ***float***

physicalVulnerability ***float***

pierceResistance ***float***

pierceVulnerability ***float***

plural ***string***

poisonResistance ***float***

poisonVulnerability ***float***

reputation ***int***

setCombatMoves ***intArray***

sex ***byte***

slashResistance ***float***

slashVulnerability ***float***

speed ***float***

types ***intArray*** : a list of the type numbers. See CreatureTypes.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/CreatureTypes.txt)

usesNewAttacks ***bool***

vision ***short***

waterResistance ***float***

waterVulnerability ***float***



### Extra properties
corpseName ***string***

ghost ***bool***

subTerranean ***bool***



### Complex properties

sizeModifier ***(int, int, int)*** : Modifier to the size of the creature.
(64, 64, 64) is default.
<br>Example: cret.sizeModifier = 256; 256; 256

onFire ***(bool, byte)*** : onFire, fireRadius

hitSounds ***(string, string)*** : Hit sound male and female. See sounds.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/sounds.txt)
<br>Example: cret.hitSounds = sound.combat.hit.cat; sound.combat.hit.cat

dimension ***(short, short, short)*** : The effective size of the creature
in centimeters. Height, length, and width.
Height determines how far the creature is visible from
(401 makes it visible as far as possible). 
<br>Example: cret.dimension = 40; 500; 100

deathSounds ***(string, string)*** : The death sounds. Male and female. See sounds.txt or [on github](https://github.com/Tyoda/CustomCreatures/blob/master/include/sounds.txt)
<br>Example: cret.deathSounds = sound.death.dragon; sound.death.dragon

damages ***(float, float, float, float, float)*** : Hand, kick, bite,
head, breath damage.
<br>Example: cret.damages = 17.0; 20.0f; 0.0f; 0.0f; 0.0f

color ***(int, int, int)*** : RGB color
<br>Example: cret.color = 128; 64; 196

boundsValues ***(float, float, float, float)*** : minX, minY, maxX, maxY
<br>Example: cret.boundsValues = 1.5; 3; 5.2; 36.6



### Complicated properties

***You can define several instances for these properties.
The first one must end with `1`, the second with `2` and so on.*** 

addPrimaryAttack ***(string, AttackIdentifier[STRIKE, BITE, MAUL, CLAW, HEADBUTT, KICK]
float, float, float, int, int, byte, bool, int, float)*** :
name, attackIdentifier, baseDamage, criticalChance, baseSpeed, attackReach,
weightGroup, damageType, usesWeapon, rounds, waitUntilNextAttack
<br>Example: cret.addPrimaryAttack1 = maul; MAUL; 7.0; 0.04; 6.0; 3; 2; 0; true; 3; 1.4
<br>Example: cret.addPrimaryAttack2 = bite rawrxd; BITE; 7.0; 0.04; 6.0; 3; 2; 0; true; 3; 1.4
<br>Example: cret.addPrimaryAttack3 = strike; STRIKE; 7.0; 0.04; 6.0; 3; 2; 0; true; 3; 1.4

addSecondaryAttack ***same as addPrimaryAttack***
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
<br>Example: cret.encounter1 = TILE_GRASS; 5; 1
<br>Example: cret.encounter2 = TILE_TAR; 5; 10