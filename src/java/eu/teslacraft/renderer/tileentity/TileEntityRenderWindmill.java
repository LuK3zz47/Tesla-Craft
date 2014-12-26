package eu.teslacraft.renderer.tileentity;

import eu.teslacraft.References;
import eu.teslacraft.TeslaCraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Lukin on 25.12.2014.
 */
public class TileEntityRenderWindmill extends TileEntitySpecialRenderer {

    private final ResourceLocation textureWindmill = new ResourceLocation(References.MOD_ID, "blockCopper");

    private int textureWidth = 64;
    private int textureHeigt = 32;

    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {

        GL11.glPushMatrix();
        GL11.glTranslated((float) x, (float) y, (float) z);

        Tessellator tessellator = Tessellator.instance;
        this.bindTexture(textureWindmill);
        tessellator.startDrawingQuads();
        {
            tessellator.addVertexWithUV(0, 0, 1, 1, 1);
            tessellator.addVertexWithUV(1, 1, 1, 1/4, 1/4);
            tessellator.addVertexWithUV(0, 1, 0, 0, 0);
            tessellator.addVertexWithUV(0, 0, 0, 0, 1);
        }
            tessellator.draw();
        GL11.glPopMatrix();
    }
}
