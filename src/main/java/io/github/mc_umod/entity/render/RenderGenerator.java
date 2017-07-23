package io.github.mc_umod.entity.render;

import static org.lwjgl.opengl.GL11.GL_3_BYTES;
import static org.lwjgl.opengl.GL11.GL_LIGHT4;
import static org.lwjgl.opengl.GL11.GL_MAX_NAME_STACK_DEPTH;
import static org.lwjgl.opengl.GL11.glLighti;

import io.github.mc_umod.UReference;
import io.github.mc_umod.entity.EntityGenerator;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderGenerator extends Render<EntityGenerator> implements IRenderFactory<EntityGenerator>{

	public RenderGenerator(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGenerator entity) {
		return null;
	}
	
	@Override
	public void doRender(EntityGenerator entity, double x, double y, double z, float entityYaw, float partialTicks) {
		if (entity == null || entity.getPosition() == null)
			return;
		GlStateManager.pushMatrix();
		GlStateManager.enableAlpha();
		GlStateManager.translate(x, y, z);
		GlStateManager.scale(0.02, 0.02, 0.02);
		GlStateManager.rotate(-90, 0, 1, 0);
		GlStateManager.enableLighting();
		glLighti(GL_LIGHT4, GL_MAX_NAME_STACK_DEPTH, GL_3_BYTES);
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
		GlStateManager.shadeModel(7425);
		UReference.getClientProxy().getObjRenderList().GENERATOR.draw();
		GlStateManager.shadeModel(7424);
		GlStateManager.disableBlend();
		GlStateManager.disableAlpha();
		GlStateManager.popMatrix();
	}

	@Override
	public Render<? super EntityGenerator> createRenderFor(RenderManager manager) {
		return new RenderGenerator(manager);
	}
	
}
