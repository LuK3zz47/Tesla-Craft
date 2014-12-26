package eu.teslacraft.renderer.tileentity;

import eu.teslacraft.References;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created by Lukin on 26.12.2014.
 */
public class TileEntityRendererWindmillFloor extends TileEntitySpecialRenderer {

    private final ResourceLocation textureWindmillFloor = new ResourceLocation(References.MOD_ID + ":textures/model/windmillFloor.png");

    private int textureWidth = 32;
    private int textureHeight = 32;

    private float pixel = 1F/16F;

    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f){
      GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);

        Tessellator tessellator = Tessellator.instance;
        this.bindTexture(textureWindmillFloor);
        tessellator.startDrawingQuads();
        {
            if(tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) == 5){
                tessellator.addVertexWithUV(0, pixel*5, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(1, pixel*5, 1, 1F/textureWidth*(8+16), 1F/textureHeight*8);
                tessellator.addVertexWithUV(1, pixel*5, 0, 1F/textureWidth*8, 1F/textureHeight*8);
                tessellator.addVertexWithUV(0, pixel*5, 0, 1F/textureWidth*8, 1F/textureHeight*(8+16));
            }

            if(tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) == 1){
                tessellator.addVertexWithUV(0.5, pixel*5, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(32));
                tessellator.addVertexWithUV(0.5, pixel*5, 0, 1F/textureWidth*(32), 1F/textureHeight*(32));
                tessellator.addVertexWithUV(0, pixel*5, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0, pixel*5, 0.5, 1F/textureWidth*(8+16), 1F/textureHeight*(32));
            }

            if(tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) == 2){
                tessellator.addVertexWithUV(0.5, pixel*5, 1, 1F/textureWidth*(32), 1F/textureHeight*(8+16));
                tessellator.addVertexWithUV(0.5, pixel*5, 0, 1F/textureWidth*(32), 1F/textureHeight*(8));
                tessellator.addVertexWithUV(0, pixel*5, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8));
                tessellator.addVertexWithUV(0, pixel*5, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));

            if(tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) == 3){
                    tessellator.addVertexWithUV(0.5, pixel*5, 1, 1F/textureWidth*(32), 1F/textureHeight*(8));
                    tessellator.addVertexWithUV(0.5, pixel*5, 0.5, 1F/textureWidth*(32), 1F/textureHeight*(0));
                    tessellator.addVertexWithUV(0, pixel*5, 0.5, 1F/textureWidth*(8+16), 1F/textureHeight*(0));
                    tessellator.addVertexWithUV(0, pixel*5, 1, 1F/textureWidth*(8+16), 1F/textureHeight*(8));
                }

            if(tileentity.getWorldObj().getBlockMetadata(tileentity.xCoord, tileentity.yCoord, tileentity.zCoord) == 4){
                    tessellator.addVertexWithUV(1, pixel*5, 0.5, 1F/textureWidth*(8+16), 1F/textureHeight*(32));
                    tessellator.addVertexWithUV(1, pixel*5, 0, 1F/textureWidth*(8+16), 1F/textureHeight*(8+16));
                    tessellator.addVertexWithUV(0, pixel*5, 0, 1F/textureWidth*(8), 1F/textureHeight*(8+16));
                    tessellator.addVertexWithUV(0, pixel*5, 0.5, 1F/textureWidth*(8), 1F/textureHeight*(32));
                }
            }
            tessellator.draw();
            GL11.glPopMatrix();
        }
    }
}

