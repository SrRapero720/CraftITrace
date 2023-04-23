# CRAFTICRASHES
The port of [CraftyCrashes](https://github.com/Chocohead/Crafty-Crashes) 
and [MixinTrace](https://github.com/comp500/mixintrace) in a one convenient mod<br>
originally this mod was wrapped into my main mod [WATERCoRE](https://github.com/SrRapero720/WATERCoRE)
but it's getting bigger and maintain a lot of features in a wrapped mod this is hard

## OFFICIAL DOWNLOADS
- [CurseForge](https://www.curseforge.com/minecraft/mc-mods/crafticrashes)
- Modrinth
- SrRapero720.me

## MIXINTRACE
This is a quick example of how looks a mixintrace in crash reports
```
Mixins in Stacktrace: 
	net.minecraft.client.MinecraftClient:
		me.srrapero720.watercore.mixin.client.MinecraftMixin (watercore.mixin.json)
		net.backslot.mixin.HandledScreenMixin (backslot.mixins.json)
		dev.emi.trinkets.mixin.HandledScreenMixin (trinkets.mixins.json)
	net.minecraft.client.gui.screens.Screen:
		dev.emi.trinkets.mixin.AbstractInventoryScreenMixin (trinkets.mixins.json)
```

## CRAFTY CRASHES
### Description taken from original repo
Normally when this is run you'd get the following crash report section (which is effectively the top frames of the full stack trace):
```
-- Head --
Thread: Render thread
Stacktrace:
	at net.minecraft.class_309.handler$zzg001$beforeKeyPressedEvent(class_309.java:1075)
	at net.minecraft.class_309.handler$zzg001$beforeKeyPressedEvent(class_309.java:1084)
	at net.minecraft.class_309.method_1454(class_309.java:374)
```
`Keyboard` only has around 520 lines, so 1075 and 1084 are entirely unhelpful to finding what is wrong. The only knowledge gained is that the Mixin which crashed had handlers called `beforeKeyPressedEvent`.

In contrast, running with Crafty Crashes:
```
-- Head --
Thread: Render thread
Stacktrace:
	at net.minecraft.class_309.handler$zzg001$beforeKeyPressedEvent(com/chocohead/example/mixin/BadMixin.java [cc-example.mixins.json]:24)
	at net.minecraft.class_309.handler$zzg001$beforeKeyPressedEvent(com/chocohead/example/mixin/BadMixin.java [cc-example.mixins.json]:33)
	at net.minecraft.class_309.method_1454(class_309.java:374)
```
Now we have the fully qualified name of the Mixin which has gone wrong, the Mixin config which registered it, and the correct line numbers for the Mixin. This makes finding and debugging the Mixin much easier, especially as searching for a Mixin config by name on Github is more likely to return a unique result than searching the handler or Mixin class's name.


## Incompatibilities
- MemoryLeakFix (causes crashes, use instead [WATERCoRE](https://github.com/SrRapero720/WATERCoRE))

***
<img style="display:block; width: 100%; height: auto; margin: 0 auto;" src="https://media.discordapp.net/attachments/1076151535291088916/1076656790986559538/WATERCoRE.png">

***

## KNOWED ISSUES
- CraftyCrashes uses target class instead mixin class (i blame forge)

## SUPPORT AND DISCORD
- This mod is maintained by me... and is the result of WATERCoRE
- Need support for: Mod safe and trusts, Developer contributor, Pull request, Bug reports. [Join to my Discord](https://discord.gg/cuYAzzZ)

## FA~~Q~~
- No ports to Fabric or Quilt
- No allowed respost of the mod
