package me.srrapero720.craftitrace.mixins;

import com.mojang.logging.LogUtils;
import me.srrapero720.craftitrace.CraftITrace;
import me.srrapero720.craftitrace.internal.SMAPper;
import net.minecraft.CrashReportCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = CrashReportCategory.class, priority = 72)
public class TraceMixinCategory {
	@Shadow private StackTraceElement[] stackTrace;

	@Inject(method = "getDetails", at = @At("TAIL"))
	private void injectGetDetailsToAddTrace(StringBuilder crashReportBuilder, CallbackInfo ci) {
		LogUtils.getLogger().debug("Running MixinTrace");
		CraftITrace.printTrace(stackTrace, crashReportBuilder);
	}

	@Inject(method = "fillInStackTrace", at = @At(value = "INVOKE", target = "Ljava/lang/System;arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V", shift = At.Shift.AFTER))
	private void injectFillInStackTraceToSMAPCause(int p_128149_, CallbackInfoReturnable<Integer> cir) {
		LogUtils.getLogger().debug("Running CraftyCrashes");
		SMAPper.apply(stackTrace, "java.", "sun.", "net.minecraftforge.fml.", "com.mojang.authlib.");
	}
}
